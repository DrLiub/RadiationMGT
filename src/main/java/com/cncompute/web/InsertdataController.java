package com.cncompute.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cncompute.pojo.Insertdata;
import com.cncompute.service.InsertdataService;

/**
 * 工作人员职业健康情况表控制层
 * @author Admin
 *2018年8月15日15:30:28
 */
@Controller
public class InsertdataController {
	@Autowired
	private InsertdataService inserservice;
	/**
	 * 插入监测数据界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="stinsert",method=RequestMethod.GET)
	public String stinsert(HttpServletRequest request) {
		inserservice.sendStnumber(request);
		return "institutionspage/inserhealth";
	}
	/**
	 * 插入监测数据 返回工作人员显示界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="ininsert",method=RequestMethod.POST)
	public void stinsertPost(HttpServletRequest request,HttpServletResponse response) {
		inserservice.inInsert(request,response);
	}
	/**
	 * 辐射工作人员培训情况界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="insert",method=RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		inserservice.queryAll(request);
		return "institutionspage/insertdata";
	}
	/**
	 * 删除录入信息 返回辐射工作人员培训情况界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="indel",method=RequestMethod.GET)
	public String indel(HttpServletRequest request, String type) {
		inserservice.indelete(request,type);
		return "institutionspage/insertdata";
	}
	/**
	 * 辐射工作人员修改界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="inupdate",method=RequestMethod.GET)
	public String inUpdate(HttpServletRequest request,String type) {
		inserservice.inPdate(request, type);
		return "institutionspage/inserupdate";
	}
	/**
	 * 修改员工辐射记录
	 * @param request
	 * @param inser
	 * @param response
	 */
	@RequestMapping(value="inpdaten",method=RequestMethod.POST)
	public void inPdate(HttpServletRequest request, Insertdata inser,HttpServletResponse response)  {
		inserservice.updatePost(request, inser, response);
	}
	/**
	 * 导出Excel
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="inexport",method=RequestMethod.GET)
	public void inexport(HttpServletRequest request,HttpServletResponse response) throws IOException {
		inserservice.downloadClastall(request, response);
	}
	/**
	 * 查询信息
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="inquery",method=RequestMethod.POST)
	public String inQuery(HttpServletRequest request,HttpServletResponse response,String inname) {
		inserservice.inQuery(request, response, inname);
		return "institutionspage/insertdatafuzzy";
	}
	/**
	 * 模糊查询
	 * @param request
	 * @param response
	 * @param inname
	 * @return
	 */
	@RequestMapping(value="inquery",method=RequestMethod.GET)
	public String inQueryget(HttpServletRequest request,HttpServletResponse response,String inname) {
		inserservice.inQuery(request, response, inname);
		return "institutionspage/insertdatafuzzy";
	}
}
