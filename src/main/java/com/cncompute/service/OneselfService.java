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

import com.cncompute.dao.EntrustDao;
import com.cncompute.dao.OneselfDao;
import com.cncompute.pojo.Entrust;
import com.cncompute.pojo.Oneself;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 表oneself(辐射环境监测数据)表service层
 * 
 * @author Admin 2018年8月21日14:05:06
 */
@Service
@Transactional
public class OneselfService {
	@Autowired
	private OneselfDao oneselfdao;
	@Autowired
	private EntrustDao entrdao;
	@Autowired
	private Methods methods;

	/**
	 * 向单位显示界面(donunitpreview)发送数据
	 * 
	 * @param request
	 */
	public void senDonunitpreview(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Entrust> enall = entrdao.enQuery();
			index=(enall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Entrust> enall = entrdao.enQuery();
		for(int i=0;i<enall.size();i++){
			enall.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("enall", enall);
	}

	/**
	 * 添加单位的方法
	 * @param request
	 * @param response
	 * @param entr
	 */
	public void addunit(HttpServletRequest request, HttpServletResponse response, Entrust entr) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ("".equals(entr.getEntypeen()) || entr.getEntypeen() == null) {
			pw.print("2");// 单位名称不能为空
			return;
		} else if (entr.getEnunit().length() != 11 || "".equals(entr.getEnunit()) || entr.getEnunit() == null
				|| !methods.isNumeric(entr.getEnunit())) {
			pw.print("3");// 电话号码格式不正确
			return;
		}
		entr.setEnid(Methods.getUUID());
		entr.setEnuserid(methods.getUser(request));
		entr.setEnstate(1);
		entrdao.enInsert(entr);
		pw.print("1");
	}

	/**
	 * 向单位自行监测数据显示页面(reunit)发送数据
	 * @param request
	 * @param type
	 */
	public void reunit(HttpServletRequest request, String type) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Oneself> onall = oneselfdao.onQuery(type, 1);
			index=(onall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Oneself> onall = oneselfdao.onQuery(type, 1);
		for(int i=0;i<onall.size();i++){
			onall.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("onall", onall);
		sendNoid(request, type);
	}
	/**
	 * 向页面发送onid
	 * @param request
	 * @param noid
	 */
	public void sendNoid(HttpServletRequest request, String noid) {
		Oneself on = new Oneself();
		on.setNoid(noid);
		request.setAttribute("one", on);
	}
	/**
	 * 向页面发送onid  nonumberid
	 * @param request
	 * @param noid
	 */
	public void sendNoidNonumberid(HttpServletRequest request, String noid,Oneself on) {
		on.setNoid(noid);
		request.setAttribute("one", on);
	}
	/**
	 * 向页面发送onid  nonumberid
	 * @param request
	 * @param noid
	 */
	public void sendNonumberid(HttpServletRequest request,Oneself on,String type) {
		on.setNonumberid(Methods.getUUID());
		on.setNoid(type);
		request.setAttribute("one", on);
	}

	/**
	 * 添加添加单位自行监测数据方法
	 * 
	 * @param request
	 * @param response
	 * @param ones
	 * @param notag 1位单位2位委托
	 */
	public void addUnitpost(HttpServletRequest request, HttpServletResponse response,String noid,Integer notag) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String []noproject=request.getParameterValues("noproject");// 监测项目名称
		String []nonumber=request.getParameterValues("nonumber");// 监测项目编号
		String []notimeno=request.getParameterValues("notimeno");// 监测时间
		String []nopeople=request.getParameterValues("nopeople");// 监测执行人
		String []noplace=request.getParameterValues("noplace");// 监测地点
		String []notype=request.getParameterValues("notype");// 选择监测类型
//		String []nodata=request.getParameterValues("nodata");// 监测数据地址
		List<Object> list1 = methods.handleFileUpload(request, "file1", "D://aim//");
		for(int i=0;i<noplace.length;i++) {
            if("".equals(noplace[i])||noplace[i]==null) {
            	pw.print("2");
            	return;
            }
		}
		for(int i=0;i<noproject.length;i++) {
			Oneself ones=new Oneself();
			ones.setNoid(noid);
			ones.setNonumberid("xl"+Methods.getUUID());
			ones.setNotag(notag);// 1位单位2位委托
			ones.setNoproject(noproject[i]);// 监测项目名称
			ones.setNonumber(nonumber[i]);
			try {
				ones.setNotimeno(notimeno[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			ones.setNopeople(nopeople[i]);
			ones.setNoplace(noplace[i]);
			ones.setNotype(notype[i]);
			try {
				ones.setNodata((String)list1.get(i));
			} catch (Exception e) {
				// TODO: handle exception
			}
			ones.setNouserid(methods.getUser(request));
			ones.setNostate(1);
			oneselfdao.onInsert(ones);
		}
		pw.print("1");
	}
	/**
	 *  下载文件
	 * @param request
	 * @param response
	 * @param page
	 */
	public void download(HttpServletRequest request,HttpServletResponse response,String page) {
		String realPath=null;
		try {
			 realPath=page.substring(5, page.length());
		} catch (Exception e) {
			
		}
		methods.downloadFile(request, response, realPath, "D://aim//");
	}
	/**
	 *删除单位自行监测数据
	 * @param request
	 * @param onid
	 */
	public void onDelect(HttpServletRequest request,String onid,String nonum) {
		oneselfdao.onDelete(nonum);
		reunit(request,onid);
	}
	/**
	 * 根据编号查询单位自行监测数据
	 * @param request
	 * @param onnumber
	 */
	public void onOnnumber(HttpServletRequest request,String onnumber) {
		Oneself one= oneselfdao.onOnid(onnumber);
		request.setAttribute("one", one);
	}
	/**
	 * 修改数据
	 * @param request
	 * @param one
	 * @param response
	 */
	public void onUpdate(HttpServletRequest request,Oneself one,HttpServletResponse response) {
		try {
			List<Object> list1 = methods.handleFileUpload(request, "file1", "D://aim//");
			one.setNodata((String)list1.get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		oneselfdao.onUpdate(one);
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw.print("1");
	}
	/**
	 * 查询委托检测数据内容发送给委托检测数据界面
	 * @param request
	 */
	public void queryEntrust(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Oneself>ones=oneselfdao.queryEntrust(2);
			index=(ones.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Oneself>ones=oneselfdao.queryEntrust(2);
		for(int i=0;i<ones.size();i++){
			ones.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("onall", ones);
	}
	/**
	 * 添加委托检测数据
	 * @param request
	 * @param response
	 * @param noid
	 * @param notag 1位单位2位委托
	 */
	public void onEntaddPost(HttpServletRequest request, HttpServletResponse response,Integer notag) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String []noproject=request.getParameterValues("noproject");// 监测项目名称1
		String []nonumber=request.getParameterValues("nonumber");// 监测项目编号1
		String []notimeno=request.getParameterValues("notimeno");// 监测时间1
		String []nounit=request.getParameterValues("nounit");// 单位名称1
		String []notype=request.getParameterValues("notype");// 选择监测类型1
//		String []nodata=request.getParameterValues("nodata");// 监测数据地址1
		List<Object> list1 = methods.handleFileUpload(request, "file1", "D://aim//");
		for(int i=0;i<noproject.length;i++) {
			if("".equals(noproject[i])||noproject[i]==null) {
				pw.print("2");
				return;
			}
			Oneself ones=new Oneself();
			ones.setNoid("wt"+Methods.getUUID());
			ones.setNonumberid("wt"+Methods.getUUID());
			ones.setNotag(notag);// 1位单位2位委托
			ones.setNoproject(noproject[i]);// 监测项目名称
			ones.setNonumber(nonumber[i]);
			try {
				ones.setNotimeno(notimeno[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			ones.setNounit(nounit[i]);
			ones.setNotype(notype[i]);
			try {
				ones.setNodata((String)list1.get(i));
			} catch (Exception e) {
				// TODO: handle exception
			}
			ones.setNouserid(methods.getUser(request));
			ones.setNostate(1);
			oneselfdao.onInsert(ones);
		}
		pw.print("1");
	}
	/**
	 * 删除委托检测数据
	 * @param requets
	 * @param onnum
	 */
	public void onDelete(HttpServletRequest request ,String onnum) {
		oneselfdao.onDelete(onnum);
	}
	/**
	 * 向修改委托检测数据界面发送信息
	 * @param request
	 * @param onnum
	 */
	public void onModify(HttpServletRequest request,String onnum) {
		Oneself one= oneselfdao.onOnid(onnum);
		request.setAttribute("one", one);
	}
	/**
	 * 删除单位自行监测数据
	 * @param requets
	 * @param enid
	 */
	public void onDel(HttpServletRequest request,String enid) {
		Entrust entr =new Entrust();
		entr.setEnid(enid);
		entr.setEnstate(0);
		entrdao.enUpdate(entr);
	}
	/**
	 * 向修改单位自行监测界面发送信息
	 * @param request
	 * @param enid
	 */
	public void updateEn(HttpServletRequest request,String enid) {
		Entrust entr=entrdao.enid(enid);
		request.setAttribute("entr", entr);
	}
	/**
	 * 修改单位自行监测数据
	 * @param request
	 * @param response
	 * @param entr
	 */
	public void updateEntrust(HttpServletRequest request,HttpServletResponse response,Entrust entr) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		entrdao.enUpdate(entr);
		pw.print("1");
	}
	/**
	 * 获取地图上点的位置信息
	 * @param request
	 * @param response
	 * @param ones
	 */
	public void getMap(HttpServletRequest request,HttpServletResponse response,Oneself ones) {
		PrintWriter pw=null;
		try {
			 pw= response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ones.getMaplong()==1) {
			String json= "{\"index\":1}";//一个覆盖物
			pw.print(json);
		}else if(ones.getMaplong()>1) {
			String json= "{\"index\":2}";//覆盖物大于1
			pw.print(json);
		}else if(ones.getMaplong()<1) {
			String json= "{\"index\":3}";//覆盖物小于1
			pw.print(json);
		}
	}
	/**
	 * 单位自行监测数据添加--室外
	 * @param request
	 * @param response
	 * @param ones
	 */
	public void addOutdoor(HttpServletRequest request,HttpServletResponse response,Oneself ones,MultipartFile file) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if("".equals(ones.getNonumberid())||ones.getNonumberid()==null) {
			pw.print("2");//没有在地图上取点
			return;
		}
		ones.setNotag(1);// 1位单位2位委托
		ones.setNouserid(methods.getUser(request));
		ones.setNostate(1);
		String page = methods.fileUpload(request, file);
		if (!page.equals("文件为空")) {
			ones.setNodata(page);
		}
		oneselfdao.onInsert(ones);
		pw.print("1");
	}
	/**
	 * 通过numberid向页面发送数据
	 * @param request
	 * @param nonumberid
	 */
	public void onView(HttpServletRequest request,String nonumberid) {
		Oneself on=oneselfdao.onOnid(nonumberid);
		request.setAttribute("one", on);
	}
	/**
	 * 修改地图坐标
	 * @param request
	 * @param response
	 * @param nonumberid
	 */
	public void updateMaplng(HttpServletRequest request,Oneself ones) {
		oneselfdao.onUpdate(ones);
		Oneself on=oneselfdao.onOnid(ones.getNonumberid());
		request.setAttribute("one", on);
	}
	/**
	 * 委托检测数据模糊查询
	 * @param request
	 * @param name
	 */
	public void onenFuzzy(HttpServletRequest request,String name,int num) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Oneself>ones=oneselfdao.fuzzyOnes(name,num);
			index=(ones.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Oneself>ones=oneselfdao.fuzzyOnes(name,2);
		for(int i=0;i<ones.size();i++){
			ones.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("onall", ones);
		request.setAttribute("name", name);
	}
	/**
	 * 单位自行监测数据模糊查询
	 * @param request
	 * @param name
	 */
	public void fuzzyOnun(HttpServletRequest request,String name) {
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Entrust> enall = entrdao.fuzzyEntrust(name);
			index=(enall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Entrust> enall = entrdao.fuzzyEntrust(name);
		for(int i=0;i<enall.size();i++){
			enall.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("enall", enall);
		request.setAttribute("name", name);
	}
	/**
	 * 单位自行监测数据--模糊查询
	 * @param request
	 * @param type
	 * @param name
	 */
	public void reunitFuzzy(HttpServletRequest request,String name,String type) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Oneself> onall = oneselfdao.reunFuzzy(name, type, 1);
			index=(onall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Oneself> onall = oneselfdao.reunFuzzy(name, type, 1);
		for(int i=0;i<onall.size();i++){
			onall.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("onall", onall);
		sendNoid(request, type);
		request.setAttribute("name", name);
	}
}
