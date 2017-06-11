package edu.pzhu.system.model;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public class FertilizationAndApplication {

    /**
     * datas : [{"id":"5","name":"敌敌畏"},{"id":"6","name":"敌敌畏2号"}]
     * code : 200
     */
    private List<DatasEntity> datas;
    private int code;

    public void setDatas(List<DatasEntity> datas) {
        this.datas = datas;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DatasEntity> getDatas() {
        return datas;
    }

    public int getCode() {
        return code;
    }

    public class DatasEntity {
        /**
         * id : 5
         * name : 敌敌畏
         */
        private String id;
        private String name;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
