package com.hotel.domain;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    /**
     * 用户id

     */
    @Id
    @Column(name = "`uid`")
    @GeneratedValue(generator = "JDBC")
    private Integer uid;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 名字
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 身份证
     */
    @Column(name = "IDnumber")
    private String idnumber;

    /**
     * 是否会员
     */
    @Column(name = "vip")
    private Integer vip;

    /**
     * 房间号
     */


    @Transient
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取用户id

     *
     * @return uid - 用户id

     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户id

     *
     * @param uid 用户id

     */
    public void setUid(Integer uid) {
        this.uid = uid;
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
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证
     *
     * @return IDnumber - 身份证
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * 设置身份证
     *
     * @param idnumber 身份证
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * 获取是否会员
     *
     * @return vip - 是否会员
     */
    public Integer getVip() {
        return vip;
    }

    /**
     * 设置是否会员
     *
     * @param vip 是否会员
     */
    public void setVip(Integer vip) {
        this.vip = vip;
    }

    /**
     * 获取房间号
     *
     * @return accommodationNumber - 房间号
     */

    /**
     * 设置房间号
     *
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", vip=").append(vip);
        sb.append("]");
        return sb.toString();
    }
}