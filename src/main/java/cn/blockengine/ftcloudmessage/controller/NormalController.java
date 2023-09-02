package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.entity.NormalOrders;
import cn.blockengine.ftcloudmessage.service.ArtificialOrdersService;
import cn.blockengine.ftcloudmessage.service.NormalOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/normal")
@Api (tags = "[小程序] 普通短信")
public class NormalController {

    @Resource
    private NormalOrdersService normalOrdersService;

    @PostMapping("add")
    @ApiOperation("添加")
    public AjaxResult add (HttpServletRequest request, @RequestBody NormalOrders orders) {
        return normalOrdersService.add(request, orders);
    }

}
