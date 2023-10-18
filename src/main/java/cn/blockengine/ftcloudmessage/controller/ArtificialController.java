package cn.blockengine.ftcloudmessage.controller;


import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.ArtificialOrderRequest;
import cn.blockengine.ftcloudmessage.service.ArtificialOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/artificial")
@Api(tags = "[小程序] 人工传话")
public class ArtificialController extends BaseController{

    @Resource
    private ArtificialOrdersService artificialOrdersService;

    @PostMapping("/add")
    @ApiOperation("添加")
    public AjaxResult add (@RequestBody ArtificialOrderRequest orders) {
        return AjaxResult.success(artificialOrdersService.add(orders));
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public AjaxResult update (@RequestBody ArtificialOrderRequest orders) {
        return AjaxResult.success(artificialOrdersService.update(orders));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public AjaxResult delete (@PathVariable Long id) {
        return AjaxResult.success(artificialOrdersService.delete(id));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("详情")
    public AjaxResult detail (@PathVariable Long id) {
        return AjaxResult.success(artificialOrdersService.detail(id));
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public AjaxResult list (ArtificialOrderRequest orders) {
        startPage();
        return AjaxResult.success(artificialOrdersService.list(orders));
    }

    @GetMapping("/usArtificial/page")
    @ApiOperation("我的传话")
    public TableDataInfo usArtificial (ArtificialOrderRequest orders) {
        startPage();
        return getDataTable(artificialOrdersService.usArtificial(orders));
    }
}
