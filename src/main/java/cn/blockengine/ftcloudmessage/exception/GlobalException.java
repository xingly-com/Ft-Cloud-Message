package cn.blockengine.ftcloudmessage.exception;


import cn.blockengine.ftcloudmessage.component.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalException  {

    // 全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResult error(Exception e) {
        return AjaxResult.error().message("请求异常：" + e.getMessage());
    }

}
