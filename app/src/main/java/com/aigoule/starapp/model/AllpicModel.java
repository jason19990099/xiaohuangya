package com.aigoule.starapp.model;

import java.util.List;

public class AllpicModel extends BaseModel {

    /**
     * message :
     * data : [{"url":8,"name":"pic1"},{"url":6,"name":"222"},{"url":7,"name":"111"}]
     */

    private String message;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : 8
         * name : pic1
         */

        private int url;
        private String name;

        public int getUrl() {
            return url;
        }

        public void setUrl(int url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
