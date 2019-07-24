package com.aigoule.starapp.model;

public class RegistMosdel extends BaseModel {

    /**
     * message : 用户名已存在，请更换用户名
     * data : {}
     */

    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
