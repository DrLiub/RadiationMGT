package com.cncompute.service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cncompute.dao.NonsealDao;
import com.cncompute.dao.SafetysheetDao;
import com.cncompute.dao.XraydeviceDao;
import com.cncompute.pojo.Nonseal;
import com.cncompute.pojo.Roomnuclide;
import com.cncompute.pojo.Safetysheet;
import com.cncompute.pojo.Xauxiliary;
import com.cncompute.repeat.Methods;
/**
 * 非密封放射性物质表DAO层
 * @author Admin
 * 2018年9月10日14:34:55
 */
@Service
@Transactional
public class NonsealService {
	@Autowired
	private NonsealDao nonsealdao;
	@Autowired
	private Methods methods;
	@Autowired
	private SafetysheetDao SafetDao;
	@Autowired
	private XraydeviceDao raydevicedao;
	/**
	 * 向非密封放射性物质显示界面发送信息
	 * @param request
	 */
	public void nonsealAll(HttpServletRequest request) {
		List<Nonseal> nonsall= nonsealdao.nonsAll();
		request.setAttribute("nonsall", nonsall);
	}
	/**
	 * 添加-非密封放射性物质
	 * @param response
	 * @param request
	 * @param nons
	 */
	public void nonsAdd(HttpServletResponse response,HttpServletRequest request,Nonseal nons) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		nons.setNoid(Methods.getUUID());
		nons.setNouserid(methods.getUser(request));
		nonsealdao.nonsAdd(nons);
		pw.print("1");
	}
	/**
	 * 删除-非密封放射性物质
	 * @param request
	 * @param type
	 */
	public void nonsDelete(HttpServletRequest request,String type) {
		Nonseal nons=new Nonseal();
		nons.setNoid(type);
		nons.setNostate(0);
		nonsealdao.updateNonseal(nons);
	}
	/**
	 * 向页面发送ID
	 * @param request
	 * @param type
	 */
	public void sendId(HttpServletRequest request,String type) {
		Nonseal nons=new Nonseal();
		nons.setNoid(type);
		request.setAttribute("nonsid", nons);
	}
	/**
	 * 向修改非密封放射性物质发送信息
	 * @param request
	 * @param type
	 */
	public void sendNons(HttpServletRequest request,String type) {
		Nonseal nons=nonsealdao.queryNonsid(type);
		request.setAttribute("nonsid", nons);
	}
	/**
	 * 修改非密封放射性物质
	 * @param request
	 * @param response
	 * @param nons
	 */
	public void updateNons(HttpServletRequest request,HttpServletResponse response,Nonseal nons) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		nonsealdao.updateNonseal(nons);
		pw.print("1");
	}
	/**
	 * 向非密封放射性物质添加界面发送信息
	 * @param request
	 * @param type
	 */
	public void sendContent(HttpServletRequest request,String type) {
		Nonseal nons= nonsealdao.queryNonsid(type);
		if(nons.getNolevel().equals("甲")) {
			nons.setA("checked");
		}else if(nons.getNolevel().equals("乙")) {
			nons.setB("checked");
		}else if(nons.getNolevel().equals("丙")) {
			nons.setC("checked");
		}
		request.setAttribute("nons", nons);
		sendId(request, type);
	}
	/**
	 * 非密封放射性物质添加
	 * @param request
	 * @param response
	 * @param noid
	 * @param robuiding
	 * @param rofloor
	 * @param roroomid
	 * @param rolevel
	 */
	public void roomnuAdd(HttpServletRequest request,HttpServletResponse response,String noid,String nobuiding,String nofloor,String noroomid,String nolevel) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String roname[]=request.getParameterValues("roname");//核素的名称
		String rochemical[]=request.getParameterValues("rochemical");// 理化性质
		String roway[]=request.getParameterValues("roway");;//来源方式
		String roquantity[]=request.getParameterValues("roquantity");// 日最大操作量
		String royear[]=request.getParameterValues("royear");// 年最大操作量
		String rooperation[]=request.getParameterValues("rooperation");//操作方式
		String rocorrection[]=request.getParameterValues("rocorrection");//操作修正因子
		String rotoxicity[]=request.getParameterValues("rotoxicity");//毒性修正因子
		String rouse[]=request.getParameterValues("rouse");// 用途
		String rostorageway[]=request.getParameterValues("rostorageway");// 贮存方式
		String rostorage[]=request.getParameterValues("rostorage");// 贮存地点
		long robiggest = 0;//日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
		for(int i=0;i<roname.length;i++) {
			Roomnuclide room=new Roomnuclide();
			room.setRoid(noid);
			room.setRonumber(Methods.getUUID());// 信息编号
			room.setRouserid(methods.getUser(request));//当前登录ID
			room.setRoname(roname[i]);
			room.setRochemical(rochemical[i]);
			room.setRoway(roway[i]);
			room.setRoquantity(roquantity[i]);
			room.setRoyear(royear[i]);
			room.setRooperation(rooperation[i]);
			room.setRocorrection(rocorrection[i]);
			room.setRotoxicity(rotoxicity[i]);
			room.setRouse(rouse[i]);
			room.setRostorageway(rostorageway[i]);
			room.setRostorage(rostorage[i]);
			try {
				long num1 = Long.parseLong(roquantity[i]);//日最大操作量
				long num2 = Long.parseLong(rotoxicity[i]);//毒性修正因子
				long num3 = Long.parseLong(rocorrection[i]);//操作修正因子
				robiggest=(num1*num2)/num3;
			} catch (Exception e) {
				// TODO: handle exception
			}
			room.setRobiggest(String.valueOf(robiggest));// 日等效最大操作量
			nonsealdao.roomAdd(room);
		}
		Nonseal nons=new Nonseal();
		nons.setNoid(noid);
		nons.setNobuiding(nobuiding);
		nons.setNofloor(nofloor);
		nons.setNoroomid(noroomid);
		nons.setNolevel(nolevel);
//		nons.setNolimit(nolimit);//是否超出限值
		nonsealdao.updateNonseal(nons);
		pw.print("1");
	}
	/**
	 * 添加安全措施表
	 * @param request
	 * @param type
	 */
	public void sendSafetysheet(HttpServletRequest request,String type,String num1) {
		List<Nonseal> raidall= nonsealdao.queryNons(type);

		List<Safetysheet>safetAll1= SafetDao.queryRay(Integer.parseInt(num1));
		for (Nonseal xray : raidall) {
			for (Safetysheet sa : safetAll1) {
				//判断是否有已选取安全措施表
				if(xray.getXauxiliary().getAucategory().equals(num1) && xray.getXauxiliary().getAunumber().equals(sa.getSaname())) {//已选取
					sa.setSastate("checked");
				}
			}
		}
		request.setAttribute("safetAll1", safetAll1);
		sendId(request,type);
	}
	/**
	 * 添加安全措施表(bug)
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void addSa(HttpServletRequest request,HttpServletResponse response,String type) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		String[] num1=request.getParameterValues("num1");
		List<Nonseal> raidall= nonsealdao.queryNons(type);
		int index=0;
		int num=0;
		String auserial=null;
		try {
			for (Nonseal xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
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
				for (Nonseal xraydevice : raidall) {
					//判断页面选中表数据库中是否存在
					if(string.equals(xraydevice.getXauxiliary().getAunumber())) {//已存在
						index=1;
					}
				}
				if(index==0) {
					//数据库中不存在就新建添加数据
					Xauxiliary auxi=new Xauxiliary();
					auxi.setAuid(type);
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
			for (Nonseal xraydevice : raidall) {//判读数据库中是否存有新修改的安全措施表，如果没有就删除原来的
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
	public void file(HttpServletRequest request,HttpServletResponse response ,String type) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Nonseal> raidall= nonsealdao.queryNons(type);//查询安全措施表全部信息
		for (Nonseal xra : raidall) {
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
	 * 向查看详情页面发送信息
	 * @param request
	 * @param type
	 */
	public void isDetail(HttpServletRequest request,String type) {
		Nonseal nons= nonsealdao.queryNonsid(type);
		List<Nonseal> nonsall=nonsealdao.queryRoom(type);
		List<Nonseal> issafet= nonsealdao.queryNons(type);
		request.setAttribute("nonsall", nonsall);
		request.setAttribute("issafet", issafet);
		request.setAttribute("nons", nons);
		sendId(request, type);
	}
}
