package com.xfdmao.fcat.api.vo.user;

import lombok.Data;

import java.io.Serializable;
/**
 * Created by xiangfei on 2017/10/16.
 */
@Data
public class AuthInfo implements Serializable{

	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 姓名
	 */
	private String name;

}
