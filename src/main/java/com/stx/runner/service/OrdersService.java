package com.stx.runner.service;

import com.github.pagehelper.PageInfo;
import com.stx.runner.entity.OrderProduct;
import com.stx.runner.entity.Orders;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * (Orders)表服务接口
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public interface OrdersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Orders queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(int offset, int limit);


    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    Orders update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Orders> findAllByUid(Integer id);

    boolean createOrders(Orders orders, OrderProduct[] orderProduct);

    List<Orders> findAllOrdersByPage();

    PageInfo<Orders> getOrdersByUserAndShop(Integer uid, Integer sid , Integer pageNum, Integer pageSize);

    List<Orders> findOrdersByStatus(Integer status,Integer uid);

    int updateOrdersStatus(Integer status, Integer id,Integer rid);

    List<Orders> findRunnerOrdersByStatus(Integer status,Integer rid);

    List<Orders>  findRunnerOrdersByRid(Integer rid);

    List<Orders> findAllOrdersWithCan();

    int deleteOrdersByOid(Integer id);

    int deleteMany(Integer[] ids);

}