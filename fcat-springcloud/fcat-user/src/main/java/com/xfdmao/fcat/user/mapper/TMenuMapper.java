package com.xfdmao.fcat.user.mapper;

import com.xfdmao.fcat.user.entity.TMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMenuMapper extends Mapper<TMenu> {
    List<TMenu> getAuthorityMenusByUsername(String username);
}