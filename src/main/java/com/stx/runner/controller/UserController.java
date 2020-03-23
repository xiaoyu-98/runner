package com.stx.runner.controller;

import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.User;
import com.stx.runner.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-03-07 15:16:12
 */
@RestController
@RequestMapping("/user")
@Api("用户User接口")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 获取当前用户信息
     * @return
     */
    @ApiOperation("获取当前用户信息")
    @GetMapping("/findCurrentUser")
    public User findCurrentUser(Authentication authentication) {
        return userService.findCurrentUser(authentication);
    }

    //用户注册接口
    @ApiOperation("用户注册")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true)
    @PostMapping("/register")
    public RespBean register(@RequestBody User user) {
        if (userService.register(user) == 1) {
            return RespBean.ok("注册成功！");
        }
        return RespBean.error("注册失败！");
    }

    @ApiOperation("获取所有用户信息")
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}