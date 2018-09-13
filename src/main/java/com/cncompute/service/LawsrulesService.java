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
import com.cncompute.repeat.Methods;

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
		List<Lawsrules> lawsall = lawsDao.queryLaws();
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
