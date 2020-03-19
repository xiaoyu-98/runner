package com.stx.runner.controller;

import com.stx.runner.entity.OrderProduct;
import com.stx.runner.entity.Orders;
import com.stx.runner.entity.OrdersReq;
import com.stx.runner.entity.RespBean;
import com.stx.runner.service.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Orders)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Autowired
    private OrdersService ordersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   /* @GetMapping("selectOne")
    public Orders selectOne(Integer id) {
        return this.ordersService.queryById(id);
    }
*/
    @ApiOperation("根据用户id查询用户的所有订单")
    @GetMapping("/findOrdersByUid/{id}")
    public List<Orders> findAllByUid(@PathVariable Integer id) {
        return ordersService.findAllByUid(id);
    }


//    public


    @ApiOperation("生成订单的接口，前端传入OrdersReq实例对象")
    @PostMapping("/")
    public RespBean createOrders(@RequestBody OrdersReq ordersReq) {
        Orders orders = ordersReq.getOrders();
        OrderProduct[] orderProduct = ordersReq.getOrderProducts();

        if (ordersService.createOrders(orders,orderProduct)) {
            return RespBean.ok("订单生成成功！");
        }
        return RespBean.error("订单生成失败");
    }

}