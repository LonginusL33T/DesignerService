package cn.smartx.push.api;

import cn.smartx.push.model.PushMessage;
import cn.smartx.push.model.UserDevice;
import cn.smartx.utils.JsonUtils;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.constants.BaiduPushConstants;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToAllRequest;
import com.baidu.yun.push.model.PushMsgToAllResponse;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.baidu.yun.push.model.PushMsgToSingleDeviceResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Android推送接口，用到百度云推送
 * Created by Jeepeng on 2015/5/6.
 */
public class AndroidPush {
    final Logger log = LoggerFactory.getLogger(getClass());

    private BaiduPushClient pushClient;

    /**
     * 初始化
     * @param apiKey 百度推送apikey
     * @param secretKey 百度推送secretKey
     */
    public AndroidPush(String apiKey, String secretKey){

        if(StringUtils.isBlank(apiKey) || StringUtils.isBlank(secretKey)){
            log.warn("警告：初始化百度推送时apikey或secretKey为空！");
            return;
        }
        // 1. 设置百度推送的ApiKey/SecretKey
        PushKeyPair pair = new PushKeyPair(apiKey, secretKey);

        // 2. 创建BaiduPushClient，访问SDK接口
        pushClient = new BaiduPushClient(pair, BaiduPushConstants.CHANNEL_REST_URL);

        // 3. 注册YunLogHandler，获取本次请求的交互信息
        pushClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                log.info(event.getMessage());
            }
        });
    }

    /**
     * 推送通知给多个用户
     * @param devices 用户设备list
     * @param message 推送消息体
     */
    public void pushToMultipleDevice(List<UserDevice> devices ,PushMessage message){

        for (UserDevice device : devices) {
            pushToSingleDevice(device, message);
        }
    }

    /**
     * 推送通知给由百度管理（绑定）的所有设备
     * @param message 推送消息体
     */
    public boolean pushToAll(PushMessage message){
        String messageJson = JsonUtils.ConvertToJson(message);
        try {
            PushMsgToAllRequest request = new PushMsgToAllRequest()
                    .addMsgExpires(3600)
                    .addMessageType(0)
                    .addMessage(messageJson)
                    // 设置定时推送时间，必需超过当前时间一分钟，单位秒.实例70秒后推送
                    .addSendTime(System.currentTimeMillis() / 1000 + 70)
                    .addDeviceType(3);
            PushMsgToAllResponse response = pushClient.pushMsgToAll(request);
            // Http请求返回值解析
            log.info("msgId: " + response.getMsgId() + ",sendTime: " + response.getSendTime() + ",timerId: " + response.getTimerId());
            return true;
        } catch (PushClientException e) {
            e.printStackTrace();
        } catch (PushServerException e) {
            log.info(String.format("requestId: %d, errorCode: %d, errorMsg: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
        return false;
    }

    /**
     * 推送通知给单个Android用户
     * @param device 用户设备
     * @param message 推送的消息体
     * @return true if push success
     */
    public boolean pushToSingleDevice (UserDevice device ,PushMessage message) {
        if ("android".equalsIgnoreCase(device.getSmartxPlatform()) && !"".equalsIgnoreCase(device.getDeviceToken())) {
            try {
                String messageJson = JsonUtils.ConvertToJson(message);
                // 4. 设置请求参数，创建请求实例
                PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest()
                        .addChannelId(device.getDeviceToken())
                        .addMsgExpires(3600)   //设置消息的有效时间,单位秒,默认3600*5.
                        .addMessageType(0)             //设置消息类型,0表示透传消息,1表示通知,默认为0.
                        .addMessage(messageJson)
                        .addDeviceType(3);   //设置设备类型，deviceType => 3 for android, 4 for ios.

                // 5. 执行Http请求
                PushMsgToSingleDeviceResponse response = pushClient.pushMsgToSingleDevice(request);
                // 6. Http请求返回值解析
                log.info("msgId: " + response.getMsgId()  + ",sendTime: " + response.getSendTime());
                return true;
            } catch (PushClientException e) {
                e.printStackTrace();
            } catch (PushServerException e) {
                    log.info(String.format("requestId: %d, errorCode: %d, errorMsg: %s",e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
            }
        }
        return false;
    }
}
