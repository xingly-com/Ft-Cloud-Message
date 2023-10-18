package cn.blockengine.ftcloudmessage.request;

import cn.blockengine.ftcloudmessage.entity.PlanGoods;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : 镜像
 * @create 2023/10/18 10:21
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class PlanRequest extends PlanGoods {

    private String startTime;

    private String endTime;
}
