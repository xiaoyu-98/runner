package com.stx.runner.controller;

import com.stx.runner.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (OrderProduct)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:11
 */
@RestController
@RequestMapping("orderProduct")
public class OrderProductController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderProductService orderProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
/*    @GetMapping("selectOne")
    public OrderProduct selectOne(Integer id) {
        return this.orderProductService.queryById(id);
    }*/

}