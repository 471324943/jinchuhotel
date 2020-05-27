package com.hotel.povo;

/**
 * Created by yxq on 2019/11/7.
 */
public class PageResult extends BaseResult {
    private Long total;

    public PageResult() {
    }

    public PageResult(Long total) {
        this.total = total;
    }

    public PageResult(Integer code, String msg, Long total) {
        super(code, msg);
        this.total = total;
    }

    public PageResult(Integer code, String msg, Object data, Long total) {
        super(code, msg, data);
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
