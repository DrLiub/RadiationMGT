package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 非密封放射性物质表控制层
 * @author Admin
 * 2018年9月10日14:36:31
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cncompute.pojo.Nonseal;
import com.cncompute.service.NonsealService;
@Controller
public class NonsealController {
	@Autowired
	private NonsealService nonservice;
	/**
	 * 非密封放射性物质显示界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="nonseal",method=RequestMethod.GET)
	public String nonsAll(HttpServletRequest request) {
		nonservice.nonsealAll(request);
		return"parameterpage/nonseal";
	}
	/**
	 * 添加非密封放射性物质界面
	 * @param request
	 */
	@RequestMapping(value="nonsadd",method=RequestMethod.GET)
	public String nonsAdd(HttpServletRequest request) {
		return"parameterpage/nonsealadd";
	}
	/**
	 * 添加非密封放射性物质
	 * @param request
	 * @param nons
	 */
	@RequestMapping(value="nonsaddpost",method=RequestMethod.POST)
	public void nonsealAdd(HttpServletResponse response,HttpServletRequest request,Nonseal nons) {
		nonservice.nonsAdd(response, request, nons);
	}
	/**
	 * 删除非密封放射性物质
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="nonsdelete",method=RequestMethod.GET)
	public String qudateNons(HttpServletRequest request,String type) {
		nonservice.nonsDelete(request, type);
		nonservice.nonsealAll(request);
		return "parameterpage/nonseal";
	}
	/**
	 * 修改非密封放射性物质界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="nonsup",method=RequestMethod.GET)
	public String nonsUp(HttpServletRequest request,String type) {
		nonservice.sendNons(request, type);
		return"parameterpage/nonsealqudate";
	}
	/**
	 * 修改非密封放射性物质
	 * @param request
	 * @param response
	 * @param nons
	 */
	@RequestMapping(value="noupdate",method=RequestMethod.POST)
	public void qudateNonspost(HttpServletRequest request,HttpServletResponse response,Nonseal nons) {
		nonservice.updateNons(request, response, nons);
	}
	/**
	 * 非密封放射性物质添加界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="noopen",method=RequestMethod.GET)
	public String addRoomnuclide(HttpServletRequest request,String type) {
		nonservice.sendContent(request, type);
		return"parameterpage/roomnuclideadd";
	}
	/**
	 * 非密封放射性物质添加
	 * @param request
	 * @param response
	 * @param noid
	 * @param robuiding
	 * @param rofloor
	 * @param roroomid
	 * @param rolevel
	 */
	@RequestMapping(value="noroomaddpost",method=RequestMethod.POST)
	public void roomAdd(HttpServletRequest request,HttpServletResponse response,String noid,String nobuiding,String nofloor,String noroomid,String nolevel) {
		nonservice.roomnuAdd(request, response, noid, nobuiding, nofloor, noroomid, nolevel);
	}
	/**
	 * 辅助决策界面
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="noauxiliary",method=RequestMethod.GET)
	public String noAuxiliary(HttpServletRequest request,String type) {
		nonservice.sendSafetysheet(request, type,"4");
		return"parameterpage/safetysheets";
	}
	/**
	 * 添加-辅助决策
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="nosnpost",method=RequestMethod.POST)
	public void notpost(HttpServletRequest request,HttpServletResponse response,String noid) {
		nonservice.addSa(request, response, noid);
	}
	/**
	 * 查看非密封性放射性物质详情
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="nodetails",method=RequestMethod.GET)
	public String isDetails(HttpServletRequest request,String type) {
		nonservice.isDetail(request, type);
		return"parameterpage/roomnuclideall";
	}
	/**
	 * 修改安全措施表
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="nooupsafet",method=RequestMethod.POST)
	public void updateSafetysheet(HttpServletRequest request,HttpServletResponse response,String noid) {
		nonservice.file(request, response, noid);
	}
}
