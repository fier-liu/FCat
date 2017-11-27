package com.xfdmao.fcat.user.mapper;

import com.xfdmao.fcat.user.entity.TGroup;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TGroupMapper extends Mapper<TGroup> {
    List<TGroup> getListByGroupTypeId(Integer groupTypeId);

    List<TGroup> getListByUsername(String username);
}