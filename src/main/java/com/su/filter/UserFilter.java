package com.su.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 过滤器
 * 
 * @author Administrator
 * 
 */
public class UserFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		if (request.getServletPath().equals("/login.do")
				|| request.getServletPath().equals("/vaildUser.do")) {
			chain.doFilter(request, response);
			return;
		} else {
			User user = (User) CommonUtil.getSessionObj(request,
					StrConstant.USER);
			if (null == user) {
				String url = request.getScheme() + "://"
						+ request.getServerName() + ":"
						+ request.getServerPort() + request.getContextPath()
						+ "/";
				url += "login.do";
				response.sendRedirect(url);
				return;
			}

			Map<String, String> navMap = this.setNavAndMenu(request, user);
			request.getSession().setAttribute("navMap", navMap);
		}
		chain.doFilter(request, response);
		return;
	}

	/**
	 * 设置导航栏和被选中的菜单
	 * 
	 * @param request
	 * @param user
	 */
	private Map<String, String> setNavAndMenu(HttpServletRequest request,
			User user) {
		Map<String, String> navMap = new HashMap<String, String>();
		String menuId = request.getParameter(StrConstant.MENUID);
		if (!("").equals(menuId) && null != menuId) {

			request.getSession().setAttribute(StrConstant.MENUID, menuId);
			List<Menu> menuList = new ArrayList<Menu>();
			menuList = user.getMenuList();
			int menuIdInt = Integer.valueOf(menuId);
			for (Menu menu : menuList) {
				if (menuIdInt == menu.getId()) {
					navMap.put("chlidMenu", menu.getMenuName());
					return navMap;
				}

				for (Menu cMenu : menu.getChildMenu()) {
					if (menuIdInt == cMenu.getId()) {
						navMap.put("chlidMenu", cMenu.getMenuName());
						navMap.put("parentMenu", menu.getMenuName());

						return navMap;
					}

				}
			}
		} else {
			request.getSession().setAttribute(StrConstant.MENUID, "0");
		}
		return navMap;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
