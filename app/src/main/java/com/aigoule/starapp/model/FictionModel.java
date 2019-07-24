package com.aigoule.starapp.model;

import java.util.List;

public class FictionModel extends BaseModel {


    /**
     * message :
     * data : {"title":"激情小说","base_url":"http://10.7.0.60/fiction/classData","icon_image":"http://xhy166.com/images/icon/tv_show.png","list":[{"title":"我和美女少妇的野战","class_name":"都市激情","link_url":7},{"title":"我的美丽娇妻","class_name":"都市激情","link_url":6},{"title":"送上门的寂寞丝袜少妇","class_name":"都市激情","link_url":5},{"title":"第一次插大学女友的蜜穴","class_name":"都市激情","link_url":4},{"title":"一次三P的记录","class_name":"都市激情","link_url":3},{"title":"我强上了母亲","class_name":"都市激情","link_url":2},{"title":"性欲高涨的妻子","class_name":"都市激情","link_url":1}]}
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
         * title : 激情小说
         * base_url : http://10.7.0.60/fiction/classData
         * icon_image : http://xhy166.com/images/icon/tv_show.png
         * list : [{"title":"我和美女少妇的野战","class_name":"都市激情","link_url":7},{"title":"我的美丽娇妻","class_name":"都市激情","link_url":6},{"title":"送上门的寂寞丝袜少妇","class_name":"都市激情","link_url":5},{"title":"第一次插大学女友的蜜穴","class_name":"都市激情","link_url":4},{"title":"一次三P的记录","class_name":"都市激情","link_url":3},{"title":"我强上了母亲","class_name":"都市激情","link_url":2},{"title":"性欲高涨的妻子","class_name":"都市激情","link_url":1}]
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
             * title : 我和美女少妇的野战
             * class_name : 都市激情
             * link_url : 7
             */

            private String title;
            private String class_name;
            private int link_url;

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

            public int getLink_url() {
                return link_url;
            }

            public void setLink_url(int link_url) {
                this.link_url = link_url;
            }
        }
    }
}
