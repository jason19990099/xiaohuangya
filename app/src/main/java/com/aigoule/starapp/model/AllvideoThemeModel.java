package com.aigoule.starapp.model;

import java.util.List;

public class AllvideoThemeModel extends BaseModel {


    /**
     * message :
     * data : [{"title":"女优专题","logo":"http://xhy166.com//images/tv.png","more":"http://api.xhy166.com/theme/themeMore/1","list":[{"theme_id":20,"title":"三上悠亜","picture":"http://xhy166.com//uploadfile/image/20190701/20190701155930_40351.jpg"},{"theme_id":15,"title":"希志あいの","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145255_58051.jpg"},{"theme_id":18,"title":"三原ほのか","picture":"http://xhy166.com//uploadfile/image/20190701/20190701155847_80633.jpg"},{"theme_id":16,"title":"星奈あい","picture":"http://xhy166.com//uploadfile/image/20190701/20190701160614_57846.jpg"},{"theme_id":14,"title":"大槻ひびき","picture":"http://xhy166.com//uploadfile/image/20190701/20190701161136_96848.jpg"},{"theme_id":13,"title":"篠田ゆう","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145014_92425.jpg"},{"theme_id":17,"title":"水野朝陽","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162447_10173.jpg"},{"theme_id":12,"title":"佐々木あき","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162922_86403.jpg"},{"theme_id":11,"title":"浜崎真緒","picture":"http://xhy166.com//uploadfile/image/20190701/20190701172346_78474.jpg"},{"theme_id":7,"title":"波多野結衣","picture":"http://xhy166.com//uploadfile/image/20190701/20190701173351_72802.jpg"},{"theme_id":9,"title":"椎名そら","picture":"http://xhy166.com//uploadfile/image/20190701/20190701174625_60203.jpg"},{"theme_id":6,"title":"泷泽萝拉","picture":"http://xhy166.com//uploadfile/image/20190701/20190701183240_10100.jpg"},{"theme_id":21,"title":"橋本ありな","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145553_84029.jpg"},{"theme_id":19,"title":"白石茉莉奈","picture":"http://xhy166.com//uploadfile/image/20190701/20190701175216_68564.jpg"},{"theme_id":22,"title":"小島みなみ","picture":"http://xhy166.com//uploadfile/image/20190702/20190702122505_67764.jpg"},{"theme_id":23,"title":"桜空もも","picture":"http://xhy166.com//uploadfile/image/20190703/20190703154848_95794.jpg"}]},{"title":"热门专题","logo":"http://xhy166.com//images/tv.png","more":"http://api.xhy166.com/theme/themeMore/0","list":[{"theme_id":5,"title":"Mila Azul","picture":"http://xhy166.com//uploadfile/image/20190701/20190701173727_36540.jpg"},{"theme_id":2,"title":"软萌萝莉小仙","picture":"http://xhy166.com//uploadfile/image/20190701/20190701181923_24075.jpg"},{"theme_id":8,"title":"巨乳","picture":"http://xhy166.com//uploadfile/image/20190701/20190701181632_57217.jpg"},{"theme_id":3,"title":"潮吹","picture":"http://xhy166.com//uploadfile/image/20190710/20190710172632_93836.jpg"},{"theme_id":1,"title":"怪蜀黍的乖萝莉","picture":"http://xhy166.com//uploadfile/image/20190710/20190710173219_12179.jpg"},{"theme_id":4,"title":"萌白酱","picture":"http://xhy166.com//uploadfile/image/20190706/20190706150549_31168.jpg"},{"theme_id":10,"title":"小黄鸭独家制作","picture":"http://xhy166.com//uploadfile/image/20190623/20190623162952_83757.png"}]}]
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
         * title : 女优专题
         * logo : http://xhy166.com//images/tv.png
         * more : http://api.xhy166.com/theme/themeMore/1
         * list : [{"theme_id":20,"title":"三上悠亜","picture":"http://xhy166.com//uploadfile/image/20190701/20190701155930_40351.jpg"},{"theme_id":15,"title":"希志あいの","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145255_58051.jpg"},{"theme_id":18,"title":"三原ほのか","picture":"http://xhy166.com//uploadfile/image/20190701/20190701155847_80633.jpg"},{"theme_id":16,"title":"星奈あい","picture":"http://xhy166.com//uploadfile/image/20190701/20190701160614_57846.jpg"},{"theme_id":14,"title":"大槻ひびき","picture":"http://xhy166.com//uploadfile/image/20190701/20190701161136_96848.jpg"},{"theme_id":13,"title":"篠田ゆう","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145014_92425.jpg"},{"theme_id":17,"title":"水野朝陽","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162447_10173.jpg"},{"theme_id":12,"title":"佐々木あき","picture":"http://xhy166.com//uploadfile/image/20190701/20190701162922_86403.jpg"},{"theme_id":11,"title":"浜崎真緒","picture":"http://xhy166.com//uploadfile/image/20190701/20190701172346_78474.jpg"},{"theme_id":7,"title":"波多野結衣","picture":"http://xhy166.com//uploadfile/image/20190701/20190701173351_72802.jpg"},{"theme_id":9,"title":"椎名そら","picture":"http://xhy166.com//uploadfile/image/20190701/20190701174625_60203.jpg"},{"theme_id":6,"title":"泷泽萝拉","picture":"http://xhy166.com//uploadfile/image/20190701/20190701183240_10100.jpg"},{"theme_id":21,"title":"橋本ありな","picture":"http://xhy166.com//uploadfile/image/20190708/20190708145553_84029.jpg"},{"theme_id":19,"title":"白石茉莉奈","picture":"http://xhy166.com//uploadfile/image/20190701/20190701175216_68564.jpg"},{"theme_id":22,"title":"小島みなみ","picture":"http://xhy166.com//uploadfile/image/20190702/20190702122505_67764.jpg"},{"theme_id":23,"title":"桜空もも","picture":"http://xhy166.com//uploadfile/image/20190703/20190703154848_95794.jpg"}]
         */

        private String title;
        private String logo;
        private String more;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * theme_id : 20
             * title : 三上悠亜
             * picture : http://xhy166.com//uploadfile/image/20190701/20190701155930_40351.jpg
             */

            private int theme_id;
            private String title;
            private String picture;

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
        }
    }
}
