package com.stx.runner.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stx.runner.dao.OrderProductDao;
import com.stx.runner.entity.OrderProduct;
import com.stx.runner.entity.Orders;
import com.stx.runner.dao.OrdersDao;
import com.stx.runner.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * (Orders)表服务实现类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;
    @Autowired
    OrderProductDao orderProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Orders queryById(Integer id) {
        return this.ordersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Orders> queryAllByLimit(int offset, int limit) {
        return this.ordersDao.queryAllByLimit(offset, limit);
    }



    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 实例对象
     */
    @Override
    public Orders update(Orders orders) {
        this.ordersDao.update(orders);
        return this.queryById(orders.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.ordersDao.deleteById(id) > 0;
    }

    @Override
    public List<Orders> findAllByUid(Integer id) {
        return ordersDao.findAllByUid(id);
    }

    /**
     * 生成订单业务层
     * @param orders
     * @param orderProduct
     * @return
     */
    @Transactional
    @Override
    public boolean createOrders(Orders orders, OrderProduct[] orderProduct) {

        System.out.println(orders.toString());
        //设置时间
        orders.setCreateTime(new Date());
        //新增订单
        ordersDao.insert(orders);
        //查到订单为了拿到oid
        List<Orders> orders1 = ordersDao.queryAll(orders);
        Integer oid = orders1.get(0).getId();

        int s = 0;//记录影响行数
        for (OrderProduct product : orderProduct) {
            product.setOid(oid);
            if (orderProductDao.insert(product) == 1) {
                s++;
            }
        }
        if (s == orderProduct.length) {
            return true;
        }
        return false;
    }

    @Override
    public List<Orders> findAllOrdersByPage() {
        return ordersDao.findAllOrdersByPage();
    }

    @Override
    public PageInfo<Orders> getOrdersByUserAndShop(Integer uid, Integer sid, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders = ordersDao.getOrdersByUserAndShop(uid,sid);
        PageInfo<Orders> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }

    @Override
    public List<Orders> findOrdersByStatus(Integer status) {
        return ordersDao.findOrdersByStatus(status);
    }
}