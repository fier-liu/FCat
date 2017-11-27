package com.xfdmao.fcat.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xfdmao.fcat.common.constant.CommonConstant;
import com.xfdmao.fcat.common.service.BaseService;
import com.xfdmao.fcat.common.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiangfei on 2017/10/16.
 */
public class BaseController<Bsi extends BaseService,Entity,T> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected Bsi bsi;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject add(@RequestBody Entity entity){
        int result=bsi.insertSelective(entity);
        if(result==0){
            return JsonUtil.getFailJsonObject();
        }else{
            return JsonUtil.getSuccessJsonObject();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject get(@PathVariable T id){
        return JsonUtil.getSuccessJsonObject(bsi.selectById(id));
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject update(@RequestBody Entity entity){
        int result=bsi.updateById(entity);
        if(result==0){
            return JsonUtil.getFailJsonObject();
        }else{
            return JsonUtil.getSuccessJsonObject();
        }
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject remove(@PathVariable T id){
        int result=bsi.deleteById(id);
        if(result <= 0){
            return JsonUtil.getFailJsonObject();
        }else{
            return JsonUtil.getSuccessJsonObject();
        }
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject list(){
        return JsonUtil.getSuccessJsonObject(bsi.selectListAll());
    }

    @RequestMapping(value = "/listByPage",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listByPage(Integer pageNum, Integer pageSize){

        pageNum = pageNum == null? CommonConstant.PAGE_NUM:pageNum;
        pageSize = pageSize == null?CommonConstant.PAGE_SIZE:pageSize;

        PageHelper.startPage(pageNum, pageSize);
        List<Entity> tMenuList = bsi.selectListAll();
        PageInfo page = new PageInfo(tMenuList);
        return JsonUtil.getSuccessJsonObject(page);
    }


    /**
     * 获取所有请求参数，封装为map对象
     * @return
     */
    public Map<String,Object> getParameterMap(){
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            parameterMap.put(key,value);
        }
        return parameterMap;
    }
}
