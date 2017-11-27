package com.xfdmao.fcat.gate.rpc;

import com.xfdmao.fcat.api.vo.user.TUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xiangfei on 2017/10/16.
 */
@FeignClient("fcat-user")
public interface IUserServiceRpc {
	
	@RequestMapping(value = "/tUserServiceRpc/user/username/{userName}", method = RequestMethod.POST)
	TUser getByUsername(@PathVariable("userName") String userName);

}
