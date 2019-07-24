package com.aigoule.starapp.model;

import java.util.List;

public class PicdetailModel  extends BaseModel{

    /**
     * message :
     * data : {"title":"test1","class_name":"pic1","time":"2019-05-09 11:54:52","image_list":["http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg","http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg","http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg"]}
     */

    private String message;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : test1
         * class_name : pic1
         * time : 2019-05-09 11:54:52
         * image_list : ["http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg","http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg","http://xhy166.com/Api/upload/php_server/files/10/201905101259515cd5054776de2.jpg"]
         */

        private String title;
        private String class_name;
        private String time;
        private List<String> image_list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public List<String> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<String> image_list) {
            this.image_list = image_list;
        }
    }
}
