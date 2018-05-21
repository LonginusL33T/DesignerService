package cn.smartx.push.model;

/**
 * 推送消息体
 * Created by Jeepeng on 2015/5/21.
 */
public class PushMessage {
    /**
     * 通知标题，可以为空；如果为空则设为appid对应的应用名;
     */
    String title;//必选
    /**
     * 通知文本内容，不能为空;
     */
    String summary;//必选
    /**
     * 点击通知后打开的url
     */
    String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
