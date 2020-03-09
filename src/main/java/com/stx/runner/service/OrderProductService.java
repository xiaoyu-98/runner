package com.stx.runner.service;

import com.stx.runner.entity.OrderProduct;
import java.util.List;

/**
 * (OrderProduct)表服务接口
 *
 * @author makejava
 * @since 2020-03-07 15:16:10
 */
public interface OrderProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderProduct queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderProduct> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orderProduct 实例对象
     * @return 实例对象
     */
    OrderProduct insert(OrderProduct orderProduct);

    /**
     * 修改数据
     *
     * @param orderProduct 实例对象
     * @return 实例对象
     */
    OrderProduct update(OrderProduct orderProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}