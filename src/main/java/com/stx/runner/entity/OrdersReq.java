package com.stx.runner.entity;

/**
 * 类描述:
 *  解决前端不能传两个类的问题
 * @author xiaoyu
 * on 2020/3/19
 */
public class OrdersReq {

    private Orders orders;
    private OrderProduct[] orderProducts;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrderProduct[] getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(OrderProduct[] orderProducts) {
        this.orderProducts = orderProducts;
    }
}
