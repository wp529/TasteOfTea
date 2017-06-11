package edu.pzhu.system.model.selectresult;

import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public class SelectResultBean {

    /**
     * datas : {"lists":[{"id":"2","use_name":"","string":"施肥","create_time":"2017-05-07","use_number":"","type":"2"},{"id":"3","use_name":"","string":"修剪","create_time":"2017-05-07","use_number":"","type":"3"},{"id":"4","use_name":"钾肥","string":"修剪","create_time":"2017-05-21","use_number":"1.1包","type":"3"}],"info":{"status":"1","location":"这是详细地址","number_sn":"20171002","tea_park":"国胜茶园","id":"2","price":"100.00","name":"龙井","introduce_time":"0000-00-00 00:00:00","create_time":"2017-05-07 00:00:00","longtitude":"122.000000","mid":"82","latitude":"34.000000","introduce_place":"西湖"}}
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
         * lists : [{"id":"2","use_name":"","string":"施肥","create_time":"2017-05-07","use_number":"","type":"2"},{"id":"3","use_name":"","string":"修剪","create_time":"2017-05-07","use_number":"","type":"3"},{"id":"4","use_name":"钾肥","string":"修剪","create_time":"2017-05-21","use_number":"1.1包","type":"3"}]
         * info : {"status":"1","location":"这是详细地址","number_sn":"20171002","tea_park":"国胜茶园","id":"2","price":"100.00","name":"龙井","introduce_time":"0000-00-00 00:00:00","create_time":"2017-05-07 00:00:00","longtitude":"122.000000","mid":"82","latitude":"34.000000","introduce_place":"西湖"}
         */
        private List<ListsEntity> lists;
        private InfoEntity info;

        public void setLists(List<ListsEntity> lists) {
            this.lists = lists;
        }

        public void setInfo(InfoEntity info) {
            this.info = info;
        }

        public List<ListsEntity> getLists() {
            return lists;
        }

        public InfoEntity getInfo() {
            return info;
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

        public class InfoEntity {
            /**
             * status : 1
             * location : 这是详细地址
             * number_sn : 20171002
             * tea_park : 国胜茶园
             * id : 2
             * price : 100.00
             * name : 龙井
             * introduce_time : 0000-00-00 00:00:00
             * create_time : 2017-05-07 00:00:00
             * longtitude : 122.000000
             * mid : 82
             * latitude : 34.000000
             * introduce_place : 西湖
             */
            private String status;
            private String location;
            private String number_sn;
            private String tea_park;
            private String id;
            private String price;
            private String name;
            private String introduce_time;
            private String create_time;
            private String longtitude;
            private String mid;
            private String latitude;
            private String introduce_place;

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

            public void setPrice(String price) {
                this.price = price;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setIntroduce_time(String introduce_time) {
                this.introduce_time = introduce_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public void setLongtitude(String longtitude) {
                this.longtitude = longtitude;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public void setIntroduce_place(String introduce_place) {
                this.introduce_place = introduce_place;
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

            public String getPrice() {
                return price;
            }

            public String getName() {
                return name;
            }

            public String getIntroduce_time() {
                return introduce_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public String getLongtitude() {
                return longtitude;
            }

            public String getMid() {
                return mid;
            }

            public String getLatitude() {
                return latitude;
            }

            public String getIntroduce_place() {
                return introduce_place;
            }
        }
    }
}
