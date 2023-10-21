package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.ContactsRequest;
import cn.blockengine.ftcloudmessage.service.ContactsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:48
 */
@RestController
@RequestMapping("/contacts")
@Api(tags = "联系人")
public class ContactsController extends BaseController{

    @Resource
    private ContactsService contactsService;

    @PostMapping("/add")
    @ApiOperation("添加")
    public AjaxResult add(@RequestBody ContactsRequest contact) {
        return AjaxResult.success(contactsService.add(contact));
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public AjaxResult update(@RequestBody ContactsRequest contact) {
        return AjaxResult.success(contactsService.update(contact));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public AjaxResult delete(@PathVariable Long id) {
        return AjaxResult.success(contactsService.delete(id));
    }

    @GetMapping("/page")
    @ApiOperation("列表")
    public TableDataInfo list(ContactsRequest contact) {
        startPage();
        return getDataTable(contactsService.contactsList(contact));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("详情")
    public AjaxResult detail(@PathVariable Long id) {
        return AjaxResult.success(contactsService.detail(id));
    }

    @GetMapping("/list")
    @ApiOperation("我的联系人列表")
    public AjaxResult contactLists(ContactsRequest contact) {
        return AjaxResult.success(contactsService.contactsList(contact));
    }
}
