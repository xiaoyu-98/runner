package com.stx.runner.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stx.runner.entity.Product;
import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.Shop;
import com.stx.runner.service.ProductService;
import com.stx.runner.service.ShopService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("查询所有商家信息")
    @GetMapping("/findAll")
    public List<Shop> findAll() {
        List<Shop> shops = shopService.findAll();
        return shops;
    }

    @ApiOperation("查询所有商家信息")
    @GetMapping("/findAllByPage")
    public PageInfo<Shop> findAllByPage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shop> shops = shopService.findAll();
        PageInfo<Shop> shopPageInfo = new PageInfo<>(shops);
        return shopPageInfo;
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
    public Shop findShopById(@PathVariable Integer id) {
        return shopService.findShopById(id);
    }

    @GetMapping("/getShopByName")
    public List<Shop> getShopByName(String name) {
        return shopService.getShopByName(name);
    }

    @PutMapping("/updateShop")
    public RespBean updateShop(@RequestBody Shop shop) {
        if (shopService.updateShop(shop) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteShopById/{id}")
    public RespBean deleteShopById(@PathVariable Integer id) {
        if (shopService.deleteById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/deleteMany")
    public RespBean deleteMany(Integer[] ids) {
        if (shopService.deleteByIds(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @GetMapping("/findAllShops")
    public List<Shop> findAllShops() {
        return shopService.findAll();
    }
}