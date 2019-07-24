package com.aigoule.starapp.model;


public class Body {

    private String exp;
    private String id;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Body{" +
                "exp='" + exp + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
