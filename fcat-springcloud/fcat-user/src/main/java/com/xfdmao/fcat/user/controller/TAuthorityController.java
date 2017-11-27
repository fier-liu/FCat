package com.xfdmao.fcat.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.common.controller.BaseController;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.user.entity.TAuthority;
import com.xfdmao.fcat.user.service.TAuthorityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/tAuthority")
public class TAuthorityController extends BaseController<TAuthorityService,TAuthority,Integer>{

    /**
     * 通过groupId保存授权信息
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过groupId保存授权信息" )
    @RequestMapping(value = "{groupId}", method = RequestMethod.POST)
    public JSONObject groupId(@PathVariable Integer groupId,@RequestBody JSONObject param)throws Exception{
        JSONArray menuIds = param.getJSONArray("menuIds");
        JSONArray elementIds = param.getJSONArray("elementIds");
        boolean result = bsi.saveBatch(groupId,menuIds,elementIds);
        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 通过groupId获取授权信息
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过groupId获取授权信息" )
    @RequestMapping(value = "{groupId}", method = RequestMethod.GET)
    public JSONObject get(@PathVariable Integer groupId){
        JSONObject result = bsi.getAuthority(groupId);
        return JsonUtil.getSuccessJsonObject(result);
    }
}
