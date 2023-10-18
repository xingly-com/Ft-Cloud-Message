package cn.blockengine.ftcloudmessage.request;

import cn.blockengine.ftcloudmessage.entity.PlanOrders;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/18 09:55
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class PlanOrderRequest extends PlanOrders {

    private String startTime;

    private String endTime;
}
