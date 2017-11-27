package com.xfdmao.fcat.user.service;

import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.user.entity.TMenu;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
public interface TMenuService extends BaseService<TMenu>{

    List<TMenu> getAuthorityMenusByUsername(String username);
}
