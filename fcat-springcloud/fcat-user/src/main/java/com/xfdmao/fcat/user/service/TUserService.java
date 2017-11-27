package com.xfdmao.fcat.user.service;

import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TUser;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TUserService extends BaseService<TUser>{

    TUser getByUsername(String userName);

    List<TUser> getByKey(String key);

    List<TUser> getLeadersByGroupId(Integer groupId);

    List<TUser> getMembersByGroupId(Integer groupId);
}
