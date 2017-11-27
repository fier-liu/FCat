package com.xfdmao.fcat.user.mapper;

import com.xfdmao.fcat.user.entity.TUserGroup;
import tk.mybatis.mapper.common.Mapper;

public interface TUserGroupMapper extends Mapper<TUserGroup> {

    void deleteByGroupId(Integer groupId);

    TUserGroup getByUserIdAndGroupId(TUserGroup tUserGroup);

    Boolean deleteByUserIdAndGroupId(TUserGroup tUserGroup);
}