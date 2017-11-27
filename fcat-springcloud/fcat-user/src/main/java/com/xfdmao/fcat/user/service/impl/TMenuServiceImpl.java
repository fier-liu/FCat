package com.xfdmao.fcat.user.service.impl;

import com.xfdmao.fcat.common.service.impl.BaseServiceImpl;
import com.xfdmao.fcat.user.entity.TMenu;
import com.xfdmao.fcat.user.mapper.TMenuMapper;
import com.xfdmao.fcat.user.service.TMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Service
public class TMenuServiceImpl extends BaseServiceImpl<TMenuMapper,TMenu> implements TMenuService {

    @Override
    public List<TMenu> getAuthorityMenusByUsername(String username) {
        return mapper.getAuthorityMenusByUsername(username);
    }
}
