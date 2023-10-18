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

    @PostMapping("/login")
    @ApiOperation("code手机号登陆")
    public AjaxResult login(@RequestBody UserRequest request) {
        // 学生使用微信登陆, 所以没有密码, 直接生成token
        return AjaxResult.success(usersService.loginUser(request));
    }

    @PostMapping("/openId/login")
    @ApiOperation("openId一键登陆")
    public AjaxResult openIdLogin(@RequestBody UserRequest request) {
        // 学生使用微信登陆, 所以没有密码, 直接生成token
        return AjaxResult.success(usersService.openIdLogin(request));
    }

    @GetMapping("/us")
    @ApiOperation("我的信息")
    public AjaxResult us (HttpServletRequest request) {
        return AjaxResult.success(usersService.us(request));
    }

    @PostMapping(value = "/getPhone")
    @ApiOperation("获取手机号")
    public AjaxResult getPhone(@RequestBody UserRequest request) {
        System.out.println("传入的参数为:" + request);
        return AjaxResult.success(usersService.getPhone(request));
    }
}


