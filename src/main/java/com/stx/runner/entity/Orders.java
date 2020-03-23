package com.stx.runner.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public class Orders implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家收获地址
     */
    private String buyerAddress;
    /**
     * 订单总价
     */
    private Double orderAmount;
    /**
     * 订单状态1，已下单 0 已送达
     */
    private Boolean orderStatus;
    /**
     * 订单创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date createTime;
    /**
     * 卖家姓名
     */
    private String sellerName;
    /**
     * 卖家电话
     */
    private String sellerPhone;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 商家id
     */
    private Integer sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}