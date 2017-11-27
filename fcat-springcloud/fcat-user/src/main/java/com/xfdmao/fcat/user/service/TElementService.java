package com.xfdmao.fcat.user.service;

import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TElement;
import com.xfdmao.fcat.user.po.TElementVo;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TElementService extends BaseService<TElement>{

    List<TElement> getListByMenuId(Integer menuId);

    List<TElement> getAuthorityElementsByUsername(String username);

    List<TElementVo> getListByRole(String role);

    String[] getPermissionsByRoles(String[] roles);
}
