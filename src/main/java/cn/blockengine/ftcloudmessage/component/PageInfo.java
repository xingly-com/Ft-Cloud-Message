package cn.blockengine.ftcloudmessage.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private Integer pageNum;
    private Integer pageSize;
}
