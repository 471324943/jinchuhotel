package com.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "accommodation")
public class Accommodation {
    @Id
    @Column(name = "aid")
    @GeneratedValue(generator = "JDBC")
    private Integer aid;

    /**
     * 房间id
     */
    @Column(name = "room_id")
    private Integer roomId;

    /**
     * 入住的旅客id 多个用,号分割
     */
    @Column(name = "pids")
    private String pids;

    @Column(name = "checkOut")
    private Integer checkOut;


    @Column(name = "roomType")
    private String roomType;


    @Column(name = "passengerType")
    private String passengerType;


    /**
     * 入住时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "putUpTime")
    private Date putuptime;

    /**
     * 到期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @Column(name = "putDownTime")
    private Date putdowntime;

    @Transient
    private Room room;

    @Transient
    private Passenger passenger;

    @Transient
    private Double price;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Integer getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Integer checkOut) {
        this.checkOut = checkOut;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * @return aid
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * @param aid
     */
    public void setAid(Integer aid) {
        this.aid = aid;
    }

    /**
     * 获取房间id
     *
     * @return room_id - 房间id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * 设置房间id
     *
     * @param roomId 房间id
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取入住的旅客id 多个用,号分割
     *
     * @return pids - 入住的旅客id 多个用,号分割
     */
    public String getPids() {
        return pids;
    }

    /**
     * 设置入住的旅客id 多个用,号分割
     *
     * @param pids 入住的旅客id 多个用,号分割
     */
    public void setPids(String pids) {
        this.pids = pids;
    }

    /**
     * 获取入住时间
     *
     * @return putUpTime - 入住时间
     */
    public Date getPutuptime() {
        return putuptime;
    }

    /**
     * 设置入住时间
     *
     * @param putuptime 入住时间
     */
    public void setPutuptime(Date putuptime) {
        this.putuptime = putuptime;
    }

    /**
     * 获取到期时间
     *
     * @return putDownTime - 到期时间
     */
    public Date getPutdowntime() {
        return putdowntime;
    }

    /**
     * 设置到期时间
     *
     * @param putdowntime 到期时间
     */
    public void setPutdowntime(Date putdowntime) {
        this.putdowntime = putdowntime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", roomId=").append(roomId);
        sb.append(", pids=").append(pids);
        sb.append(", putuptime=").append(putuptime);
        sb.append(", putdowntime=").append(putdowntime);
        sb.append("]");
        return sb.toString();
    }
}