package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.UserRequest;
import cn.blockengine.ftcloudmessage.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@Api(tags = "[小程序] 用户模块")
public class UserController extends  BaseController{

    @Resource
    private UsersService usersService;

//    @PostMapping("/login")
//    @ApiOperation("微信登陆")
//    public AjaxResult login (@RequestBody Users user) {
//        return usersService.login(user);
//    }

    @PostMapping("/login")
    @ApiOperation("登陆")
    public AjaxResult login(@RequestBody UserRequest request) {
        // 学生使用微信登陆, 所以没有密码, 直接生成token
        return AjaxResult.success(usersService.loginUser(request));
    }

    @PostMapping("/openId/login")
    @ApiOperation("一键登陆")
    public AjaxResult openIdLogin(@RequestBody UserRequest request) {
        // 学生使用微信登陆, 所以没有密码, 直接生成token
        return AjaxResult.success(usersService.openIdLogin(request));
    }

    @GetMapping("/usMessage")
    @ApiOperation("我的短信")
    public TableDataInfo usMessage (HttpServletRequest request) {
        startPage();
        return getDataTable(usersService.usMessage(request));
    }

    @GetMapping("/us")
    @ApiOperation("我的信息")
    public AjaxResult us (HttpServletRequest request) {
        return AjaxResult.success(usersService.us(request));
    }

    @GetMapping("/getMessage")
    @ApiOperation("我的收信")
    public AjaxResult getMessage (HttpServletRequest request) {
        startPage();
        return AjaxResult.success(usersService.getMessage(request));
    }

    @GetMapping("/usPlan")
    @ApiOperation("我的计划")
    public TableDataInfo usPlan (HttpServletRequest request) {
        startPage();
        return getDataTable(usersService.usPlan(request));
    }

    @GetMapping("/usArtificial")
    @ApiOperation("我的传话")
    public TableDataInfo usArtificial (HttpServletRequest request) {
        startPage();
        return getDataTable(usersService.usArtificial(request));
    }

    @GetMapping("/usPost")
    @ApiOperation("我的邮寄")
    public TableDataInfo usPost (HttpServletRequest request) {
        startPage();
        return getDataTable(usersService.usPost(request));
    }

    @GetMapping("/usAddress")
    @ApiOperation("我的地址")
    public TableDataInfo usAddress (HttpServletRequest request) {
        startPage();
        return getDataTable(usersService.usAddress(request));
    }
}


