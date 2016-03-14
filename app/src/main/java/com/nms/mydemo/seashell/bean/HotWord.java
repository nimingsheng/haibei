package com.nms.mydemo.seashell.bean;

import java.util.List;

/**
 * Created by my on 2016/3/7.
 */
public class HotWord {

    /**
     * code : 0
     * data : {"keywords":["杏仁糖","面膜","小林制药","cpb","没有查找历史","洗眼","防晒","ysl","眼膜","健康水","洗眼液"]}
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
        private List<String> keywords;

        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        public List<String> getKeywords() {
            return keywords;
        }
    }
}
