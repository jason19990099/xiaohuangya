package com.aigoule.starapp.event;

public class playerEvent extends BaseEvent {

    private String videourl;
    private String videoname;

    public playerEvent(String videourl,String videoname){
         this.videourl=videourl;
         this.videoname=videoname;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }
}
