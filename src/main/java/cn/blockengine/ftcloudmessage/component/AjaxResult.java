package cn.blockengine.ftcloudmessage.component;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AjaxResult {
    private boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private AjaxResult() {
    }

    public static AjaxResult ok(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(true);
        ajaxResult.setCode(ResultCode.SUCCESS);
        ajaxResult.setMessage("请求成功");
        return ajaxResult;
    }

    public static AjaxResult error(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        ajaxResult.setCode(ResultCode.ERROR);
        ajaxResult.setMessage("请求失败");
        return ajaxResult;
    }

    public static AjaxResult noAuth(){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        ajaxResult.setCode(ResultCode.NOTAUTH);
        ajaxResult.setMessage("未登录");
        return ajaxResult;
    }

    public AjaxResult message(String message){
        this.setMessage(message);
        return this;
    }

    public AjaxResult data(String key, Object value){
        this.data.put(key,value);
        return this;
    }

    public AjaxResult data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
