package com.cncompute.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cncompute.pojo.Management;
import com.cncompute.repeat.Methods;
import com.cncompute.service.ManagementService;

/**
 * 管理机构管理人员控制层
 * @author 劉
 *2018年8月2日15:01:47
 */
@Controller
public class ManagementController {
	@Autowired
	private ManagementService mangservice;
	@Autowired
	private Methods methods;
	/**
	 * 管理机构页面
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="manag",method=RequestMethod.GET)
	public String registered(HttpServletRequest request, HttpServletResponse response)  {
//		String userid=methods.getUser(request);
//		if("".equals(userid)||userid==null) {
//			return "login";
//		}
	    return "institutionspage/management";
	}
	/**
	 * 新建机构并插入管理人员
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="manag",method=RequestMethod.POST)
	public String registeredPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		mangservice.personnel(request,response);
		mangservice.sendMang(request);
	    return "institutionspage/institution";
	}
	/**
	 * 辐射管理机构构成页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="quman",method=RequestMethod.GET)
	public String queryManag(HttpServletRequest request, HttpServletResponse response)  {
//		String userid=methods.getUser(request);
//		if("".equals(userid)||userid==null) {
//			return "login";
//		}
		mangservice.sendMang(request);
	    return "institutionspage/institution";
	}
	/**
	 * 删除-辐射管理机构
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="manidel",method=RequestMethod.GET)
	public String deleteMana(HttpServletRequest request,String type) {
		mangservice.upModi(request, type);
		mangservice.sendMang(request);
		return "institutionspage/institution";
	}
	/**
	 * 修改-辐射管理机构界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="maupdate",method=RequestMethod.GET)
	public String updateMana(HttpServletRequest request,String type) {
		mangservice.sendUpMana(request,type);
		return "institutionspage/managementupdate";
	}
	/**
	 * 修改-辐射管理机构
	 * @param request
	 * @param response
	 * @param mana
	 */
	@RequestMapping(value="maupmana",method=RequestMethod.POST)
	public void upMana(HttpServletRequest request,HttpServletResponse response,Management mana) {
		mangservice.updateMana(request, response, mana);
	}
	/**
	 * 辐射管理人员显示页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="mpeople",method=RequestMethod.GET)
	public String manPeople(HttpServletRequest request, HttpServletResponse response)  {
//		String userid=methods.getUser(request);
//		if("".equals(userid)||userid==null) {
//			return "login";
//		}
		mangservice.setMpeople(request);
	    return "institutionspage/managpeople";
	}
	/**
	 * 辐射管理人员显示界面添加管理人员页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="personnel",method=RequestMethod.GET)
	public String personnel(HttpServletRequest request, HttpServletResponse response)  {
//		String userid=methods.getUser(request);
//		if("".equals(userid)||userid==null) {
//			return "login";
//		}
		mangservice.encapsulation(request);
	    return "institutionspage/addmanag";
	}
	/**
	 * 在机构下添加管理人员
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="addmanag",method=RequestMethod.POST)
	public String addManag(HttpServletRequest request, HttpServletResponse response)  {
		String peid=request.getParameter("type");
		mangservice.addManagement(request,peid);
		mangservice.setMpeople(request);
	    return "institutionspage/managpeople";
	}
	/**
	 * 删除辐射管理人员界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="madelete",method=RequestMethod.GET)
	public String madelete(HttpServletRequest request)  {
		mangservice.madelete(request);
	    return "institutionspage/managpeople";
	}
	/**
	 * 修改辐射管理人员界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mamodify",method=RequestMethod.GET)
	public String mamodify(HttpServletRequest request)  {
        mangservice.sending(request);
	    return "institutionspage/modifystaff";
	}
	/**
	 * 修改辐射管理人员信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="maupdate",method=RequestMethod.POST)
	public void mamodifyPost(HttpServletRequest request,HttpServletResponse response) {
		mangservice.mamodify(request,response);
	}
}
