package cn.smartx.push.api;

import cn.smartx.push.ConfigUtils;
import cn.smartx.push.model.PushMessage;
import cn.smartx.push.model.UserDevice;
import javapns.notification.PushedNotifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * SmartX推送
 * Created by Jeepeng on 2015/5/21.
 */
public class SmartXPush {
    final Logger log = LoggerFactory.getLogger(getClass());

    private String baidu_push_api_key;
    private String baidu_push_secret_key;
    private String keystorePath;
    private String password;
    private boolean production;

    public SmartXPush() {
        //读取配置文件
        Map configMap = ConfigUtils.loadProperties2Map("config/push.properties");
        this.baidu_push_api_key = (String) configMap.get("baidu_push_api_key");
        this.baidu_push_secret_key = (String) configMap.get("baidu_push_secret_key");
        log.info("Android推送配置 apiKey=[{}] ,secretKey=[{}]", this.baidu_push_api_key, this.baidu_push_secret_key);
        this.keystorePath = (String) configMap.get("keystorePath");
        this.password = (String) configMap.get("password");
        this.production = "true".equalsIgnoreCase((String)configMap.get("production"));
        log.info("iOS推送配置 keystorePath=[{}], password=[{}], production=[{}]", this.keystorePath, this.password, this.production);
    }

    /**
     * 推送消息
     * @param userDeviceList
     * @param summary
     * @param url
     */
    public void push(final List<UserDevice> userDeviceList, String summary, String url) {
        pushToAndroid(userDeviceList, summary, url);
        pushToIOS(userDeviceList, summary, url);
    }

    /**
     * 只推送给Android用户
     * @param userDeviceList
     * @param summary
     * @param url
     */
    public void pushToAndroid(final List<UserDevice> userDeviceList, String summary, String url) {
        final PushMessage message = new PushMessage();
        message.setSummary(summary);
        message.setUrl(url);
        new Thread(new Runnable() {

            @Override
            public void run() {
                AndroidPush androidPush = new AndroidPush(baidu_push_api_key,baidu_push_secret_key);
                androidPush.pushToMultipleDevice(userDeviceList, message);
            }
        }).start();
    }

    /**
     * 只推送给iOS用户
     * @param userDeviceList
     * @param summary
     * @param url
     */
    public void pushToIOS(final List<UserDevice> userDeviceList, String summary, String url) {
        final PushMessage message = new PushMessage();
        message.setSummary(summary);
        message.setUrl(url);
        new Thread(new Runnable() {
            @Override
            public void run() {
                IOSPush iosPush = new IOSPush(keystorePath, password, production);
                PushedNotifications iosNotifications = iosPush.push(userDeviceList , message);
                if (iosNotifications != null) {
                    log.info("【iOS】消息推送成功{}数,失败{}数",iosNotifications.getSuccessfulNotifications().size(),iosNotifications.getFailedNotifications().size());
                }
            }
        }).start();
    }
}
