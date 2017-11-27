package com.xfdmao.fcat.user.service;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TUser;
import com.xfdmao.fcat.user.entity.TUserGroup;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TUserGroupService extends BaseService<TUserGroup>{

    Boolean saveGroupRelateUsers(Integer groupId, JSONObject param);

    Boolean addByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}
