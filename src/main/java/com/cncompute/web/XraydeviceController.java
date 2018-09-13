package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cncompute.pojo.Xaccelerator;
import com.cncompute.pojo.Xneutron;
import com.cncompute.pojo.Xraydevice;
import com.cncompute.pojo.Xraymachine;
import com.cncompute.service.XraydeviceService;
/**
 *  射线装置表控制层
 * @author Admin
 *2018年8月30日17:08:39
 */
@Controller
public class XraydeviceController {
	@Autowired
	private XraydeviceService xraydeviceservice;
	/**
	 * 射线装置名称显示界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="xraydall",method=RequestMethod.GET)
	public String xraydeviceAll(HttpServletRequest request) {
		xraydeviceservice.reydsAll(request);
		return "parameterpage/raydevice";
	}
	/**
	 * 添加射线装置界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="raydadd",method=RequestMethod.GET)
	public String xraydeviceAdd(HttpServletRequest request) {
		xraydeviceservice.reydsAll(request);
		return "parameterpage/raydevicedd";
	}	
	/**
	 * 添加射线装置
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="raydname",method=RequestMethod.POST)
	public void addName(HttpServletRequest request,HttpServletResponse response,Xraydevice rayd) {
		xraydeviceservice.addName(request, response, rayd);
	}
	/**
	 * 录入加速器界面xaccelerator
	 * @param requets
	 * @param type
	 * @return
	 */
	@RequestMapping(value="xraentryac",method=RequestMethod.GET)
	public String accelerator(HttpServletRequest request,String type) {
		xraydeviceservice.insertXaccelerator(request, type);
		return "parameterpage/acceleratoradd";
	}
	/**
	 * 录入加速器
	 * @param request
	 * @param response
	 * @param raid
	 * @param acce
	 */
	@RequestMapping(value="accepost",method=RequestMethod.POST)
	public void acceleratorAdd(HttpServletRequest request,HttpServletResponse response,String raid,Xaccelerator acce) {
		xraydeviceservice.acceleratorAdd(request, response, raid, acce);
	}
	/**
	 * 录入 (X射线机)界面xraymachine
	 * @param requets
	 * @param type
	 * @return
	 */
	@RequestMapping(value="xraentryraym",method=RequestMethod.GET)
	public String raymachine(HttpServletRequest request,String type) {
		xraydeviceservice.queryRaym(request, type);
		return "parameterpage/raymachineadd";
	}
	/**
	 * 录入 (X射线机)
	 * @param request
	 * @param response
	 * @param raym
	 */
	@RequestMapping(value="raympost",method=RequestMethod.POST)
	public void entryRaym(HttpServletRequest request,HttpServletResponse response,Xraymachine raym) {
		xraydeviceservice.raymAdd(request, response, raym);
	}
	/**
	 * 录入(中子发生器)界面xneutron
	 * @param requets
	 * @param type
	 * @return
	 */
	@RequestMapping(value="xraentry",method=RequestMethod.GET)
	public String neutron(HttpServletRequest request,String type) {
		xraydeviceservice.queryNeut(request, type);
		return "parameterpage/neutronadd";
	}
	/**
	 * 录入 (中子发生器)
	 * @param request
	 * @param response
	 * @param raym
	 */
	@RequestMapping(value="neutpost",method=RequestMethod.POST)
	public void neutPost(HttpServletRequest request,HttpServletResponse response,Xneutron neut,String raid) {
		xraydeviceservice.neutAdd(request, response, neut, raid);
	}
	/**
	 * 查看射线装置的详情
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="xradetails",method=RequestMethod.GET)
	public String queryAll(HttpServletRequest request,String type) {
		xraydeviceservice.deviceAll(request, type);
		return "parameterpage/deviceall";
	}
	/**
	 * 添加辐射安全管理措施界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="xraentryneu",method=RequestMethod.GET)
	public String addSafet(HttpServletRequest request,String type) {
		xraydeviceservice.sendSafetysheet(request, type,"3","5");
		return"parameterpage/safetysheetx";
	}
	/**
	 * 添加辐射安全管理措施
	 * @param request
	 * @param response
	 * @param raid
	 */
	@RequestMapping(value="xraaddsafet",method=RequestMethod.POST)
	public void addSafetpost(HttpServletRequest request,HttpServletResponse response,String raid) {
		xraydeviceservice.addSafet(request, response, raid);
	}
	/**
	 * 修改安全措施表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="xrauxipost",method=RequestMethod.POST)
	public void xrauxiPost(HttpServletRequest request,HttpServletResponse response,String raid) {
		xraydeviceservice.file(request, response,raid);
	}
	/**
	 * 删除射线装置
	 * @param requets
	 * @param type
	 */
	@RequestMapping(value="xraydel",method=RequestMethod.GET)
	public String xrayDel(HttpServletRequest request,String type) {
		xraydeviceservice.xrayDel(request, type);
		xraydeviceservice.reydsAll(request);
		return "parameterpage/raydevice";
	}
	/**
	 * 修改射线装置界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="raydup",method=RequestMethod.GET)
	public String raydUpdate(HttpServletRequest request,String type) {
		xraydeviceservice.raydUp(request, type);
		return "parameterpage/raydeviceupdate";
	}
	/**
	 * 修改射线装置
	 * @param request
	 * @param response
	 * @param rayd
	 */
	@RequestMapping(value="xrauppost",method=RequestMethod.POST)
	public void xraupdatePost(HttpServletRequest request,HttpServletResponse response,Xraydevice rayd) {
		xraydeviceservice.xraUpdate(request, response, rayd);
	}
}
