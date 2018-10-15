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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
		int each =13; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Nonseal> nonsall= nonsealdao.nonsAll();
			index=(nonsall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Nonseal> nonsall= nonsealdao.nonsAll();
		methods.sendPage(page, pag, starting, end, index, request, jnum);
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
		if("".equals(nons.getNolevel())||nons.getNolevel()==null) {
			
		}else {
			if(nons.getNolevel().equals("甲")) {
				nons.setA("checked");
			}else if(nons.getNolevel().equals("乙")) {
				nons.setB("checked");
			}else if(nons.getNolevel().equals("丙")) {
				nons.setC("checked");
			}
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
		try {
		for (int i=0;i<roquantity.length;i++) {
			boolean bool= methods.judgeDigital(roquantity[i]);
			if(!bool) {
				pw.print("2");//请检查日最大操作量格式是否正确
				return;
			}
			if(!methods.judgeDigital(royear[i])) {
				pw.print("3");//请检查年最大操作量格式是否正确
				return;
			}
			if(!methods.judgeDigital(rocorrection[i])) {
				pw.print("4");//请检查操作修正因子格式是否正确
				return;
			}
			if(!methods.judgeDigital(rotoxicity[i])) {
				pw.print("5");//请检查毒性修正因子格式是否正确
				return;
			}
		}
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
			//计算日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
//			BigInteger num1= methods.strTurn(roquantity[i]);//日最大操作量
//			BigInteger num2= methods.strTurn(rotoxicity[i]);//毒性修正因子
//			BigInteger num3= methods.strTurn(rocorrection[i]);//操作修正因子
//			robiggest=(num1.multiply(num2)).divide(num3);
//			room.setRobiggest(String.valueOf(robiggest));// 日等效最大操作量
//			System.out.println("robiggest="+robiggest);
//			String str=String.valueOf(robiggest);
//			int num=str.indexOf("0");
//			String str2=str.substring(1,num);//截取第2位数字到后几位数字
//			String str3=str.substring(0,1);//截取第一位
//   		System.out.println("str2="+str2);
//			System.out.println("str3="+str3);
//			String index=str3+"."+str2+"*"+"10"+"^"+(str.length()-1);
//			System.out.println("index="+index);
			//计算日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
			Double roqud= methods.getDigital(roquantity[i]);//日最大操作量
			int roqui= methods.getPower(roquantity[i]);//日最大操作量

			Double rotod= methods.getDigital(rotoxicity[i]);//毒性修正因子
			int rotoi= methods.getPower(rotoxicity[i]);//毒性修正因子

			Double rocod= methods.getDigital(rocorrection[i]);//操作修正因子
			int rocoi= methods.getPower(rocorrection[i]);//操作修正因子

			//计算日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
			Double numd=(roqud*rotod)/rocod;//小数部分计算

			Double doubleNumber= methods.getTwoDecimal(numd);//截取小数点后两位

			int intNumber=roqui+rotoi-rocoi;//计算10次方部分
			String robiggest=doubleNumber+"*"+"10^"+intNumber;

			room.setRobiggest(robiggest);// 日等效最大操作量
			nonsealdao.roomAdd(room);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		Nonseal nons=new Nonseal();
		nons.setNoid(noid);
		nons.setNobuiding(nobuiding);
		nons.setNofloor(nofloor);
		nons.setNoroomid(noroomid);
		nons.setNolevel(nolevel);
		nonsealdao.updateNonseal(nons);
		nons.setNolimit(judgeExcessive(noid));//是否超出限值
		nonsealdao.updateNonseal(nons);
		pw.print("1");
	}
	/**
	 * 叠加同一个工作场所内所有核素的日等效最大操作量判断是否超标
	 * @return
	 */
	public String judgeExcessive(String type) {
		long num=0;
		String nolevelj=null;//场所等级
		String yesorno=null;//是或否
		List<Nonseal>nonsall= nonsealdao.queryRoom(type);
		for (Nonseal nonseal : nonsall) {
			String str=nonseal.getRoomnuclide().getRobiggest();//日等效最大操作量
			 num+=methods.strTurn(str);
			 nolevelj=nonseal.getNolevel();
		}
        if("".equals(nolevelj)||nolevelj==null) {
        	
        }else {
    		if(nolevelj.equals("甲")) {
    			//
    			System.out.println("甲场所需求中没有提到默认为否");
    			yesorno="否";
    		}else if(nolevelj.equals("乙")) {
    			//乙级场所不超过4*10^9 Bq
    			long b=methods.strTurn("4*10^9");
    			if(num>b) {
    				yesorno="是";
    			}else {
    				yesorno="否";
    			}
    		}else if(nolevelj.equals("丙")) {
    			//丙级场所不超过2*10^7 Bq
    			long c=methods.strTurn("2*10^7");
    			if(num>c) {
    				yesorno="是";
    			}else {
    				yesorno="否";
    			}
    		}
        }

		return yesorno;
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
		//查询是否已有“辐射安全许可证”、“环境影响评价批复”、“环保竣工验收批复”。
		Nonseal nons= nonsealdao.queryNonsid(type);
		if(nons.getNolicense()!=null&&nons.getNolicense()==1) {
			//辐射安全许可证已选取
			nons.setNolicensebox("checked");
		} 
		if(nons.getNoimpact()!=null&&nons.getNoimpact()==1) {
			//环境影响评价批复已选取
			nons.setNoimpactbox("checked");
		}
		if(nons.getNoreply()!=null&&nons.getNoreply()==1) {
			//环保竣工验收批复已选取
			nons.setNoreplybox("checked");
		}
		request.setAttribute("nons", nons);
	}
	/**
	 * 添加安全措施表(bug)
	 * @param request
	 * @param response
	 * @param raid
	 */
	public void addSa(HttpServletRequest request,HttpServletResponse response,String type,Nonseal nons) {
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
		
		//添加是否已有“辐射安全许可证”、“环境影响评价批复”、“环保竣工验收批复”。
		if(nons.getNolicense()==null) {
			//辐射安全许可证未选取
			nons.setNolicense(0);
		} 
		if(nons.getNoimpact()==null) {
			//环境影响评价批复未选取
			nons.setNoimpact(0);
		}
		if(nons.getNoreply()==null) {
			//环保竣工验收批复未选取
			nons.setNoreply(0);
		}
		nonsealdao.updateNonseal(nons);
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
			List<Object> list1 = methods.handleFileUpload(request, page, "D://aim//");
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
		//查询是否已有“辐射安全许可证”、“环境影响评价批复”、“环保竣工验收批复”。
		if(nons.getNolicense()!=null&&nons.getNolicense()==1) {
			//辐射安全许可证已选取
			nons.setNolicensebox("checked");
		} 
		if(nons.getNoimpact()!=null&&nons.getNoimpact()==1) {
			//环境影响评价批复已选取
			nons.setNoimpactbox("checked");
		}
		if(nons.getNoreply()!=null&&nons.getNoreply()==1) {
			//环保竣工验收批复已选取
			nons.setNoreplybox("checked");
		}
		if("".equals(nons.getNolimit())||nons.getNolimit()==null) {
			
		}else {
    		if(nons.getNolimit().equals("是")) {
    			nons.setNolimitcolor("color:red");
    		}
		}
		List<Nonseal> nonsall=nonsealdao.queryRoom(type);
		List<Nonseal> issafet= nonsealdao.queryNons(type);
		request.setAttribute("nonsall", nonsall);
		request.setAttribute("issafet", issafet);
		request.setAttribute("nons", nons);
		sendId(request, type);

		
	}
	/**
	 * 非密封放射性物质模糊查询
	 * @param request
	 * @param name
	 */
	public void fuzzyNonseal(HttpServletRequest request,String name) {
		int each =3; //每页显示条数*
		int index = 1;//页面传来第几页
		int end =1;//末尾页数
		int starting=1;//起始页面
		String pag = request.getParameter("newpaging");
		String jnum = request.getParameter("end");//结束页面
		if(!("".equals(jnum)||jnum==null)) {
			List<Nonseal> nonsall= nonsealdao.fuzzyNons(name);
			index=(nonsall.size()/each)+1;
		}
		Page page = null;
		if("".equals(pag)||pag==null) {
			page = PageHelper.startPage(index, each);//第几页   每页显示条数
		}else {
			index = Integer.parseInt(pag);
			page = PageHelper.startPage(index, each);
		}
		List<Nonseal> nonsall= nonsealdao.fuzzyNons(name);
		methods.sendPage(page, pag, starting, end, index, request, jnum);
		request.setAttribute("nonsall", nonsall);
		request.setAttribute("name", name);
	}
	/**
	 * 删除房间中核素
	 * @param request
	 * @param ronumber
	 */
	public void roomDel(HttpServletRequest request,String ronumber) {
		Roomnuclide room=new Roomnuclide();
		room.setRonumber(ronumber);
		room.setRostate(0);
		nonsealdao.updateRoom(room);
	}
	/**
	 * 向修改房间中核素界面发送信息
	 * @param request
	 * @param ronumber
	 * @param roid
	 */
	public void  updateRoom(HttpServletRequest request,String ronumber,String roid) {
		Nonseal nons= nonsealdao.roomNumber(ronumber);
        request.setAttribute("nons", nons);		
	}
	/**
	 * 修改房间中核素信息
	 * @param request
	 * @param response
	 * @param room
	 */
	public void upRoompost(HttpServletRequest request,HttpServletResponse response,Roomnuclide room) {
		PrintWriter pw=null;
		try {
			pw=response.getWriter();
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean bool= methods.judgeDigital(room.getRoquantity());
		if(!bool) {
			pw.print("2");//请检查日最大操作量格式是否正确
			return;
		}
		if(!methods.judgeDigital(room.getRoyear())) {
			pw.print("3");//请检查年最大操作量格式是否正确
			return;
		}
		if(!methods.judgeDigital(room.getRocorrection())) {
			pw.print("4");//请检查操作修正因子格式是否正确
			return;
		}
		if(!methods.judgeDigital(room.getRotoxicity())) {
			pw.print("5");//请检查毒性修正因子格式是否正确
			return;
		}
		
		
		//计算日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
		Double roqud= methods.getDigital(room.getRoquantity());//日最大操作量
		int roqui= methods.getPower(room.getRoquantity());//日最大操作量

		Double rotod= methods.getDigital(room.getRotoxicity());//毒性修正因子
		int rotoi= methods.getPower(room.getRotoxicity());//毒性修正因子

		Double rocod= methods.getDigital(room.getRocorrection());//操作修正因子
		int rocoi= methods.getPower(room.getRocorrection());//操作修正因子

		//计算日等效最大操作量=(日最大操作量×毒性修正因子÷操作修正因子)
		Double numd=(roqud*rotod)/rocod;//小数部分计算
		Double doubleNumber= methods.getTwoDecimal(numd);//截取小数点后两位
		int intNumber=roqui+rotoi-rocoi;//计算10次方部分
		String robiggest=doubleNumber+"*"+"10^"+intNumber;
		room.setRobiggest(robiggest);// 日等效最大操作量
		nonsealdao.updateRoom(room);
		judgeExcessive(room.getRoid());
		Nonseal nons=new Nonseal();
		nons.setNoid(room.getRoid());
		nons.setNolimit(judgeExcessive(room.getRoid()));//是否超出限值
		nonsealdao.updateNonseal(nons);
		pw.print("1");
	}
}
