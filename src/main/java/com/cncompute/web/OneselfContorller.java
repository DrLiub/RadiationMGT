package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cncompute.pojo.Entrust;
import com.cncompute.pojo.Oneself;
import com.cncompute.service.OneselfService;

/**
 * 表oneself(辐射环境监测数据)表的控制层
 * @author Admin
 *2018年8月21日14:06:51
 */
@Controller
public class OneselfContorller {
	@Autowired
	private OneselfService onservice;
    /**
     * 向单位显示界面发送数据
     * @param request
     * @param notag
     * @return
     */
	@RequestMapping(value="reentrust" ,method=RequestMethod.GET)
	public String reEntrust(HttpServletRequest request) {
		onservice.senDonunitpreview(request);
		return "registrpage/onunitpreview";
	}
	/**
	 * 添加单位界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="enaddunit",method=RequestMethod.GET)
	public String enaddUnit(HttpServletRequest request) {
		return "registrpage/onunitpreviewadd";
	}
	/**
	 * 添加单位
	 * @param request
	 * @param response
	 * @param entr
	 */
	@RequestMapping(value="enunitpost",method=RequestMethod.POST)
	public void enunitPost(HttpServletRequest request ,HttpServletResponse response,Entrust entr) {
		onservice.addunit(request, response, entr);
	}
	/**
	 * 单位自行监测数据详情界面
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="reunit",method=RequestMethod.GET)
	public String reunit(HttpServletRequest request,String type) {
		onservice.reunit(request, type);
		return "registrpage/reunit";
	}
	/**
	 * 添加单位自行监测数据界面-室内
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="onunitadd",method=RequestMethod.GET)
	public String onUnitadd(HttpServletRequest request,String type) {
		onservice.sendNoid(request, type);
		return"registrpage/reunitadd";
	}
	/**
	 * 添加单位自行监测数据界面-室外
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value="onoutdoor",method=RequestMethod.GET)
	public String outdoorAdd(HttpServletRequest request,String type) {
		onservice.sendNoid(request, type);
		return"registrpage/reunitadd2";
	}
	/**
	 * 添加添加单位自行监测数据
	 * @param request
	 * @param response
	 * @param noid
	 */
	@RequestMapping(value="onunitaddp",method=RequestMethod.POST)
	public void onUnitaddp(HttpServletRequest request,HttpServletResponse response,String noid) {
		onservice.addUnitpost(request, response, noid,1);
	}
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @param nodata
	 */
	@RequestMapping(value="onpage",method=RequestMethod.GET)
	public void onpage(HttpServletRequest request,HttpServletResponse response,String page) {
		if("".equals(page)||page==null) {
			return;
		}
		onservice.download(request, response, page);
	}
	/**
	 * 删除单位自行监测数据
	 * @param request
	 * @param onid
	 */
	@RequestMapping(value="onesdelete",method=RequestMethod.GET)
	public String onesDelete(HttpServletRequest request,String onid,String onnum) {
		onservice.onDelect(request, onid,onnum);
		return "registrpage/reunit";
	}
	/**
	 * 修改单位自行监测数据界面
	 * @param request
	 * @param onid
	 * @param onnum
	 * @return
	 */
	@RequestMapping(value="onunp",method=RequestMethod.GET)
	public String onUpdate(HttpServletRequest request,String onnum) {
		onservice.onOnnumber(request, onnum);
		return "registrpage/reunitupdate";
	}
	/**
	 * 修改单位自行监测数据
	 * @param request
	 * @param one
	 */
	@RequestMapping(value="onsupdate",method=RequestMethod.POST)
	public void onUpdatePost(HttpServletRequest request,Oneself one,HttpServletResponse response) {
		onservice.onUpdate(request, one, response);
	}
	/**
	 * 委托检测数据界面
	 * @param request
	 */
	@RequestMapping(value="onentrust",method=RequestMethod.GET)
	public String onEntrust(HttpServletRequest request) {
		onservice.queryEntrust(request);
		return "registrpage/onentrust";
	}
	/**
	 * 添加委托检测数据界面
	 * @param request
	 * @return
	 */
	@RequestMapping(value="onentrustadd",method=RequestMethod.GET)
	public String onEntrustadd(HttpServletRequest request) {
		return "registrpage/onentrustadd";
	}
	/**
	 * 添加委托检测数据
	 * @param request
	 * @param one
	 * @param response
	 */
	@RequestMapping(value="onentadd",method=RequestMethod.POST)
	public void onEntadd(HttpServletRequest request,Oneself one,HttpServletResponse response) {
		onservice.onEntaddPost(request, response, 2);
	}
	/**
	 * 删除委托检测数据
	 * @param request
	 * @param onnum
	 */
	@RequestMapping(value="onendelete",method=RequestMethod.GET)
	public String onenDelete(HttpServletRequest request,String onnum) {
		onservice.onDelete(request, onnum);
		onservice.queryEntrust(request);
		return "registrpage/onentrust";
	}
	/**
	 * 修改委托检测数据界面
	 * @param request
	 * @param onnum
	 * @return
	 */
	@RequestMapping(value="onmodify",method=RequestMethod.GET)
	public String onModify(HttpServletRequest request,String onnum) {
		onservice.onModify(request, onnum);
		return "registrpage/onentrustmodify";
	}
	/**
	 * 删除单位自行监测数据
	 * @param request
	 * @param meid
	 * @return
	 */
	@RequestMapping(value="onenup",method=RequestMethod.GET)
	public String enDelete(HttpServletRequest request,String enid) {
		onservice.onDel(request, enid);
		onservice.senDonunitpreview(request);
		return "registrpage/onunitpreview";
	}
	/**
	 * 修改单位自行监测数据-界面
	 * @param request
	 * @param enid
	 * @return
	 */
	@RequestMapping(value="onupdatyen",method=RequestMethod.GET)
	public String ondatyen(HttpServletRequest request,String enid) {
		onservice.updateEn(request, enid);
		return"registrpage/entrustqudate";
	}
	/**
	 * 修改单位自行监测数据
	 * @param request
	 * @param response
	 * @param entr
	 */
	@RequestMapping(value="onupentrust",method=RequestMethod.POST)
	public void uodateEn(HttpServletRequest request,HttpServletResponse response,Entrust entr) {
		onservice.updateEntrust(request, response, entr);
	}
	/**
	 * 地图界面
	 * @param request
	 * @param type
	 */
	@RequestMapping(value="onmap",method=RequestMethod.GET)
	public String onmap(HttpServletRequest request,String type) {
		onservice.sendNoid(request, type);
		return"registrpage/map";
	}
	/**
	 * 添加获取覆盖物信息
	 * @param request
	 * @param response
	 * @param maplng
	 * @param maplat
	 * @param maplong
	 */
	@RequestMapping(value="ongetmap",method=RequestMethod.GET)
	public void getMap(HttpServletRequest request,HttpServletResponse response,Oneself ones) {
		onservice.getMap(request, response, ones);
	}
}
