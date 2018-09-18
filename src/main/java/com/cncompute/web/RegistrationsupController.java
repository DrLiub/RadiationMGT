package com.cncompute.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cncompute.pojo.Registrationsup;
import com.cncompute.service.RegistrationsupService;

/**
 * 监测设备、报警仪器和辐射防护用品登记表的控制层
 * @author Admin
 *2018年8月20日11:00:12
 */
@Controller
public class RegistrationsupController {
	@Autowired
	private RegistrationsupService regService;
	/**
	 * 辐射环境监测设备界面
	 * @param request
	 */
	@RequestMapping(value="reequip",method=RequestMethod.GET)
	public String reequip(HttpServletRequest request,Integer retable) {
		regService.reQuery(request, retable);
		return "registrpage/regequipment"+retable;
	}
	/**
	 * 添加信息界面
	 * @param request
	 * @param retable
	 * @return
	 */
	@RequestMapping(value="readd",method=RequestMethod.GET)
	public String readd(HttpServletRequest request,Integer retable) {
		regService.sendRetable(request, retable);
		return"registrpage/regentry"+retable;
	}
	/**
	 * 添加信息
	 * @param request
	 * @param retable
	 * @param response
	 */
	@RequestMapping(value="readdpost",method=RequestMethod.POST)
	public void readdPost(HttpServletRequest request,Integer retable,HttpServletResponse response) {
		regService.addReg(request,response,retable);
	}
	/**
	 * 删除监测设备、报警仪器和辐射防护用品登记表信息
	 * @param request
	 * @param response
	 * @param retable
	 * @param reid
	 */
	@RequestMapping(value="regdelete",method=RequestMethod.GET)
	public String regDelete(HttpServletRequest request,Integer retable,String reid) {
		regService.reDelete(request, retable, reid);
		return "registrpage/regequipment"+retable;
	}
	/**
	 * 修改监测设备、报警仪器和辐射防护用品登记表信息界面
	 * @param request
	 * @param retable
	 * @param reid
	 * @return
	 */
	@RequestMapping(value="reupdate",method=RequestMethod.GET)
	public String reuPdate(HttpServletRequest request,Integer retable,String reid) {
		regService.reReid(request,reid);
		return "registrpage/reupdate"+retable;
	}
	/**
	 * 修改监测设备、报警仪器和辐射防护用品登记表信息
	 * @param request
	 * @param retable
	 * @param reid
	 * @return
	 */
	@RequestMapping(value="reuppost",method=RequestMethod.POST)
	public void updatePost(HttpServletRequest request,Registrationsup reg,HttpServletResponse response) {
		regService.updatePost(request, reg,response);
	}
	/**
	 * 导出Excel辐射环境监测设备
	 * @param request
	 * @param response
	 * @param retable
	 * @throws IOException 
	 */
	@RequestMapping(value="reexport",method=RequestMethod.GET)
	public void export(HttpServletRequest request,HttpServletResponse response,Integer retable) throws IOException {
		regService.export(request, response, retable);
	}
}
