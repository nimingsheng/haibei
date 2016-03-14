package com.nms.mydemo.seashell.bean;

import java.util.List;

/**
 * Created by my on 2016/3/8.
 */
public class Header {

    /**
     * code : 0
     * data : {"topics":[{"id":7,"image":"http://ec-img.ufile.ucloud.cn/e035d0f062584baf959713635de78880.jpg","title":"吃土也要败的女神爱用物"},{"id":1,"image":"http://ec-img.ufile.ucloud.cn/ac4f8096ae0146c88803390c2b7f0c66.png","title":"护肤保湿"},{"id":2,"image":"http://ec-img.ufile.ucloud.cn/10fbe715e91d44fa89b9da673c103cd1.jpg","title":"花王-乐而雅"},{"id":3,"image":"http://ec-img.ufile.ucloud.cn/465a30af077f40b69bcd8f49c181bce4.jpg","title":"影漫游戏周边"},{"id":4,"image":"http://ec-img.ufile.ucloud.cn/d0e1543ac9104bdfb4ed8dead9df003c.jpg","title":"Thermos保温杯"}]}
     * success : true
     */

    private int code;
    private DataEntity data;
    private boolean success;

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public DataEntity getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class DataEntity {
        /**
         * id : 7
         * image : http://ec-img.ufile.ucloud.cn/e035d0f062584baf959713635de78880.jpg
         * title : 吃土也要败的女神爱用物
         */

        private List<TopicsEntity> topics;

        public void setTopics(List<TopicsEntity> topics) {
            this.topics = topics;
        }

        public List<TopicsEntity> getTopics() {
            return topics;
        }

        public static class TopicsEntity {
            private int id;
            private String image;
            private String title;

            public void setId(int id) {
                this.id = id;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getId() {
                return id;
            }

            public String getImage() {
                return image;
            }

            public String getTitle() {
                return title;
            }
        }
    }
}
