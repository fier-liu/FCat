package com.xfdmao.fcat.gate.controller;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.api.vo.authority.SessionInfo;
import com.xfdmao.fcat.common.util.HttpHelper;
import com.xfdmao.fcat.common.util.JsonUtil;
import com.xfdmao.fcat.common.util.UserDetailsUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Controller
public class SecurityController {
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@RequestMapping(value = "/login_page", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		if (HttpHelper.isAjaxRequest(request)) {
			return "forward:/login/ajax";
		}
		return "login";
	}

	@RequestMapping(value = "/login/ajax", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject loginAjax() {
		return JsonUtil.getFailJsonObject("需要登录");
	}

	/**
	 * 如果是访问受限页面后，跳转到登录页的，则在targetUrl保存之前受限页面的路径，供页面调用
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login/success", method = RequestMethod.GET)
	public @ResponseBody  JSONObject loginSuccess(HttpServletRequest request, HttpServletResponse response) {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		String targetUrl = null;
		if (savedRequest != null) {
			targetUrl = savedRequest.getRedirectUrl();
		}
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		result.put("targetUrl", targetUrl);
		UserDetails userDetails = UserDetailsUtil.getCurrentUser();
		result.put("userDetails",userDetails);

		if(userDetails!=null) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUsername(userDetails.getUsername());
			request.getSession().setAttribute("sessionInfo", sessionInfo);
			result.put("sessionInfo",sessionInfo);
		}
		return JsonUtil.getSuccessJsonObject(result);
	}

	/**
	 * 获取异常信息返回给页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login/failure", method = RequestMethod.GET)
	public @ResponseBody JSONObject loginFailure(HttpServletRequest request) {
		AuthenticationException ae = (AuthenticationException) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		return JsonUtil.getFailJsonObject(ae.getMessage());
	}


	@RequestMapping(value = "/security/user", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject securityUser() {
		UserDetails user = UserDetailsUtil.getCurrentUser();
		Map<String, Object> result = new HashMap<>();
		StringBuilder userRole = new StringBuilder();
		setUserRole(user, result, userRole);
		result.put("userRole", userRole.toString());
		result.put("message", "This message is only visible to the user");
		return JsonUtil.getSuccessJsonObject(result);
	}

	@RequestMapping(value = "/security/admin", method = RequestMethod.GET)
	public Map<String, Object> securityAdmin(HttpServletRequest request) {
		UserDetails user = UserDetailsUtil.getCurrentUser();
		Map<String, Object> result = new HashMap<String, Object>();
		StringBuilder userRole = new StringBuilder();
		setUserRole(user, result, userRole);
		result.put("userRole", userRole.toString());
		result.put("message", "This message is only visible to the admin");
		return result;
	}

	private void setUserRole(UserDetails user, Map<String, Object> result, StringBuilder userRole) {
		if (user != null) {
			result.put("userName", user.getUsername());
			Collection<? extends GrantedAuthority> roleLst = user.getAuthorities();
			for (GrantedAuthority sga : roleLst) {
				userRole.append(sga.toString() + "; ");
			}
		}
	}


}
