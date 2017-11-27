package com.xfdmao.fcat.user.service.impl;

import com.xfdmao.fcat.common.service.impl.BaseServiceImpl;
import com.xfdmao.fcat.user.entity.TUser;
import com.xfdmao.fcat.user.mapper.TUserMapper;
import com.xfdmao.fcat.user.service.TUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Service
public class TUserServiceImpl extends BaseServiceImpl<TUserMapper,TUser> implements TUserService{

    @Override
    public TUser getByUsername(String userName) {
        return mapper.getByUsername(userName);
    }

    @Override
    public List<TUser> getByKey(String key) {
        return mapper.getByKey(key);
    }

    @Override
    public List<TUser> getLeadersByGroupId(Integer groupId) {
        return mapper.getLeadersByGroupId(groupId);
    }

    @Override
    public List<TUser> getMembersByGroupId(Integer groupId) {
        return mapper.getMembersByGroupId(groupId);
    }
}
