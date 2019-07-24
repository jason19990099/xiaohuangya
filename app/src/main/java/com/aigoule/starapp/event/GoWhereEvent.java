package com.aigoule.starapp.event;

public class GoWhereEvent extends BaseEvent {
    private int index;
    public GoWhereEvent(int index){
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
