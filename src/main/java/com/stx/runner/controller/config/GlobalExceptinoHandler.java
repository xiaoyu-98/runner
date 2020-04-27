package com.stx.runner.controller.config;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.stx.runner.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 类描述:
 *
 * @author xiaoyu
 * on 2020/3/25
 */
@RestControllerAdvice
public class GlobalExceptinoHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean mySQLIntegrityConstraintViolationException(SQLException e) {
        if (e instanceof MySQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据,操作失败！");
        } else {
            return RespBean.error("数据库异常,操作失败！");
        }
    }
}