package com.aigoule.starapp.model;

import java.util.List;

public class PlayRecordsModel extends BaseModel {


    /**
     * message :
     * data : {"data":[{"id":116372,"name":"猛插燕舞情人，骚的不得了","url":360},{"id":116373,"name":"放課後～濡れた制服～ 課外授業2","url":568},{"id":116374,"name":"學生妹子!片段影片外流!女學生長得很單純!奶子很誘人","url":581},{"id":116375,"name":"对白淫荡呻吟刺激南艺大三援交小姐姐","url":588},{"id":116376,"name":"土豪包養的貴妃雞私家服務真是羨煞旁人","url":453},{"id":116378,"name":"完美奶大日本女神","url":428},{"id":116379,"name":"网红演绎留守村姑被劳作归来的农民大叔强搞","url":706},{"id":116380,"name":"這叫声会不会太夸张 被草的有这么爽吗","url":403},{"id":116381,"name":"广州激情夫妻卧室门 (1)","url":793},{"id":116382,"name":"铃木杏里唯一无码片这套情趣内衣真让人受不了","url":691},{"id":116383,"name":"清纯妹子和炮友宾馆做爱自拍又一个好白菜让猪拱了","url":529},{"id":116384,"name":"爸爸的朋友2.Dad\u2019s.Friends.2","url":760},{"id":116385,"name":"孟莉《裸血》1","url":413},{"id":116386,"name":"国产~巅峰之作超正嫩妹之女王","url":475},{"id":116387,"name":"身材一流的极品美女屁股很翘，连续操了2次才肯罢休","url":577},{"id":116390,"name":"英国小伙梅塞斯高级私人会所嫖鸡网红脸蛋的大波妹口爆吞精","url":850},{"id":116391,"name":"眼镜哥夫妻第2季13女神老婆精油涂身电击打炮被狠干（上）","url":785},{"id":116392,"name":"长腿气质姐姐约\u200b\u200b炮小区猛男干到爽翻天","url":472},{"id":116393,"name":"大学生情侣性爱自拍逼逼粘着震蛋玩能不爽么","url":820},{"id":116394,"name":"早抜き 咲乃柑菜BEST2","url":844}],"first_page_url":"http://10.7.0.60/user/history?page=1","last_page_url":"http://10.7.0.60/user/history?page=7","previous_page_url":null,"next_page_url":"http://10.7.0.60/user/history?page=2","currentPage":1,"has_more_page":true}
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
         * data : [{"id":116372,"name":"猛插燕舞情人，骚的不得了","url":360},{"id":116373,"name":"放課後～濡れた制服～ 課外授業2","url":568},{"id":116374,"name":"學生妹子!片段影片外流!女學生長得很單純!奶子很誘人","url":581},{"id":116375,"name":"对白淫荡呻吟刺激南艺大三援交小姐姐","url":588},{"id":116376,"name":"土豪包養的貴妃雞私家服務真是羨煞旁人","url":453},{"id":116378,"name":"完美奶大日本女神","url":428},{"id":116379,"name":"网红演绎留守村姑被劳作归来的农民大叔强搞","url":706},{"id":116380,"name":"這叫声会不会太夸张 被草的有这么爽吗","url":403},{"id":116381,"name":"广州激情夫妻卧室门 (1)","url":793},{"id":116382,"name":"铃木杏里唯一无码片这套情趣内衣真让人受不了","url":691},{"id":116383,"name":"清纯妹子和炮友宾馆做爱自拍又一个好白菜让猪拱了","url":529},{"id":116384,"name":"爸爸的朋友2.Dad\u2019s.Friends.2","url":760},{"id":116385,"name":"孟莉《裸血》1","url":413},{"id":116386,"name":"国产~巅峰之作超正嫩妹之女王","url":475},{"id":116387,"name":"身材一流的极品美女屁股很翘，连续操了2次才肯罢休","url":577},{"id":116390,"name":"英国小伙梅塞斯高级私人会所嫖鸡网红脸蛋的大波妹口爆吞精","url":850},{"id":116391,"name":"眼镜哥夫妻第2季13女神老婆精油涂身电击打炮被狠干（上）","url":785},{"id":116392,"name":"长腿气质姐姐约\u200b\u200b炮小区猛男干到爽翻天","url":472},{"id":116393,"name":"大学生情侣性爱自拍逼逼粘着震蛋玩能不爽么","url":820},{"id":116394,"name":"早抜き 咲乃柑菜BEST2","url":844}]
         * first_page_url : http://10.7.0.60/user/history?page=1
         * last_page_url : http://10.7.0.60/user/history?page=7
         * previous_page_url : null
         * next_page_url : http://10.7.0.60/user/history?page=2
         * currentPage : 1
         * has_more_page : true
         */

        private String first_page_url;
        private String last_page_url;
        private Object previous_page_url;
        private String next_page_url;
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

        public String getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(String next_page_url) {
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
             * id : 116372
             * name : 猛插燕舞情人，骚的不得了
             * url : 360
             */

            private int id;
            private String name;
            private int url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getUrl() {
                return url;
            }

            public void setUrl(int url) {
                this.url = url;
            }
        }
    }
}
