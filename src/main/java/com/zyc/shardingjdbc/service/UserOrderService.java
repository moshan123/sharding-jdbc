package com.zyc.shardingjdbc.service;

import com.zyc.shardingjdbc.entity.User;
import com.zyc.shardingjdbc.entity.UserOrder;
import com.zyc.shardingjdbc.mapper.UserMapper;
import com.zyc.shardingjdbc.mapper.UserOrderMapper;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: UserOrderService
 * @Package: com.zyc.shardingjdbc.service
 * @Description:
 * @Datetime: 2021/4/30 21:20
 * @Author: zyc
 * @Version: 1.0
 */
public class UserOrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserOrderMapper userOrderMapper;

    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public int saveUserOrder(User user, UserOrder userOrder){
        //1:用户库存扣减
        userMapper.addUser(user);//立即写入数据库
        userOrder.setUserId(user.getId());
        int a = 1/0;//测试回滚，统一提交的话，将这行注释掉就行
        //2.保存订单x restTemplate /rmi
        userOrderMapper.addUserOrder(userOrder);
        return 1;
    }
}
