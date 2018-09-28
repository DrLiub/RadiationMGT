package com.cncompute.web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cncompute.pojo.Isotopes;
import com.cncompute.pojo.Radioactiveentry;
import com.cncompute.pojo.Sealentry;
import com.cncompute.service.IsotopesService;
/**
 * 放射源控制层
 * @author Admin
 *2018年9月7日10:22:12
 */
@Controller
public class IsotopesController {
	@Autowired
	private IsotopesService isotservice;
	/**
	 * 放射源显示-界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="isotopes",method=RequestMethod.GET)
	public String isotAll(HttpServletRequest request) {
		isotservice.queryIsot(request);
		return"parameterpage/isotopes";
	}
	/**
	 * 添加放射源-界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="isotadd",method=RequestMethod.GET)
	public String isotAdd(HttpServletRequest request) {
		return "parameterpage/isotopesadd";
	}
	/**
	 * 添加放射源
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="isotaddpost",method=RequestMethod.POST)
	public void isotPost(HttpServletRequest request,HttpServletResponse response,Isotopes isot) {
		isotservice.addIsot(request, response, isot);
	}
	/**
	 * 开放性同位素-界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="isopen",method=RequestMethod.GET)
	public String isOpen(HttpServletRequest request,String type) {
		isotservice.radioAll(request, type);
		return "parameterpage/radioactiveentryadd";
	}
	/**
	 * 开放性同位素-添加
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="radiaddpost",method=RequestMethod.POST)
	public void radiPost(HttpServletRequest request,HttpServletResponse response,String isid) {
		isotservice.radiAddpost(request, response, isid);
	}
	/**
	 * 开放性同位素-删除
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="isradidelete",method=RequestMethod.GET)
	public String isRadidelete(HttpServletRequest request,String type,String raid) {
		isotservice.radiDelice(request, type, raid);
		isotservice.isDetail(request, raid);
		return"parameterpage/isotopesall";
	}
	/**
	 * 开放性同位素-修改界面
	 * @param request
	 * @param type
	 * @param raid
	 * @return
	 */
	@RequestMapping(value="isradiup",method=RequestMethod.GET)
	public String isradiup(HttpServletRequest request,String type,String raid) {
		isotservice.sendRadi(request, type, raid);
		return"parameterpage/radioactiveentryupdate";
	}
	/**
	 * 开放性同位素-修改
	 * @param request
	 * @param response
	 * @param radi
	 */
	@RequestMapping(value="updateradi",method=RequestMethod.POST)
	public void updateRadi(HttpServletRequest request,HttpServletResponse response,Radioactiveentry radi) {
		isotservice.updateRadi(request, response, radi);
	}
	/**
	 * 密封源-界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="issource",method=RequestMethod.GET)
	public String addSeal(HttpServletRequest request,String type) {
		isotservice.radioAll(request, type);
		return "parameterpage/sealentryadd";
	}
	/**
	 * 密封源-添加
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="sealaddpost",method=RequestMethod.POST)
	public void sealPost(HttpServletRequest request,HttpServletResponse response,String isid) {
		isotservice.sealAdd(request, response, isid);
	}
	/**
	 * 密封源-删除
	 * @param request
	 * @param type
	 * @param seid
	 * @return
	 */
	@RequestMapping(value="issealdelete",method=RequestMethod.GET)
	public String sealDelete(HttpServletRequest request,String type,String seid) {
		isotservice.sealDel(request, type, seid);
		isotservice.isDetail(request, seid);
		return"parameterpage/isotopesall";
	}
	/**
	 * 密封源-修改界面
	 * @param request
	 * @param type
	 * @param seid
	 * @return
	 */
	@RequestMapping(value="issealup",method=RequestMethod.GET)
	public String updateSeal(HttpServletRequest request,String type,String seid) {
		isotservice.updateSeal(request, type, seid);
		return"parameterpage/sealentryupdate";
	}
	/**
	 * 密封源-修改
	 * @param request
	 * @param response
	 * @param seal
	 */
	@RequestMapping(value="issealup",method=RequestMethod.POST)
	public void upSeal(HttpServletRequest request,HttpServletResponse response,Sealentry seal) {
		isotservice.upSeal(request, response, seal);
	}
	/**
	 * 辅助决策界面
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="isauxiliary",method=RequestMethod.GET)
	public String isAuxiliary(HttpServletRequest request,String type) {
		isotservice.sendSafetysheet(request, type,"4","2");
		return"parameterpage/safetysheetf";
	}
	/**
	 * 添加-辅助决策
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="isotpost",method=RequestMethod.POST)
	public void isotpost(HttpServletRequest request,HttpServletResponse response,String isid,Isotopes isot) {
		isotservice.addSa(request, response, isid,isot);
	}
	/**
	 * 查看放射源详情
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="isdetails",method=RequestMethod.GET)
	public String isDetails(HttpServletRequest request,String type) {
		isotservice.isDetail(request, type);
		return"parameterpage/isotopesall";
	}
	/**
	 * 修改安全措施表
	 * @param request
	 * @param response
	 * @param isid
	 */
	@RequestMapping(value="isoupsafet",method=RequestMethod.POST)
	public void updateSafetysheet(HttpServletRequest request,HttpServletResponse response,String isid) {
		isotservice.file(request, response, isid);
	}
	/**
	 * 删除放射源
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="isodelete",method=RequestMethod.GET)
	public String isoDelete(HttpServletRequest request,String type) {
		isotservice.upIsot(request, type);
		isotservice.queryIsot(request);
		return"parameterpage/isotopes";
	}
	/**
	 * 修改放射源名称-界面
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="isotup",method=RequestMethod.GET)
	public String isotUp(HttpServletRequest request,String type) {
		isotservice.isotUpdate(request, type);
		return"parameterpage/isotopesupdate";
	}
	/**
	 * 修改放射源信息
	 * @param request
	 * @param isot
	 */
	@RequestMapping(value="isoupdatename",method=RequestMethod.POST)
	public void isoUpdatename(HttpServletResponse response,HttpServletRequest request,Isotopes isot) {
		isotservice.isoname(response,request, isot);
	}
	/**
	 * 放射源模糊查询
	 * @param request
	 * @param name
	 * @return
	 */
	@RequestMapping(value="isotfuzzy",method=RequestMethod.GET)
	public String isotfuzzy(HttpServletRequest request,String name) {
		isotservice.fuzzyIs(request, name);
		return"parameterpage/isotopesfuzzy";
	}
}
