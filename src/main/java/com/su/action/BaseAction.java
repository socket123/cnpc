package com.su.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseAction {
	
	/**
	 * 获取静态资源服务器的路径
	 * @param request
	 * @return String 当前项目部署的服务器路径
	 */
	@ModelAttribute("base")
	public String basePath(HttpServletRequest request){
		String basePath = request.getContextPath();
		// 修复了部署为根工程的情况下，出现两个“//”的问题
		return basePath.endsWith("/") ? basePath.substring(0, basePath.length() - 1) : basePath;
	}
}
