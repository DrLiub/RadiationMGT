package com.cncompute.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
     * 向单位自行监测数据界面发送数据
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
	public String outdoorAdd(HttpServletRequest request,String type,Oneself oneself) {
		onservice.sendNoidNonumberid(request, type,oneself);
		return"registrpage/reunitaddmap";
	}
	/**
	 * 添加添加单位自行监测数据-室内
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
	@ResponseBody
	public void onpage(HttpServletRequest request,HttpServletResponse response,String page) {
		if("".equals(page)||page==null) {
			return ;
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
	 * @param enid
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
	public String onmap(HttpServletRequest request,Oneself on,String type) {
		onservice.sendNonumberid(request, on, type);
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
	/**
	 * 添加室外数据
	 * @param request
	 * @param response
	 * @param ones
	 */
	@RequestMapping(value="onoutdooradd",method=RequestMethod.POST)
	public void onOutdooradd(HttpServletRequest request,HttpServletResponse response,Oneself ones,@RequestParam("file1") MultipartFile file) {
		onservice.addOutdoor(request, response, ones, file);
	}
	/**
	 * 查看地图上取点位置
	 * @param request
	 * @param nonumberid
	 * @return
	 */
	@RequestMapping(value="onview",method=RequestMethod.GET)
	public String onView(HttpServletRequest request,String nonumberid) {
		onservice.onView(request, nonumberid);
		return"registrpage/maplocation";
	}
	/**
	 * 修改-室外取点地图界面
	 * @return
	 */
	@RequestMapping(value="onviewupdate")
	public String onViewupdate(HttpServletRequest request,String nonumberid) {
		onservice.onView(request, nonumberid);
		return"registrpage/mapupdate";
	}
	/**
	 * 修改-室外取点地图
	 * @param request
	 * @param ones
	 * @return
	 */
	@RequestMapping(value="pnupmap",method=RequestMethod.GET)
	public String updateMap(HttpServletRequest request,Oneself ones) {
		onservice.updateMaplng(request, ones);
		return"registrpage/reunitupdate";
	}
	/**
	 * 委托检测数据模糊查询
	 * @param request
	 * @param name
	 * @return
	 */
	@RequestMapping(value="onenfuzzy",method=RequestMethod.GET)
	public String onenFuzzy(HttpServletRequest request,String name) {
		onservice.onenFuzzy(request, name,2);
		return "registrpage/onentrustfuzzy";
	}
	/**
	 * 单位自行监测数据模糊查询
	 * @param request
	 * @param name
	 * @return
	 */
	@RequestMapping(value="onunfuzzy",method=RequestMethod.GET)
	public String onunFuzzy(HttpServletRequest request,String name) {
		onservice.fuzzyOnun(request, name);
		return "registrpage/onunitpreviewfuzzy";
	}
//	/**
//	 * 查看历史变化趋势
//	 * @return
//	 */
//	@RequestMapping(value="onhistorys",method=RequestMethod.GET)
//	public String onHistory(HttpServletRequest request) {
//		System.out.println("功能未实行");
//		return"registrpage/history";
//	}
	/**
	 * 单位自行监测数据--模糊查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="onreunitfuzzy",method=RequestMethod.GET)
	public String onreunitFuzzy(HttpServletRequest request,String name,String type) {
		onservice.reunitFuzzy(request,name,type);
		return"registrpage/reunitfuzzy";
	}
}
