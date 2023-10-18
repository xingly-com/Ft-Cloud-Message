package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.PlanRequest;
import cn.blockengine.ftcloudmessage.service.PlanGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/plan")
@Api(tags = "[小程序] 计划模块")
public class PlanController extends BaseController {

    @Resource
    private PlanGoodsService service;

    @ApiOperation("计划列表")
    @GetMapping("/page")
    public TableDataInfo goodsList (PlanRequest request) {
        startPage();
        return getDataTable(service.goodsList(request));
    }

    @ApiOperation("计划详情")
    @GetMapping("/detail")
    public AjaxResult goodsDetail (String goodId) {
        return AjaxResult.success(service.goodsDetail(goodId));
    }

    @ApiOperation("添加")
    @PostMapping("add")
    public AjaxResult add (@RequestBody PlanRequest request) {
        return AjaxResult.success(service.add(request));
    }

    @ApiOperation("修改")
    @PostMapping("update")
    public AjaxResult update (@RequestBody PlanRequest request) {
        return AjaxResult.success(service.update(request));
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public AjaxResult delete (@PathVariable Long id) {
        return AjaxResult.success(service.delete(id));
    }
}
