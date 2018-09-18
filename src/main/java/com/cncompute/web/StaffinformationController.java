package com.cncompute.web;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cncompute.service.StaffinformationService;

/**
 * 辐射员工表的控制层
 * @author 劉
 *2018年8月9日14:39:52
 */
@Controller
public class StaffinformationController {
	@Autowired
	private StaffinformationService staffservice;
//	@Autowired
//	private Methods methods;
	/**
	 * 辐射工作人员显示界面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="staff",method=RequestMethod.GET)
	public String staff(HttpServletRequest request)  {
//		String userid=methods.getUser(request);
//		if("".equals(userid)||userid==null) {
//			return "login";
//		}
		staffservice.sendStaff(request);
	    return "institutionspage/staffpeople";
	}
	/**
	 * 辐射工作人员添加界面
	 * @param request
	 * @param response
	 * @return  
	 */
	@RequestMapping(value="addstaff",method=RequestMethod.GET)
	public String addstaf(HttpServletRequest request)  {
		staffservice.send(request);
	    return "institutionspage/addstaffpeople";
	}
	/**
	 * 插入新工作人员并向页面发生数据
	 * @param request
	 * @return 
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="stadd",method=RequestMethod.POST)
	public void addst(HttpServletRequest request,HttpServletResponse response) throws ParseException  {
		staffservice.addStaff(request,response);
	}
	/**
	 * 删除工作人员信息人员信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="stdelete",method=RequestMethod.GET)
	public String stdelete(HttpServletRequest request) {
		staffservice.staffDelete(request);
		return "institutionspage/staffpeople";
	}
	/**
	 * 修改工作人员信息界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="stupdate",method=RequestMethod.GET)
	public String stupdate(HttpServletRequest request) {
		staffservice.queryStnumber(request);
		return "institutionspage/staffupdate";
	}
	/**
	 * 修改工作人员信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="stupdate",method=RequestMethod.POST)
	public void stupdatePost(HttpServletRequest request,HttpServletResponse response) {
		staffservice.staffUpdate(request,response);
	}
	/**
	 * 辐射工作人员培训情况界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="sttraining",method=RequestMethod.GET)
	public String stTraining(HttpServletRequest request) {
		staffservice.staffAll(request);
		return "institutionspage/stalltraining";
	}
	/**
	 * 删除辐射工作人员
	 * @return
	 */
	@RequestMapping(value="stdel",method=RequestMethod.GET)
	public String stdelete(HttpServletRequest request,String type) {
		staffservice.stdel(request,type);
		return "institutionspage/stalltraining";
	}
	/**
	 * 导出Excel(工作人员)
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="stexport",method=RequestMethod.GET)
	public void export(HttpServletRequest request,HttpServletResponse response,String type) throws IOException {
		staffservice.export(request, response, type);
	}
	/**
	 * 导出Excel辐射工作人员培训情况全部
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="ststaff",method=RequestMethod.GET)
	public void ststaff(HttpServletRequest request,HttpServletResponse response) throws IOException {
		staffservice.downloadClastall(request, response);
	}
}
