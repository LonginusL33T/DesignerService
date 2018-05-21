package com.aolc.designer.mesh.bean.request;

public class CreateNodeRequest<T> {
    private ParentNode parentNode;
    private Schema schema;
    private String language;
    private T fields;

    public CreateNodeRequest(String parentNode, String schema, String language, T fields) {
        this.parentNode = new ParentNode(parentNode);
        this.schema = new Schema(schema);
        this.language = language;
        this.fields = fields;
    }

    public ParentNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(ParentNode parentNode) {
        this.parentNode = parentNode;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public T getFields() {
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }
}
class ParentNode{
    private String uuid;

    public ParentNode(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
class Schema{
    private String name;

    public Schema(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}