package com.stx.runner.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public class Product implements Serializable {

    private Integer id;
    /**
    * 商品名
    */
    private String name;
    /**
    * 商品单价
    */
    private Integer price;
    /**
    * 商品添加时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date createTime;
    /**
    * 该商品销量
    */
    private Integer sellNum;
    /**
    * 该商品图片
    */
    private String image;

    private Shop shop;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}