package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.PostOrderRequest;
import cn.blockengine.ftcloudmessage.service.PostOrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/post")
@Api(tags = "[小程序] 邮寄模块")
public class PostController extends BaseController {

    @Resource
    private PostOrdersService postOrdersService;

    @PostMapping("/add")
    @ApiOperation("添加")
    public AjaxResult add(@RequestBody PostOrderRequest orders) {
        return AjaxResult.success(postOrdersService.add(orders));
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public AjaxResult update(@RequestBody PostOrderRequest orders) {
        return AjaxResult.success(postOrdersService.update(orders));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public AjaxResult delete(@PathVariable Long id) {
        return AjaxResult.success(postOrdersService.delete(id));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("详情")
    public AjaxResult detail(@PathVariable Long id) {
        return AjaxResult.success(postOrdersService.detail(id));
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public AjaxResult list(PostOrderRequest orders) {
        startPage();
        return AjaxResult.success(postOrdersService.list(orders));
    }

    @GetMapping("/usPost/page")
    @ApiOperation("我的邮寄")
    public TableDataInfo usPost(PostOrderRequest request) {
        startPage();
        return getDataTable(postOrdersService.usPost(request));
    }
}


