package com.cncompute.service;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.cncompute.dao.LawsrulesDao;
import com.cncompute.pojo.Lawsrules;
import com.cncompute.pojo.Management;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 法律法规表Service层
 * @author Admin 
 * 2018年8月29日16:45:50
 */
@Service
@Transactional
public class LawsrulesService {
	@Autowired
	private LawsrulesDao lawsDao;
	@Autowired
	private Methods methods;

	/**
	 * 查询全部法律法规信息
	 * 
	 * @param request
	 */
	public void lawsAll(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Lawsrules> lawsall = lawsDao.queryLaws();
			index=(lawsall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Lawsrules> lawsall = lawsDao.queryLaws();
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("laws", lawsall);
	}

	/**
	 * 添加法律法规
	 * 
	 * @param request
	 * @param response
	 * @param laws
	 * @param file
	 */
	public void lawsAdd(HttpServletRequest request, HttpServletResponse response, Lawsrules laws, MultipartFile file) {
        PrintWriter pw=null;
        try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String page = methods.fileUpload(request, file);
		if (!page.equals("文件为空")) {
			laws.setLaelectronicid(page);
		}
		laws.setLaid(Methods.getUUID());
		laws.setLauserid(methods.getUser(request));
		lawsDao.addLaws(laws);
		pw.print("1");
	}
}
