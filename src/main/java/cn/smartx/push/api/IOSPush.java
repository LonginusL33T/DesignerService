package cn.smartx.push.api;

import cn.smartx.push.ConfigUtils;
import cn.smartx.push.model.PushMessage;
import cn.smartx.push.model.UserDevice;
import javapns.Push;
import javapns.communication.exceptions.CommunicationException;
import javapns.communication.exceptions.KeystoreException;
import javapns.devices.Device;
import javapns.devices.implementations.basic.BasicDevice;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotifications;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * iOS Push
 * Created by Jeepeng on 2015/5/6.
 */
public class IOSPush {
    final Logger log = LoggerFactory.getLogger(getClass());

    private String keystorePath;
    private String password;
    private boolean production;

    private String pushSound;
    private int badge;
    private int threadNum;

    /**
     * iOS推送初始化
     * @param keystorePath ios推送keystore路径
     * @param password 密码
     * @param production 是否为产品
     */
    public IOSPush(String keystorePath, String password ,boolean production){
        this.keystorePath = ConfigUtils.getResourcePath() + keystorePath;
        this.password = password;
        this.production = production;
    }

    /**
     * 从Apple服务器获取无效的token
     *
     * @return
     */
    public List<Device> iOSFeedback() {
        List<Device> deviceList = null;
        try {
                deviceList = Push.feedback(this.keystorePath, this.password, this.production);
                for (Device basicDevice : deviceList) {
                    log.info(basicDevice.getToken());
                }

        } catch (CommunicationException | KeystoreException e) {
            e.printStackTrace();
        }
        return deviceList;
    }

    /**
     * iOS 推送
     */
    public PushedNotifications push(List<UserDevice> devices, PushMessage message) {
        PushedNotifications notifications = null;
        try {
            BasicConfigurator.configure();
            PushNotificationPayload payload = new PushNotificationPayload();
            payload.addCustomAlertBody(message.getSummary());
            payload.addCustomDictionary("url", message.getUrl());
            if (this.badge == 0) {
                payload.addBadge(1);
            } else {
                payload.addBadge(this.badge);
            }
            if (this.pushSound != null) {
                if (this.pushSound.equalsIgnoreCase("")) {
                    payload.addSound("default");
                } else {
                    payload.addSound(this.pushSound);
                }
            } else {
                payload.addSound("default");
            }
            List<Device> device = new ArrayList<Device>();
            for (UserDevice udevice : devices) {
                if (udevice.getSmartxPlatform().equalsIgnoreCase("ios") && !udevice.getDeviceToken().equalsIgnoreCase("")) {
                    device.add(new BasicDevice(udevice.getDeviceToken()));
                }

            }
            notifications = Push.payload(payload, this.keystorePath, this.password, this.production, this.threadNum, device);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
