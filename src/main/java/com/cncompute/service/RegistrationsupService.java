package com.cncompute.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.*;
import com.cncompute.pojo.*;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 监测设备、报警仪器和辐射防护用品登记表service层
 * @author Admin 
 * 2018年8月20日10:42:00
 */
@Service
@Transactional
public class RegistrationsupService {
	@Autowired
	private RegistrationsupDao regDao;
	@Autowired
	private Methods methods;

	/**
	 * 根据retable查询发送给显示页面
	 *  1：辐射环境监测设备2：辐射环境安全报警仪器3：辐射防护用品
	 * @param request
	 * @param retable
	 */
	public void reQuery(HttpServletRequest request, Integer retable) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Registrationsup> reg = regDao.reQuery(retable);
			index=(reg.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Registrationsup> reg = regDao.reQuery(retable);
		for(int i=0;i<reg.size();i++){
			reg.get(i).setPageNumber((i+1)+((index-1)*each));
     	}
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		sendRetable(request, retable);
		request.setAttribute("reg", reg);
	}

	/**
	 * 向页面发送retable分辨是哪种器材
	 * 
	 * @param retable
	 */
	public void sendRetable(HttpServletRequest request, Integer retable) {
		Registrationsup regi = new Registrationsup();
		regi.setRetable(retable);
		request.setAttribute("regi", regi);
	}

	/**
	 * 添加仪器
	 *  1：辐射环境监测设备2：辐射环境安全报警仪器3：辐射防护用品
	 * @param request
	 * @param retable
	 */
	public void addReg(HttpServletRequest request,HttpServletResponse response, Integer retable) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []renameof=request.getParameterValues("renameof");;// 仪器名称
		String []remodel=request.getParameterValues("remodel");// 型号
		String []rebuytime=request.getParameterValues("rebuytime");// 购置日期
		String []reitemssatte=request.getParameterValues("reitemssatte");// 状态
		String []renum=request.getParameterValues("renum");// 数量
		String []rebrand=request.getParameterValues("rebrand");;// 品牌
		String []relocation=request.getParameterValues("relocation");;// 位置信息
		String []rehead=request.getParameterValues("rehead");;// 管理责任人
		for (int i=0;i<renameof.length;i++) {
			String reid="jh"+Methods.getUUID();// 表ID
			Registrationsup reg=new Registrationsup();
			reg.setReid(reid);
			reg.setRetable(retable);
			reg.setRenameof(renameof[i]);
			reg.setRemodel(remodel[i]);
			if("".equals(rebuytime[i])||rebuytime[i]==null) {
				pw.print("3");
				return;
			}
			reg.setRebuytime(rebuytime[i]);
			reg.setReitemssatte(reitemssatte[i]);
			if(!methods.isNumeric(renum[i])||"".equals(renum[i])||renum[i]==null) {
				pw.print("2");
				return;
			}
			reg.setRenum(renum[i]);
			reg.setRebrand(rebrand[i]);
			reg.setRelocation(relocation[i]);
			reg.setRehead(rehead[i]);
			reg.setReuserid(methods.getUser(request));
			reg.setRestate(1);// 状态：0删除1正常
			regDao.reInsert(reg);
		}
		pw.print("1");
	}
	/**
	 * 删除监测设备、报警仪器和辐射防护用品登记表信息
	 * @param request
	 * @param retable
	 * @param reid
	 */
	public void reDelete(HttpServletRequest request,Integer retable,String reid) {
		regDao.reDelete(reid);
		reQuery(request,retable);
	}
	/**
	 * 向修改监测设备、报警仪器和辐射防护用品登记表界面发送信息
	 * @param request
	 * @param retable
	 * @param reid
	 */
	public void reReid(HttpServletRequest request,String reid) {
		Registrationsup reg=regDao.reReid(reid);
		request.setAttribute("reg", reg);
	}
	/**
	 * 修改数据方法
	 * @param request
	 * @param reg
	 */
	public void updatePost(HttpServletRequest request,Registrationsup reg,HttpServletResponse response) {
		regDao.reUpdate(reg);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("1");
	}
	/**
	 * 导出
	 * @param request
	 * @param response
	 * @param retable
	 * @throws IOException 
	 */
	public void export(HttpServletRequest request,HttpServletResponse response,Integer retable) throws IOException {
		List<Registrationsup> reg = regDao.reQuery(retable);
		methods.downloadAllClassmate(response, reg);
	}
	/**
	 * 模糊查询
	 * @param request
	 * @param name
	 */
	public void fuzzy(HttpServletRequest request,String name,Integer retable) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Registrationsup> reg= regDao.fuzzyQueryre(name,retable);
			index=(reg.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Registrationsup> reg= regDao.fuzzyQueryre(name,retable);
		for(int i=0;i<reg.size();i++){
			reg.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("reg", reg);
		request.setAttribute("name", name);
		request.setAttribute("retable", retable);
		sendRetable(request, retable);
	}
}
