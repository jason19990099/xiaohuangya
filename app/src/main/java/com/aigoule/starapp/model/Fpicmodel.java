package com.aigoule.starapp.model;

import java.util.List;

public class Fpicmodel extends BaseModel {

    /**
     * message :
     * data : {"title":"福利图片","base_url":"http://xhy166.com/picture/classData","icon_image":"http://xhy166.com/images/icon/jiemu_show.png","list":[{"title":"test1","pic_url":"http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg","class_name":"pic1","link_url":10},{"title":"额撒飞洒","pic_url":"http://xhy166.com//style/load.gif","class_name":"222","link_url":9},{"title":"adcsa","pic_url":"http://xhy166.com//style/load.gif","class_name":"222","link_url":8},{"title":"wqaq","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":7},{"title":"sav ds","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":6},{"title":"点上班地方","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":5}]}
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
         * title : 福利图片
         * base_url : http://xhy166.com/picture/classData
         * icon_image : http://xhy166.com/images/icon/jiemu_show.png
         * list : [{"title":"test1","pic_url":"http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg","class_name":"pic1","link_url":10},{"title":"额撒飞洒","pic_url":"http://xhy166.com//style/load.gif","class_name":"222","link_url":9},{"title":"adcsa","pic_url":"http://xhy166.com//style/load.gif","class_name":"222","link_url":8},{"title":"wqaq","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":7},{"title":"sav ds","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":6},{"title":"点上班地方","pic_url":"http://xhy166.com//style/load.gif","class_name":null,"link_url":5}]
         */

        private String title;
        private String base_url;
        private String icon_image;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBase_url() {
            return base_url;
        }

        public void setBase_url(String base_url) {
            this.base_url = base_url;
        }

        public String getIcon_image() {
            return icon_image;
        }

        public void setIcon_image(String icon_image) {
            this.icon_image = icon_image;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : test1
             * pic_url : http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg
             * class_name : pic1
             * link_url : 10
             */

            private String title;
            private String pic_url;
            private String class_name;
            private int link_url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public int getLink_url() {
                return link_url;
            }

            public void setLink_url(int link_url) {
                this.link_url = link_url;
            }
        }
    }
}
