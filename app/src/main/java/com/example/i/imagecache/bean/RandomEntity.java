package com.example.i.imagecache.bean;

/***
 * Created by I on 2017/9/26.
 */

import java.util.List;

public class RandomEntity {

    private boolean error;

    private List<GankEntity> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<GankEntity> getResults() {
        return results;
    }

    public void setResults(List<GankEntity> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "RandomEntity{" +
                "error=" + error +
                ", results=" + results.toString() +
                '}';
    }
}
