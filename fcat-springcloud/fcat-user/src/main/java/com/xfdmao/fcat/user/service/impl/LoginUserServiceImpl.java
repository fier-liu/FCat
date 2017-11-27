package com.xfdmao.fcat.user.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xfdmao.fcat.user.service.LoginUserService;
import com.xfdmao.fcat.user.entity.LoginUser;

/**
 * Created by xiangfei on 2017/9/16.
 */
@Service
@CacheConfig(cacheNames = "LoginUserService")
public class LoginUserServiceImpl implements LoginUserService {
	@Override
	@Cacheable(key = "#p0", value = "loginUser")
	public LoginUser getLoginUser(String userName) {
		LoginUser loginUser = new LoginUser();
		loginUser.setUserName(userName);
		System.err.println(loginUser.getUserName() +" " +loginUser.getPassword());
		return loginUser;
	}
		
	@Override
	@CachePut(key = "#p0", value = "loginUser")
	public LoginUser saveLoginUser(String userName, String password) {
		LoginUser loginUser = new LoginUser();
		loginUser.setUserName(userName);
		loginUser.setPassword(password);
		return loginUser;
	}
	
	
//	public String getMobileCode(String mobilePhone) {
//		LoginUser loginUser=getLoginUser(mobilePhone);
//		if(loginUser==null){
//			System.err.println("loginUser==null");
//		}
//		System.err.println(loginUser.getUserName() +" " +loginUser.getPassword());
//		return loginUser.getPassword();
//	}
}
