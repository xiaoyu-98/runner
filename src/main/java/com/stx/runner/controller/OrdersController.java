package com.stx.runner.controller;

import com.stx.runner.entity.Orders;
import com.stx.runner.service.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Orders selectOne(Integer id) {
        return this.ordersService.queryById(id);
    }

    @ApiOperation("根据用户id查询用户的所有订单")
    @GetMapping("/findOrdersByUid/{id}")
    public List<Orders> findAllByUid(@PathVariable Integer id) {
        return ordersService.findAllByUid(id);
    }
}