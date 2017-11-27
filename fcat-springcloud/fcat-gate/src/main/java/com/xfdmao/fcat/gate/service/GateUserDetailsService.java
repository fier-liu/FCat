package com.xfdmao.fcat.gate.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xfdmao.fcat.api.vo.user.TUser;
import com.xfdmao.fcat.gate.rpc.IUserServiceRpc;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Service
public class GateUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserServiceRpc iUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        String password;
        TUser tUser = iUserService.getByUsername(username);
        if(tUser==null){
            throw new UsernameNotFoundException("登录账号不存在");
        }else{
            password=tUser.getPassword();
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new org.springframework.security.core.userdetails.User(
                username, password,
                true,
                true,
                true,
                true,
                authorities);
    }
}
