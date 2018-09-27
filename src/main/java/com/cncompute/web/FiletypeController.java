package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cncompute.pojo.Unitsystem;
import com.cncompute.service.FiletypeService;
/**
 * 单位辐射安全规章制度模块
 * 文件类别控制层
 * @author Admin
 * 2018年8月28日15:09:06
 */
@Controller
public class FiletypeController {
	@Autowired
	private FiletypeService fileservice;
	/**
	 * 单位辐射安全规章制度显示界面
	 * @param Request
	 */
	@RequestMapping(value="unsystem",method=RequestMethod.GET)
	public String Unsystem(HttpServletRequest request) {
		fileservice.fileAll(request);
		return "environmental/filetype";
	}
	/**
	 * 添加文件类别界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="fileadd",method=RequestMethod.GET)
	public String fileadd(HttpServletRequest request,String type) {
		fileservice.flnameAll(request);
		return"environmental/filetypeadd";
	}
	/**
	 * 添加文件类别
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="fiadd",method=RequestMethod.POST)
	public void fiAdd(HttpServletRequest request,String flname1,String flname2,HttpServletResponse response) {
		fileservice.fileAddpost(request, response, flname1, flname2);
	}
	/**
	 * 删除规章制度
	 * @param request
	 */
	@RequestMapping(value="filedelete",method=RequestMethod.GET)
	public String fileDelete(HttpServletRequest request,String type) {
		fileservice.deleteFile(request, type);
		fileservice.fileAll(request);
		return "environmental/filetype";
	}
	/**
	 * 查询详细，向规章制度显示界面发送信息
	 * @return
	 */
	@RequestMapping(value="filedetails",method=RequestMethod.GET)
	public String fileDetails(HttpServletRequest request,String type) {
		fileservice.viewFile(request, type);
		return "environmental/unitsystem";
	}
	/**
	 * 添加规章制度界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="fiunadd",method=RequestMethod.GET)
	public String fiunAdd(HttpServletRequest request ,String type) {
		fileservice.sendfileid(request, type);
		return "environmental/unitsystemadd";
	}
	/**
	 * 添加规章制度方法
	 * @param request
	 * @param response
	 * @param Unit
	 * @param flid
	 */
	@RequestMapping(value="flunaddpost",method=RequestMethod.POST)
	public void flunaddpost(HttpServletRequest request,HttpServletResponse response,Unitsystem unit,String flid,@RequestParam("file1") MultipartFile file) {
		fileservice.addUnit(request, response, unit, flid, file);
	}
	/**
	 * 删除规章制度
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="undelete",method=RequestMethod.GET)
	public String unDelete(HttpServletRequest request,String type,String flid){
		fileservice.unDelete(request, type);
		fileservice.viewFile(request, flid);
		return "environmental/unitsystem";
	}
	/**
	 * 修改规章制度界面
	 * @return
	 */
	@RequestMapping(value="unupdate",method=RequestMethod.GET)
	public String unupdate(HttpServletRequest request ,String number) {
		fileservice.updateUnti(request,number);
		return"environmental/unitsystemupdate";
	}
	/**
	 * 修改规章制度
	 * @param request
	 * @param response
	 * @param unit
	 */
	@RequestMapping(value="unupdatepost",method=RequestMethod.POST)
	public void unupDatepost(HttpServletRequest request,HttpServletResponse response,Unitsystem unit,@RequestParam("file1") MultipartFile file) {
		fileservice.updateUntipost(request, response, unit,file);
	}
	/**
	 * 单位辐射安全规章制度模糊查询
	 * @param requets
	 * @param name
	 * @return
	 */
	@RequestMapping(value="fileunfuzzy",method=RequestMethod.GET)
	public String unFuzzy(HttpServletRequest request,String name) {
		fileservice.unitFuzzy(request, name);
		return"environmental/filetypefuzzy";
	}
}
