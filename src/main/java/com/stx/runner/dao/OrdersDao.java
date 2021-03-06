package com.stx.runner.dao;

import com.stx.runner.entity.Orders;
import com.stx.runner.entity.Shop;
import com.stx.runner.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * (Orders)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@Repository
public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Orders queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Orders> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orders 实例对象
     * @return 对象列表
     */
    List<Orders> queryAll(Orders orders);

    /**
     * 新增数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int insert(Orders orders);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Orders> findAllByUid(Integer id);

    List<Orders> findAllOrdersByPage();

    List<Orders> getOrdersByUserAndShop(@Param("uid") Integer uid, @Param("sid") Integer sid);

    int updateByUser(User user);

    int updateByShop(Shop shop);

    List<Orders> findOrdersByStatus(@Param("status") Integer status,@Param("uid") Integer uid);

    int updateOrdersStatus(@Param("status") Integer status, @Param("id") Integer id, @Param("rid") Integer rid);

    List<Orders> findRunnerOrdersByStatus(@Param("status") Integer status,@Param("rid") Integer rid);

    List<Orders> findRunnerOrdersByRid(Integer rid);

    List<Orders> findAllOrdersWithCan();

    int deleteOrdersByOid(Integer id);

    int deleteMany(@Param("ids") Integer[] ids);
}