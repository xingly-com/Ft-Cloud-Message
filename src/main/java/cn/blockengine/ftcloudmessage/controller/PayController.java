package cn.blockengine.ftcloudmessage.controller;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.service.PayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/wePay")
@Slf4j
@Api(tags = "支付接口")
public class PayController extends BaseController{

    @Resource
    private PayService payService;

    @GetMapping("/createNo")
    @ApiOperation("JSAPI下单")
    public AjaxResult createPay(Long orderId, String price, @ApiParam(value = "0普通短信，1人工传话，2计划任务，3邮寄任务") String type) {
        return AjaxResult.success(payService.createPay(orderId, price, type));
    }


    @ApiOperation("paySign")
    @GetMapping("wakePay")
    @SneakyThrows
    public AjaxResult wakePay(String prepay_id) {
        return AjaxResult.success(payService.wakePay(prepay_id));
    }
}
