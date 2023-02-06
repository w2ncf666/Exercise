package com.wcf.dto;

import java.util.List;

public class DishDto2 {


    private List<DishDto> records;

    private Long total;

    public DishDto2() {
    }

    public DishDto2(List<DishDto> records, Long total) {
        this.records = records;
        this.total = total;
    }

    /**
     * 获取
     * @return records
     */
    public List<DishDto> getRecords() {
        return records;
    }

    /**
     * 设置
     * @param records
     */
    public void setRecords(List<DishDto> records) {
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
        return "DishDto2{records = " + records + ", total = " + total + "}";
    }
}
