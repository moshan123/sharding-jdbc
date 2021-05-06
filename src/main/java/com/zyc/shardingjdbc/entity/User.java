package com.zyc.shardingjdbc.entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * User 
 */
@Data
public class User implements java.io.Serializable {

    /**
     * id
     */
    public Long id;

    /**
     * nickname
     */
    public String nickname;

    /**
     * password
     */
    public String password;

    /**
     * sex
     */
    public Integer sex;

    public Integer age;

    /**
     * birthday
     */
    public Date birthday;

}
