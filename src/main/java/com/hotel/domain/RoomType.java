package com.hotel.domain;

import javax.persistence.*;

@Table(name = "room_type")
public class RoomType {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(generator = "JDBC")
    private Integer roomId;

    @Column(name = "room_name")
    private String roomName;

    /**
     *  规格
     */
    @Column(name = "specification")
    private String specification;

    /**
     * 房间大小
     */
    @Column(name = "roomSize")
    private Integer roomsize;

    /**
     * 特点
     */
    @Column(name = "trait")
    private String trait;

    /**
     * 价格
     */
    @Column(name = "price")
    private Double price;

    @Column(name = "room_imgUrl")
    private String roomImgurl;


    @Transient
    private String surplus;

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
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
     * @return room_name
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * @param roomName
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * 获取 规格
     *
     * @return specification -  规格
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * 设置 规格
     *
     * @param specification  规格
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * 获取房间大小
     *
     * @return roomSize - 房间大小
     */
    public Integer getRoomsize() {
        return roomsize;
    }

    /**
     * 设置房间大小
     *
     * @param roomsize 房间大小
     */
    public void setRoomsize(Integer roomsize) {
        this.roomsize = roomsize;
    }

    /**
     * 获取特点
     *
     * @return trait - 特点
     */
    public String getTrait() {
        return trait;
    }

    /**
     * 设置特点
     *
     * @param trait 特点
     */
    public void setTrait(String trait) {
        this.trait = trait;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return room_imgUrl
     */
    public String getRoomImgurl() {
        return roomImgurl;
    }

    /**
     * @param roomImgurl
     */
    public void setRoomImgurl(String roomImgurl) {
        this.roomImgurl = roomImgurl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roomId=").append(roomId);
        sb.append(", roomName=").append(roomName);
        sb.append(", specification=").append(specification);
        sb.append(", roomsize=").append(roomsize);
        sb.append(", trait=").append(trait);
        sb.append(", price=").append(price);
        sb.append(", roomImgurl=").append(roomImgurl);
        sb.append("]");
        return sb.toString();
    }
}