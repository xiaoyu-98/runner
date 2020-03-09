package com.stx.runner.entity;

import lombok.Data;

import javax.xml.ws.Response;

/**
 * 类描述:
 * 响应给前端的RespBean对象
 *
 * @author xiaoyu
 * on 2020/3/8
 */
@Data
public class RespBean {

    private String msg;  //响应提示信息
    private Integer status; //响应代码
    private Object obj; //响应对象

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }

    private RespBean(Integer status, String msg, Object object) {
        this.msg = msg;
        this.status = status;
        this.obj = object;
    }

    private RespBean() {

    }
}
