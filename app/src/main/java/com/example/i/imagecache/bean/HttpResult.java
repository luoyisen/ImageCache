package com.example.i.imagecache.bean;

import java.io.Serializable;

/***
 * Created by I on 2017/9/26.
 */

public class HttpResult<T> implements Serializable {

    private static final long serialVersionUID = 2369780845535121572L;
    private boolean error;

    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "error=" + error +
                ", results=" + results.toString() +
                '}';
    }

}
