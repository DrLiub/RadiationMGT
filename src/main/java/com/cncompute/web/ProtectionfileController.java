package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cncompute.pojo.Completionreply;
import com.cncompute.pojo.Environmental;
import com.cncompute.pojo.License;
import com.cncompute.pojo.Protectionfile;
import com.cncompute.service.ProtectionfileService;
/**
 * 环保手续文件控制层
 * @author Admin
 *2018年8月24日10:13:05
 */
@Controller
public class ProtectionfileController {
	@Autowired
	private ProtectionfileService proservice;
	/**
	 * 环保手续文件显示界面
	 * @param request
	 */
	@RequestMapping(value="proforma",method=RequestMethod.GET)
	public String proForma(HttpServletRequest request) {
		proservice.proall(request);
		return "environmental/protection";
	}
	/**
	 * 添加环保手续文件界面
	 * @param request
	 * @param prid
	 * @return
	 */
	@RequestMapping(value="proteadd",method=RequestMethod.GET)
	public String proteAdd(HttpServletRequest request ,String prid) {
		return "environmental/protectionadd";
	}
	/**
	 * 添加环保手续文件方法
	 * @param request
	 * @param pro
	 */
	@RequestMapping(value="pradd",method=RequestMethod.POST)
	public void pradd(HttpServletRequest request,HttpServletResponse response,Protectionfile pro) {
		proservice.addProte(request, response, pro);
	}
	/**
	 * 录入许可证界面
	 * @param requets
	 * @param type
	 * @return
	 */
	@RequestMapping(value="prlic",method=RequestMethod.GET)
	public String prlic(HttpServletRequest request,String type) {
		proservice.prlic(request, type);
		return "environmental/licenseadd";
	}
	/**
	 * 添加修改许可证内容
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="prlicpost",method=RequestMethod.POST)
	public void prlicPost(HttpServletRequest request,HttpServletResponse response,License lice,String prid,@RequestParam("file1") MultipartFile file) {
		proservice.prlicPost(request, response, lice, prid,file);
	}
	/**
	 * 录入环境影响评价文件批复界面
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="prenv",method=RequestMethod.GET)
	public String prenv(HttpServletRequest request,String type) {
		proservice.prenv(request, type);
		return"environmental/environmentaladd";
	}
	/**
	 * 修改保存环境影响评价文件批复
	 * @param request
	 * @param response
	 * @param envi
	 * @param prid
	 * @param file
	 */
	@RequestMapping(value="prenvpost",method=RequestMethod.POST)
	public void prenvPost(HttpServletRequest request,HttpServletResponse response,Environmental envi,String prid,@RequestParam("file1") MultipartFile file) {
		proservice.prenvPost(request, response, envi, prid, file);
	}
	/**
	 * 录入环保竣工验收监测文件批复界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="prcom",method=RequestMethod.GET)
	public String prcom(HttpServletRequest request,String type) {
		proservice.prcom(request, type);
		return"environmental/completionreplyadd";
	}
	/**
	 * 修改环保竣工验收监测文件批复
	 * @param request
	 * @param response
	 * @param comp
	 * @param prid
	 * @param file
	 */
	@RequestMapping(value="prcompost",method=RequestMethod.POST)
	public void prcomPost(HttpServletRequest request,HttpServletResponse response,Completionreply comp,String prid,@RequestParam("file1") MultipartFile file) {
		proservice.prcomPost(request, response, comp, prid, file);
	}
	/**
	 * 显示全部信息
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="prdetails",method=RequestMethod.GET)
	public String prDetails(HttpServletRequest request,String type) {
		proservice.prall(request, type);
		return"environmental/protectionall";
	}
	/**
	 * 删除环保手续文件
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="protdelete",method=RequestMethod.GET)
	public String protDelete(HttpServletRequest request,String type) {
		proservice.prDelete(request, type);
		return "environmental/protection";
	}
	/**
	 * 修改环保手续文件界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="protupdate",method=RequestMethod.GET)
	public String prUpdate(HttpServletRequest request ,String type) {
		proservice.prUpdate(request, type);
		return "environmental/protectionupdate";
	}
	/**
	 * 修改环保手续文件方法
	 * @param request
	 * @param prot
	 */
	@RequestMapping(value="protuppost",method=RequestMethod.POST)
	public void prUppost(HttpServletRequest request,HttpServletResponse response,Protectionfile prot) {
		proservice.prUpdatepost(request, response, prot);
	}
}
