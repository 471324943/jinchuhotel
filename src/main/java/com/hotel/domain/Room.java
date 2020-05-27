package com.hotel.domain;

import javax.persistence.*;

@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(generator = "JDBC")
    private Integer roomId;

    /**
     * 房间号
     */
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "`state`")
    private Integer state;

    /**
     * 外键连接类型表
     */
    @Column(name = "roomType_id")
    private Integer roomtypeId;

    @Transient
    private RoomType roomType;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    /**
     * @return room_id
     */
    public Integer getRoomId() {
        return roomId;
    }

    /**
     * @param roomId
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * 获取房间号
     *
     * @return room_number - 房间号
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 设置房间号
     *
     * @param roomNumber 房间号
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取外键连接类型表
     *
     * @return roomType_id - 外键连接类型表
     */
    public Integer getRoomtypeId() {
        return roomtypeId;
    }

    /**
     * 设置外键连接类型表
     *
     * @param roomtypeId 外键连接类型表
     */
    public void setRoomtypeId(Integer roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomId=").append(roomId);
        sb.append(", roomNumber=").append(roomNumber);
        sb.append(", state=").append(state);
        sb.append(", roomtypeId=").append(roomtypeId);
        sb.append("]");
        return sb.toString();
    }
}