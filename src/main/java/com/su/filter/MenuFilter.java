/**
 * 
 */
package com.su.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.constant.StrConstant;
import com.su.entity.Menu;
import com.su.entity.User;
import com.su.utils.CommonUtil;

/**
 * @author Eric
 * 
 */
public class MenuFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getServletPath();
		path = path.substring(1, path.length());
		// 判断用户是否有该URL权限
		User user = (User) CommonUtil.getSessionObj(request, StrConstant.USER);
		List<Menu> menuList = user.getMenuList();
		if (menuList == null) {
			response.sendRedirect("../error.do");
			return;
		}
		List<String> urlList = new ArrayList<>();
		for (Menu menu : menuList) {
			List<Menu> childMenus = menu.getChildMenu();
			if (childMenus != null) {
				for (Menu m : childMenus) {
					urlList.add(m.getLink());
				}
			}
			urlList.add(menu.getLink());
		}
		if (!urlList.contains(path)) {
			response.sendRedirect("../error.do");
			return;
		}
		chain.doFilter(request, response);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
