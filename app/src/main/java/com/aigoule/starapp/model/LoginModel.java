package com.aigoule.starapp.model;

public class LoginModel extends BaseModel {


    /**
     * message :
     * data : {"u_id":95,"u_qid":"0","u_name":"long123","u_password":"5abd06d6f6ef0e022e11b8a41f57ebda","u_qq":"","u_email":"lonjj@ghh.bon","u_phone":"","u_status":1,"u_flag":0,"u_question":"","u_answer":"","u_group":1,"u_points":0,"u_regtime":"1559890196","u_logintime":"2019-06-07 16:06:59","u_loginnum":2,"u_extend":0,"u_loginip":"10.1.52.14","u_random":"","u_fav":"0","u_plays":"0","u_downs":"0","u_start":0,"u_end":0,"regtime":"2019-06-07 14:49:56","id":95,"name":"long123","qq":"","email":"lonjj@ghh.bon","phone":"","logintime":"2019-06-07 16:07:07","group_name":"普通会员"}
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
         * u_id : 95
         * u_qid : 0
         * u_name : long123
         * u_password : 5abd06d6f6ef0e022e11b8a41f57ebda
         * u_qq :
         * u_email : lonjj@ghh.bon
         * u_phone :
         * u_status : 1
         * u_flag : 0
         * u_question :
         * u_answer :
         * u_group : 1
         * u_points : 0
         * u_regtime : 1559890196
         * u_logintime : 2019-06-07 16:06:59
         * u_loginnum : 2
         * u_extend : 0
         * u_loginip : 10.1.52.14
         * u_random :
         * u_fav : 0
         * u_plays : 0
         * u_downs : 0
         * u_start : 0
         * u_end : 0
         * regtime : 2019-06-07 14:49:56
         * id : 95
         * name : long123
         * qq :
         * email : lonjj@ghh.bon
         * phone :
         * logintime : 2019-06-07 16:07:07
         * group_name : 普通会员
         */

        private int u_id;
        private String u_qid;
        private String u_name;
        private String u_password;
        private String u_qq;
        private String u_email;
        private String u_phone;
        private int u_status;
        private int u_flag;
        private String u_question;
        private String u_answer;
        private int u_group;
        private int u_points;
        private String u_regtime;
        private String u_logintime;
        private int u_loginnum;
        private int u_extend;
        private String u_loginip;
        private String u_random;
        private String u_fav;
        private String u_plays;
        private String u_downs;
        private int u_start;
        private int u_end;
        private String regtime;
        private int id;
        private String name;
        private String qq;
        private String email;
        private String phone;
        private String logintime;
        private String group_name;

        public int getU_id() {
            return u_id;
        }

        public void setU_id(int u_id) {
            this.u_id = u_id;
        }

        public String getU_qid() {
            return u_qid;
        }

        public void setU_qid(String u_qid) {
            this.u_qid = u_qid;
        }

        public String getU_name() {
            return u_name;
        }

        public void setU_name(String u_name) {
            this.u_name = u_name;
        }

        public String getU_password() {
            return u_password;
        }

        public void setU_password(String u_password) {
            this.u_password = u_password;
        }

        public String getU_qq() {
            return u_qq;
        }

        public void setU_qq(String u_qq) {
            this.u_qq = u_qq;
        }

        public String getU_email() {
            return u_email;
        }

        public void setU_email(String u_email) {
            this.u_email = u_email;
        }

        public String getU_phone() {
            return u_phone;
        }

        public void setU_phone(String u_phone) {
            this.u_phone = u_phone;
        }

        public int getU_status() {
            return u_status;
        }

        public void setU_status(int u_status) {
            this.u_status = u_status;
        }

        public int getU_flag() {
            return u_flag;
        }

        public void setU_flag(int u_flag) {
            this.u_flag = u_flag;
        }

        public String getU_question() {
            return u_question;
        }

        public void setU_question(String u_question) {
            this.u_question = u_question;
        }

        public String getU_answer() {
            return u_answer;
        }

        public void setU_answer(String u_answer) {
            this.u_answer = u_answer;
        }

        public int getU_group() {
            return u_group;
        }

        public void setU_group(int u_group) {
            this.u_group = u_group;
        }

        public int getU_points() {
            return u_points;
        }

        public void setU_points(int u_points) {
            this.u_points = u_points;
        }

        public String getU_regtime() {
            return u_regtime;
        }

        public void setU_regtime(String u_regtime) {
            this.u_regtime = u_regtime;
        }

        public String getU_logintime() {
            return u_logintime;
        }

        public void setU_logintime(String u_logintime) {
            this.u_logintime = u_logintime;
        }

        public int getU_loginnum() {
            return u_loginnum;
        }

        public void setU_loginnum(int u_loginnum) {
            this.u_loginnum = u_loginnum;
        }

        public int getU_extend() {
            return u_extend;
        }

        public void setU_extend(int u_extend) {
            this.u_extend = u_extend;
        }

        public String getU_loginip() {
            return u_loginip;
        }

        public void setU_loginip(String u_loginip) {
            this.u_loginip = u_loginip;
        }

        public String getU_random() {
            return u_random;
        }

        public void setU_random(String u_random) {
            this.u_random = u_random;
        }

        public String getU_fav() {
            return u_fav;
        }

        public void setU_fav(String u_fav) {
            this.u_fav = u_fav;
        }

        public String getU_plays() {
            return u_plays;
        }

        public void setU_plays(String u_plays) {
            this.u_plays = u_plays;
        }

        public String getU_downs() {
            return u_downs;
        }

        public void setU_downs(String u_downs) {
            this.u_downs = u_downs;
        }

        public int getU_start() {
            return u_start;
        }

        public void setU_start(int u_start) {
            this.u_start = u_start;
        }

        public int getU_end() {
            return u_end;
        }

        public void setU_end(int u_end) {
            this.u_end = u_end;
        }

        public String getRegtime() {
            return regtime;
        }

        public void setRegtime(String regtime) {
            this.regtime = regtime;
        }

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

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLogintime() {
            return logintime;
        }

        public void setLogintime(String logintime) {
            this.logintime = logintime;
        }

        public String getGroup_name() {
            return group_name;
        }

        public void setGroup_name(String group_name) {
            this.group_name = group_name;
        }
    }
}
