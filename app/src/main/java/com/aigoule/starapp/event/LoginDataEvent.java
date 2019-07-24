package com.aigoule.starapp.event;

import com.aigoule.starapp.model.LoginModel;

public class LoginDataEvent extends BaseEvent {
    private LoginModel.DataBean data;
    public LoginDataEvent(LoginModel.DataBean data){
        this.data=data;
    }

    public LoginModel.DataBean getData() {
        return data;
    }

    public void setData(LoginModel.DataBean data) {
        this.data = data;
    }
}
