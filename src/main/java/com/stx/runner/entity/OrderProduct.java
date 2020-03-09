package com.stx.runner.entity;

import java.io.Serializable;

/**
 * (OrderProduct)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:09
 */
public class OrderProduct implements Serializable {
    private static final long serialVersionUID = -38626596147798858L;
    
    private Integer id;
    
    private Integer pid;
    
    private Integer oid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

}