package com.aigoule.starapp.model;

import java.util.List;

public class SearchModel extends BaseModel{


    /**
     * message :
     * data : [{"d_name":"被性感閨蜜看上自己男友 打賭誰能讓男友爽誰就能成爲他的女人","d_id":1426,"d_picture":"http://xhy166.com//pictures/20190801/5d42fd668849b.jpg","d_content":"","image_width":227,"image_height":341},{"d_name":"專門學習了讓女人發情的按摩手法用在超美的女友身上 真是超有效果的","d_id":962,"d_picture":"http://xhy166.com//pictures/20190613/5d025fc2ebba0.jpg","d_content":"","image_width":510,"image_height":294},{"d_name":"大酒店调教大奶美少妇，奶都扎破也不敢坑声，女人就是要这样调教才给力","d_id":730,"d_picture":"http://xhy166.com//uploadfile/image/20190503/20190503221028_18022.png","d_content":"","image_width":929,"image_height":521},{"d_name":"国产比女人还美的TS人妖米兰独自一人在酒店寂寞的撸射","d_id":687,"d_picture":"http://xhy166.com//uploadfile/image/20190502/20190502162017_62724.png","d_content":"","image_width":329,"image_height":497},{"d_name":"被单男猛操的女人是我的律师高傲老婆","d_id":535,"d_picture":"http://xhy166.com//uploadfile/image/20190426/20190426164134_47329.png","d_content":"","image_width":456,"image_height":378}]
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
         * d_name : 被性感閨蜜看上自己男友 打賭誰能讓男友爽誰就能成爲他的女人
         * d_id : 1426
         * d_picture : http://xhy166.com//pictures/20190801/5d42fd668849b.jpg
         * d_content :
         * image_width : 227
         * image_height : 341
         */

        private String d_name;
        private int d_id;
        private String d_picture;
        private String d_content;
        private int image_width;
        private int image_height;

        public String getD_name() {
            return d_name;
        }

        public void setD_name(String d_name) {
            this.d_name = d_name;
        }

        public int getD_id() {
            return d_id;
        }

        public void setD_id(int d_id) {
            this.d_id = d_id;
        }

        public String getD_picture() {
            return d_picture;
        }

        public void setD_picture(String d_picture) {
            this.d_picture = d_picture;
        }

        public String getD_content() {
            return d_content;
        }

        public void setD_content(String d_content) {
            this.d_content = d_content;
        }

        public int getImage_width() {
            return image_width;
        }

        public void setImage_width(int image_width) {
            this.image_width = image_width;
        }

        public int getImage_height() {
            return image_height;
        }

        public void setImage_height(int image_height) {
            this.image_height = image_height;
        }
    }
}
