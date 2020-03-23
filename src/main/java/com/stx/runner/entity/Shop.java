package com.stx.runner.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Shop)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public class Shop implements Serializable {
    private Integer id;

    private String name;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date createTime;

    private Boolean score;
    /**
     * 商家类型1.外卖2.图书3.超市
     */
    private Integer type;
    /**
     * 是否认证1/0
     */
    private Boolean isApprove;
    /**
     * 商家电话
     */
    private String phone;
    /**
     * 以售商品数
     */
    private Integer sellNum;
    /**
     * 商家简介
     */
    private String info;
    /**
     * 是否营业
     */
    private Boolean open;
    /**
     * 商家图片
     */
    private String image;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getScore() {
        return score;
    }

    public void setScore(Boolean score) {
        this.score = score;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getApprove() {
        return isApprove;
    }

    public void setApprove(Boolean approve) {
        isApprove = approve;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}