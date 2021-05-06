package com.zyc.shardingjdbc.mapper;

import com.zyc.shardingjdbc.entity.UserOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: UserOrderMapper
 * @Package: com.zyc.shardingjdbc.mapper
 * @Description:
 * @Datetime: 2021/4/25 21:45
 * @Author: zyc
 * @Version: 1.0
 */
@Mapper
@Repository
public interface UserOrderMapper {

    @Insert("insert into user_order (orderNumber,userId,create_time,yearMonth) values (#{orderNumber},#{userId},#{createTime},#{yearMonth})")
    @Options(useGeneratedKeys = true, keyColumn = "orderId", keyProperty = "orderId")
    void addUserOrder(UserOrder userOrder);


    @Select("select * from user_order limit #{pageNo},10")
    List<UserOrder> findUserOrders(@Param("pageNo") Integer pageNo);

    @Select("select count(1) from user_order")
    int countUserOrders();
}
