package cn.blockengine.ftcloudmessage.page;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 表格分页数据对象
 * 
 * @author ruoyi
 */
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalRunPrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalCurrentPagePrice;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalNumber;

    public BigDecimal getTotalCurrentPagePrice() {
        return totalCurrentPagePrice;
    }

    public void setTotalCurrentPagePrice(BigDecimal totalCurrentPagePrice) {
        this.totalCurrentPagePrice = totalCurrentPagePrice;
    }

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    /**
     * 分页
     * 
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, int total)
    {
        this.rows = list;
        this.total = total;
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalRunPrice() {
        return totalRunPrice;
    }

    public void setTotalRunPrice(BigDecimal totalRunPrice) {
        this.totalRunPrice = totalRunPrice;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }
}
