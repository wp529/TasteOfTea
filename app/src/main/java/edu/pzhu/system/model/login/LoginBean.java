package edu.pzhu.system.model.login;

/**
 *
 */
public class LoginBean {

    /**
     * datas : {"username":"15680351591","token":"f9cb1a6bbb10f2d9dd4f2e5011e3203a","status":"1","address":"是点击付款了束带结发","nickname":"王萍","create_time":"2017-05-25 ","mid":"83"}
     * code : 200
     */
    private DatasEntity datas;
    private int code;

    public void setDatas(DatasEntity datas) {
        this.datas = datas;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasEntity getDatas() {
        return datas;
    }

    public int getCode() {
        return code;
    }

    public class DatasEntity {
        /**
         * username : 15680351591
         * token : f9cb1a6bbb10f2d9dd4f2e5011e3203a
         * status : 1
         * address : 是点击付款了束带结发
         * nickname : 王萍
         * create_time : 2017-05-25
         * mid : 83
         */
        private String username;
        private String token;
        private String status;
        private String address;
        private String nickname;
        private String create_time;
        private String mid;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getUsername() {
            return username;
        }

        public String getToken() {
            return token;
        }

        public String getStatus() {
            return status;
        }

        public String getAddress() {
            return address;
        }

        public String getNickname() {
            return nickname;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getMid() {
            return mid;
        }
    }
}
