package com.yourshop.core.model;

import java.util.List;

/**
 * @author G
 */
public class PageResult<T> {
    private long total;
    private List<T> data;

    public PageResult(long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
