package com.xfdmao.fcat.user.rpc;

import com.xfdmao.fcat.user.entity.TUser;
import com.xfdmao.fcat.user.service.TUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tUserServiceRpc")
public class TUserServiceRpc {

	@Autowired
	private TUserService tUserService;
	/**
	 * 通过用户名获取用户的基本信息
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/user/username/{userName}", method = RequestMethod.POST)
	public com.xfdmao.fcat.api.vo.user.TUser getByUsername(@PathVariable("userName") String userName) {
		com.xfdmao.fcat.api.vo.user.TUser tUser = null;
		try {
			TUser tUser1 = tUserService.getByUsername(userName);
			if (tUser1 != null) {
				tUser=new com.xfdmao.fcat.api.vo.user.TUser();
				BeanUtils.copyProperties(tUser1,tUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tUser;
	}
}