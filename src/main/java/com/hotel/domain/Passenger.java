package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "pid")
    @GeneratedValue(generator = "JDBC")
    private Integer pid;

    /**
     * 手机号

     */
    @Column(name = "phone")
    private String phone;

    /**
     * 旅客姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 旅客身份证号

     */
    @Column(name = "IDnumber")
    private String idnumber;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 外键连接房间id
     */
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "vip")
    private Integer vip;

    @Column(name = "`nation`")
    private String nation;


    @Column(name = "`level`")
    private String level;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`date`")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private String date;


    @Transient
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取手机号

     *
     * @return phone - 手机号

     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号

     *
     * @param phone 手机号

     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取旅客姓名
     *
     * @return name - 旅客姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置旅客姓名
     *
     * @param name 旅客姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取旅客身份证号

     *
     * @return IDnumber - 旅客身份证号

     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * 设置旅客身份证号

     *
     * @param idnumber 旅客身份证号

     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取外键连接房间id
     *
     * @return room_id - 外键连接房间id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 设置外键连接房间id
     *
     * @param roomId 外键连接房间id
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "pid=" + pid +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", sex=" + sex +
                ", roomId=" + roomId +
                ", nation='" + nation + '\'' +
                ", level='" + level + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}