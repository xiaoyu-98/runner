package com.stx.runner.dao;

import com.stx.runner.entity.OrderProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (OrderProduct)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-07 15:16:10
 */

public interface OrderProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderProduct queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrderProduct> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderProduct 实例对象
     * @return 对象列表
     */
    List<OrderProduct> queryAll(OrderProduct orderProduct);

    /**
     * 新增数据
     *
     * @param orderProduct 实例对象
     * @return 影响行数
     */
    int insert(OrderProduct orderProduct);

    /**
     * 修改数据
     *
     * @param orderProduct 实例对象
     * @return 影响行数
     */
    int update(OrderProduct orderProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}