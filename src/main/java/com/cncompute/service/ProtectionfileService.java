package com.cncompute.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cncompute.dao.ProtectionfileDao;
import com.cncompute.pojo.Completionreply;
import com.cncompute.pojo.Environmental;
import com.cncompute.pojo.License;
import com.cncompute.pojo.Protectionfile;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * 环保手续文件Service层
 * @author Admin
 *2018年8月24日10:10:29
 */
@Service
@Transactional
public class ProtectionfileService {
	@Autowired
	private ProtectionfileDao proDao;
	@Autowired
	private Methods methods;
	/**
	 * 查询所有环保手续文件信息，发送给环保手续显示页面
	 * @param Request
	 */
	public void proall(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Protectionfile> proall= proDao.prall();
			index=(proall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Protectionfile> proall= proDao.prall();
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("proall", proall);
	}
	/**
	 * 向界面发送prid
	 * @param request
	 * @param prid
	 */
	public void sendPrid(HttpServletRequest request, String prid) {
		Protectionfile pro=new Protectionfile();
		pro.setPrid(prid);
		request.setAttribute("pro",pro);
	}
	/**
	 * 添加环保手续文件
	 * @param request
	 * @param response
	 * @param pro
	 */
	public void addProte(HttpServletRequest request,HttpServletResponse response,Protectionfile pro) {
		PrintWriter pw=null;
		try {
			 pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String id=Methods.getUUID();
		pro.setPrid(id);
		pro.setPruserid(methods.getUser(request));
		pro.setPrstate(1);// 表状态
		proDao.pradd(pro);
		proDao.liceadd(id);
		proDao.compadd(id);
		proDao.enviadd(id);
		pw.print("1");
	}
	/**
	 * 向许可证界面发送prid和License表内容
	 * @param request
	 * @param prid
	 */
	public void prlic(HttpServletRequest request,String prid) {
		sendPrid(request,prid);
		Protectionfile pro= proDao.liQuery(prid);
		request.setAttribute("lice", pro);
	}
	/**
	 * 修改保存许可证(License)表内容
	 * @param request
	 * @param response
	 * @param lice
	 * @param prid
	 */
	public void prlicPost(HttpServletRequest request,HttpServletResponse response,License lice,String prid, MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String page=methods.fileUpload(request,file);
		if(!page.equals("文件为空")) {
			lice.setLicertificateid(page);
		}
		lice.setLiid(prid);
		proDao.updateLice(lice);
		pw.print("1");
	}
	/**
	 * 向环境影响评价文件批复界面发送信息
	 * @param request
	 * @param type
	 */
	public void prenv(HttpServletRequest request,String enid) {
		sendPrid(request,enid);
		Protectionfile envi= proDao.enQuery(enid);
		request.setAttribute("envi", envi);
	}
	/**
	 * 修改环境影响评价文件批复内容
	 * @param request
	 * @param response
	 * @param envi
	 * @param prid
	 * @param file
	 */
	public void prenvPost(HttpServletRequest request,HttpServletResponse response,Environmental envi,String prid,MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String page=methods.fileUpload(request,file);
		if(!page.equals("文件为空")) {
			envi.setEnelectronic(page);
		}
		envi.setEnid(prid);
		proDao.updateEnvi(envi);
		pw.print("1");
	}
	/**
	 * 向环保竣工验收监测文件批复界面发送信息
	 * @param request
	 * @param enid
	 */
	public void prcom(HttpServletRequest request,String enid) {
		sendPrid(request,enid);
		Protectionfile comp= proDao.coQuery(enid);
		request.setAttribute("comp", comp);
	}
	/**
	 * 修改环保竣工验收监测文件批复
	 * @param request
	 * @param response
	 * @param comp
	 * @param prid
	 * @param file
	 */
	public void prcomPost(HttpServletRequest request,HttpServletResponse response,Completionreply comp,String prid,MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String page=methods.fileUpload(request,file);
		if(!page.equals("文件为空")) {
			comp.setCoelectronic(page);
		}
		comp.setCoid(prid);
		proDao.updateComp(comp);
		pw.print("1");
	}
	/**
	 * 查询环保手续文件全部信息发送给显示页面
	 * @param request
	 * @param prid
	 */
	public void prall(HttpServletRequest request,String prid) {
		Protectionfile prall= proDao.queryAll(prid);
		request.setAttribute("prall", prall);
	}
	/**
	 *  删除环保手续文件
	 * @param request
	 * @param type
	 */
	public void prDelete(HttpServletRequest request ,String type) {
		Protectionfile prot=new Protectionfile();
		prot.setPrid(type);
		prot.setPrstate(0);
		proDao.updateProt(prot);
		proall(request);
	}
	/**
	 * 向修改环保手续文件界面发送信息
	 * @param request
	 * @param type
	 */
	public void prUpdate(HttpServletRequest request ,String type) {
		Protectionfile pro=proDao.prIdall(type);
		request.setAttribute("pro",pro);
	}
	/**
	 * 修改环保手续文件
	 * @param request
	 * @param response
	 * @param prot
	 */
	public void prUpdatepost(HttpServletRequest request,HttpServletResponse response,Protectionfile prot) {
		PrintWriter pw=null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proDao.updateProt(prot);
		pw.print("1");
	}
	/**
	 * 环保手续文件模糊查询
	 * @param request
	 * @param name
	 */
	public void fuzzyProte(HttpServletRequest request,String name) {
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Protectionfile> proall= proDao.fuzzyProt(name);
			index=(proall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Protectionfile> proall= proDao.fuzzyProt(name);
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("proall", proall);
		request.setAttribute("name", name);
	}
}
