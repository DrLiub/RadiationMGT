package com.cncompute.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.StaffinformationDao;
import com.cncompute.pojo.Staffinformation;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 辐射员工表的Service层
 * 
 * @author 劉 2018年8月9日14:41:18
 */
@Service
@Transactional
public class StaffinformationService {
	@Autowired
	private StaffinformationDao staffDao;
	@Autowired
	Methods methods;
//	@Autowired
//	private ManagementDao mandao;

	/**
	 * 向辐射工作人员显示页面发送数据
	 * 
	 * @param request
	 */
	public void sendStaff(HttpServletRequest request) {
		String stid = request.getParameter("type");
		encapsulation(request, stid);
	}

	/**
	 * 封装人员信息
	 * 
	 * @param request
	 */
	public void encapsulation(HttpServletRequest request, String stid) {
		Staffinformation staff = new Staffinformation();
		staff.setStid(stid);
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Staffinformation> staffAll = staffDao.queryStaff(staff);
			index=(staffAll.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}

		List<Staffinformation> staffAll = staffDao.queryStaff(staff);
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("staff", staffAll);
		request.setAttribute("staffid", staff);
	}

	/**
	 * 插入新员工的方法
	 * 
	 * @param request
	 * @throws ParseException
	 */
	public void addStaff(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String stid = request.getParameter("type");// 表ID
		
		String stinstitutions = Methods.getUUID();// 机构编号
		String[] stname = request.getParameterValues("stname");// 姓名
		String[] stgender = request.getParameterValues("stgender");// 性别
		String[] stage = request.getParameterValues("stage");// 年龄
		String[] stjobs = request.getParameterValues("stjobs");// 工作岗位
		String[] stschooling = request.getParameterValues("stschooling");// 学历及专业
		String[] sttrainingtime = request.getParameterValues("sttrainingtime");// 培训时间
		String[] stcertificate = request.getParameterValues("stcertificate");// 资格证书编号
		String[] stnote = request.getParameterValues("stnote");// 备注
		String[] stbirth = request.getParameterValues("stbirth");// 出生日期
		String[] stgraduation = request.getParameterValues("stgraduation");// 培训毕业时间
//    	Management man=new Management();
//    	man.setMaid(stid);
//    	Management manga=mandao.queryMaid(man);
		List<Object> list1 = methods.handleFileUpload(request, "file1", "D://aim//");

		// String stsecurity;//安全培训证书ID
		// String stdose;//个人剂量监测结果ID
		// String stquarter;//个人季度超量
		// String stannual;//个人年度超量
		String stuserid = methods.getUser(request);// 当前登录ID
		Date sttime = methods.getTime();// 当前时间

		for (int i = 0; i < stname.length; i++) {
			String stnumber = Methods.getUUID();// 信息编号
			Staffinformation staff = new Staffinformation();
			staff.setStid(stid);
			staff.setStnumber(stnumber);
			staff.setStinstitutions(stinstitutions);
			staff.setStname(stname[i]);
			staff.setStgender(stgender[i]);
			staff.setStage(stage[i]);
			staff.setStjobs(stjobs[i]);
			staff.setStschooling(stschooling[i]);
//			staff.setStdepartment(manga.getManame());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				staff.setSttrainingtime(Methods.getStringDate(sdf.parse(sttrainingtime[i])));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				staff.setStbirth(Methods.getStringDate(sdf.parse(stbirth[i])));
			} catch (Exception e) {
				// TODO: handle exception
			}
			staff.setStcertificate(stcertificate[i]);
			staff.setStnote(stnote[i]);
			try {
				staff.setStgraduation(stgraduation[i]);// 培训毕业时间
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date now = new Date();
				sdf2.format(now);
				Boolean bool = Methods.belongDate(now, sdf.parse(stgraduation[i]), 1460);
				if (bool) {
					staff.setStoverdue("是");// 证书是否过期
					staff.setStoverdueyn(1);
				} else {
					staff.setStoverdue("否");// 证书是否过期
					staff.setStoverdueyn(0);
				}
			} catch (Exception e) {
				// TODO: handle exception
				pw.print("2");//录入培训毕业时间
				return;
			}
			try {
				staff.setStsecurity((String) list1.get(i));
			} catch (Exception e) {

			}
			staff.setStdose("jl" + Methods.getUUID());
			staff.setStuserid(stuserid);
			staff.setSttime(sttime);
			staff.setStstate(1);
			staffDao.addStaff(staff);
		}
		pw.print("1");
	}

	/**
	 * 向添加人员页面发送ID
	 * 
	 * @param request
	 */
	public void send(HttpServletRequest request) {
		Staffinformation staff = new Staffinformation();
		staff.setStid(request.getParameter("type"));
		request.setAttribute("staffid", staff);
	}

	/**
	 * 删除管理人员
	 * 
	 * @param request
	 */
	public void staffDelete(HttpServletRequest request) {
		String stnumber = request.getParameter("type");
		Staffinformation staff = new Staffinformation();
		staff.setStnumber(stnumber);
		staffDao.stdelete(staff);
		encapsulation(request, staffDao.stquery(staff).getStid());
	}

	/**
	 * 根据stnumber查询员工信息
	 * 
	 * @param request
	 */
	public void queryStnumber(HttpServletRequest request) {
		String stnumber = request.getParameter("type");
		Staffinformation staff = new Staffinformation();
		staff.setStnumber(stnumber);
		Staffinformation staff2 = staffDao.stquery(staff);
		request.setAttribute("staff", staff2);
	}

	/**
	 * 修改工作人员信息
	 * 
	 * @param request
	 */
	public void staffUpdate(HttpServletRequest request ,HttpServletResponse response) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String stnumber = request.getParameter("type");
		String stname = request.getParameter("stname");// 姓名
		String stgender = request.getParameter("stgender");// 性别
		String stage = request.getParameter("stage");// 年龄
		String stjobs = request.getParameter("stjobs");// 工作岗位
		String stschooling = request.getParameter("stschooling");// 学历及专业
		String sttrainingtime = request.getParameter("sttrainingtime");// 培训时间
		String stbirth = request.getParameter("stbirth");// 出生日期
		String stcertificate = request.getParameter("stcertificate");// 资格证书编号
		String stgraduation = request.getParameter("stgraduation");// 培训毕业时间
		// String stsecurity = request.getParameter("stsecurity");// 安全培训证书ID
		String stnote = request.getParameter("stnote");// 备注
		Staffinformation staff = new Staffinformation();
		staff.setStnumber(stnumber);
		staff.setStname(stname);
		staff.setStgender(stgender);
		staff.setStage(stage);
		staff.setStjobs(stjobs);
		staff.setStschooling(stschooling);
		if(sttrainingtime.length()!=0) {
			try {
				staff.setSttrainingtime(sttrainingtime);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
        if(stbirth.length()!=0) {
    		try {
    			staff.setStbirth(stbirth);
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
        }
		staff.setStcertificate(stcertificate);
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if(stgraduation.length()==0) {
			
		}else {
			try {
				date = format1.parse(stgraduation);
				staff.setStgraduation(stgraduation);
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date now = new Date();
				sdf2.format(now);
				Boolean bool = Methods.belongDate(now, date, 1460);
				if (bool) {
					staff.setStoverdue("是");// 证书是否过期
				} else {
					staff.setStoverdue("否");// 证书是否过期
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		try {
			List<Object> list1 = methods.handleFileUpload(request, "file1", "D://aim//");
			staff.setStsecurity((String) list1.get(0));
		} catch (Exception e) {
			// TODO: handle exception
		}
		staff.setStnote(stnote);
		staffDao.stupdate(staff);
		encapsulation(request, staffDao.stquery(staff).getStid());
		pw.print("1");
	}
	/**
	 * 查询全部工作人员信息
	 * @param request
	 */
	public void staffAll(HttpServletRequest request) {
		List<Staffinformation> all=staffDao.stallAll();
		for (Staffinformation sta : all) {
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
				try {
					date = format1.parse(sta.getStgraduation());
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					Date now = new Date();
					sdf2.format(now);
					Boolean bool = Methods.belongDate(now, date, 1460);
					if (bool) {
						sta.setStoverdue("是");// 证书是否过期
						sta.setStoverdueyn(1);
					} else {
						sta.setStoverdue("否");// 证书是否过期
						sta.setStoverdueyn(0);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				staffDao.stupdate(sta);
		}
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Staffinformation> staff=staffDao.stallAll();
			index=(staff.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Staffinformation> staff=staffDao.stallAll();
		for (Staffinformation staffin : staff) {
			if(staffin.getStoverdue().equals("是")) {
				staffin.setColor("color:red");
			}else {
				staffin.setColor("color:black");
			}
		}
		request.setAttribute("staff", staff);
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
	}
	/**
	 * 删除(培训情况)界面人员
	 * @param request
	 */
	public void stdel(HttpServletRequest request,String type) {
		Staffinformation staff=new Staffinformation();
		staff.setStnumber(type);
		staffDao.stdelete(staff);
		staffAll(request);
	}
	/**
	 * 导出Excel(工作人员)
	 * @param request
	 * @param response
	 * @param type
	 * @throws IOException 
	 */
	public void export(HttpServletRequest request,HttpServletResponse response,String type) throws IOException {
		Staffinformation staff = new Staffinformation();
		staff.setStid(type);
		List<Staffinformation> staffAll = staffDao.queryStaff(staff);
		downloadClassmate(response, staffAll);
	}
	/**
	 * 导出Excel工作人员
	 * @param response
	 * @param classmateList
	 * @throws IOException
	 */
	public void downloadClassmate(HttpServletResponse response ,List<Staffinformation> classmateList) throws IOException {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("信息表");
	        String fileName = "information"  + ".xls";//设置要导出的文件的名字
	        //新增数据行，并且设置单元格数据
	        int rowNum = 1;
	        String[] headers = { "姓名", "性别", "年龄", "工作岗位", "学历及专业","培训时间", "出生日期", "培训证书编号","证书是否到期","备注"};
	        //headers表示excel表中第一行的表头

	        HSSFRow row = sheet.createRow(0);
	        //在excel表中添加表头

	        for(int i=0;i<headers.length;i++){
	            HSSFCell cell = row.createCell(i);
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }

	        //在表中存放查询到的数据放入对应的列
	        for (Staffinformation teacher : classmateList) {
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell(0).setCellValue(teacher.getStname());
	            row1.createCell(1).setCellValue(teacher.getStgender());
	            row1.createCell(2).setCellValue(teacher.getStage());
	            row1.createCell(3).setCellValue(teacher.getStjobs());
	            row1.createCell(4).setCellValue(teacher.getStschooling());
	            row1.createCell(5).setCellValue(teacher.getSttrainingtime());
	            row1.createCell(6).setCellValue(teacher.getStbirth());
	            row1.createCell(7).setCellValue(teacher.getStcertificate());
	            row1.createCell(8).setCellValue(teacher.getStoverdue());
	            row1.createCell(9).setCellValue(teacher.getStnote());
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
	/**
	 * 导出Excel辐射工作人员培训情况
	 * @param response
	 * @param classmateList
	 * @throws IOException
	 */
	public void downloadClastall(HttpServletRequest request,HttpServletResponse response ) throws IOException {
	        HSSFWorkbook workbook = new HSSFWorkbook();
	        HSSFSheet sheet = workbook.createSheet("信息表");
	        String fileName = "information"  + ".xls";//设置要导出的文件的名字
	        //新增数据行，并且设置单元格数据
	        int rowNum = 1;
	        String[] headers = { "姓名", "性别", "年龄","工作岗位","培训日期","培训毕业时间", "培训证书编号", "证书是否到期"};
	        //headers表示excel表中第一行的表头

	        HSSFRow row = sheet.createRow(0);
	        //在excel表中添加表头

	        for(int i=0;i<headers.length;i++){
	            HSSFCell cell = row.createCell(i);
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	            cell.setCellValue(text);
	        }
	        List<Staffinformation> classmateList=staffDao.stallAll();
	        //在表中存放查询到的数据放入对应的列
	        for (Staffinformation teacher : classmateList) {
	            HSSFRow row1 = sheet.createRow(rowNum);
	            row1.createCell(0).setCellValue(teacher.getStname());
	            row1.createCell(1).setCellValue(teacher.getStgender());
	            row1.createCell(2).setCellValue(teacher.getStage());
//	            row1.createCell(3).setCellValue(teacher.getStdepartment());
	            row1.createCell(3).setCellValue(teacher.getStjobs());
	            row1.createCell(4).setCellValue(teacher.getSttrainingtime());
	            row1.createCell(5).setCellValue(teacher.getStgraduation());
	            row1.createCell(6).setCellValue(teacher.getStcertificate());
	            row1.createCell(7).setCellValue(teacher.getStoverdue());
	            rowNum++;
	        }
	        response.setContentType("application/octet-stream");
	        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
	        response.flushBuffer();
	        workbook.write(response.getOutputStream());
	    }
	/**
	 * 模糊查询
	 * @param request
	 * @param response
	 * @param name
	 */
	public void fuzzyQueryst(HttpServletRequest request,String name) {
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Staffinformation> staff= staffDao.fuzzyQueryst(name);
			index=(staff.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Staffinformation> staff= staffDao.fuzzyQueryst(name);
		for (Staffinformation staffin : staff) {
			if(staffin.getStoverdue().equals("是")) {
				staffin.setColor("color:red");
			}else {
				staffin.setColor("color:black");
			}
		}
		request.setAttribute("staff", staff);
		request.setAttribute("name", name);
		methods.sendPage(page, pag, starting, end, index, request, jnum);
	}
}
