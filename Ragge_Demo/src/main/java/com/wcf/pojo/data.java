package com.wcf.pojo;

import java.util.List;

public class data <t>{

    private List<t> records;

    private Long total;

    public data() {
    }

    public data(List<t> records, Long total) {
        this.records = records;
        this.total = total;
    }

    /**
     * 获取
     * @return records
     */
    public List<t> getRecords() {
        return records;
    }

    /**
     * 设置
     * @param records
     */
    public void setRecords(List<t> records) {
        this.records = records;
    }

    /**
     * 获取
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    public String toString() {
        return "data{records = " + records + ", total = " + total + "}";
    }
}
