package com.aigoule.starapp.event;

public class ThemeIdEvent extends BaseEvent {

 private int themeid;


    public ThemeIdEvent(int themeid){
        this.themeid=themeid;

    }

    public int getThemeid() {
        return themeid;
    }

    public void setThemeid(int themeid) {
        this.themeid = themeid;
    }
}
