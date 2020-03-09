package com.stx.runner.service;

import com.stx.runner.entity.Shop;
import java.util.List;

/**
 * (Shop)表服务接口
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
public interface ShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shop queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Shop> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop insert(Shop shop);

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Shop> findAll();

    List<Shop> findShopsByType(Integer type);
}