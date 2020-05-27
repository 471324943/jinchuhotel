package com.hotel.povo;

import lombok.Data;

/**
 * Created by yxq on 2019/11/6.
 * 工具类
 */
@Data
public class PageRequest {
    // 页码
    private Integer page;
    // 每页条数
    private Integer rows;

    private String titleKey;

    private String startTime;

    private String endTime;

}
