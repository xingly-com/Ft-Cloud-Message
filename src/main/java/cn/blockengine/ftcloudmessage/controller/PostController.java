package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.entity.PostOrders;
import cn.blockengine.ftcloudmessage.service.NormalOrdersService;
import cn.blockengine.ftcloudmessage.service.PostOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/post")
@Api(tags = "[小程序] 邮寄模块")
public class PostController {

    @Resource
    private PostOrdersService postOrdersService;

    @PostMapping("add")
    @ApiOperation("添加")
    public AjaxResult add (HttpServletRequest request, @RequestBody PostOrders orders) {
        return postOrdersService.add(request, orders);
    }
}


