package com.xfdmao.fcat.user.mapper;

import com.xfdmao.fcat.user.entity.TAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TAuthorityMapper extends Mapper<TAuthority> {
    void deleteByGroupId(Integer groupId);

    List<TAuthority> getListByAuthorityId(Integer authorityId);
}