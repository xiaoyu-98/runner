package com.stx.runner.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stx.runner.entity.RespBean;
import com.stx.runner.entity.User;
import com.stx.runner.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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
     *
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

    @ApiOperation("分页获取所有用户信息")
    @GetMapping("/getAllUsersByPage")
    public PageInfo<User> getAllUsers(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize) {
        //设置页码和每页大小
        PageHelper.startPage(pageNum, pageSize);
        //获取数据
        List<User> users = userService.getAllUsers();
        //创建PageInfo实例对象
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
    @ApiOperation("获取所有用户信息")
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation("根据用户名称查询该用户信息")
    @GetMapping("/getUserByName")
    public List<User> getUserByName(String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/updateUser")
    public RespBean updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败！");
    }

    @DeleteMapping("/deleteUser/{id}")
    public RespBean deleteUser(@PathVariable Integer id) {
        if (userService.deleteUser(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @DeleteMapping("/deleteMany")
    public RespBean deleteMany(Integer[] ids) {
        if (userService.deleteMany(ids) == ids.length) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}