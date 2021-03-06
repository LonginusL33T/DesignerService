package com.aolc.designer.auto;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;

/**
 * Class _MstAdvertisement was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _MstAdvertisement extends CayenneDataObject {

    public static final String NAME_PROPERTY = "name";
    public static final String SID_PROPERTY = "sid";
    public static final String SOURCE_PROPERTY = "source";
    public static final String TIME_PROPERTY = "time";

    public static final String SID_PK_COLUMN = "sid";

    public void setName(String name) {
        writeProperty(NAME_PROPERTY, name);
    }
    public String getName() {
        return (String)readProperty(NAME_PROPERTY);
    }

    public void setSid(Integer sid) {
        writeProperty(SID_PROPERTY, sid);
    }
    public Integer getSid() {
        return (Integer)readProperty(SID_PROPERTY);
    }

    public void setSource(String source) {
        writeProperty(SOURCE_PROPERTY, source);
    }
    public String getSource() {
        return (String)readProperty(SOURCE_PROPERTY);
    }

    public void setTime(Date time) {
        writeProperty(TIME_PROPERTY, time);
    }
    public Date getTime() {
        return (Date)readProperty(TIME_PROPERTY);
    }

}
