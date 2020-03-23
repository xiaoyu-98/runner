package com.stx.runner.controller;

import com.stx.runner.entity.Product;
import com.stx.runner.entity.Shop;
import com.stx.runner.service.ProductService;
import com.stx.runner.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Shop)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    /**
     * 服务对象
     */
    @Autowired
    private ShopService shopService;

    @Autowired
    ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
  /*  @GetMapping("selectOne")
    public Shop selectOne(Integer id) {
        return shopService.queryById(id);
    }*/
    @ApiOperation("查询所有商家信息")
    @GetMapping("/findAll")
    public List<Shop> findAll() {
        List<Shop> shops = shopService.findAll();
        return shops;
    }

    @ApiOperation("根据商家类型查询该类型所有商家")
    @GetMapping("/findShopsByType/{type}")
    public List<Shop> findShopsByType(@PathVariable Integer type) {
        List<Shop> shops = shopService.findShopsByType(type);
        return shops;
    }

    /**
     * 根据商家id查询商家的所有产品
     */
    @ApiOperation("根据商家id查询商家的所有产品")
    @GetMapping("/findProductsBySid/{sid}")
    public List<Product> findProductsBySid(@PathVariable Integer sid) {
        return productService.findProductsBySid(sid);
    }

    @ApiOperation("根据商家id查询该商家信息")
    @GetMapping("/findShopById/{id}")
    public Shop findShopById(Integer id) {
        return shopService.findShopById(id);
    }

}