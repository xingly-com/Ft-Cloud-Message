package cn.blockengine.ftcloudmessage.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description="字典")
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class Dicts extends BaseEntity implements Serializable {

    private String name;

    private String key;

    private String value;

    private static final long serialVersionUID = 1L;
}