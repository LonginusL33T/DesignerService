package com.aolc.designer.utils;

import cn.smartx.core.service.validate.email.MailServerInfo;

public class EmailServer extends MailServerInfo {
    private static final String SERVER_HOST="smtp.shang-highstreet.cn";
    private static final String USERNAME="wedesign@shang-highstreet.cn";
    private static final String PASSWORD="WeDesign2017";
    private static final String ADDRESS="wedesign@shang-highstreet.cn";

    public EmailServer(){
        super(SERVER_HOST, USERNAME, PASSWORD, ADDRESS);
    }
}
