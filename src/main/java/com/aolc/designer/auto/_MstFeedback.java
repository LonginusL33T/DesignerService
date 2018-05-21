package com.aolc.designer.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _MstFeedback was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MstFeedback extends CayenneDataObject {

    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String FEEDBACK_PROPERTY = "feedback";
    public static final String IMAGE1_PROPERTY = "image1";
    public static final String IMAGE2_PROPERTY = "image2";
    public static final String IMAGE3_PROPERTY = "image3";
    public static final String UNIQUEID_PROPERTY = "uniqueid";
    public static final String USER_UNIQUEID_PROPERTY = "userUniqueid";

    public static final String UNIQUEID_PK_COLUMN = "uniqueid";

    public void setCreateTime(Date createTime) {
        writeProperty(CREATE_TIME_PROPERTY, createTime);
    }
    public Date getCreateTime() {
        return (Date)readProperty(CREATE_TIME_PROPERTY);
    }

    public void setFeedback(String feedback) {
        writeProperty(FEEDBACK_PROPERTY, feedback);
    }
    public String getFeedback() {
        return (String)readProperty(FEEDBACK_PROPERTY);
    }

    public void setImage1(String image1) {
        writeProperty(IMAGE1_PROPERTY, image1);
    }
    public String getImage1() {
        return (String)readProperty(IMAGE1_PROPERTY);
    }

    public void setImage2(String image2) {
        writeProperty(IMAGE2_PROPERTY, image2);
    }
    public String getImage2() {
        return (String)readProperty(IMAGE2_PROPERTY);
    }

    public void setImage3(String image3) {
        writeProperty(IMAGE3_PROPERTY, image3);
    }
    public String getImage3() {
        return (String)readProperty(IMAGE3_PROPERTY);
    }

    public void setUniqueid(String uniqueid) {
        writeProperty(UNIQUEID_PROPERTY, uniqueid);
    }
    public String getUniqueid() {
        return (String)readProperty(UNIQUEID_PROPERTY);
    }

    public void setUserUniqueid(String userUniqueid) {
        writeProperty(USER_UNIQUEID_PROPERTY, userUniqueid);
    }
    public String getUserUniqueid() {
        return (String)readProperty(USER_UNIQUEID_PROPERTY);
    }

}
