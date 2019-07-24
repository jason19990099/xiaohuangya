package com.aigoule.starapp.model;

import java.util.List;

public class AllvidesModel  extends BaseModel {

    /**
     * message :
     * data : [{"class_id":158,"name":"东南亚"},{"class_id":135,"name":"制服诱惑"},{"class_id":136,"name":"人妻熟女"},{"class_id":138,"name":"欧美AV"},{"class_id":139,"name":"深夜综艺"},{"class_id":140,"name":"三级剧情"},{"class_id":141,"name":"集体性爱"},{"class_id":142,"name":"日本当红女优"},{"class_id":143,"name":"国产精品"},{"class_id":144,"name":"重口变态"},{"class_id":145,"name":"素人"},{"class_id":146,"name":"不伦乱伦"},{"class_id":147,"name":"按摩桑拿"},{"class_id":148,"name":"H动漫"},{"class_id":150,"name":"偷拍"},{"class_id":151,"name":"自拍"},{"class_id":152,"name":"日本无码SM"},{"class_id":153,"name":"91网友"}]
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
         * class_id : 158
         * name : 东南亚
         */

        private int class_id;
        private String name;
        private boolean ifSelect;

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIfSelect() {
            return ifSelect;
        }

        public void setIfSelect(boolean ifSelect) {
            this.ifSelect = ifSelect;
        }
    }
}
