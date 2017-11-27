/**    
 * Title:  http工具类
 * fileName:HttpUtil.java
 * Description: 
 * @Copyright: PowerData Software Co.,Ltd. Rights Reserved.
 * @Company: 深圳市易简行系统日志管理平台商务有限公司
 * @author: jonex
 * @version:1.0
 * create date:2015年4月14日  
 * Copyright jonex Corporation
 *    
 */
package com.xfdmao.fcat.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class HttpUtil {
	
	private HttpUtil(){
		
	}
	
	public static String getIpAddr(HttpServletRequest request) throws Exception{  
	       String ip = request.getHeader("X-Real-IP");  
	       if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {  
	           return ip;  
	       }  
	       ip = request.getHeader("X-Forwarded-For");  
	       if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {  
	           // 多次反向代理后会有多个IP值，第一个为真实IP。  
	           int index = ip.indexOf(',');  
	           if (index != -1) {  
	               return ip.substring(0, index);  
	           } else {  
	               return ip;  
	           }  
	       } else {  
	           return request.getRemoteAddr();  
	       }  
	   }

}
