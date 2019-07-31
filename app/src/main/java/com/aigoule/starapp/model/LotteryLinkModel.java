package com.aigoule.starapp.model;

public class LotteryLinkModel extends BaseModel {

    /**
     * message :
     * data : https://www.agc77.com/mobile/#/
     */

    private String message;
    private String data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
