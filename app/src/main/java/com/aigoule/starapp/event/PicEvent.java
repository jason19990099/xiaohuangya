package com.aigoule.starapp.event;

public class PicEvent extends BaseEvent {

 private String linl_url;
 private String title;

    public PicEvent(String linl_url,String title){
        this.linl_url=linl_url;
        this.title=title;
    }
    public String getLinl_url() {
        return linl_url;
    }

    public void setLinl_url(String linl_url) {
        this.linl_url = linl_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
