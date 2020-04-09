package com.stx.runner.dao;

import com.stx.runner.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */

public interface ProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Product> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param product 实例对象
     * @return 对象列表
     */
    List<Product> queryAll(Product product);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Product> findProductsBySid(Integer sid);

    List<Product> findAllProducts();

    int deleteByIds(@Param("ids") Integer[] ids);

    int updateProduct(@Param("product") Product product,@Param("sid") Integer sid);

    List<Product> findBySnameAndPname(@Param("sid") Integer sid, @Param("pname") String pname);
}