package com.aigoule.starapp.model;

import java.util.List;

public class ThemeDetailModel extends BaseModel {


    /**
     * message :
     * data : {"theme_detail":{"theme_id":17,"title":"水野朝陽","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162447_10173.jpg","description":"水野朝阳（みずのあさひ）是一名日本AV女优，1990年11月12日出生于东京都，经济公司是プロダクションクラップ，三围是B90cm、W58cm、H88cm。"},"theme_video":[{"video_id":294,"title":"友達の目の前で犯されるレズビアン女子校生","picture":"http://xhy166.com//pictures/20190725/5d3981d0a2cf8.jpg"},{"video_id":165,"title":"親の居ない日、僕は5人の姉とむちゃくちゃSEXした。","picture":"http://xhy166.com//pictures/20190712/5d2860f97aad5.jpg"},{"video_id":153,"title":"ワキ出しっぱなし性交 ～ワキ舐め・脇コキ・ワキ発射～","picture":"http://xhy166.com//pictures/20190711/5d26f9db99aaf.jpg"},{"video_id":141,"title":"パンスト20デニールのオールスルーデカ尻オンナ","picture":"http://xhy166.com//pictures/20190711/5d26ad38dbc05.jpg"},{"video_id":140,"title":"至近距離NTR 僕が起きている事に気付かず、腰を振り続けている妻に何も出来なかった時の話です。","picture":"http://xhy166.com//pictures/20190711/5d26acd00da09.jpg"},{"video_id":139,"title":"私だけのレズビアンペット-2泊3日の温泉旅行で、つばささんを私だけのモノにします。-","picture":"http://xhy166.com//pictures/20190711/5d26ac6b66637.jpg"},{"video_id":138,"title":"水野朝陽AV引退 水野朝陽のAV最後の朝陽を一緒に見ませんか？","picture":"http://xhy166.com//pictures/20190711/5d26abfa7cb29.jpg"},{"video_id":80,"title":"美脚黒ストッキングOL中出し乱交～仕事終わりにオフィスで乱交した思い出～","picture":"http://xhy166.com//pictures/20190705/5d1eb5e580fdb.jpg"}]}
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
         * theme_detail : {"theme_id":17,"title":"水野朝陽","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162447_10173.jpg","description":"水野朝阳（みずのあさひ）是一名日本AV女优，1990年11月12日出生于东京都，经济公司是プロダクションクラップ，三围是B90cm、W58cm、H88cm。"}
         * theme_video : [{"video_id":294,"title":"友達の目の前で犯されるレズビアン女子校生","picture":"http://xhy166.com//pictures/20190725/5d3981d0a2cf8.jpg"},{"video_id":165,"title":"親の居ない日、僕は5人の姉とむちゃくちゃSEXした。","picture":"http://xhy166.com//pictures/20190712/5d2860f97aad5.jpg"},{"video_id":153,"title":"ワキ出しっぱなし性交 ～ワキ舐め・脇コキ・ワキ発射～","picture":"http://xhy166.com//pictures/20190711/5d26f9db99aaf.jpg"},{"video_id":141,"title":"パンスト20デニールのオールスルーデカ尻オンナ","picture":"http://xhy166.com//pictures/20190711/5d26ad38dbc05.jpg"},{"video_id":140,"title":"至近距離NTR 僕が起きている事に気付かず、腰を振り続けている妻に何も出来なかった時の話です。","picture":"http://xhy166.com//pictures/20190711/5d26acd00da09.jpg"},{"video_id":139,"title":"私だけのレズビアンペット-2泊3日の温泉旅行で、つばささんを私だけのモノにします。-","picture":"http://xhy166.com//pictures/20190711/5d26ac6b66637.jpg"},{"video_id":138,"title":"水野朝陽AV引退 水野朝陽のAV最後の朝陽を一緒に見ませんか？","picture":"http://xhy166.com//pictures/20190711/5d26abfa7cb29.jpg"},{"video_id":80,"title":"美脚黒ストッキングOL中出し乱交～仕事終わりにオフィスで乱交した思い出～","picture":"http://xhy166.com//pictures/20190705/5d1eb5e580fdb.jpg"}]
         */

        private ThemeDetailBean theme_detail;
        private List<ThemeVideoBean> theme_video;

        public ThemeDetailBean getTheme_detail() {
            return theme_detail;
        }

        public void setTheme_detail(ThemeDetailBean theme_detail) {
            this.theme_detail = theme_detail;
        }

        public List<ThemeVideoBean> getTheme_video() {
            return theme_video;
        }

        public void setTheme_video(List<ThemeVideoBean> theme_video) {
            this.theme_video = theme_video;
        }

        public static class ThemeDetailBean {
            /**
             * theme_id : 17
             * title : 水野朝陽
             * picture : http://xhy166.com//uploadfile/image/20190701/20190701162447_10173.jpg
             * description : 水野朝阳（みずのあさひ）是一名日本AV女优，1990年11月12日出生于东京都，经济公司是プロダクションクラップ，三围是B90cm、W58cm、H88cm。
             */

            private int theme_id;
            private String title;
            private String picture;
            private String description;

            public int getTheme_id() {
                return theme_id;
            }

            public void setTheme_id(int theme_id) {
                this.theme_id = theme_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class ThemeVideoBean {
            /**
             * video_id : 294
             * title : 友達の目の前で犯されるレズビアン女子校生
             * picture : http://xhy166.com//pictures/20190725/5d3981d0a2cf8.jpg
             */

            private int video_id;
            private String title;
            private String picture;

            public int getVideo_id() {
                return video_id;
            }

            public void setVideo_id(int video_id) {
                this.video_id = video_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }
        }
    }
}
