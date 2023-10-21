package cn.blockengine.ftcloudmessage.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表格分页数据对象
 *
 * @author ruoyi
 */
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
//    private long total;

    /**
     * 列表数据
     */
//    private List<?> rows;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    private Map<String, Object> data;

//    private Integer currentPage;
//
//    private Integer maxPage;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
//    public TableDataInfo(List<?> list, int total) {
//        this.rows = list;
//        this.total = total;
//    }

//    public long getTotal() {
//        return total;
//    }

//    public void setTotal(long total) {
//        this.total = total;
//    }
//
//    public List<?> getRows() {
//        return rows;
//    }
//
//    public void setRows(List<?> rows) {
//        this.rows = rows;
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(List<?> rows, long total, Integer currentPage, Integer maxPage) {
        this.data = new HashMap<>();
        this.data.put("rows", rows);
        this.data.put("total", total);
        this.data.put("currentPage", currentPage);
        this.data.put("maxPage", maxPage);
    }
}
