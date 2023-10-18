package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.NormalOrderRequest;
import cn.blockengine.ftcloudmessage.service.NormalOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/normal")
@Api(tags = "[小程序] 普通短信")
public class NormalController extends BaseController {

    @Resource
    private NormalOrdersService normalOrdersService;

    @PostMapping("/add")
    @ApiOperation("添加")
    public AjaxResult add(@RequestBody NormalOrderRequest orders) {
        return AjaxResult.success(normalOrdersService.add(orders));
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public AjaxResult update(@RequestBody NormalOrderRequest orders) {
        return AjaxResult.success(normalOrdersService.update(orders));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public AjaxResult delete(@PathVariable Long id) {
        return AjaxResult.success(normalOrdersService.delete(id));
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public TableDataInfo list(NormalOrderRequest orders) {
        startPage();
        return getDataTable(normalOrdersService.normalMessageList(orders));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("详情")
    public AjaxResult detail(@PathVariable Long id) {
        return AjaxResult.success(normalOrdersService.detail(id));
    }

    @GetMapping("/usMessage/page")
    @ApiOperation("我的短信")
    public TableDataInfo usMessage(NormalOrderRequest orders) {
        startPage();
        return getDataTable(normalOrdersService.usMessage(orders));
    }

    @GetMapping("/getMessage/page")
    @ApiOperation("我的收信")
    public TableDataInfo getMessage(NormalOrderRequest orders) {
        startPage();
        return getDataTable(normalOrdersService.getMessage(orders));
    }
}
