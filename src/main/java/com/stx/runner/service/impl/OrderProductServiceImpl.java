package com.stx.runner.service.impl;

import com.stx.runner.entity.OrderProduct;
import com.stx.runner.dao.OrderProductDao;
import com.stx.runner.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (OrderProduct)表服务实现类
 *
 * @author makejava
 * @since 2020-03-07 15:16:11
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
     OrderProductDao orderProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderProduct queryById(Integer id) {
        return this.orderProductDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrderProduct> queryAllByLimit(int offset, int limit) {
        return this.orderProductDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orderProduct 实例对象
     * @return 实例对象
     */
    @Override
    public OrderProduct insert(OrderProduct orderProduct) {
        this.orderProductDao.insert(orderProduct);
        return orderProduct;
    }

    /**
     * 修改数据
     *
     * @param orderProduct 实例对象
     * @return 实例对象
     */
    @Override
    public OrderProduct update(OrderProduct orderProduct) {
        this.orderProductDao.update(orderProduct);
        return this.queryById(orderProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderProductDao.deleteById(id) > 0;
    }
}