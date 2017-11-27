package com.xfdmao.fcat.gate.config;

import com.alibaba.fastjson.JSON;
import com.xfdmao.fcat.common.util.HttpHelper;
import com.xfdmao.fcat.common.util.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiangfei on 2017/10/26.
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        AuthenticationException ae = (AuthenticationException) httpServletRequest.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if(ae==null){
            HttpHelper.setResponseJsonData(httpServletResponse, JSON.toJSONString( JsonUtil.getFailJsonObject()));
        }else{
            HttpHelper.setResponseJsonData(httpServletResponse, JSON.toJSONString( JsonUtil.getFailJsonObject(ae.getMessage())));
        }

    }
}
