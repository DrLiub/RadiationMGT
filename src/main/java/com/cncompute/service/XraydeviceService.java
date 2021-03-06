package com.cncompute.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.SafetysheetDao;
import com.cncompute.dao.XraydeviceDao;
import com.cncompute.pojo.*;
import com.cncompute.pojo.Xaccelerator;
import com.cncompute.pojo.Xauxiliary;
import com.cncompute.pojo.Xneutron;
import com.cncompute.pojo.Xraydevice;
import com.cncompute.pojo.Xraymachine;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * 射线装备Service层
 * @author Admin
 *2018年8月30日17:01:41
 */
@Service
@Transactional
public class XraydeviceService {
	@Autowired
	private XraydeviceDao raydevicedao;
	@Autowired
	private SafetysheetDao SafetDao;
	@Autowired
	private Methods methods;
	/**
	 * 查询射线装置表全部信息发送给射线装置显示页面
	 * @param request
	 */
	public void reydsAll(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Xraydevice>rayall=raydevicedao.raydAll();
			index=(rayall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Xraydevice> rayall=raydevicedao.raydAll();
		
		for(int i=0;i<rayall.size();i++){
				rayall.get(i).setPageNumber((i+1)+((index-1)*13));
		}
		//(1加速器)(2X射线机)(3中子发生器)
		for (Xraydevice xray : rayall) {
			if(xray.getRadevice().equals("1")) {
				xray.setRadevice("加速器");
			}else if(xray.getRadevice().equals("2")){
				xray.setRadevice("X射线机");
			}else if(xray.getRadevice().equals("3")){
				xray.setRadevice("中子发生器");
			}
		}
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("raydall",rayall);
	}
	/**
	 * 添加射线装置
	 * @param request
	 * @param response
	 */
	public void addName(HttpServletRequest request,HttpServletResponse response,Xraydevice rayd) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if("".equals(rayd.getRaname())||rayd.getRaname()==null) {
			pw.print("2");//名称不能为空
			return;
		}
	    String id=Methods.getUUID();
	    rayd.setRaid(id);
	    rayd.setRauserid(methods.getUser(request));
//	    raydevicedao.addRaydevice(rayd);//添加射线装置
//	    raydevicedao.addAccelerator(id);//射线装置-加速器
//	    raydevicedao.addNeutron(id);//射线装置-中子发生器
//	    raydevicedao.addRaymachine(id);//(射线装置-X射线机)
	    pw.print("1");
	}
	/**
	 * 向界面发送(射线装置表)raid
	 * @param requets
	 * @param raid
	 */
	public void sendID(HttpServletRequest request,String raid) {
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(raid);
		request.setAttribute("raydid", rayd);
	}
	/**
	 * 通过ID查询(射线装置-加速器)全部信息，发送给界面
	 * @param request
	 * @param raid
	 */
	public void insertXaccelerator(HttpServletRequest request,String raid) {
		Xraydevice rayd= raydevicedao.acceleratorId(raid);
		request.setAttribute("rayd", rayd);
		sendID(request ,raid);
	}
	/**
	 * 录入(射线装置-加速器)信息
	 * @param request
	 * @param response
	 * @param raid
	 * @param acce
	 */
	public void acceleratorAdd(HttpServletRequest request,HttpServletResponse response,Xaccelerator acce) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String id=Methods.getUUID();
		acce.setAcid(id);
		acce.setAcuserid(methods.getUser(request));
		acce.setActime(methods.getTime());
		acce.setAcstate(1);
		raydevicedao.addAccelerator(acce);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(id);// 表ID
		rayd.setRaname(acce.getAcmodel());// 名称型号
		rayd.setRadevice("1");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(acce.getAcmanufacturer());//生产厂家
		rayd.setRainput(acce.getAcusetime());//投入使用时间
		rayd.setRabuilding(acce.getAcbuilding());//楼宇
		rayd.setRaroom(acce.getAcroom());//房间信息
		rayd.setRause(acce.getAcuse());//用途
		rayd.setRanote(acce.getAcnote());//备注
		raydevicedao.addRaydevice(rayd);
		pw.print("1");
	}
	/**
	 * 查询(x射线装置)
	 * @param request
	 * @param type
	 */
	public void queryRaym(HttpServletRequest request, String type) {
		Xraydevice rayd=raydevicedao.queryRayma(type);
		request.setAttribute("rayd", rayd);
		sendID(request ,type);
	}
	/**
	 * 录入(x射线装置)
	 * @param request
	 * @param response
	 * @param raid
	 * @param raym
	 */
	public void raymAdd(HttpServletRequest request,HttpServletResponse response,Xraymachine raym) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String id=Methods.getUUID();
		raym.setRaid(id);
		raym.setRanumber(Methods.getUUID());
		raym.setRatime(methods.getTime());
		raym.setRauserid(methods.getUser(request));
		raym.setRastate(1);
		raydevicedao.addRaymachine(raym);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(id);// 表ID
		rayd.setRaname(raym.getRaname());// 名称型号
		rayd.setRadevice("2");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(raym.getRamodel());//生产厂家
		rayd.setRainput(raym.getRainputtime());//投入使用时间
		rayd.setRabuilding(raym.getRabuilding());//楼宇
		rayd.setRaroom(raym.getRaroom());//房间信息
		rayd.setRause(raym.getRause());//用途
		rayd.setRanote(raym.getRanote());//备注
		raydevicedao.addRaydevice(rayd);
		pw.print("1");
	}
	/**
	 * 查询(中子发生器)
	 * @param request
	 * @param type
	 */
	public void queryNeut(HttpServletRequest request,String type) {
		Xraydevice rayd=raydevicedao.queryNeut(type);
		request.setAttribute("rayd", rayd);
		sendID(request ,type);
	}
	/**
	 * 录入(中子发生器)
	 * @param request
	 * @param response
	 * @param raid
	 * @param raym
	 */
	public void neutAdd(HttpServletRequest request,HttpServletResponse response,Xneutron neut) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String id=Methods.getUUID();
		neut.setNeid(id);
		neut.setNeswauserid(methods.getUser(request));
		neut.setNetime(methods.getTime());
		neut.setNestate(1);
		raydevicedao.addNeutron(neut);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(id);// 表ID
		rayd.setRaname(neut.getNemodel());// 名称型号
		rayd.setRadevice("3");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(neut.getNemanufacturer());//生产厂家
		rayd.setRainput(neut.getNeswainput());//投入使用时间
		rayd.setRabuilding(neut.getNebuikding());//楼宇
		rayd.setRaroom(neut.getNeroom());//房间信息
		rayd.setRause(neut.getNeuse());//用途
		rayd.setRanote(neut.getNenote());//备注
		raydevicedao.addRaydevice(rayd);
		pw.print("1");
	}
	/**
	 * 查询全部射线装置信息发送给页面
	 * @param request
	 * @param type
	 */
	public void deviceAll(HttpServletRequest request,String type) {
		Xraydevice rayd=raydevicedao.queryAll(type);
		//通过ID查询射线装置表(xraydevice)
		if(rayd.getRapermit()!=null&&rayd.getRapermit()==1) {
			//辐射安全许可证已选取
			rayd.setRapermitbox("checked");
		} 
		if(rayd.getRaassessmen()!=null&&rayd.getRaassessmen()==1) {
			//环境影响评价批复已选取
			rayd.setRaassessmenbox("checked");
		}
		if(rayd.getRacompletion()!=null&&rayd.getRacompletion()==1) {
			//环保竣工验收批复已选取
			rayd.setRacompletionbox("checked");
		}
		List<Xraydevice> raidall= raydevicedao.queryRaidauxi(type);
		request.setAttribute("auxiall", raidall);
		request.setAttribute("rayd", rayd);
		sendID(request,type);
	}
	/**
	 * 射线装置-添加安全措施表
	 * @param request
	 * @param type
	 */
	public void sendSafetysheet(HttpServletRequest request,String type,String num1,String num2) {
		List<Xraydevice> raidall= raydevicedao.queryRaidauxi(type);

		List<Safetysheet>safetAll1= SafetDao.queryRay(Integer.parseInt(num1));
		for (Xraydevice xray : raidall) {
			for (Safetysheet sa : safetAll1) {
				//判断是否有已选取安全措施表
				if(xray.getXauxiliary().getAucategory().equals(num1) && xray.getXauxiliary().getAunumber().equals(sa.getSaname())) {//已选取
					sa.setSastate("checked");
				}
			}
		}
		List<Safetysheet>safetAll2= SafetDao.queryRay(Integer.parseInt(num2));
		for (Xraydevice xray : raidall) {
			for (Safetysheet sa : safetAll2) {
				//判断是否有已选取安全措施表
				if(xray.getXauxiliary().getAucategory().equals(num2) && xray.getXauxiliary().getAunumber().equals(sa.getSaname())) {//已选取
					sa.setSastate("checked");
				}
			}
		}
		request.setAttribute("safetAll1", safetAll1);
		request.setAttribute("safetAll2", safetAll2);
		sendID(request,type);
		//通过ID查询射线装置表(xraydevice)
		Xraydevice rayd= raydevicedao.raydID(type);
		if(rayd.getRapermit()!=null&&rayd.getRapermit()==1) {
			//辐射安全许可证已选取
			rayd.setRapermitbox("checked");
		} 
		if(rayd.getRaassessmen()!=null&&rayd.getRaassessmen()==1) {
			//环境影响评价批复已选取
			rayd.setRaassessmenbox("checked");
		}
		if(rayd.getRacompletion()!=null&&rayd.getRacompletion()==1) {
			//环保竣工验收批复已选取
			rayd.setRacompletionbox("checked");
		}
		request.setAttribute("rayd", rayd);
	}
	/**
	 * 添加安全措施表(bug)
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void addSafet(HttpServletRequest request,HttpServletResponse response,String raid,Xraydevice rayd) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String[] num1=request.getParameterValues("num1");
		List<Xraydevice> raidall= raydevicedao.queryRaidauxi(raid);
		int index=0;
		int num=0;
		String auserial=null;
		try {
			for (Xraydevice xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
				for (String string : num1) {
					//判断数据库存储的和页面新添加的是否有相同数据
					if(xraydevice.getXauxiliary().getAunumber().equals(string)) {//存在
						num=1;
					}
				}
				if(num==0) {
					//删除数据库中页面没有选中的数据
					auserial=xraydevice.getXauxiliary().getAuserial();
					Xauxiliary au=new Xauxiliary();
					au.setAuserial(auserial);
					au.setAuexisting(0);
					raydevicedao.qudatAuxi(au);
				}else {
					num=0;
				}
			}
			for (String string : num1) {
				for (Xraydevice xraydevice : raidall) {
					//判断页面选中表数据库中是否存在
					if(string.equals(xraydevice.getXauxiliary().getAunumber())) {//已存在
						index=1;
					}
				}
				if(index==0) {
					//数据库中不存在就新建添加数据
					Xauxiliary auxi=new Xauxiliary();
					auxi.setAuid(raid);
					auxi.setAuserial(Methods.getUUID());
					auxi.setAunumber(string);
					Safetysheet safet= SafetDao.queryAuid(string);
					auxi.setAucategory(safet.getSaattribute());
					auxi.setAusecurity(safet.getSapage());
					auxi.setAuname(safet.getSanameof());
					raydevicedao.addAuxiliary(auxi);
				}else {
					index=0;
				}
			}
		} catch (Exception e) {
			//如果没写选择任何安全措施，删除所有的安全措施表
			for (Xraydevice xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
					auserial=xraydevice.getXauxiliary().getAuserial();
					Xauxiliary au=new Xauxiliary();
					au.setAuserial(auserial);
					au.setAuexisting(0);
					raydevicedao.qudatAuxi(au);
			}
		}
		pw.print("1");
		
		//添加是否已有“辐射安全许可证”、“环境影响评价批复”、“环保竣工验收批复”。
		if(rayd.getRapermit()==null) {
			//辐射安全许可证未选取
			rayd.setRapermit(0);
		} 
		if(rayd.getRaassessmen()==null) {
			//环境影响评价批复未选取
			rayd.setRaassessmen(0);
		}
		if(rayd.getRacompletion()==null) {
			//环保竣工验收批复未选取
			rayd.setRacompletion(0);
		}
		raydevicedao.updateRayd(rayd);
	}
	/**
	 * 修改辐射安全措施
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void file(HttpServletRequest request,HttpServletResponse response ,String raid) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Xraydevice> raidall= raydevicedao.queryRaidauxi(raid);//查询安全措施表全部信息
		for (Xraydevice xra : raidall) {
			String page=xra.getXauxiliary().getAuserial();//安全措施表编号
			List<Object> list1 = methods.handleFileUpload(request, page, "D://aim//");
			for (Object object : list1) {
				Xauxiliary au=new Xauxiliary();
				au.setAuserial(page);
				au.setAusecurity((String)object);
				raydevicedao.qudatAuxi(au);
			}
		}
		pw.print("1");
	}
	/**
	 * 删除射线装置
	 * @param requets
	 * @param type
	 */
	public void xrayDel(HttpServletRequest requets,String type) {
		Xraydevice rayd =new Xraydevice();
		rayd.setRaid(type);
		rayd.setRastate(0);
		raydevicedao.updateRayd(rayd);
	}
	/**
	 * 向修改射线装置表界面
	 * @param request
	 * @param type
	 */
	public void raydUp(HttpServletRequest request,String type,String radevice) {
		if(radevice.equals("加速器")) {
			Xraydevice rade=raydevicedao.acceleratorId(type);
			request.setAttribute("rayd", rade);
		}else if(radevice.equals("X射线机")) {
			Xraydevice rade=raydevicedao.queryRayma(type);
			request.setAttribute("rayd", rade);
		}else if(radevice.equals("中子发生器")) {
			Xraydevice rade=raydevicedao.queryNeut(type);
			request.setAttribute("rayd", rade);
		}
	}
	/**
	 * 修改射线装置
	 * @param request
	 * @param response
	 * @param rayd
	 */
	public void xraUpdate(HttpServletRequest request,HttpServletResponse response,Xraydevice rayd) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		raydevicedao.updateRayd(rayd);
		pw.print("1");
	}
	/**
	 * 射线装置模糊查询
	 * @param request
	 * @param name
	 */
	public void rayFuzzy(HttpServletRequest request,String name) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Xraydevice>rayall= raydevicedao.fuzzyRayd(name);
			index=(rayall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Xraydevice>rayall= raydevicedao.fuzzyRayd(name);
		for(int i=0;i<rayall.size();i++){
			rayall.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		//(1加速器)(2X射线机)(3中子发生器)
		for (Xraydevice xray : rayall) {
			if(xray.getRadevice().equals("1")) {
				xray.setRadevice("加速器");
			}else if(xray.getRadevice().equals("2")){
				xray.setRadevice("X射线机");
			}else if(xray.getRadevice().equals("3")){
				xray.setRadevice("中子发生器");
			}
		}
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("raydall",rayall);
		request.setAttribute("name", name);
	}
	/**
	 * 修改加速器信息
	 * @param request
	 * @param response
	 * @param acce
	 */
	public void uodateacce(HttpServletRequest request,HttpServletResponse response,Xaccelerator acce) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		raydevicedao.insertAccel(acce);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(acce.getAcid());// 表ID
		rayd.setRaname(acce.getAcmodel());// 名称型号
		rayd.setRadevice("1");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(acce.getAcmanufacturer());//生产厂家
		rayd.setRainput(acce.getAcusetime());//投入使用时间
		rayd.setRabuilding(acce.getAcbuilding());//楼宇
		rayd.setRaroom(acce.getAcroom());//房间信息
		rayd.setRause(acce.getAcuse());//用途
		rayd.setRanote(acce.getAcnote());//备注
		raydevicedao.updateRayd(rayd);
		pw.print("1");
	}
	/**
	 * 修改(X射线机)信息
	 * @param request
	 * @param response
	 * @param raym
	 */
	public void updateRaym(HttpServletRequest request,HttpServletResponse response,Xraymachine raym) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		raydevicedao.insertRayma(raym);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(raym.getRaid());// 表ID
		rayd.setRaname(raym.getRaname());// 名称型号
		rayd.setRadevice("2");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(raym.getRamodel());//生产厂家
		rayd.setRainput(raym.getRainputtime());//投入使用时间
		rayd.setRabuilding(raym.getRabuilding());//楼宇
		rayd.setRaroom(raym.getRaroom());//房间信息
		rayd.setRause(raym.getRause());//用途
		rayd.setRanote(raym.getRanote());//备注
		raydevicedao.updateRayd(rayd);
		pw.print("1");
	}
	/**
	 * 修改(中子发生器)信息
	 * @param request
	 * @param response
	 * @param raym
	 */
	public void uodateXneut(HttpServletRequest request,HttpServletResponse response,Xneutron neut) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		raydevicedao.insertNeut(neut);
		//向射线装置表添加数据
		Xraydevice rayd=new Xraydevice();
		rayd.setRaid(neut.getNeid());// 表ID
		rayd.setRaname(neut.getNemodel());// 名称型号
		rayd.setRadevice("3");//射线装置(1加速器)(2X射线机)(3中子发生器)
		rayd.setRamanufacturer(neut.getNemanufacturer());//生产厂家
		rayd.setRainput(neut.getNeswainput());//投入使用时间
		rayd.setRabuilding(neut.getNebuikding());//楼宇
		rayd.setRaroom(neut.getNeroom());//房间信息
		rayd.setRause(neut.getNeuse());//用途
		rayd.setRanote(neut.getNenote());//备注
		raydevicedao.updateRayd(rayd);
		pw.print("1");
	}
}
