package com.su.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.su.constant.Forward;
import com.su.constant.StrConstant;

@Controller
public class IndexAction extends BaseAction {

	@RequestMapping(value = "index")
	public String toLogin(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.INDEX);
		return Forward.ActionPage.PUBLIC;
	}

	@RequestMapping(value = "error")
	public String error(HttpServletRequest request, ModelMap map) {
		map.put(StrConstant.PAGE, Forward.ActionPage.ERROR);
		return Forward.ActionPage.PUBLIC;
	}
}
