package com.zyc.shardingjdbc;

import com.zyc.shardingjdbc.entity.User;
import com.zyc.shardingjdbc.entity.UserOrder;
import com.zyc.shardingjdbc.mapper.UserMapper;
import com.zyc.shardingjdbc.mapper.UserOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class ShardingJdbcApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        User user =new User();
        user.setNickname("张三"+ new Random().nextInt());
        user.setPassword("123456");
        user.setSex(1);
        user.setAge(2);
        user.setBirthday(new Date());
        userMapper.addUser(user);
        System.out.println(user.getId());
    }

    @Autowired
    private UserOrderMapper userOrderMapper;
    @Test
    public void orderYearMaster(){
        for (int i = 0; i < 10; i++) {
            UserOrder userOrder = new UserOrder();
            userOrder.setUserId(1L);
            userOrder.setCreateTime(new Date());
            userOrder.setOrderNumber("123456789");
            userOrder.setYearMonth("202103");
            userOrderMapper.addUserOrder(userOrder);
            System.out.println(userOrder.getOrderId());
        }
    }


    @Test
    public void count(){
        System.out.println(userOrderMapper.countUserOrders());
    }

    @Test
    public void getList(){
        System.out.println(userOrderMapper.findUserOrders(0));
        System.out.println("=====================================");
        System.out.println(userOrderMapper.findUserOrders(1));
        System.out.println("=====================================");
        System.out.println(userOrderMapper.findUserOrders(2));
    }





}
