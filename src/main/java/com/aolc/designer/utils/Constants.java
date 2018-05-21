package com.aolc.designer.utils;

public class Constants {
    /**
     * 静态变量
     */
    public static final String ERROR_CODE  ="error_code";
    public static final String TOKEN  ="token";
    public static final String MESH_TOKEN  ="mesh_token";
    public static final String LANGUAGE  ="en";
    public static final String AVATAR  ="avatar";

    public static final String LOCKED  ="locked";
    public static final String ACCEPT  ="accept";
    public static final String VERIFING  ="verifing";
    public static final String UPLOAD  ="upload";
    public static final String REJECT  ="reject";
    public static final String MESSAGE  ="message";
    public static final String USER  ="user";
    public static final String COMPANY  ="company";
    public static final String CUSTOMER  ="customer";
    public static final String TOTAL_NUM  ="total_num";
    public static final String APPLY  ="apply";

    public static final String USER_FREE  ="free";
    public static final String USER_GRADUATE  ="graduate";
    public static final String USER_PRODUCTION  ="production";

    public static final String CATEGORY_WORKS  ="works";
    public static final String CATEGORY_RESUMES  ="resumes";
    public static final String APPLYS  ="applys";





    /**
     * 错误码
     */
    //成功
    public static final int SUCCESS = 0x0000;
    //参数出错
    public static final int ERROR_PARAM_INCORRECT = 0x0001;
    //用户不存在
    public static final int ERROR_USER_NOT_EXIST = 0x0101;
    //用户密码错误
    public static final int ERROR_USER_PASSWORD_INCORRECT = 0x0102;
    //用户已锁定
    public static final int ERROR_USER_LOCKED = 0x0103;
    //用户session超时
    public static final int ERROR_SESSION_TIMEOUT = 0x010A;

    //用户正在审核中
    public static final int ERROR_USER_VERIFING = 0x0104;
    //用户已存在
    public static final int ERROR_USER_EXIST = 0x0105;
    //用户添加失败
    public static final int ERROR_USER_ADD_ERROR = 0x0106;
    //用户信息上传失败
    public static final int ERROR_USER_PUBLISHED_ERROR = 0x0109;

    //用户名或密码错误
    public static final int ERROR_USERNAME_OR_PASSWORD_ERROR = 0x0107;
    //修改密码失败
    public static final int ERROR_CHANGE_PASSWORD_ERROR = 0x0108;

    //添加企业信息出错
    public static final int ERROR_COMPANY_EROR = 0x0201;

    //验证码错误
    public static final int ERROR_PHONE_NUMBER_NOT_SAME = 0x0301;//验证账号不一致

    public static final int ERROR_VALIDATE_CODE_ERROR = 0x0302;//验证码错误

    public static final int ERROR_VALIDATE_CODE_TIMEOUT = 0x0303;//验证码超时

    public static final int ERROR_TAG_ALREADY_EXIST = 0x0401;//标签已存在

    public static final int ERROR_EMAIL_SEND_FAILED = 0x0304;//邮箱发送失败

    //超级管理员
    public static final int ERROR_ADD_PERMISSION_ERROR = 0x0501;//添加权限失败
    //招聘
    public static final int ERROR_ADD_RECURIT_ERROR = 0x0601;//添加招聘信息失败

    public static final int ERROR_ADD_RECURIT_USER_VARIFYING = 0x0602;//用户正在审核中

    public static final int ERROR_ADD_RECURIT_USER_REJECT = 0x0603;//用户正在审核中

    public static final int ERROR_ADD_RECURIT_USER_LOCKED = 0x0604;//用户正在审核中

    public static final int ERROR_SEND_APPLY_ERROR = 0x0605;//用户正在审核中




}
