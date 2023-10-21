package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.page.TableDataInfo;
import cn.blockengine.ftcloudmessage.request.AddressRequest;
import cn.blockengine.ftcloudmessage.service.UserAddressesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/18 07:55
 */
@RequestMapping("/user/address")
@RestController
@Api(tags = "[小程序] 用户地址")
public class AddressController extends BaseController {

    @Resource
    private UserAddressesService addressService;

    @GetMapping("/usAddress/page")
    @ApiOperation("获取当前用户地址列表")
    public TableDataInfo usAddress(HttpServletRequest request) {
        startPage();
        return getDataTable(addressService.usAddress(request));
    }

    @PostMapping("/insert")
    @ApiOperation("新增地址")
    public AjaxResult insertAddress(@RequestBody AddressRequest request) {
        return AjaxResult.success(addressService.insertAddress(request));
    }

    @PostMapping("/update")
    @ApiOperation("修改地址")
    public AjaxResult updateAddress(@RequestBody AddressRequest request) {
        return AjaxResult.success(addressService.updateAddress(request));
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除地址")
    public AjaxResult deleteAddress(@RequestParam(value = "id") Long id) {
        return AjaxResult.success(addressService.deleteAddress(id));
    }

    @GetMapping("/detail")
    @ApiOperation("地址详情")
    public AjaxResult getAddressDetail(Long id) {
        return AjaxResult.success(addressService.getAddressDetail(id));
    }

    @PostMapping("/default")
    @ApiOperation("设置为默认地址")
    public AjaxResult updateDefaultAddress(@RequestBody AddressRequest request) {
        return AjaxResult.success(addressService.updateDefaultAddress(request.getId()));
    }

    @GetMapping("/default")
    @ApiOperation("获取当前用户默认地址")
    public AjaxResult getCurrentUserDefaultAddress() {
        return AjaxResult.success(addressService.getCurrentUserDefaultAddress());
    }
}
