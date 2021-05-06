package com.zyc.shardingjdbc.mapper;

import com.zyc.shardingjdbc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into user (nickname,password,age,sex,birthday) values (#{nickname, jdbcType=VARCHAR},#{password, jdbcType=VARCHAR},#{age, jdbcType=INTEGER},#{sex, jdbcType=INTEGER},#{birthday, jdbcType=DATE})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addUser(User user);

    @Select("select * from user")
    List<User> findUser();

}
