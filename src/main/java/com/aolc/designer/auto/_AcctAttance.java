package com.aolc.designer.auto;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _AcctAttance was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AcctAttance extends CayenneDataObject {

    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String RESOURSE_TOKEN_PROPERTY = "resourseToken";
    public static final String TYPE_PROPERTY = "type";
    public static final String UNIQUEID_PROPERTY = "uniqueid";
    public static final String USER_UNIQUEID_PROPERTY = "userUniqueid";

    public static final String UNIQUEID_PK_COLUMN = "uniqueid";

    public void setDescription(String description) {
        writeProperty(DESCRIPTION_PROPERTY, description);
    }
    public String getDescription() {
        return (String)readProperty(DESCRIPTION_PROPERTY);
    }

    public void setResourseToken(String resourseToken) {
        writeProperty(RESOURSE_TOKEN_PROPERTY, resourseToken);
    }
    public String getResourseToken() {
        return (String)readProperty(RESOURSE_TOKEN_PROPERTY);
    }

    public void setType(String type) {
        writeProperty(TYPE_PROPERTY, type);
    }
    public String getType() {
        return (String)readProperty(TYPE_PROPERTY);
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
