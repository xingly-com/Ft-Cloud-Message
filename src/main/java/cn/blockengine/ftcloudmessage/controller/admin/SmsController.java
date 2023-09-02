package cn.blockengine.ftcloudmessage.controller.admin;

import cn.blockengine.ftcloudmessage.component.AjaxResult;
import cn.blockengine.ftcloudmessage.component.SmsCallback;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {


    @ApiOperation("短信回复回调")
    @PostMapping("/callback")
    public AjaxResult smsCallback (@RequestBody SmsCallback callback) {
        //todo 逻辑处理待定
        log.info(callback.toString());
        return AjaxResult.ok();
    }

}
