package com.nms.mydemo.seashell.bean;

import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class ProductDetails {

    /**
     * code : 0
     * data : {"product":{"category_id":12,"current_sku":{"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109},"custom_properties":[],"desc":"491.4","fav_count":4,"favorite":false,"id":10359900,"images":[{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg","w":1242},{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg","w":1242}],"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"name":"Albion 奥尔滨 健康水 ","review_count":0,"score":8,"skus":[{"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109},{"discount":19,"id":10360273,"list_price":{"CNY":58000},"real_price":{"CNY":47500},"spec":{"含量":"规格2"},"stock":109},{"discount":21,"id":10360274,"list_price":{"CNY":99900},"real_price":{"CNY":79900},"spec":{"含量":"规格3"},"stock":111}],"specs":{"含量":["规格3","规格2","规格1"]}}}
     * success : true
     */

    private int code;
    /**
     * product : {"category_id":12,"current_sku":{"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109},"custom_properties":[],"desc":"491.4","fav_count":4,"favorite":false,"id":10359900,"images":[{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg","w":1242},{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg","w":1242}],"location":"日本","merchant":{"id":84843049,"name":"海呗自营","score":8},"name":"Albion 奥尔滨 健康水 ","review_count":0,"score":8,"skus":[{"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109},{"discount":19,"id":10360273,"list_price":{"CNY":58000},"real_price":{"CNY":47500},"spec":{"含量":"规格2"},"stock":109},{"discount":21,"id":10360274,"list_price":{"CNY":99900},"real_price":{"CNY":79900},"spec":{"含量":"规格3"},"stock":111}],"specs":{"含量":["规格3","规格2","规格1"]}}
     */

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
         * category_id : 12
         * current_sku : {"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109}
         * custom_properties : []
         * desc : 491.4
         * fav_count : 4
         * favorite : false
         * id : 10359900
         * images : [{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg","w":1242},{"h":2208,"t_h":256,"t_w":256,"thumb":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg?iopcmd=thumbnail&type=8&width=256&height=256","url":"http://ec-img.ufile.ucloud.cn/0173af98d45a4930a6e066b3b495672f.jpg","w":1242}]
         * location : 日本
         * merchant : {"id":84843049,"name":"海呗自营","score":8}
         * name : Albion 奥尔滨 健康水
         * review_count : 0
         * score : 8
         * skus : [{"discount":14,"id":10360272,"list_price":{"CNY":38000},"real_price":{"CNY":32800},"spec":{"含量":"规格1"},"stock":109},{"discount":19,"id":10360273,"list_price":{"CNY":58000},"real_price":{"CNY":47500},"spec":{"含量":"规格2"},"stock":109},{"discount":21,"id":10360274,"list_price":{"CNY":99900},"real_price":{"CNY":79900},"spec":{"含量":"规格3"},"stock":111}]
         * specs : {"含量":["规格3","规格2","规格1"]}
         */

        private ProductEntity product;

        public void setProduct(ProductEntity product) {
            this.product = product;
        }

        public ProductEntity getProduct() {
            return product;
        }

        public static class ProductEntity {
            private int category_id;
            /**
             * discount : 14
             * id : 10360272
             * list_price : {"CNY":38000}
             * real_price : {"CNY":32800}
             * spec : {"含量":"规格1"}
             * stock : 109
             */

            private CurrentSkuEntity current_sku;
            private String desc;
            private int fav_count;
            private boolean favorite;
            private int id;
            private String location;
            /**
             * id : 84843049
             * name : 海呗自营
             * score : 8
             */

            private MerchantEntity merchant;
            private String name;
            private int review_count;
            private int score;
            private SpecsEntity specs;
            private List<?> custom_properties;
            /**
             * h : 2208
             * t_h : 256
             * t_w : 256
             * thumb : http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg?iopcmd=thumbnail&type=8&width=256&height=256
             * url : http://ec-img.ufile.ucloud.cn/aab8aee69adf422c928dbb5870e9ce7e.jpg
             * w : 1242
             */

            private List<ImagesEntity> images;
            /**
             * discount : 14
             * id : 10360272
             * list_price : {"CNY":38000}
             * real_price : {"CNY":32800}
             * spec : {"含量":"规格1"}
             * stock : 109
             */

            private List<SkusEntity> skus;

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public void setCurrent_sku(CurrentSkuEntity current_sku) {
                this.current_sku = current_sku;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public void setFav_count(int fav_count) {
                this.fav_count = fav_count;
            }

            public void setFavorite(boolean favorite) {
                this.favorite = favorite;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public void setMerchant(MerchantEntity merchant) {
                this.merchant = merchant;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setReview_count(int review_count) {
                this.review_count = review_count;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public void setSpecs(SpecsEntity specs) {
                this.specs = specs;
            }

            public void setCustom_properties(List<?> custom_properties) {
                this.custom_properties = custom_properties;
            }

            public void setImages(List<ImagesEntity> images) {
                this.images = images;
            }

            public void setSkus(List<SkusEntity> skus) {
                this.skus = skus;
            }

            public int getCategory_id() {
                return category_id;
            }

            public CurrentSkuEntity getCurrent_sku() {
                return current_sku;
            }

            public String getDesc() {
                return desc;
            }

            public int getFav_count() {
                return fav_count;
            }

            public boolean isFavorite() {
                return favorite;
            }

            public int getId() {
                return id;
            }

            public String getLocation() {
                return location;
            }

            public MerchantEntity getMerchant() {
                return merchant;
            }

            public String getName() {
                return name;
            }

            public int getReview_count() {
                return review_count;
            }

            public int getScore() {
                return score;
            }

            public SpecsEntity getSpecs() {
                return specs;
            }

            public List<?> getCustom_properties() {
                return custom_properties;
            }

            public List<ImagesEntity> getImages() {
                return images;
            }

            public List<SkusEntity> getSkus() {
                return skus;
            }

            public static class CurrentSkuEntity {
                private int discount;
                private int id;
                /**
                 * CNY : 38000
                 */

                private ListPriceEntity list_price;
                /**
                 * CNY : 32800
                 */

                private RealPriceEntity real_price;
                /**
                 * 含量 : 规格1
                 */

                private SpecEntity spec;
                private int stock;

                public void setDiscount(int discount) {
                    this.discount = discount;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setList_price(ListPriceEntity list_price) {
                    this.list_price = list_price;
                }

                public void setReal_price(RealPriceEntity real_price) {
                    this.real_price = real_price;
                }

                public void setSpec(SpecEntity spec) {
                    this.spec = spec;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getDiscount() {
                    return discount;
                }

                public int getId() {
                    return id;
                }

                public ListPriceEntity getList_price() {
                    return list_price;
                }

                public RealPriceEntity getReal_price() {
                    return real_price;
                }

                public SpecEntity getSpec() {
                    return spec;
                }

                public int getStock() {
                    return stock;
                }

                public static class ListPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class RealPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class SpecEntity {
                    private String 含量;

                    public void set含量(String 含量) {
                        this.含量 = 含量;
                    }

                    public String get含量() {
                        return 含量;
                    }
                }
            }

            public static class MerchantEntity {
                private int id;
                private String name;
                private int score;

                public void setId(int id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public int getScore() {
                    return score;
                }
            }

            public static class SpecsEntity {
                private List<String> 含量;

                public void set含量(List<String> 含量) {
                    this.含量 = 含量;
                }

                public List<String> get含量() {
                    return 含量;
                }
            }

            public static class ImagesEntity {
                private int h;
                private int t_h;
                private int t_w;
                private String thumb;
                private String url;
                private int w;

                public void setH(int h) {
                    this.h = h;
                }

                public void setT_h(int t_h) {
                    this.t_h = t_h;
                }

                public void setT_w(int t_w) {
                    this.t_w = t_w;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public void setW(int w) {
                    this.w = w;
                }

                public int getH() {
                    return h;
                }

                public int getT_h() {
                    return t_h;
                }

                public int getT_w() {
                    return t_w;
                }

                public String getThumb() {
                    return thumb;
                }

                public String getUrl() {
                    return url;
                }

                public int getW() {
                    return w;
                }
            }

            public static class SkusEntity {
                private int discount;
                private int id;
                /**
                 * CNY : 38000
                 */

                private ListPriceEntity list_price;
                /**
                 * CNY : 32800
                 */

                private RealPriceEntity real_price;
                /**
                 * 含量 : 规格1
                 */

                private SpecEntity spec;
                private int stock;

                public void setDiscount(int discount) {
                    this.discount = discount;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setList_price(ListPriceEntity list_price) {
                    this.list_price = list_price;
                }

                public void setReal_price(RealPriceEntity real_price) {
                    this.real_price = real_price;
                }

                public void setSpec(SpecEntity spec) {
                    this.spec = spec;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getDiscount() {
                    return discount;
                }

                public int getId() {
                    return id;
                }

                public ListPriceEntity getList_price() {
                    return list_price;
                }

                public RealPriceEntity getReal_price() {
                    return real_price;
                }

                public SpecEntity getSpec() {
                    return spec;
                }

                public int getStock() {
                    return stock;
                }

                public static class ListPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class RealPriceEntity {
                    private int CNY;

                    public void setCNY(int CNY) {
                        this.CNY = CNY;
                    }

                    public int getCNY() {
                        return CNY;
                    }
                }

                public static class SpecEntity {
                    private String 含量;

                    public void set含量(String 含量) {
                        this.含量 = 含量;
                    }

                    public String get含量() {
                        return 含量;
                    }
                }
            }
        }
    }
}
