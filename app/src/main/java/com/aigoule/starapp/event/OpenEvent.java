package com.aigoule.starapp.event;

public class OpenEvent extends BaseEvent {
    private  boolean open;

    public OpenEvent(boolean open) {
        this.open=open;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
