package com.hotel.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "checking")
public class Checking {
    @Id
    @Column(name = "cid")
    @GeneratedValue(generator = "JDBC")
    private Integer cid;

    /**
     * 员工id
     */
    @Column(name = "eid")
    private Integer eid;

    /**
     * 日期
     */
    @Column(name = "`date`")
    private Date date;

    /**
     * 1,正常考勤  2,休假 3,病假
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取员工id
     *
     * @return eid - 员工id
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * 设置员工id
     *
     * @param eid 员工id
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * 获取日期
     *
     * @return date - 日期
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置日期
     *
     * @param date 日期
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取1,正常考勤  2,休假 3,病假
     *
     * @return status - 1,正常考勤  2,休假 3,病假
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1,正常考勤  2,休假 3,病假
     *
     * @param status 1,正常考勤  2,休假 3,病假
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", eid=").append(eid);
        sb.append(", date=").append(date);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}