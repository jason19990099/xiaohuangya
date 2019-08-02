package com.aigoule.starapp.model;

import java.util.List;

public class VideoclassdataModel extends BaseModel {


    /**
     * message :
     * data : {"currentPage":1,"has_more_page":false,"list":[{"image":"http://xhy166.com//uploadfile/image/20190430/20190430191322_16415.png","name":"91新人xh98hx新作-白色泳装美乳情人沙发上被操 持续抽插猛操 淫语浪叫\u201cJ8好大 使劲干我\u201d","image_width":0,"image_height":0,"video_url":654,"android_url":"http://xhy166.com/video/classData?id=654","video_id":654},{"image":"http://xhy166.com//pictures/20190424/1556106047.2765cc04b3f43663.png","name":"咲綾 （サアヤ）「変態浣腸 ～野外排泄する25歳～」","image_width":0,"image_height":0,"video_url":488,"android_url":"http://xhy166.com/video/classData?id=488","video_id":488},{"image":"http://xhy166.com//pictures/20190425/5cc1366c5a369.jpg","name":"快楽に溺れる２６歳 ～～異物挿入シンドローム","image_width":0,"image_height":0,"video_url":487,"android_url":"http://xhy166.com/video/classData?id=487","video_id":487},{"image":"http://xhy166.com//pictures/20190425/5cc132443a2c3.jpg","name":"狂った妊婦 ～電撃と輪姦中出し～","image_width":0,"image_height":0,"video_url":486,"android_url":"http://xhy166.com/video/classData?id=486","video_id":486}]}
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
         * currentPage : 1
         * has_more_page : false
         * list : [{"image":"http://xhy166.com//uploadfile/image/20190430/20190430191322_16415.png","name":"91新人xh98hx新作-白色泳装美乳情人沙发上被操 持续抽插猛操 淫语浪叫\u201cJ8好大 使劲干我\u201d","image_width":0,"image_height":0,"video_url":654,"android_url":"http://xhy166.com/video/classData?id=654","video_id":654},{"image":"http://xhy166.com//pictures/20190424/1556106047.2765cc04b3f43663.png","name":"咲綾 （サアヤ）「変態浣腸 ～野外排泄する25歳～」","image_width":0,"image_height":0,"video_url":488,"android_url":"http://xhy166.com/video/classData?id=488","video_id":488},{"image":"http://xhy166.com//pictures/20190425/5cc1366c5a369.jpg","name":"快楽に溺れる２６歳 ～～異物挿入シンドローム","image_width":0,"image_height":0,"video_url":487,"android_url":"http://xhy166.com/video/classData?id=487","video_id":487},{"image":"http://xhy166.com//pictures/20190425/5cc132443a2c3.jpg","name":"狂った妊婦 ～電撃と輪姦中出し～","image_width":0,"image_height":0,"video_url":486,"android_url":"http://xhy166.com/video/classData?id=486","video_id":486}]
         */

        private int currentPage;
        private boolean has_more_page;
        private List<ListBean> list;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * image : http://xhy166.com//uploadfile/image/20190430/20190430191322_16415.png
             * name : 91新人xh98hx新作-白色泳装美乳情人沙发上被操 持续抽插猛操 淫语浪叫“J8好大 使劲干我”
             * image_width : 0
             * image_height : 0
             * video_url : 654
             * android_url : http://xhy166.com/video/classData?id=654
             * video_id : 654
             */

            private String image;
            private String name;
            private int image_width;
            private int image_height;
            private int video_url;
            private String android_url;
            private String video_id;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public int getVideo_url() {
                return video_url;
            }

            public void setVideo_url(int video_url) {
                this.video_url = video_url;
            }

            public String getAndroid_url() {
                return android_url;
            }

            public void setAndroid_url(String android_url) {
                this.android_url = android_url;
            }

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }
        }
    }
}
