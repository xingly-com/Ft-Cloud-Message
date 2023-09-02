package cn.blockengine.ftcloudmessage.component;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmsCallback {
    private String extend;
    private String mobile;
    private String nationcode;
    private String sign;
    private String text;
    private Integer time;
}
