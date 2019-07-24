package com.aigoule.starapp.model;


import java.io.Serializable;

/**
 * 描述：Model基类 其他model需继承该类
 */

public class BaseModel implements Serializable {
    protected boolean status;
    protected String msg;
    protected int code;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
