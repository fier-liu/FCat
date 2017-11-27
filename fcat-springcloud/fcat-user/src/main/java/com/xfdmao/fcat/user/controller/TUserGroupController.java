package com.xfdmao.fcat.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.controller.BaseController;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.user.entity.TUserGroup;
import com.xfdmao.fcat.user.service.TUserGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/tUserGroup")
public class TUserGroupController extends BaseController<TUserGroupService,TUserGroup,Integer>{
    /**
     * 通过用户Id和组织Id添加记录
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过用户Id和组织Id添加记录" )
    @RequestMapping(value = "addByUserIdAndGroupId", method = RequestMethod.POST)
    public JSONObject addByUserIdAndGroupId(@RequestBody TUserGroup tUserGroup)throws Exception{
        Boolean result = bsi.addByUserIdAndGroupId(tUserGroup);
        System.err.println(tUserGroup);
        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 通过用户Id和组织Id删除记录
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过用户Id和组织Id删除记录" )
    @RequestMapping(value = "deleteByUserIdAndGroupId", method = RequestMethod.POST)
    public JSONObject deleteByUserIdAndGroupId(@RequestBody TUserGroup tUserGroup)throws Exception{
        Boolean result = bsi.deleteByUserIdAndGroupId(tUserGroup);
        System.err.println(tUserGroup);
        return JsonUtil.getSuccessJsonObject(result);
    }
}
