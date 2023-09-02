package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.component.PageInfo;
import cn.blockengine.ftcloudmessage.entity.Users;
import cn.blockengine.ftcloudmessage.mapper.UsersMapper;
import cn.blockengine.ftcloudmessage.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Api(tags = "[小程序] 用户模块")
public class UserController {

    @Resource
    private UsersService usersService;

    @PostMapping("/login")
    @ApiOperation("微信登陆")
    public AjaxResult login (@RequestBody Users user) {
        return usersService.login(user);
    }

    @GetMapping("/usMessage")
    @ApiOperation("我的短信")
    public AjaxResult usMessage (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.usMessage(request, pageInfo);
    }

    @GetMapping("/us")
    @ApiOperation("我的信息")
    public AjaxResult us (HttpServletRequest request) {
        return usersService.us(request);
    }

    @GetMapping("/getMessage")
    @ApiOperation("我的收信")
    public AjaxResult getMessage (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.getMessage(request, pageInfo);
    }

    @GetMapping("/usPlan")
    @ApiOperation("我的计划")
    public AjaxResult usPlan (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.usPlan(request, pageInfo);
    }

    @GetMapping("/usArtificial")
    @ApiOperation("我的传话")
    public AjaxResult usArtificial (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.usArtificial(request, pageInfo);
    }

    @GetMapping("/usPost")
    @ApiOperation("我的邮寄")
    public AjaxResult usPost (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.usPost(request, pageInfo);
    }

    @GetMapping("/usAddress")
    @ApiOperation("我的地址")
    public AjaxResult usAddress (HttpServletRequest request, PageInfo pageInfo) {
        return usersService.usAddress(request, pageInfo);
    }
}


