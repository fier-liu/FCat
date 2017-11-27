package com.xfdmao.fcat.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.controller.BaseController;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.user.entity.TGroup;
import com.xfdmao.fcat.user.service.TGroupService;
import com.xfdmao.fcat.user.service.TUserGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/tGroup")
public class TGroupController extends BaseController<TGroupService,TGroup,Integer>{

    @Autowired
    private TUserGroupService tUserGroupService;
    /**
     * 通过groupTypeId获取组织列表
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过menuId获取元素列表" )
    @RequestMapping(value = "groupTypeId/{groupTypeId}", method = RequestMethod.GET)
    public JSONObject getByMenuId(@PathVariable Integer groupTypeId)throws Exception{
        List<TGroup> result = bsi.getListBygroupTypeId(groupTypeId);
        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 保存组织关联的用户
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "保存组织关联的用户" )
    @RequestMapping(value = "/{groupId}", method = RequestMethod.POST)
    public JSONObject groupId(@PathVariable Integer groupId, @RequestBody JSONObject param)throws Exception{

        Boolean result = tUserGroupService.saveGroupRelateUsers(groupId,param);
        return JsonUtil.getSuccessJsonObject(result);
    }
}
