package com.aigoule.starapp.event;

public class playerEvent extends BaseEvent {

    private int videourl;
    private String videoname;

    public playerEvent(int videourl,String videoname){
         this.videourl=videourl;
         this.videoname=videoname;
    }

    public int getVideourl() {
        return videourl;
    }

    public void setVideourl(int videourl) {
        this.videourl = videourl;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }
}
