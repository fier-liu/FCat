package com.xfdmao.fcat.user.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TAuthority;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TAuthorityService extends BaseService<TAuthority>{

    boolean saveBatch(Integer groupId, JSONArray menuIds, JSONArray elementIds);

    JSONObject getAuthority(Integer groupId);
}
