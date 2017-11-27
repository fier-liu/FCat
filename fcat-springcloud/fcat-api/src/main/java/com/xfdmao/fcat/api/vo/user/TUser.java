package com.xfdmao.fcat.api.vo.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TUser implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String birthday;

    private String address;

    private String mobilePhone;

    private String telPhone;

    private String email;

    private String sex;

    private String status;

    private Date createTime;

    private Date updateTime;
}