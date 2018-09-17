package com.cncompute.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cncompute.repeat.Methods;
import com.cncompute.service.UserService;

/**
 * 用户控制层
 * @author 劉
 *2018年7月24日10:32:26
 */
@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private Methods methods;
	/**
	 * 用户登录验证
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="validation",method=RequestMethod.GET)
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userservice.getUser( request, response);
	}
	/**
	 * 注册用户
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="registered",method=RequestMethod.POST)
	public void registered(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userservice.regUser(request, response);
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="change",method=RequestMethod.GET)
	public void getChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userservice.modifyPassword(request, response);
	}
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value="change",method=RequestMethod.POST)
	public void postChange(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userservice.modify(request, response);
	}
	/**
	 * 跳转注册界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String regist(HttpServletRequest request) {
		return "userpage/registered";
	}
	/**
	 * 修改密码界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "close", method = RequestMethod.GET)
	public String close(HttpServletRequest request) {
		return "userpage/modify";
	}
	
	/**
	 * 登录界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "login";
	}
	/**
	 * 主页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(HttpServletRequest request) {
		String userid=methods.getUser(request);
		if("".equals(userid)||userid==null) {
			return "login";
		}
		return "main";
	}
}
