package com.wcf.pojo;

import java.util.List;

public class Page<T>{
    private Integer totalCount;

    private List<T> list;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Page(Integer totalCount, List<T> list) {
        this.totalCount = totalCount;
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
