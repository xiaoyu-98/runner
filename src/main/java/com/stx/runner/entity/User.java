package com.stx.runner.entity;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.image.ImageConsumer;
import java.util.Collection;
import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@ToString
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = -11524650745083523L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 用户密码
    */
    private String password;
    /**
    * 电话
    */
    private String phone;
    /**
    * 性别
    */
    private String sex;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 详细地址
    */
    private String address;
    /**
    * 创建时间，自动插入当前时间段
    */
    private Date createTime;
    /**
    * 是否激活1/0
    */
    private Boolean enabled;
    /**
    * 用户头像
    */
    private String image;
    /**
    * 中文名
    */
    private String nameZh;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

}