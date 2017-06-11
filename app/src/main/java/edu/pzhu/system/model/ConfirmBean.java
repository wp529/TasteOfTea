package edu.pzhu.system.model;

/**
 * Created by Administrator on 2017/5/25.
 */
public class ConfirmBean {

    /**
     * datas : {"number_sn":"2017050702"}
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
         * number_sn : 2017050702
         */
        private String number_sn;

        public void setNumber_sn(String number_sn) {
            this.number_sn = number_sn;
        }

        public String getNumber_sn() {
            return number_sn;
        }
    }
}
