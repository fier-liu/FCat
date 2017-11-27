package com.xfdmao.fcat.gate.feign;

import com.xfdmao.fcat.api.vo.authority.PermissionInfo;
import com.xfdmao.fcat.api.vo.user.TUserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by xiangfei on 2017/10/16.
 */
@FeignClient("fcat-user")
public interface IUserServiceFeign {
	
	@RequestMapping(value = "/tUserServiceFeign/user/username/{username}", method = RequestMethod.POST)
	TUserVo getByUsername(@PathVariable("username") String username);

	/**
	 * 通过角色名查询菜单
	 *
	 * @param roles 角色名称  分号隔开
	 * @return 菜单列表
	 */
	@RequestMapping(value = "/tElementServiceFeign/findPermissionInfoByRoles/{roles}", method = RequestMethod.POST)
	Set<PermissionInfo> findPermissionInfoByRoles(@PathVariable("roles") String roles);

}
