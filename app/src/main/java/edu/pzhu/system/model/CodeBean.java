package edu.pzhu.system.model;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public class CodeBean {
    /**
     * datas : {"nickname":"你猜","status":"1","location":"这是详细地址","number_sn":"20171002","tea_park":"国胜茶园","id":"2","username":"18780182002","level":"0","price":"100.00","tea_name":"高品","name":"龙井","create_time":"2017-05-07 00:00:00","introduce_time":"0000-00-00 00:00:00","longtitude":"122.000000","latitude":"34.000000","mid":"82","place":"这儿","introduce_place":"西湖","lists":[{"id":"2","use_name":"","string":"施肥","create_time":"2017-05-07","use_number":"","type":"2"},{"id":"3","use_name":"","string":"修剪","create_time":"2017-05-07","use_number":"","type":"3"},{"id":"4","use_name":"钾肥","string":"修剪","create_time":"2017-05-21","use_number":"1.1包","type":"3"}]}
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
         * nickname : 你猜
         * status : 1
         * location : 这是详细地址
         * number_sn : 20171002
         * tea_park : 国胜茶园
         * id : 2
         * username : 18780182002
         * level : 0
         * price : 100.00
         * tea_name : 高品
         * name : 龙井
         * create_time : 2017-05-07 00:00:00
         * introduce_time : 0000-00-00 00:00:00
         * longtitude : 122.000000
         * latitude : 34.000000
         * mid : 82
         * place : 这儿
         * introduce_place : 西湖
         * lists : [{"id":"2","use_name":"","string":"施肥","create_time":"2017-05-07","use_number":"","type":"2"},{"id":"3","use_name":"","string":"修剪","create_time":"2017-05-07","use_number":"","type":"3"},{"id":"4","use_name":"钾肥","string":"修剪","create_time":"2017-05-21","use_number":"1.1包","type":"3"}]
         */
        private String nickname;
        private String status;
        private String location;
        private String number_sn;
        private String tea_park;
        private String id;
        private String username;
        private String level;
        private String price;
        private String tea_name;
        private String name;
        private String create_time;
        private String introduce_time;
        private String longtitude;
        private String latitude;
        private String mid;
        private String place;
        private String introduce_place;
        private List<ListsEntity> lists;

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setNumber_sn(String number_sn) {
            this.number_sn = number_sn;
        }

        public void setTea_park(String tea_park) {
            this.tea_park = tea_park;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setTea_name(String tea_name) {
            this.tea_name = tea_name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setIntroduce_time(String introduce_time) {
            this.introduce_time = introduce_time;
        }

        public void setLongtitude(String longtitude) {
            this.longtitude = longtitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public void setIntroduce_place(String introduce_place) {
            this.introduce_place = introduce_place;
        }

        public void setLists(List<ListsEntity> lists) {
            this.lists = lists;
        }

        public String getNickname() {
            return nickname;
        }

        public String getStatus() {
            return status;
        }

        public String getLocation() {
            return location;
        }

        public String getNumber_sn() {
            return number_sn;
        }

        public String getTea_park() {
            return tea_park;
        }

        public String getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getLevel() {
            return level;
        }

        public String getPrice() {
            return price;
        }

        public String getTea_name() {
            return tea_name;
        }

        public String getName() {
            return name;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getIntroduce_time() {
            return introduce_time;
        }

        public String getLongtitude() {
            return longtitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public String getMid() {
            return mid;
        }

        public String getPlace() {
            return place;
        }

        public String getIntroduce_place() {
            return introduce_place;
        }

        public List<ListsEntity> getLists() {
            return lists;
        }

        public class ListsEntity {
            /**
             * id : 2
             * use_name :
             * string : 施肥
             * create_time : 2017-05-07
             * use_number :
             * type : 2
             */
            private String id;
            private String use_name;
            private String string;
            private String create_time;
            private String use_number;
            private String type;

            public void setId(String id) {
                this.id = id;
            }

            public void setUse_name(String use_name) {
                this.use_name = use_name;
            }

            public void setString(String string) {
                this.string = string;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public void setUse_number(String use_number) {
                this.use_number = use_number;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public String getUse_name() {
                return use_name;
            }

            public String getString() {
                return string;
            }

            public String getCreate_time() {
                return create_time;
            }

            public String getUse_number() {
                return use_number;
            }

            public String getType() {
                return type;
            }
        }
    }
}
