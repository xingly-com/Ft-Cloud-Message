package cn.blockengine.ftcloudmessage.controller;


import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.ArtificialOrders;
import cn.blockengine.ftcloudmessage.service.ArtificialOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/artificial")
@Api(tags = "[小程序] 人工传话")
public class ArtificialController {

    @Resource
    private ArtificialOrdersService artificialOrdersService;

    @PostMapping("add")
    @ApiOperation("添加")
    public AjaxResult add (HttpServletRequest request, @RequestBody ArtificialOrders orders) {
        return AjaxResult.success(artificialOrdersService.add(request, orders));
    }

}
