package com.stx.runner.service.impl;

import com.stx.runner.entity.Product;
import com.stx.runner.entity.Shop;
import com.stx.runner.dao.ShopDao;
import com.stx.runner.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
     ShopDao shopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shop queryById(Integer id) {
        return this.shopDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Shop> queryAllByLimit(int offset, int limit) {
        return this.shopDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop insert(Shop shop) {
        this.shopDao.insert(shop);
        return shop;
    }

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop update(Shop shop) {
        this.shopDao.update(shop);
        return this.queryById(shop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shopDao.deleteById(id) > 0;
    }

    /**
     * 查询所有商家
     * @return
     */
    @Override
    public List<Shop> findAll() {
        List<Shop> shops = shopDao.findAll();
        return shops;
    }

    @Override
    public List<Shop> findShopsByType(Integer type) {
        return shopDao.findShopsByType(type);
    }

    @Override
    public Shop findShopById(Integer id) {
        return  shopDao.findShopById(id);
    }


}