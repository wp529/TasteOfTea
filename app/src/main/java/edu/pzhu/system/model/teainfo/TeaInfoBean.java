package edu.pzhu.system.model.teainfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/13.
 */
public class TeaInfoBean implements Serializable{

    /**
     * datas : {"totalpage":1,"lists":[{"id":"17","title":"我是标题","cover":"http://ogxlkpzgb.bkt.clouddn.com/Information/20170506/590d824c6a55d.png","web_url":" http: //localhost/thinkcmff_tea/Wap/Information/infoDetails?id=17","create_time":"2017-05-06","discribe":"我是简介","type":"茶叶 茶具 "}]}
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
         * lists : [{"id":"17","title":"我是标题","cover":"http://ogxlkpzgb.bkt.clouddn.com/Information/20170506/590d824c6a55d.png","web_url":" http: //localhost/thinkcmff_tea/Wap/Information/infoDetails?id=17","create_time":"2017-05-06","discribe":"我是简介","type":"茶叶 茶具 "}]
         */
        private int totalpage;
        private List<ListsEntity> lists;

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public void setLists(List<ListsEntity> lists) {
            this.lists = lists;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public List<ListsEntity> getLists() {
            return lists;
        }

        public class ListsEntity {
            /**
             * id : 17
             * title : 我是标题
             * cover : http://ogxlkpzgb.bkt.clouddn.com/Information/20170506/590d824c6a55d.png
             * web_url :  http: //localhost/thinkcmff_tea/Wap/Information/infoDetails?id=17
             * create_time : 2017-05-06
             * discribe : 我是简介
             * type : 茶叶 茶具
             */
            private String id;
            private String title;
            private String cover;
            private String web_url;
            private String create_time;
            private String discribe;
            private String type;

            public void setId(String id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public void setDiscribe(String discribe) {
                this.discribe = discribe;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getCover() {
                return cover;
            }

            public String getWeb_url() {
                return web_url;
            }

            public String getCreate_time() {
                return create_time;
            }

            public String getDiscribe() {
                return discribe;
            }

            public String getType() {
                return type;
            }
        }
    }
}
