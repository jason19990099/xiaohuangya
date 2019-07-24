package com.aigoule.starapp.model;

public class PlaydetailModel extends BaseModel {

    /**
     * message :
     * data : {"title":"猛插燕舞情人，骚的不得了","image_url":"http://xhy166.com//uploadfile/image/20190417/20190417000036_97747.jpg","video_url":"http://43.226.16.31:2100/20190416/HuAd2lAY/index.m3u8"}
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
         * title : 猛插燕舞情人，骚的不得了
         * image_url : http://xhy166.com//uploadfile/image/20190417/20190417000036_97747.jpg
         * video_url : http://43.226.16.31:2100/20190416/HuAd2lAY/index.m3u8
         */

        private String title;
        private String image_url;
        private String video_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }
    }
}
