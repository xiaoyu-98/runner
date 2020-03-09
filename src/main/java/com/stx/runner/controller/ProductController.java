package com.stx.runner.controller;

import com.stx.runner.entity.Product;
import com.stx.runner.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("根据商品id查询该商品信息")
    @GetMapping("findProductById/{id}")
    public Product selectOne(@PathVariable Integer id) {
        return this.productService.queryById(id);
    }

}