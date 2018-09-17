package com.cncompute.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.ManagementDao;
import com.cncompute.pojo.Management;
import com.cncompute.pojo.Personnel;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 辐射安全管理人员表的Service层
 * @author 劉
 *  2018年8月2日14:59:10
 */
@Service
@Transactional
public class ManagementService {
	@Autowired
	private ManagementDao mangdao;
	@Autowired
	Methods methods;

	/**
	 * 新建机构并插入管理人员
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void personnel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// List<Management> manall=mangdao.queryMang();//查询Management表所有内容
		String maid = "jg" + Methods.getUUID();// 表ID
		String mainformation = "xl" + Methods.getUUID();// 信息ID
		String manumber = "bh" + Methods.getUUID();// 机构编号
		String maname = request.getParameter("maname");// 机构名称
		String mahead = request.getParameter("mahead");// 负责人
		String maphone = request.getParameter("maphone");// 电话
		Date matime = methods.getTime();// 当前时间
		String mauserid = methods.getUser(request);// 当前登录ID
		Integer mastate = 1;// 表状态0删除1正常
		Management man = new Management();
		man.setMaid(maid);
		man.setMainformation(mainformation);
		man.setManumber(manumber);
		man.setManame(maname);
		man.setMahead(mahead);
		man.setMaphone(maphone);
		man.setMatime(matime);
		man.setMauserid(mauserid);
		man.setMastate(mastate);
		mangdao.insertMangemen(man);// 保存到数据库
		addManagement(request, maid);
	}

	/**
	 * 在机构下添加管理人员方法
	 * 
	 * @param request
	 * @param peid
	 */
	public void addManagement(HttpServletRequest request, String peid) {
		String[] peusername = request.getParameterValues("peusername");// 姓名
		String[] pemanagement = request.getParameterValues("pemanagement");// 管理岗位
		String[] pegender = request.getParameterValues("pegender");// 性别
		String[] peposition = request.getParameterValues("peposition");// 职务或职称
		String[] pedepartment = request.getParameterValues("pedepartment");// 工作部门
		String[] pespecially = request.getParameterValues("pespecially");// 专（兼）职
		String[] pewhether = request.getParameterValues("pewhether");// 是否为负责人
		String[] perecord = request.getParameterValues("perecord");// 学历
		String[] peprofessional = request.getParameterValues("peprofessional");// 专业

		List<Object> list1 = methods.handleFileUpload(request, "file1", ".jpg", "D://aim//");
		List<Object> list2 = methods.handleFileUpload(request, "file2", ".jpg", "D://aim//");

		String peuserid = methods.getUser(request);// 当前登录用户ID
		Date petime = methods.getTime();// 当前时间
		try {
		for (int i = 0; i < pemanagement.length; i++) {
			Personnel per = new Personnel();
			per.setPeid(peid);
			// per.setPename(pename);
			per.setPeinformation(Methods.getUUID());// 信息ID
			// per.setPenumber(penumber);
			per.setPeusername(peusername[i]);
			per.setPemanagement(pemanagement[i]);// 管理岗位
			per.setPegender(pegender[i]);// 性别
			per.setPeposition(peposition[i]);// 职务或职称
			per.setPedepartment(pedepartment[i]);// 工作部门
			per.setPespecially(pespecially[i]);// 专（兼）职
			per.setPewhether(pewhether[i]);// 是否为负责人
			per.setPerecord(perecord[i]);// 学历
			per.setPeprofessional(peprofessional[i]);// 专业
			per.setPeuserid(peuserid);
			per.setPetime(petime);
			per.setPestate(1);// 表状态0删除1正常
			try {
				per.setPecertificateid((String) list1.get(i));// 学历证书ID
				per.setPeradiationid((String) list2.get(i));// 辐射安全培训证书ID
			} catch (Exception e) {
			}
			mangdao.insertPersonnel(per);// 保存到数据库
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 向辐射管理机构构成界面发送信息
	 * 
	 * @param request
	 * @param response
	 */
	public void sendMang(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Management> manAll = mangdao.queryMang();
			index=(manAll.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		
		List<Management> manAll = mangdao.queryMang();
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("install", manAll);
	}
	/**
	 * 向辐射管理人员显示界面发送信息
	 * 
	 * @param request
	 */
	public void setMpeople(HttpServletRequest request) {
		String maid = request.getParameter("type");
		sendInformation(maid, request);
	}

	/**
	 * 封装maid发送给管理人员发送界面
	 * 
	 * @param request
	 */
	public void encapsulation(HttpServletRequest request) {
		String maid = request.getParameter("type");
		Management man = new Management();
		man.setMaid(maid);
		request.setAttribute("man", man);
	}

	/**
	 * 封装发送信息方法
	 * 
	 * @param maid
	 */
	public void sendInformation(String maid, HttpServletRequest request) {
		int each =4; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Management> manAll = mangdao.queryMang();
			index=(manAll.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		Management man = new Management();
		man.setMaid(maid);
		List<Management> list = mangdao.queryId(man);
		for (int i = 0; i < list.size(); i++) {
			man.setMainformation(list.get(0).getMainformation());
			man.setManumber(list.get(0).getManumber());
			man.setManame(list.get(0).getManame());
			man.setMahead(list.get(0).getMahead());
			man.setMaphone(list.get(0).getMaphone());

		}
		request.setAttribute("mangp", list);
		request.setAttribute("mang", man);
		methods.sendPage(page, pag, starting, end, index, request, jnum);
	}

	/**
	 * 删除辐射管理人员
	 * 
	 * @param request
	 */
	public void madelete(HttpServletRequest request) {
		String peinformation = request.getParameter("type");
		Personnel per = new Personnel();
		per.setPeinformation(peinformation);
		Management man2 = mangdao.perId(per);
		mangdao.maDelete(per);
		sendInformation(man2.getPersonnel().getPeid(), request);
	}

	/**
	 * 修改辐射管理人员
	 * 
	 * @param request
	 */
	public void mamodify(HttpServletRequest request ,HttpServletResponse response) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String peinformation = request.getParameter("type");
		String pemanagement = request.getParameter("pemanagement");// 管理岗位
		String peusername = request.getParameter("peusername");// 姓名
		String pegender = request.getParameter("pegender");// 性别
		String peposition = request.getParameter("peposition");// 职务或职称
		String pedepartment = request.getParameter("pedepartment");// 工作部门
		String pespecially = request.getParameter("pespecially");// 专（兼）职
		String pewhether = request.getParameter("pewhether");// 是否为负责人
		String perecord = request.getParameter("perecord");// 学历
		String peprofessional = request.getParameter("peprofessional");// 专业
		Personnel per = new Personnel();
		per.setPeinformation(peinformation);
		per.setPemanagement(pemanagement);
		per.setPeusername(peusername);
		per.setPegender(pegender);
		per.setPeposition(peposition);
		per.setPedepartment(pedepartment);
		per.setPespecially(pespecially);
		per.setPewhether(pewhether);
		per.setPerecord(perecord);
		per.setPeprofessional(peprofessional);
		try {
			List<Object> list1 = methods.handleFileUpload(request, "file1", ".jpg", "D://aim//");
			per.setPecertificateid((String) list1.get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			List<Object> list2 = methods.handleFileUpload(request, "file2", ".jpg", "D://aim//");
			per.setPeradiationid((String) list2.get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		mangdao.maModify(per);
		Management man2 = mangdao.perId(per);
		sendInformation(man2.getPersonnel().getPeid(), request);
		pw.print("1");
	}

	/**
	 * 向修改辐射管理人员界面发送内容
	 * 
	 * @param request
	 */
	public void sending(HttpServletRequest request) {
		String peinformation = request.getParameter("type");
		Personnel per = new Personnel();
		per.setPeinformation(peinformation);
		Management man = mangdao.perId(per);
		request.setAttribute("man", man);
	}
	/**
	 * 删除辐射管理机构构成
	 * @param request
	 * @param type
	 */
	public void upModi(HttpServletRequest request,String type) {
		Management mana=new Management();
		mana.setMaid(type);
		mana.setMastate(0);
		mangdao.updateModi(mana);
	}
	/**
	 * 向修改辐射管理界面发送信息
	 * @param request
	 * @param type
	 */
	public void sendUpMana(HttpServletRequest request,String type) {
		Management mana=mangdao.quMaid(type);
		request.setAttribute("mana",mana);
	}
	/**
	 * 修改辐射管理机构
	 * @param request
	 * @param response
	 * @param mana
	 */
	public void updateMana(HttpServletRequest request,HttpServletResponse response,Management mana) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		mangdao.updateModi(mana);
		pw.print("1");
	}
}
