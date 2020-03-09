package com.stx.runner.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -59592412542454769L;
    
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
    private Date createtime;
    /**
    * 该商品销量
    */
    private Integer sellnum;
    /**
    * 该商品图片
    */
    private String image;
    
    private Integer sid;


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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getSellnum() {
        return sellnum;
    }

    public void setSellnum(Integer sellnum) {
        this.sellnum = sellnum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

}