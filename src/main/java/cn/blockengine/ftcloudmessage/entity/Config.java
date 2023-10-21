package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 参数配置表 sys_config
 * 
 * @author ruoyi
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Config extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数主键 */
    @ApiModelProperty(value = "参数主键")
    private Long configId;

    /** 参数名称 */
    @ApiModelProperty(value = "参数名称")
    private String configName;

    /** 参数键名 */
    @ApiModelProperty(value = "参数键名")
    private String configKey;

    /** 参数键值 */
    @ApiModelProperty(value = "参数键值")
    private String configValue;

    /** 系统内置（Y是 N否） */
    @ApiModelProperty(value = "系统内置（Y是 N否）")
    private String configType;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    /** 备注 */
    @ApiModelProperty(value = "备注")
    private String remark;

    @NotBlank(message = "参数名称不能为空")
    @Size(min = 0, max = 100, message = "参数名称不能超过100个字符")
    public String getConfigName()
    {
        return configName;
    }

    @NotBlank(message = "参数键名长度不能为空")
    @Size(min = 0, max = 100, message = "参数键名长度不能超过100个字符")
    public String getConfigKey()
    {
        return configKey;
    }

    @NotBlank(message = "参数键值不能为空")
    @Size(min = 0, max = 500, message = "参数键值长度不能超过500个字符")
    public String getConfigValue()
    {
        return configValue;
    }
}
