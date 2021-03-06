package com.aolc.designer.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _MstRecruit was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MstRecruit extends CayenneDataObject {

    public static final String ADDRESS_PROPERTY = "address";
    public static final String CATEGORY_PROPERTY = "category";
    public static final String COMPENSATION_BENEFIT_PROPERTY = "compensationBenefit";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String EDUCATIONAL_REQUIREMENTS_PROPERTY = "educationalRequirements";
    public static final String EXPERIENCE_PROPERTY = "experience";
    public static final String JOB_DETAIL_PROPERTY = "jobDetail";
    public static final String SKILLS_REQUIREMENTS_PROPERTY = "skillsRequirements";
    public static final String STATUS_PROPERTY = "status";
    public static final String TAGS_PROPERTY = "tags";
    public static final String TITLE_PROPERTY = "title";
    public static final String UNIQUEID_PROPERTY = "uniqueid";
    public static final String USER_UNIQUEID_PROPERTY = "userUniqueid";

    public static final String UNIQUEID_PK_COLUMN = "uniqueid";

    public void setAddress(String address) {
        writeProperty(ADDRESS_PROPERTY, address);
    }
    public String getAddress() {
        return (String)readProperty(ADDRESS_PROPERTY);
    }

    public void setCategory(String category) {
        writeProperty(CATEGORY_PROPERTY, category);
    }
    public String getCategory() {
        return (String)readProperty(CATEGORY_PROPERTY);
    }

    public void setCompensationBenefit(String compensationBenefit) {
        writeProperty(COMPENSATION_BENEFIT_PROPERTY, compensationBenefit);
    }
    public String getCompensationBenefit() {
        return (String)readProperty(COMPENSATION_BENEFIT_PROPERTY);
    }

    public void setCreateTime(Date createTime) {
        writeProperty(CREATE_TIME_PROPERTY, createTime);
    }
    public Date getCreateTime() {
        return (Date)readProperty(CREATE_TIME_PROPERTY);
    }

    public void setEducationalRequirements(String educationalRequirements) {
        writeProperty(EDUCATIONAL_REQUIREMENTS_PROPERTY, educationalRequirements);
    }
    public String getEducationalRequirements() {
        return (String)readProperty(EDUCATIONAL_REQUIREMENTS_PROPERTY);
    }

    public void setExperience(String experience) {
        writeProperty(EXPERIENCE_PROPERTY, experience);
    }
    public String getExperience() {
        return (String)readProperty(EXPERIENCE_PROPERTY);
    }

    public void setJobDetail(String jobDetail) {
        writeProperty(JOB_DETAIL_PROPERTY, jobDetail);
    }
    public String getJobDetail() {
        return (String)readProperty(JOB_DETAIL_PROPERTY);
    }

    public void setSkillsRequirements(String skillsRequirements) {
        writeProperty(SKILLS_REQUIREMENTS_PROPERTY, skillsRequirements);
    }
    public String getSkillsRequirements() {
        return (String)readProperty(SKILLS_REQUIREMENTS_PROPERTY);
    }

    public void setStatus(String status) {
        writeProperty(STATUS_PROPERTY, status);
    }
    public String getStatus() {
        return (String)readProperty(STATUS_PROPERTY);
    }

    public void setTags(String tags) {
        writeProperty(TAGS_PROPERTY, tags);
    }
    public String getTags() {
        return (String)readProperty(TAGS_PROPERTY);
    }

    public void setTitle(String title) {
        writeProperty(TITLE_PROPERTY, title);
    }
    public String getTitle() {
        return (String)readProperty(TITLE_PROPERTY);
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
