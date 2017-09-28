package com.example.i.imagecache.bean;

import java.io.Serializable;
import java.util.List;

/**
 * import java.util.List;
 * Created by I on 2017/9/26.
 */

public class DayEntity implements Serializable {
    private static final long serialVersionUID = 1437313256335061579L;


    private boolean error;
    private ResultsEntity results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsEntity getResults() {
        return results;
    }

    public void setResults(ResultsEntity results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsEntity {


        private List<GankEntity> Android;


        private List<GankEntity> iOS;


        private List<GankEntity> 休息视频;


        private List<GankEntity> 拓展资源;


        private List<GankEntity> 福利;

        public List<GankEntity> getAndroid() {
            return Android;
        }

        public void setAndroid(List<GankEntity> Android) {
            this.Android = Android;
        }

        public List<GankEntity> getIOS() {
            return iOS;
        }

        public void setIOS(List<GankEntity> iOS) {
            this.iOS = iOS;
        }

        public List<GankEntity> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<GankEntity> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<GankEntity> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<GankEntity> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<GankEntity> get福利() {
            return 福利;
        }

        public void set福利(List<GankEntity> 福利) {
            this.福利 = 福利;
        }

    }
}
