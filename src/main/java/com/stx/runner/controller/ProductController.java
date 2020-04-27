package com.stx.runner.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stx.runner.entity.Product;
import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.Shop;
import com.stx.runner.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12s
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Autowired
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

    @GetMapping("/findAllProductsByPage")
    public PageInfo<Product> findAllProducts(@RequestParam(defaultValue = "1") Integer pageNum,
                                             @RequestParam(defaultValue = "8") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productService.findAllProducts();
        PageInfo<Product> shopPageInfo = new PageInfo<>(products);
        return shopPageInfo;
    }

    @DeleteMapping("/deleteMany")
    public RespBean deleteMany(Integer[] ids) {
        if (productService.deleteByIds(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");

    }

    @DeleteMapping("/deleteById/{id}")
    public RespBean deleteById(@PathVariable Integer id) {
        if (productService.deleteById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


    @PutMapping("/updateProduct")
    public RespBean updateProduct(@RequestBody Product product) {
        if (productService.updateProduct(product) == 1) {
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/findBySnameAndPname")
    public PageInfo<Product> findBySnameAndPname(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize, Integer sid, String pname) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productService.findBySnameAndPname(sid, pname);
        PageInfo<Product> productPageInfo = new PageInfo<>(products);
        return productPageInfo;
    }
}