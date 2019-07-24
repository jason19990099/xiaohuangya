package com.aigoule.starapp.model;

import java.util.List;

public class PicModel extends BaseModel{
    /**
     * message :
     * data : {"data":[{"class_name":"pic1","title":"test1","link_url":10,"pic_url":"http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg"},{"class_name":"222","title":"额撒飞洒","link_url":9,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":"222","title":"adcsa","link_url":8,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"wqaq","link_url":7,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"sav ds","link_url":6,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"点上班地方","link_url":5,"pic_url":"http://xhy166.com//style/load.gif"}],"first_page_url":"http://10.7.0.60/play/history?page=1&id=0","last_page_url":"http://10.7.0.60/play/history?page=1id=0","previous_page_url":null,"next_page_url":null,"currentPage":1,"has_more_page":false}
     */

    private String message;
    private DataBeanX data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : [{"class_name":"pic1","title":"test1","link_url":10,"pic_url":"http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg"},{"class_name":"222","title":"额撒飞洒","link_url":9,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":"222","title":"adcsa","link_url":8,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"wqaq","link_url":7,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"sav ds","link_url":6,"pic_url":"http://xhy166.com//style/load.gif"},{"class_name":null,"title":"点上班地方","link_url":5,"pic_url":"http://xhy166.com//style/load.gif"}]
         * first_page_url : http://10.7.0.60/play/history?page=1&id=0
         * last_page_url : http://10.7.0.60/play/history?page=1id=0
         * previous_page_url : null
         * next_page_url : null
         * currentPage : 1
         * has_more_page : false
         */

        private String first_page_url;
        private String last_page_url;
        private Object previous_page_url;
        private Object next_page_url;
        private int currentPage;
        private boolean has_more_page;
        private List<DataBean> data;

        public String getFirst_page_url() {
            return first_page_url;
        }

        public void setFirst_page_url(String first_page_url) {
            this.first_page_url = first_page_url;
        }

        public String getLast_page_url() {
            return last_page_url;
        }

        public void setLast_page_url(String last_page_url) {
            this.last_page_url = last_page_url;
        }

        public Object getPrevious_page_url() {
            return previous_page_url;
        }

        public void setPrevious_page_url(Object previous_page_url) {
            this.previous_page_url = previous_page_url;
        }

        public Object getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(Object next_page_url) {
            this.next_page_url = next_page_url;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public boolean isHas_more_page() {
            return has_more_page;
        }

        public void setHas_more_page(boolean has_more_page) {
            this.has_more_page = has_more_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * class_name : pic1
             * title : test1
             * link_url : 10
             * pic_url : http://xhy166.com//uploadfile/image/20190509/20190509115446_18457.jpg
             */

            private String class_name;
            private String title;
            private int link_url;
            private String pic_url;

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getLink_url() {
                return link_url;
            }

            public void setLink_url(int link_url) {
                this.link_url = link_url;
            }

            public String getPic_url() {
                return pic_url;
            }

            public void setPic_url(String pic_url) {
                this.pic_url = pic_url;
            }
        }
    }
}
