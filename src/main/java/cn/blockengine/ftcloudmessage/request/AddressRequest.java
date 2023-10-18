package cn.blockengine.ftcloudmessage.request;

import cn.blockengine.ftcloudmessage.entity.UserAddresses;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/18 08:03
 */

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class AddressRequest extends UserAddresses {

    private String type;
}
