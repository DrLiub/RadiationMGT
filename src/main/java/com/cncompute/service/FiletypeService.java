package com.cncompute.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.cncompute.dao.FiletypeDao;
import com.cncompute.pojo.Filetype;
import com.cncompute.pojo.Unitsystem;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * 单位辐射安全规章制度模块 
 * 文件类别Service层
 * @author Admin
 *2018年8月28日14:39:42
 */
@Service
@Transactional
public class FiletypeService {
	@Autowired
	private FiletypeDao fileDao;
	@Autowired
	private Methods methods;
	/**
	 * 发送信息给单位辐射安全规章制度显示界面
	 * @param request
	 */
	public void fileAll(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Filetype> file =fileDao.fileAll();
			index=(file.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Filetype> file =fileDao.fileAll();
		methods.sendPage(page, pag, starting, end, index, request, jnum);
	    request.setAttribute("fileall", file);
	}
	/**
	 * 查询全部未创建的文件名称发送给添加界面
	 * @param request
	 */
	public void flnameAll(HttpServletRequest request) {
		List<Filetype> filey=fileDao.flnameALL();
		request.setAttribute("finame", filey);
	}
	/**
	 * 添加环保手续文件访问数据库
	 * @param request
	 * @param response
	 * @param flname1
	 * @param flname2
	 */
	public void fileAddpost(HttpServletRequest request,HttpServletResponse response,String flname1,String flname2) {
		Filetype file=new Filetype();
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(flname1.equals("选择文件类别")&&!(flname2==null||"".equals(flname2))) {
			//自定义单位辐射安全规章制度1
			 file.setFlid(Methods.getUUID());
			 file.setFlname(flname2);
			 file.setFluserid(methods.getUser(request));
			 file.setFltime(methods.getTime());
			 fileDao.addFile(file);
			pw.print("1");
		}else if(!flname1.equals("选择文件类别")&&(flname2==null||"".equals(flname2))) {
			//用数据库存储好的2
			 file.setFlid(Methods.getUUID());
			 file.setFlname(flname1);
			 file.setFluserid(methods.getUser(request));
			 file.setFltime(methods.getTime());
			 file.setFlstate(1);
			 file.setFithere(1);
			 fileDao.updateName(file);
			 pw.print("2");
		}else if(flname1.equals("选择文件类别")&&(flname2==null||"".equals(flname2))) {
			//没有选择任何情况3
			pw.print("3");
		}else {
			//两个都选择了4
			pw.print("4");
		}
	}
	/**
	 * 通过ID删除规章制度
	 * @param request
	 * @param flid
	 */
	public void deleteFile(HttpServletRequest request,String flid) {
		Filetype file=new Filetype();
		file.setFlid(flid);
		file.setFithere(0);
		file.setFlstate(0);
		fileDao.updateId(file);
	}
	/**
	 * 通过ID查询规章制度全部信息，发送给界面
	 * @param request
	 * @param flid
	 */
	public void viewFile(HttpServletRequest request,String flid) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Filetype>fileall= fileDao.fileIdall(flid);
			index=(fileall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Filetype>fileall= fileDao.fileIdall(flid);
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("fileall", fileall);
		sendfileid(request,flid);
	}
	/**
	 * 向界面发送flid
	 * @param request
	 * @param flid
	 */
	public void sendfileid(HttpServletRequest request,String flid) {
		Filetype file=new Filetype();
		file.setFlid(flid);
		request.setAttribute("fileid", file);
	}
	/**
	 * 添加规章制度
	 * @param request
	 * @param response
	 * @param Unit
	 * @param flid
	 */
	public void addUnit(HttpServletRequest request,HttpServletResponse response,Unitsystem unit,String flid,MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 unit.setUnid(flid);
		 unit.setUdnumber(Methods.getUUID());
		 unit.setUnuserid(methods.getUser(request));
		 String page=methods.fileUpload(request,file);
		 if(!page.equals("文件为空")) {
			 unit.setUnaddress(page);
		 }
		 fileDao.addUnitsystem(unit);
		 pw.print("1");
	}
	/**
	 * 删除规章制度
	 * @param request
	 * @param type
	 */
	public void unDelete(HttpServletRequest request,String type) {
		Unitsystem unit=new Unitsystem();
		unit.setUdnumber(type);
		unit.setUnstate(0);
		fileDao.updateUnit(unit);
	}
	/**
	 * 向修改规章制度界面发送信息
	 * @param request
	 * @param number
	 * @param flid
	 */
	public void updateUnti(HttpServletRequest request,String number) {
		Unitsystem unit=new Unitsystem();
		unit.setUdnumber(number);
		Filetype file= fileDao.fileNunumber(unit);
		request.setAttribute("unit", file);
	}
	/**
	 * 修改规章制度
	 * @param request
	 * @param response
	 * @param unit
	 */
	public void updateUntipost(HttpServletRequest request,HttpServletResponse response,Unitsystem unit,MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 String page=methods.fileUpload(request,file);
		 if(!page.equals("文件为空")) {
			 unit.setUnaddress(page);
		 }
		fileDao.updateUnit(unit);
		pw.print("1");
	}
}
