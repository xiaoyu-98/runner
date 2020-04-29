package com.stx.runner.controller;

import com.stx.runner.entity.Express;
import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.User;
import com.stx.runner.service.ExpressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述:
 *
 * @author xiaoyu
 * on 2020/4/29
 */
@RestController
@RequestMapping("/express")
public class ExpresController {
    @Autowired
    ExpressService expressService;

    @ApiOperation("新增快递单")
    @PostMapping("/insertExpress")
    /**
     * {
     *   "number": 0,
     *   "orderStatus": 0,
     *   "paddress": "string",
     *   "phone": "string",
     *   "raddress": "string",
     *   "rprice": 0,
     *   "name": "ssss",
     *   "type": "string"
     * }
     */
    public RespBean insertExpress(@RequestBody Express express, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Integer id = user.getId();
        if (expressService.insertExpress(express, id) == 1) {
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation("查询当前用户的所有快递单")
    @GetMapping("/getAllExpress")
    public List<Express> getAllExpress(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Integer id = user.getId();

        return expressService.getAllExpress(id);
    }
}
