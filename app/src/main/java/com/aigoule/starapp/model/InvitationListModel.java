package com.aigoule.starapp.model;

import java.util.List;

public class InvitationListModel extends BaseModel {

    /**
     * message :
     * data : {"invite_url":"http://lumen.test/user/register?tg=29","data":[{"u_id":26,"u_name":"hahayo","u_loginnum":0,"u_regtime":"2019-04-23"},{"u_id":28,"u_name":"long661","u_loginnum":1,"u_regtime":"2019-04-24"},{"u_id":34,"u_name":"uejdutfl","u_loginnum":0,"u_regtime":"2019-04-30"},{"u_id":37,"u_name":"dnwllsjo","u_loginnum":0,"u_regtime":"2019-04-30"},{"u_id":41,"u_name":"spfigekc","u_loginnum":0,"u_regtime":"2019-04-30"}],"first_page_url":"http://lumen.test/user/invitationList?page=1","last_page_url":"http://lumen.test/user/invitationList?page=1","previous_page_url":null,"next_page_url":null,"currentPage":1,"has_more_page":false}
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
         * invite_url : http://lumen.test/user/register?tg=29
         * data : [{"u_id":26,"u_name":"hahayo","u_loginnum":0,"u_regtime":"2019-04-23"},{"u_id":28,"u_name":"long661","u_loginnum":1,"u_regtime":"2019-04-24"},{"u_id":34,"u_name":"uejdutfl","u_loginnum":0,"u_regtime":"2019-04-30"},{"u_id":37,"u_name":"dnwllsjo","u_loginnum":0,"u_regtime":"2019-04-30"},{"u_id":41,"u_name":"spfigekc","u_loginnum":0,"u_regtime":"2019-04-30"}]
         * first_page_url : http://lumen.test/user/invitationList?page=1
         * last_page_url : http://lumen.test/user/invitationList?page=1
         * previous_page_url : null
         * next_page_url : null
         * currentPage : 1
         * has_more_page : false
         */

        private String invite_url;
        private String first_page_url;
        private String last_page_url;
        private Object previous_page_url;
        private Object next_page_url;
        private int currentPage;
        private boolean has_more_page;
        private List<DataBean> data;

        public String getInvite_url() {
            return invite_url;
        }

        public void setInvite_url(String invite_url) {
            this.invite_url = invite_url;
        }

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
             * u_id : 26
             * u_name : hahayo
             * u_loginnum : 0
             * u_regtime : 2019-04-23
             */

            private int u_id;
            private String u_name;
            private int u_loginnum;
            private String u_regtime;

            public int getU_id() {
                return u_id;
            }

            public void setU_id(int u_id) {
                this.u_id = u_id;
            }

            public String getU_name() {
                return u_name;
            }

            public void setU_name(String u_name) {
                this.u_name = u_name;
            }

            public int getU_loginnum() {
                return u_loginnum;
            }

            public void setU_loginnum(int u_loginnum) {
                this.u_loginnum = u_loginnum;
            }

            public String getU_regtime() {
                return u_regtime;
            }

            public void setU_regtime(String u_regtime) {
                this.u_regtime = u_regtime;
            }
        }
    }
}
