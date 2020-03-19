package com.stx.runner.controller;

import com.stx.runner.entity.Shop;
import com.stx.runner.service.ShopService;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
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


}