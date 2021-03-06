package com.cncompute.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cncompute.dao.*;
import com.cncompute.pojo.*;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.*;

/**
 * 工作人员职业健康情况表的Service层
 * @author Admin
 *2018年8月15日14:31:52
 */
@Service
@Transactional
public class InsertdataService {
	@Autowired
	private InsertdataDao inserdao;
//	@Autowired
//	private ManagementDao mandao;
	@Autowired
	private StaffinformationDao staffDao;
	@Autowired
	private Methods methods;
	/**
	 * 插入工作人员职业健康情况
	 * @param request
	 */
    public void inInsert(HttpServletRequest request,HttpServletResponse response) {
    	PrintWriter pw=null;
    	try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
        String inid=request.getParameter("type");//表ID
        String innumber=Methods.getUUID();//信息编号
        Insertdata inser=new Insertdata();
        inser.setInid(inid);
        List<Insertdata> inserall=inserdao.queryYears(inser);
        //判断这一年是否录入的4次内容
        int inserLong=inserall.size();
        if(inserLong>=4) {
        	pw.print("3");//输入内容超过4次
        	return;
        }
        double inresults = 0;
        try {
        	inresults= new Double(request.getParameter("inresults"));//季度剂量监测数据
		} catch (Exception e) {
			// TODO: handle exception
			pw.print("2");//请检测输入是否正确
			return;
		}
//        if(inserLong==0) {
//            inser.setInquarter("一季度");
//        }else if(inserLong==1) {
//        	
//        }else if(inserLong==2) {
//        	
//        }else if(inserLong==3) {
//        	
//        }
        inser.setInnumber(innumber);
        inser.setInresults(inresults);
        
        if(inresults>5) {
        	inser.setInquarterend("是");//季度是否过量
        	inser.setInquartertag(1);//季度：0正常1超标
        }else {
        	inser.setInquarterend("否");//季度是否过量
        	inser.setInquartertag(0);//季度：0正常1超标
        }
        inser.setInuser(methods.getUser(request));
        inser.setInstate(1);//表状态0删除1正常

        Staffinformation staffid= queryStaff(inid);
        inser.setInname(staffid.getStname());//姓名
        inser.setIngender(staffid.getStgender());//性别
        inser.setInage(staffid.getStage());
        inserdao.ininsert(inser);
        double num = 0;
        for (Insertdata insertdata : inserall) {
        	num+=insertdata.getInresults();
		}
        inser.setInyears(num);//年度剂量监测数据
        if(num>20) {
        	inser.setInyearsend("是");//年度是否过量
        	inser.setInyearstag(1);//年度：0正常1超标
        }else {
        	inser.setInyearsend("否");//年度是否过量
        	inser.setInyearstag(0);//年度：0正常1超标
        }
        inserdao.inupdate(inser);
		pw.print("1");
    }
    /**
     * 通过stnumber 查询员工全部信息返回员工对象
     * @param stnumber
     * @return
     */
    public Staffinformation queryStaff(String stnumber) {
    	Staffinformation staff=new Staffinformation();
    	staff.setStnumber(stnumber);
		return staffDao.stquery(staff);
    }
    /**
     * 发送stnumber到插入监测数据界面
     * @param request
     */
    public void sendStnumber(HttpServletRequest request) {
    	String stnumber=request.getParameter("type");
    	String pageindex=request.getParameter("pageindex");
    	Staffinformation staff=new Staffinformation();
    	staff.setStnumber(stnumber);
    	request.setAttribute("pageindex", pageindex);
    	request.setAttribute("staff", staff);
    }
    /**
     * 查询全部辐射工作人员表信息
     * @param request
     */
    public void queryAll(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Insertdata>lnser= inserdao.queryAll();
			index=(lnser.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
    	List<Insertdata>lnser= inserdao.queryAll();
		for(int i=0;i<lnser.size();i++){
			lnser.get(i).setPageNumber((i+1)+((index-1)*each));
     	}
    	for (Insertdata insertdata : lnser) {
            if(insertdata.getInresults()>5) {
            	insertdata.setInquarcolor("color:red");
            }else {
            	insertdata.setInquarcolor("color:black");
            }
            if(insertdata.getInyears()>20) {
            	insertdata.setInyearscolor("color:red");
            }else {
            	insertdata.setInyearscolor("color:black");
            }
		}
    	request.setAttribute("lnser", lnser);
    	methods.sendPage(page, pag, starting, end, index, request, jnum);
    }
    /**
     * 删除员工辐射记录
     * @param request
     */
    public void indelete(HttpServletRequest request,String type) {
    	Insertdata inser=new Insertdata();
    	inser.setInnumber(type);
    	inser.setInstate(0);
    	inserdao.inupdate(inser);
    	queryAll(request);
    }
    /**
     * 根据信息编号查询信息
     * @param request
     * @param innumber
     */
    public void inPdate(HttpServletRequest request,String innumber) {
    	request.setAttribute("inser", inserdao.inserupdate(innumber));
    }
    /**
     * 修改员工辐射记录
     * @param request
     * @param inser
     * @param response
     */
    public void updatePost(HttpServletRequest request,Insertdata inser,HttpServletResponse response) {
        if(inser.getInresults()>5) {
        	inser.setInquarterend("是");//季度是否过量
        	inser.setInquartertag(1);//季度：0正常1超标
        }else {
        	inser.setInquarterend("否");//季度是否过量
        	inser.setInquartertag(0);//季度：0正常1超标
        }
        inserdao.inupdate(inser);
        List<Insertdata> inserall=inserdao.queryYears(inser);
        double num = 0;
        for (Insertdata insertdata : inserall) {
        	num+=insertdata.getInresults();
		}
        inser.setInyears(num);//年度剂量监测数据
        if(num>20) {
        	inser.setInyearsend("是");//年度是否过量
        	inser.setInyearstag(1);//年度：0正常1超标
        }else {
        	inser.setInyearsend("否");//年度是否过量
        	inser.setInyearstag(0);//年度：0正常1超标
        }
        inserdao.inupdate(inser);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("1");
//    	queryAll(request);
    }
    /**
     * 导出表
     * @param request
     * @param response
     * @throws IOException
     */
    public void downloadClastall(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	List<Insertdata>lnser= inserdao.queryAll();
    	//创建一个新的excel
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("信息表");
        String fileName = "information"  + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "姓名", "性别", "年龄", "监测时间", 
        		"季度监测数据", "季度是否过量", "年度监测数据","年度是否过量"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Insertdata teacher : lnser) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(teacher.getInname());
            row1.createCell(1).setCellValue(teacher.getIngender());
            row1.createCell(2).setCellValue(teacher.getInage());
//            row1.createCell(3).setCellValue(teacher.getIndepartment());
            row1.createCell(3).setCellValue(teacher.getIntime());
            row1.createCell(4).setCellValue(teacher.getInresults());
            row1.createCell(5).setCellValue(teacher.getInquarterend());
            row1.createCell(6).setCellValue(teacher.getInyears());
            row1.createCell(7).setCellValue(teacher.getInyearsend());
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
     * @param chaxun
     */
    public void inQuery(HttpServletRequest request,HttpServletResponse response,String inname) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Insertdata> inlist = inserdao.fuzzyQueryin(inname);
			index=(inlist.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
    	List<Insertdata> inlist = inserdao.fuzzyQueryin(inname);
    	for (Insertdata insertdata : inlist) {
            if(insertdata.getInresults()>5) {
            	insertdata.setInquarcolor("color:red");
            }else {
            	insertdata.setInquarcolor("color:black");
            }
            if(insertdata.getInyears()>20) {
            	insertdata.setInyearscolor("color:red");
            }else {
            	insertdata.setInyearscolor("color:black");
            }
		}
		for(int i=0;i<inlist.size();i++){
			inlist.get(i).setPageNumber((i+1)+((index-1)*13));
     	}
    	request.setAttribute("pageindex", index);
    	methods.sendPage(page, pag, starting, end, index, request, jnum);
    	request.setAttribute("inname", inname);
    	request.setAttribute("lnser", inlist);
    }
}
