package com.zyc.shardingjdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: UserOrder
 * @Package: com.zyc.shardingjdbc.entity
 * @Description:
 * @Datetime: 2021/4/25 21:34
 * @Author: zyc
 * @Version: 1.0
 */
@Data
public class UserOrder {

    public Long orderId;

    public Long userId;

    public String orderNumber;

    public Date createTime;

    public String yearMonth;

}
