package com.xfdmao.fcat.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.api.vo.authority.SessionInfo;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.user.entity.LoginUser;
import com.xfdmao.fcat.user.feign.TUserServiceFeign;
import com.xfdmao.fcat.user.service.LoginUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiangfei on 2017/10/17.
 */
@RestController
@RequestMapping("v1/session")
public class SessionController extends TUserServiceFeign {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private LoginUserService loginUserService;

    /**
     * 测试从session中获取用户信息
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "获取session中的信息" )
    @RequestMapping(value = "sessionInfo", method = RequestMethod.GET)
    public JSONObject sessionUserInfo()throws Exception{
        try {
            SessionInfo sessionInfo  = (SessionInfo) request.getSession().getAttribute("sessionInfo");
            System.err.println("sessionInfo :"+sessionInfo);
            return JsonUtil.getSuccessJsonObject(sessionInfo);
        }catch ( Exception e){
            e.printStackTrace();
        }
        return JsonUtil.getFailJsonObject();
    }


    @ApiOperation(value = "测试保存用户动态验证码" )
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public JSONObject login(String username) {
        String password = String.valueOf(RandomStringUtils.randomNumeric(6));
        LoginUser loginUser = loginUserService.saveLoginUser(username,password);
        LoginUser loginUser1 = loginUserService.getLoginUser(username);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("设置redis中的loginUser",loginUser);
        System.out.println(loginUser);
        jsonObject.put("读取redis中loginUser",loginUser1);
        System.out.println(loginUser1);
        return jsonObject;
    }


}
