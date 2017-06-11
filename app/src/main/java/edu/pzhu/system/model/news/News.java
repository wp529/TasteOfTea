package edu.pzhu.system.model.news;

import java.util.List;

/**
 *
 */
public class News {

    /**
     * data : [{"content":"今天天气阴","id":"13","author":"王苹","title":"哈哈","image":"null","date":"2017-4-1 14:12"},{"content":"今天天气阴","id":"14","author":"王苹","title":"哈哈","image":"null","date":"2017-4-1 14:12"},{"content":"123","id":"22","author":"教务处","title":"测试数据","image":"null","date":"2017-05-06 10:45:19"},{"content":"哈哈哈","id":"21","author":"教务处","title":"我是测试数据","image":"null","date":"2017-05-06 10:44:56"},{"content":"你好啊","id":"20","author":"学生处","title":"你好","image":"null","date":"2017-05-03 09:58:18"}]
     */
    private List<DataEntity> data;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public class DataEntity {
        /**
         * content : 今天天气阴
         * id : 13
         * author : 王苹
         * title : 哈哈
         * image : null
         * date : 2017-4-1 14:12
         */
        private String content;
        private String id;
        private String author;
        private String title;
        private String image;
        private String date;

        public void setContent(String content) {
            this.content = content;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public String getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public String getImage() {
            return image;
        }

        public String getDate() {
            return date;
        }
    }
}
