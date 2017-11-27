package com.xfdmao.fcat.gate.config;

import com.alibaba.fastjson.JSON;
import com.xfdmao.fcat.api.vo.authority.SessionInfo;
import com.xfdmao.fcat.common.util.HttpHelper;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.common.util.UserDetailsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiangfei on 2017/10/26.
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String result = JSON.toJSONString(JsonUtil.getSuccessJsonObject(true));
        if (authentication != null && authentication.getDetails() != null) {
            try {
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                Map<String, Object> map = new HashMap<>();
                map.put("success", true);
                UserDetails userDetails = UserDetailsUtil.getCurrentUser();
                map.put("userDetails",userDetails);
                logger.info("FCat:userDetails:{}",userDetails);
                if(userDetails!=null) {
                    SessionInfo sessionInfo = new SessionInfo();
                    sessionInfo.setUsername(userDetails.getUsername());
                    httpServletRequest.getSession().setAttribute("sessionInfo", sessionInfo);
                    map.put("sessionInfo",sessionInfo);
                }
                HttpHelper.setResponseJsonData(httpServletResponse,JSON.toJSONString(JsonUtil.getSuccessJsonObject(map)));
                return ;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HttpHelper.setResponseJsonData(httpServletResponse,result);
    }
}
