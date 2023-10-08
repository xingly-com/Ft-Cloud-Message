package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.service.PlanOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/plan")
@Api(tags = "[小程序] 计划模块")
public class PlanController extends BaseController {

    @Resource
    private PlanOrdersService planOrdersService;

    @ApiOperation("商品列表")
    @GetMapping("getGoodsList")
    public TableDataInfo goodsList (HttpServletRequest request) {
        startPage();
        return getDataTable(planOrdersService.goodsList(request));
    }

    @ApiOperation("商品详情")
    @GetMapping("getGoodsDetail")
    public AjaxResult goodsDetail (HttpServletRequest request, String goodId) {
        return AjaxResult.success(planOrdersService.goodsDetail(request, goodId));
    }

    @ApiOperation("添加")
    @PostMapping("add")
    public AjaxResult add (HttpServletRequest request, PlanOrders orders) {
        return AjaxResult.success(planOrdersService.add(request, orders));
    }
}
