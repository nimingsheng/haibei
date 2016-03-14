package com.nms.mydemo.seashell.bean;

import java.util.List;

/**
 * Created by my on 2016/3/9.
 */
public class CategoryInfo {

    /**
     * code : 0
     * data : {"categories":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/010fb51a90784ac5848643e4dc22a365.png?iopcmd=thumbnail&type=8&width=128&height=128","id":1,"name":"美妆个护","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/dcef1394cb95442ba2269715bd0a78fb.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":6,"name":"洁面卸妆"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4d80149373fe4a76852cadebed8c9a27.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":11,"name":"面膜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/1d88a08d7e1e46e8ba92659f1b6ec283.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":12,"name":"爽肤水"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/86fd262c896c4b7ba4b0fa2a4c3b85e1.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":9,"name":"精华液/素"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/2467e57663fd4122bac0ee37bef88fbc.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":20,"name":"卫生巾"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/7934c7d7e8d14918bc366fd0a3e2ffa4.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":15,"name":"粉底/液"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/339f5c7402964ec2af09218ede64af42.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":42,"name":"散粉/粉饼"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/8a97343f9be84f35b1d8c8bc21ac8a92.png?iopcmd=thumbnail&type=8&width=128&height=128","id":8,"name":"面霜/乳液"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4dd965890cbc42608f6969e2e5a18dad.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":14,"name":"防晒隔离"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/28d798b2c63f4f2ba85b3cfbdc9b37ce.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":10,"name":"唇膏/润唇膏"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/636138ee386447c19d2f34d37e68b6ad.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":41,"name":"BB霜/CC霜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/c4ea01eac644477cb0635f35dfbfddc9.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":62,"name":"修容/高光"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/c14da4c53c994ea3aefccd9c1d68af4a.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":37,"name":"腮红"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/813c811491ef4862b022a406bb8f57b1.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":13,"name":"护手霜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/02b245341ed34c3eb6ec40e9a10a323f.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":7,"name":"眼霜/精华"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/21f46f1d073f4d1e8c909b27e0a6fc48.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":19,"name":"美妆工具"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/3c0b40d0d41c4657894e8915b5395d0d.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":33,"name":"牙刷牙膏"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/061b22fae3334cd68842d33138852f6b.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":43,"name":"眼妆"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/8042fa74b831432284875a1ee9b6cc05.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":44,"name":"头发保养"},{"banner":null,"icon":null,"id":40,"name":"祛痘"}]},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/d0033d934d83468aaf19f63e90db9f6f.png?iopcmd=thumbnail&type=8&width=128&height=128","id":2,"name":"母婴用品","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/ce737f5e189e430d88c980ae13481872.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":21,"name":"奶粉"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/7ea7a1d6a98c43ed954e65a0f81c612b.png?iopcmd=thumbnail&type=8&width=128&height=128","id":22,"name":"纸尿裤"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/64bedd1520484af2aaa830b059720404.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":50,"name":"辅食"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/11a70e5141714aa9a274d24059238929.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":58,"name":"喂食"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/2c49ee6fda8042c3b43329f2d1429d55.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":60,"name":"宝宝护理"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/b43ed54785b04005b0e2925ffbb3c016.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":61,"name":"妈妈保养"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4495778f11b847f2ae9a54ecd8193473.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":59,"name":"工具"}]},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/a62bc5c9aa7149d697febe3c4966e7f5.png?iopcmd=thumbnail&type=8&width=128&height=128","id":5,"name":"营养保健","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/53dfe32528c94bdb86880bd237a908f9.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":36,"name":"眼药水"}]},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/99daf02a0651409c8c7baa79773fc3ad.png?iopcmd=thumbnail&type=8&width=128&height=128","id":3,"name":"进口美食","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/5f5b4bb567c547b28a1e56b6140652a2.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":25,"name":"巧克力"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/84e51ad452b84ea7b76c31c8f59eb268.png?iopcmd=thumbnail&type=8&width=128&height=128","id":46,"name":"麦片"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/7928bab91bd64779a3b03c7b765ad649.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":52,"name":"糖果"}]},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/9632c95f525d4872bee97657d10ffd86.png?iopcmd=thumbnail&type=8&width=128&height=128","id":31,"name":"家居用品","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/18686b4286374897a1b2647c40656299.png?iopcmd=thumbnail&type=8&width=128&height=128","id":32,"name":"保温杯"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/d8cf501f5fdf423aaeda9715bc272a2d.JPG?iopcmd=thumbnail&type=8&width=128&height=128","id":45,"name":"清洁"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/79ebc9283bc740b8bd0b78c4758ffdcd.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":38,"name":"便当"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/3dc2ec60fd30457a8d52ce1fd25890fc.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":34,"name":"口罩"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4df5c19979a341aa943ea8c3fcaadaa1.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":39,"name":"电饭煲"}]},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/8453a044babc4960bd67a50aa59f618e.png?iopcmd=thumbnail&type=8&width=128&height=128","id":53,"name":"极客用品","sub":[{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/5d77f0193b0244adb019232a0ae76ca9.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":57,"name":"极客数码"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/6589573208c44b368159d3f63a4acb0c.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":54,"name":"影漫游戏周边"}]}]}
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
         * banner : null
         * icon : http://ec-img.ufile.ucloud.cn/010fb51a90784ac5848643e4dc22a365.png?iopcmd=thumbnail&type=8&width=128&height=128
         * id : 1
         * name : 美妆个护
         * sub : [{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/dcef1394cb95442ba2269715bd0a78fb.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":6,"name":"洁面卸妆"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4d80149373fe4a76852cadebed8c9a27.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":11,"name":"面膜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/1d88a08d7e1e46e8ba92659f1b6ec283.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":12,"name":"爽肤水"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/86fd262c896c4b7ba4b0fa2a4c3b85e1.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":9,"name":"精华液/素"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/2467e57663fd4122bac0ee37bef88fbc.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":20,"name":"卫生巾"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/7934c7d7e8d14918bc366fd0a3e2ffa4.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":15,"name":"粉底/液"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/339f5c7402964ec2af09218ede64af42.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":42,"name":"散粉/粉饼"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/8a97343f9be84f35b1d8c8bc21ac8a92.png?iopcmd=thumbnail&type=8&width=128&height=128","id":8,"name":"面霜/乳液"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/4dd965890cbc42608f6969e2e5a18dad.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":14,"name":"防晒隔离"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/28d798b2c63f4f2ba85b3cfbdc9b37ce.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":10,"name":"唇膏/润唇膏"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/636138ee386447c19d2f34d37e68b6ad.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":41,"name":"BB霜/CC霜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/c4ea01eac644477cb0635f35dfbfddc9.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":62,"name":"修容/高光"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/c14da4c53c994ea3aefccd9c1d68af4a.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":37,"name":"腮红"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/813c811491ef4862b022a406bb8f57b1.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":13,"name":"护手霜"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/02b245341ed34c3eb6ec40e9a10a323f.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":7,"name":"眼霜/精华"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/21f46f1d073f4d1e8c909b27e0a6fc48.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":19,"name":"美妆工具"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/3c0b40d0d41c4657894e8915b5395d0d.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":33,"name":"牙刷牙膏"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/061b22fae3334cd68842d33138852f6b.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":43,"name":"眼妆"},{"banner":null,"icon":"http://ec-img.ufile.ucloud.cn/8042fa74b831432284875a1ee9b6cc05.jpg?iopcmd=thumbnail&type=8&width=128&height=128","id":44,"name":"头发保养"},{"banner":null,"icon":null,"id":40,"name":"祛痘"}]
         */

        private List<CategoriesEntity> categories;

        public void setCategories(List<CategoriesEntity> categories) {
            this.categories = categories;
        }

        public List<CategoriesEntity> getCategories() {
            return categories;
        }

        public static class CategoriesEntity {
            private Object banner;
            private String icon;
            private int id;
            private String name;
            /**
             * banner : null
             * icon : http://ec-img.ufile.ucloud.cn/dcef1394cb95442ba2269715bd0a78fb.jpg?iopcmd=thumbnail&type=8&width=128&height=128
             * id : 6
             * name : 洁面卸妆
             */

            private List<SubEntity> sub;

            public void setBanner(Object banner) {
                this.banner = banner;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setSub(List<SubEntity> sub) {
                this.sub = sub;
            }

            public Object getBanner() {
                return banner;
            }

            public String getIcon() {
                return icon;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public List<SubEntity> getSub() {
                return sub;
            }

            public static class SubEntity {
                private Object banner;
                private String icon;
                private int id;
                private String name;

                public void setBanner(Object banner) {
                    this.banner = banner;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getBanner() {
                    return banner;
                }

                public String getIcon() {
                    return icon;
                }

                public int getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }
            }
        }
    }
}
