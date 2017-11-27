package com.xfdmao.fcat.user.service;

import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TGroup;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TGroupService extends BaseService<TGroup>{

    List<TGroup> getListBygroupTypeId(Integer groupTypeId);

    String[] getCodeByUsername(String username);
}
