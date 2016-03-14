package com.nms.mydemo.seashell.bean;

import java.util.List;

/**
 * Created by my on 2016/3/10.
 */
public class HomeHeader {

    /**
     * code : 0
     * data : {"banners":[{"action":"native","image":"http://ec-img.ufile.ucloud.cn/69f3f35dc71d46928f7b89ec7a7eb05d.jpg","params":{"topic_id":"7"},"title":"女神爱用物","uri":"product_topic"}]}
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
         * action : native
         * image : http://ec-img.ufile.ucloud.cn/69f3f35dc71d46928f7b89ec7a7eb05d.jpg
         * params : {"topic_id":"7"}
         * title : 女神爱用物
         * uri : product_topic
         */

        private List<BannersEntity> banners;

        public void setBanners(List<BannersEntity> banners) {
            this.banners = banners;
        }

        public List<BannersEntity> getBanners() {
            return banners;
        }

        public static class BannersEntity {
            private String action;
            private String image;
            /**
             * topic_id : 7
             */

            private ParamsEntity params;
            private String title;
            private String uri;

            public void setAction(String action) {
                this.action = action;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public void setParams(ParamsEntity params) {
                this.params = params;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getAction() {
                return action;
            }

            public String getImage() {
                return image;
            }

            public ParamsEntity getParams() {
                return params;
            }

            public String getTitle() {
                return title;
            }

            public String getUri() {
                return uri;
            }

            public static class ParamsEntity {
                private String topic_id;

                public void setTopic_id(String topic_id) {
                    this.topic_id = topic_id;
                }

                public String getTopic_id() {
                    return topic_id;
                }
            }
        }
    }
}
