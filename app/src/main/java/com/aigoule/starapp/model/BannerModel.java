package com.aigoule.starapp.model;

import java.util.List;

public class BannerModel extends BaseModel {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * l_url :
         * l_name : .
         * l_logo : http://xhy166.com//uploadfile/image/20190426/20190426191526_15425.png
         */

        private String l_url;
        private String l_name;
        private String l_logo;

        public String getL_url() {
            return l_url;
        }

        public void setL_url(String l_url) {
            this.l_url = l_url;
        }

        public String getL_name() {
            return l_name;
        }

        public void setL_name(String l_name) {
            this.l_name = l_name;
        }

        public String getL_logo() {
            return l_logo;
        }

        public void setL_logo(String l_logo) {
            this.l_logo = l_logo;
        }
    }
}
