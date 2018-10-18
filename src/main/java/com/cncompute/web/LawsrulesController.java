package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cncompute.pojo.Lawsrules;
import com.cncompute.service.LawsrulesService;
/**
 * 法律法规表控制层
 * @author Admin
 *2018年8月29日16:50:59
 */
@Controller
public class LawsrulesController {
	@Autowired
	private LawsrulesService lawsservice;
	/**
	 * 查询法律法规全部的信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="laws",method=RequestMethod.GET)
	public String lawsAll(HttpServletRequest request) {
		lawsservice.lawsAll(request);
		return"law/lawsrules";
	}
	/**
	 * 添加法律法规页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="laentry",method=RequestMethod.GET)
	public String lawsadd(HttpServletRequest request) {
		return "law/lawsrulesadd";
	}
	/**
	 * 添加法律法规
	 * @param request
	 * @param response
	 * @param laws
	 * @param file
	 */
	@RequestMapping(value="lawsaddpost")
	public void lawsaddPost(HttpServletRequest request,HttpServletResponse response,Lawsrules laws,@RequestParam("file1") MultipartFile file) {
		lawsservice.lawsAdd(request, response, laws, file);
	}
	/**
	 * 相关法律法规模糊查询
	 * @param request
	 * @param name
	 * @return
	 */
	@RequestMapping(value="lawsfuzzy",method=RequestMethod.GET)
	public String lawsfuzzy(HttpServletRequest request,String name) {
		lawsservice.fuzzyLa(request, name);
		return"law/lawsrulesfuzzy";
	}
	/**
	 * 删除法律法规
	 * @param request
	 * @param laid
	 * @return
	 */
	@RequestMapping(value="lawdelete",method=RequestMethod.GET)
	public String lawDelete(HttpServletRequest request,Lawsrules laws) {
		lawsservice.laDelete(request, laws);
		lawsservice.lawsAll(request);
		return"law/lawsrules";
	}
	/**
	 * 修改法律法规界面
	 * @return
	 */
	@RequestMapping(value="lawupdate",method=RequestMethod.GET)
	public String laUpdatePage(HttpServletRequest request,String laid) {
		lawsservice.laUpdatesend(request, laid);
	    return"law/lawsrulesupdate";	
	}
	/**
	 * 修改法律法规
	 * @param request
	 * @param response
	 * @param laws
	 */
	@RequestMapping(value="laupdatep",method=RequestMethod.POST)
	public void laUpadte(HttpServletRequest request,HttpServletResponse response,Lawsrules laws,@RequestParam("file1") MultipartFile file) {
		lawsservice.lawsUpdate(request, response, laws,file);
	}
}
