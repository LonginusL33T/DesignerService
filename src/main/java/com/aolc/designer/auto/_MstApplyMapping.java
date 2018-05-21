package com.aolc.designer.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _MstApplyMapping was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MstApplyMapping extends CayenneDataObject {

    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String IS_SEND_BY_COMPANY_PROPERTY = "isSendByCompany";
    public static final String JOB_UNIQUEID_PROPERTY = "jobUniqueid";
    public static final String RESUME_PROPERTY = "resume";
    public static final String STATUS_PROPERTY = "status";
    public static final String UNIQUEID_PROPERTY = "uniqueid";
    public static final String USER_UNIQUEID_PROPERTY = "userUniqueid";

    public static final String UNIQUEID_PK_COLUMN = "uniqueid";

    public void setCreateTime(Date createTime) {
        writeProperty(CREATE_TIME_PROPERTY, createTime);
    }
    public Date getCreateTime() {
        return (Date)readProperty(CREATE_TIME_PROPERTY);
    }

    public void setIsSendByCompany(Integer isSendByCompany) {
        writeProperty(IS_SEND_BY_COMPANY_PROPERTY, isSendByCompany);
    }
    public Integer getIsSendByCompany() {
        return (Integer)readProperty(IS_SEND_BY_COMPANY_PROPERTY);
    }

    public void setJobUniqueid(String jobUniqueid) {
        writeProperty(JOB_UNIQUEID_PROPERTY, jobUniqueid);
    }
    public String getJobUniqueid() {
        return (String)readProperty(JOB_UNIQUEID_PROPERTY);
    }

    public void setResume(String resume) {
        writeProperty(RESUME_PROPERTY, resume);
    }
    public String getResume() {
        return (String)readProperty(RESUME_PROPERTY);
    }

    public void setStatus(String status) {
        writeProperty(STATUS_PROPERTY, status);
    }
    public String getStatus() {
        return (String)readProperty(STATUS_PROPERTY);
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
