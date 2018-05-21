package com.aolc.designer.mesh.bean.request;

public class UpdateNodeRequest<T> {
    private T fields;
    private String language;
    private String version;

    public UpdateNodeRequest(T fields, String language, String version) {
        this.fields = fields;
        this.language = language;
        this.version = version;
    }

    public T getFields() {
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
