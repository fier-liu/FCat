package com.xfdmao.fcat.gate.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xfdmao.fcat.api.vo.authority.PermissionInfo;
import com.xfdmao.fcat.gate.feign.IUserServiceFeign;
import com.xfdmao.fcat.gate.service.PermissionService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    private IUserServiceFeign iUserService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        logger.info("FCat:hasPermission");
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        logger.info("FCat:grantedAuthorityList:{}",JSONObject.toJSON(grantedAuthorityList));
        boolean hasPermission = false;

        if (principal != null) {
            Set<String> roleSet = new HashSet<>();
            grantedAuthorityList.forEach(grantedAuthority -> roleSet.add(grantedAuthority.getAuthority()));
            String roles = StringUtils.join(roleSet,";");
            Set<PermissionInfo> permissionInfos = iUserService.findPermissionInfoByRoles(roles);
            logger.info("FCat:PersissionInfos：{}", JSONObject.toJSON(permissionInfos));
            logger.info("FCat:request.getRequestURI()：{}", request.getRequestURI());
            for (PermissionInfo permissionInfo : permissionInfos) {
                if (antPathMatcher.match(permissionInfo.getUri(), request.getRequestURI())
                        && request.getMethod().equalsIgnoreCase(permissionInfo.getMethod())) {
                    hasPermission = true;
                    break;
                }
            }
        }
        logger.info("FCat:hasPermission:{}", hasPermission);
        return hasPermission;
    }
}
