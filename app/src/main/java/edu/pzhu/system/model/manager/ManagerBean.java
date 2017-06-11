package edu.pzhu.system.model.manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerBean {

    /**
     * datas : {"totalpage":1,"lists":[{"id":"1","status":"0","number_sn":"20171001","string":"进行中","create_time":"2017-05-07 "},{"id":"2","status":"1","number_sn":"20171002","string":"已完成","create_time":"2017-05-07 "}]}
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
         * totalpage : 1
         * lists : [{"id":"1","status":"0","number_sn":"20171001","string":"进行中","create_time":"2017-05-07 "},{"id":"2","status":"1","number_sn":"20171002","string":"已完成","create_time":"2017-05-07 "}]
         */
        private int totalpage;
        private ArrayList<ListsEntity> lists;

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public void setLists(ArrayList<ListsEntity> lists) {
            this.lists = lists;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public ArrayList<ListsEntity> getLists() {
            return lists;
        }

        public class ListsEntity {
            /**
             * id : 1
             * status : 0
             * number_sn : 20171001
             * string : 进行中
             * create_time : 2017-05-07
             */
            private String id;
            private String status;
            private String number_sn;
            private String string;
            private String create_time;

            public void setId(String id) {
                this.id = id;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setNumber_sn(String number_sn) {
                this.number_sn = number_sn;
            }

            public void setString(String string) {
                this.string = string;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getId() {
                return id;
            }

            public String getStatus() {
                return status;
            }

            public String getNumber_sn() {
                return number_sn;
            }

            public String getString() {
                return string;
            }

            public String getCreate_time() {
                return create_time;
            }
        }
    }
}
