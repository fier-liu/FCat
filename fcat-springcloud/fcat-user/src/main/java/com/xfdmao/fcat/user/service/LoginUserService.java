package com.xfdmao.fcat.user.service;

import com.xfdmao.fcat.user.entity.LoginUser;

/**
 * Created by xiangfei on 2017/7/18.
 */

public interface LoginUserService {

    LoginUser getLoginUser(String username);

    LoginUser saveLoginUser(String username, String password);
   // String getMobileCode(String mobilePhone);
}
