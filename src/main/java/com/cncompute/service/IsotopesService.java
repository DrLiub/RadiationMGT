package com.cncompute.service;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.IsotopesDao;
import com.cncompute.dao.SafetysheetDao;
import com.cncompute.dao.XraydeviceDao;
import com.cncompute.pojo.Isotopes;
import com.cncompute.pojo.Management;
import com.cncompute.pojo.Radioactiveentry;
import com.cncompute.pojo.Safetysheet;
import com.cncompute.pojo.Sealentry;
import com.cncompute.pojo.Xauxiliary;
import com.cncompute.repeat.Methods;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * 放射源Service层
 * @author Admin
 *2018年9月7日10:11:26
 */
@Service
@Transactional
public class IsotopesService {
	@Autowired
	private IsotopesDao isotdao;
	@Autowired
	private Methods methods;
	@Autowired
	private SafetysheetDao SafetDao;
	@Autowired
	private XraydeviceDao raydevicedao;
	/**
	 * 向放射源显示界面发送信息
	 * @param request
	 */
	public void queryIsot(HttpServletRequest request) {
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Isotopes> isotall= isotdao.isotAll();
			index=(isotall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Isotopes> isotall= isotdao.isotAll();
		methods.sendPage(page,pag, starting, end, index, request,jnum);//分页
		request.setAttribute("isotall",isotall);
	}
	/**
	 * 添加放射源信息
	 * @param request
	 * @param response
	 * @param isot
	 */
	public void addIsot(HttpServletRequest request,HttpServletResponse response,Isotopes isot) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		isot.setIsid(Methods.getUUID());
		isot.setIsuserid(methods.getUser(request));
		isotdao.isotAdd(isot);
		pw.print("1");
	}
	/**
	 * 向开放性同位素界面发送信息
	 * @param request
	 * @param type
	 */
	public void radioAll(HttpServletRequest request,String type) {
		sendID(request,type);
	}
	/**
	 * 向页面发送ID
	 * @param requets
	 * @param type
	 */
	public void sendID( HttpServletRequest requets,String type) {
		Isotopes isot =new Isotopes();
		isot.setIsid(type);
		requets.setAttribute("isotid",isot);
	}
	/**
	 * 添加-开放性同位素
	 * @param request
	 * @param response
	 * @param isid
	 */
	public void radiAddpost(HttpServletRequest request,HttpServletResponse response,String isid) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String []raname=request.getParameterValues("raname");
		String []radosage=request.getParameterValues("radosage");
		String []raphysical=request.getParameterValues("raphysical");
		String []raquantity=request.getParameterValues("raquantity");
		String []rayears=request.getParameterValues("rayears");
		String []raway=request.getParameterValues("raway");
		String []raplace=request.getParameterValues("raplace");
		String []racountry=request.getParameterValues("racountry");
		for (int i=0;i<raname.length;i++) {
			 Radioactiveentry radi=new Radioactiveentry();
			 radi.setRaid(isid);
			 radi.setRaentry(Methods.getUUID());
			 radi.setRauserid(methods.getUser(request));
			 radi.setRaname(raname[i]);
			 radi.setRadosage(radosage[i]);
			 radi.setRaphysical(raphysical[i]);
			 radi.setRaquantity(raquantity[i]);
			 radi.setRayears(rayears[i]);
			 radi.setRaway(raway[i]);
			 radi.setRaplace(raplace[i]);
			 radi.setRacountry(racountry[i]);
			 isotdao.radioaAdd(radi);
		}
		pw.print("1");
	}
	/**
	 * 删除-开放性同位素
	 * @param request
	 * @param type
	 * @param raid
	 */
	public void radiDelice(HttpServletRequest request,String type,String raid) {
		 Radioactiveentry radi=new Radioactiveentry();
		 radi.setRaentry(type);
		 radi.setRastate(0);
		isotdao.updateRadi(radi);
	}
	/**
	 * 向修改开放性同位素界面发送信息
	 * @param request
	 * @param raentry
	 * @param raid
	 */
	public void sendRadi(HttpServletRequest request,String raentry,String raid) {
		Isotopes radi=isotdao.radiSelect(raentry);
		request.setAttribute("radi",radi);
	}
	/**
	 * 修改开放性同位素
	 * @param request
	 * @param response
	 * @param radi
	 */
	public void updateRadi(HttpServletRequest request,HttpServletResponse response,Radioactiveentry radi) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		isotdao.updateRadi(radi);
		pw.print("1");
	}
	/**
	 * 添加-密封源
	 * @param request
	 * @param response
	 * @param isid
	 */
	public void sealAdd(HttpServletRequest request,HttpServletResponse response,String isid) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String []sename=request.getParameterValues("sename");
		String []selive=request.getParameterValues("selive");
		String []senumber=request.getParameterValues("senumber");
		String []sephysical=request.getParameterValues("sephysical");
		String []secategory=request.getParameterValues("secategory");
		String []seoperation=request.getParameterValues("seoperation");
		String []seplace=request.getParameterValues("seplace");
		String []secountry=request.getParameterValues("secountry");
		for (int i=0;i<sename.length;i++) {
			Sealentry seal=new Sealentry();
			seal.setSeid(isid);
			seal.setSeentry(Methods.getUUID());
			seal.setSeuserid(methods.getUser(request));
			seal.setSename(sename[i]);
			seal.setSelive(selive[i]);
			seal.setSenumber(senumber[i]);
			seal.setSephysical(sephysical[i]);
			seal.setSecategory(secategory[i]);
			seal.setSeoperation(seoperation[i]);
			seal.setSeplace(seplace[i]);
			seal.setSecountry(secountry[i]);
			isotdao.sealeAdd(seal);
		}
		pw.print("1");
	}
	/**
	 * 删除-密封源
	 * @param request
	 * @param type
	 * @param seid
	 */
	public void sealDel(HttpServletRequest request,String type,String seid) {
		Sealentry seal=new Sealentry();
		seal.setSeentry(type);
		seal.setSestate(0);
		isotdao.updateSeal(seal);
	}
	/**
	 * 修改-密封源界面-发现信息
	 * @param request
	 * @param type
	 * @param seid
	 */
	public void updateSeal(HttpServletRequest request,String type,String seid) {
		Isotopes isot= isotdao.selectSeal(type);
		request.setAttribute("seal", isot);
	}
	/**
	 * 修改-密封源信息
	 * @param request
	 * @param response
	 * @param seal
	 */
	public void upSeal(HttpServletRequest request,HttpServletResponse response,Sealentry seal) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		isotdao.updateSeal(seal);
		pw.print("1");
	}
	/**
	 * 添加安全措施表
	 * @param request
	 * @param type
	 */
	public void sendSafetysheet(HttpServletRequest request,String type,String num1,String num2) {
		List<Isotopes> raidall= isotdao.queryAux(type);

		List<Safetysheet>safetAll1= SafetDao.queryRay(Integer.parseInt(num1));
		for (Isotopes xray : raidall) {
			for (Safetysheet sa : safetAll1) {
				//判断是否有已选取安全措施表
				if(xray.getXauxiliary().getAucategory().equals(num1) && xray.getXauxiliary().getAunumber().equals(sa.getSaname())) {//已选取
					sa.setSastate("checked");
				}
			}
		}
		List<Safetysheet>safetAll2= SafetDao.queryRay(Integer.parseInt(num2));
		for (Isotopes xray : raidall) {
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
	}
	/**
	 * 添加安全措施表(bug)
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void addSa(HttpServletRequest request,HttpServletResponse response,String isid) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String[] num1=request.getParameterValues("num1");
		List<Isotopes> raidall= isotdao.queryAux(isid);
		int index=0;
		int num=0;
		String auserial=null;
		try {
			for (Isotopes xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
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
				for (Isotopes xraydevice : raidall) {
					//判断页面选中表数据库中是否存在
					if(string.equals(xraydevice.getXauxiliary().getAunumber())) {//已存在
						index=1;
					}
				}
				if(index==0) {
					//数据库中不存在就新建添加数据
					Xauxiliary auxi=new Xauxiliary();
					auxi.setAuid(isid);
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
			for (Isotopes xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
					auserial=xraydevice.getXauxiliary().getAuserial();
					Xauxiliary au=new Xauxiliary();
					au.setAuserial(auserial);
					au.setAuexisting(0);
					raydevicedao.qudatAuxi(au);
			}
		}
		pw.print("1");
	}
	/**
	 * 修改辐射安全措施
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void file(HttpServletRequest request,HttpServletResponse response ,String isid) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Isotopes> raidall= isotdao.queryAux(isid);//查询安全措施表全部信息
		for (Isotopes xra : raidall) {
			String page=xra.getXauxiliary().getAuserial();//安全措施表编号
			List<Object> list1 = methods.handleFileUpload(request, page, ".docx", "D://aim//");
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
	 * 向查看（开放性同位素）详情页面发送信息
	 * @param request
	 * @param type
	 */
	public void isDetail(HttpServletRequest request,String type) {
		List<Isotopes>isotallr= isotdao.radioAll(type);
		List<Isotopes>isotalls=isotdao.sealAll(type);
		List<Isotopes>issafetysheet= isotdao.queryAux(type);
		request.setAttribute("isotallr", isotallr);
		request.setAttribute("isotalls", isotalls);
		request.setAttribute("issafet", issafetysheet);
		sendID(request,type);
	}
	/**
	 * 删除放射源
	 * @param request
	 * @param type
	 */
	public void upIsot(HttpServletRequest request,String type) {
		Isotopes isot= new Isotopes();
		isot.setIsid(type);
		isot.setIsstate(0);
		isotdao.upIsotopes(isot);
	}
	/**
	 * 向修改放射源页面发送信息
	 * @param request
	 * @param type
	 */
	public void isotUpdate(HttpServletRequest request,String type) {
		Isotopes isot= isotdao.queryIsid(type);
		request.setAttribute("isotid",isot);
	}
	/**
	 * 修改放射源信息
	 * @param request
	 * @param type
	 */
	public void isoname(HttpServletResponse response,HttpServletRequest request,Isotopes isot) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		isotdao.upIsotopes(isot);
		pw.print("1");
	}
}
