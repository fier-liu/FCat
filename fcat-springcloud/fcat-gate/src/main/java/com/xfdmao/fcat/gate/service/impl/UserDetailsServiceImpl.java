package com.xfdmao.fcat.gate.service.impl;

import com.xfdmao.fcat.api.vo.user.TUserVo;
import com.xfdmao.fcat.api.vo.user.UserInfo;
import com.xfdmao.fcat.gate.feign.IUserServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private IUserServiceFeign iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("FCat:loadUserByUsername:{}",username);
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        TUserVo tUserVo = iUserService.getByUsername(username);
        if(tUserVo==null){
            throw new UsernameNotFoundException("登录账号不存在");
        }

        UserInfo userInfo = new UserInfo(tUserVo);
        return userInfo;
    }
}
