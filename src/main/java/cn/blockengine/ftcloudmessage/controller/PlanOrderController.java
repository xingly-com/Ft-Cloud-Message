package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.PlanOrderRequest;
import cn.blockengine.ftcloudmessage.service.PlanOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/plan/order")
@Api(tags = "[小程序] 计划订单模块")
public class PlanOrderController extends BaseController {

    @Resource
    private PlanOrdersService planOrdersService;

    @ApiOperation("计划列表")
    @GetMapping("/page")
    public TableDataInfo planOrderList (PlanOrderRequest request) {
        startPage();
        return getDataTable(planOrdersService.planOrderList(request));
    }

    @GetMapping("/usPlan/page")
    @ApiOperation("我的计划")
    public TableDataInfo usPlan (HttpServletRequest request) {
        startPage();
        return getDataTable(planOrdersService.usPlan(request));
    }

    @ApiOperation("详情")
    @GetMapping("/detail")
    public AjaxResult detail (Long goodId) {
        return AjaxResult.success(planOrdersService.detail(goodId));
    }

    @ApiOperation("添加")
    @PostMapping("add")
    public AjaxResult add (@RequestBody PlanOrderRequest request) {
        return AjaxResult.success(planOrdersService.add(request));
    }

    @ApiOperation("修改")
    @PostMapping("update")
    public AjaxResult update (@RequestBody PlanOrderRequest request) {
        return AjaxResult.success(planOrdersService.update(request));
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public AjaxResult delete (@PathVariable Long id) {
        return AjaxResult.success(planOrdersService.delete(id));
    }
}
