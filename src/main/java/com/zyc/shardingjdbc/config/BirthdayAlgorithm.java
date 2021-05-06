package com.zyc.shardingjdbc.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.*;

/**
 * @ClassName: BirthdayAlgorithm
 * @Package: com.zyc.shardingjdbc.config
 * @Description:
 * @Datetime: 2021/4/24 20:53
 * @Author: zyc
 * @Version: 1.0
 */
public class BirthdayAlgorithm implements PreciseShardingAlgorithm<Date> {
    List<Date> dateList = new ArrayList<>();
    {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 1, 1,0,0,0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2022, 1, 1,0,0,0);
        dateList.add(calendar2.getTime());
        dateList.add(calendar3.getTime());
    }


    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        // 获取属性数据库的值
        Date date = preciseShardingValue.getValue();
        // 获取数据源的名称信息列表
        Iterator<String> iterable = collection.iterator();
        String target = null;
        for (Date s:dateList){
            target = iterable.next();
            // 如果数据晚于指定的日期直接返回
            if(date.before(s)){
                break;
            }
        }
        return target;
    }
}
