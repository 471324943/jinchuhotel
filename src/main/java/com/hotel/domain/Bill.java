package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(generator = "JDBC")
    private Integer billId;

    /**
     * 收入
     */
    @Column(name = "income")
    private Double income;

    /**
     * 支付时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss")
    @Column(name = "`time`")
    private Date time;


    @Column(name = "`desc`")
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return bill_id
     */
    public Integer getBillId() {
        return billId;
    }

    /**
     * @param billId
     */
    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    /**
     * 获取收入
     *
     * @return income - 收入
     */
    public Double getIncome() {
        return income;
    }

    /**
     * 设置收入
     *
     * @param income 收入
     */
    public void setIncome(Double income) {
        this.income = income;
    }

    /**
     * 获取支付时间
     *
     * @return time - 支付时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置支付时间
     *
     * @param time 支付时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billId=").append(billId);
        sb.append(", income=").append(income);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}