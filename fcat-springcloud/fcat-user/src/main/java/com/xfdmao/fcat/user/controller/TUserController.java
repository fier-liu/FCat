package com.xfdmao.fcat.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.controller.BaseController;
import com.xfdmao.fcat.common.enumtype.ResultCodeEnum;
import com.xfdmao.fcat.common.util.CheckUtil;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.common.util.TreeUtil;
import com.xfdmao.fcat.user.entity.TElement;
import com.xfdmao.fcat.user.entity.TMenu;
import com.xfdmao.fcat.user.entity.TUser;
import com.xfdmao.fcat.user.po.TMenuTree;
import com.xfdmao.fcat.user.service.TElementService;
import com.xfdmao.fcat.user.service.TMenuService;
import com.xfdmao.fcat.user.service.TUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/tUser")
public class TUserController extends BaseController<TUserService,TUser,Integer>{

    @Autowired
    private TMenuService tMenuService;
    @Autowired
    private TElementService tElementService;

    /**
     * 注册用户
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "注册用户信息" )
    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    public JSONObject registerUser(@RequestBody TUser tUser)throws Exception{
        String username = tUser.getUsername();
        String name = tUser.getName();
        String password = tUser.getPassword();
        String email = tUser.getEmail();

        if(!CheckUtil.checkEmaile(email)){
            return JsonUtil.getResultJson(ResultCodeEnum.EMAILCHECKFAIL);
        }
        TUser tUser1 = bsi.getByUsername(username);
        if(tUser1!=null){
            return JsonUtil.getResultJson(ResultCodeEnum.USER_EXIST);
        }
        //发送邮件
        bsi.insert(tUser);
        return JsonUtil.getSuccessJsonObject();
    }
    /**
     * 通过名称模糊搜索获取用户列表
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过名称模糊搜索获取用户列表" )
    @RequestMapping(value = "getList/{key}", method = RequestMethod.GET)
    public JSONObject getList(@PathVariable String key)throws Exception{
        List<TUser> result = bsi.getByKey(key);
        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 通过组织ID获取用户列表
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过组织ID获取管理者用户列表" )
    @RequestMapping(value = "getListByGroupId/{groupId}", method = RequestMethod.GET)
    public JSONObject getLeadersByGroupId(@PathVariable Integer groupId)throws Exception{
        JSONObject result = new JSONObject();
        List<TUser> leaders = bsi.getLeadersByGroupId(groupId);
        List<TUser> members = bsi.getMembersByGroupId(groupId);
        result.put("leaders",leaders);
        result.put("members",members);
        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 通过用户名获取菜单和元素的权限
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过用户名获取菜单和元素的权限" )
    @RequestMapping(value = "getAuthority/{username}", method = RequestMethod.GET)
    public JSONObject getAuthority(@PathVariable String username)throws Exception{
        JSONObject result = new JSONObject();
        List<TMenuTree> tMenuTreeList = new ArrayList<>();
        List<TMenu> tMenus = tMenuService.getAuthorityMenusByUsername(username);
        for(TMenu tMenu:tMenus){
            TMenuTree tMenuTree = new TMenuTree();
            BeanUtils.copyProperties(tMenu,tMenuTree);
            tMenuTreeList.add(tMenuTree);
        }
        List<TMenuTree> tMenuTrees = TreeUtil.buildByRecursive(tMenuTreeList,-1);

        List<TElement> tElements = tElementService.getAuthorityElementsByUsername(username);
        result.put("tMenuTrees",tMenuTrees);
        result.put("tElements",tElements);
        return JsonUtil.getSuccessJsonObject(result);
    }
}
