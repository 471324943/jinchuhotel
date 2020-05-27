package com.hotel.domain;

import javax.persistence.*;

@Table(name = "goods")
public class Goods {
    @Id
    @Column(name = "goods_id")
    @GeneratedValue(generator = "JDBC")
    private Integer goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_type")
    private String goodsType;

    @Column(name = "specification")
    private String specification;

    @Column(name = "price")
    private Double price;

    /**
     * @return goods_id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * @param goodsId
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * @return goods_type
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * @param goodsType
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * @return specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", specification=").append(specification);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}