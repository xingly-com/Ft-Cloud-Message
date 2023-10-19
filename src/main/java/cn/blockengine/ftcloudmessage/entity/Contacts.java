package cn.blockengine.ftcloudmessage.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/19 11:45
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class Contacts extends BaseEntity implements Serializable {

    private String name;

    private String mobile;

    private Long userId;
}
