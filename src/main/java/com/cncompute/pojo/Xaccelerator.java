package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 射线装置-加速器表实现类
 * @author Admin
 *2018年8月30日14:55:05
 */
public class Xaccelerator implements Serializable {
	private static final long serialVersionUID = -8231712966514480696L;
	private String acid;// 表ID
	private String acmodel;//名称型号
	private String acmanufacturer;//生产厂家
	private String acion;// 加速离子
	private String acenergy;//能量
	private String acstrong;// 流强
	private String acuse;// 用途
	private String acnote;// 备注
	private String acwaste;//废靶类型
	private String acwastenum;//废靶数量
	private String acwasteactivity;//废靶总活度
	private String acradioactive;// 废靶主要感生放射性
	private String acwastewhere;//废靶废物去向
	private String acgasnum;//气态-数量
	private String acgasactivity;//气态-总活度
	private String acgasradioactive;//气态-主要感生放射性
	private String acgaswhere;//气态-废物去向
	private String acliquidnum;//液态-数量
	private String acliquidactivity;//液态-总活度
	private String acliquidradioactive;//液态-主要感生放射性
	private String acliquidwhere;//液态-废物去向
	private String acliquidnactivityumber;//固态-数量
	private String acsolidactivity;//固态-总活度
	private String acsolidradioactive;//固态-主要感生放射性
	private String acsolidwhere;//固态-废物去向
	private String acusetime;//投入使用时间
	private String acbuilding;//楼宇
	private String acroom;// 房间信息
	private String acuserid;//当前登录用户
	private Date actime;//当前时间
	private Integer acstate;//表状态
	private Xraydevice xraydevice;//射线装置表实现类
	Set<Xraydevice> xraydevices=new HashSet<Xraydevice>();
	public Xaccelerator() {
	}
	public Xaccelerator(String acid, String acmodel, String acmanufacturer, String acion, String acenergy,
			String acstrong, String acuse, String acnote, String acwaste, String acwastenum, String acwasteactivity,
			String acradioactive, String acwastewhere, String acgasnum, String acgasactivity, String acgasradioactive,
			String acgaswhere, String acliquidnum, String acliquidactivity, String acliquidradioactive,
			String acliquidwhere, String acliquidnactivityumber, String acsolidactivity, String acsolidradioactive,
			String acsolidwhere, String acusetime, String acbuilding, String acroom, String acuserid, Date actime,
			Integer acstate, Xraydevice xraydevice, Set<Xraydevice> xraydevices) {
		this.acid = acid;
		this.acmodel = acmodel;
		this.acmanufacturer = acmanufacturer;
		this.acion = acion;
		this.acenergy = acenergy;
		this.acstrong = acstrong;
		this.acuse = acuse;
		this.acnote = acnote;
		this.acwaste = acwaste;
		this.acwastenum = acwastenum;
		this.acwasteactivity = acwasteactivity;
		this.acradioactive = acradioactive;
		this.acwastewhere = acwastewhere;
		this.acgasnum = acgasnum;
		this.acgasactivity = acgasactivity;
		this.acgasradioactive = acgasradioactive;
		this.acgaswhere = acgaswhere;
		this.acliquidnum = acliquidnum;
		this.acliquidactivity = acliquidactivity;
		this.acliquidradioactive = acliquidradioactive;
		this.acliquidwhere = acliquidwhere;
		this.acliquidnactivityumber = acliquidnactivityumber;
		this.acsolidactivity = acsolidactivity;
		this.acsolidradioactive = acsolidradioactive;
		this.acsolidwhere = acsolidwhere;
		this.acusetime = acusetime;
		this.acbuilding = acbuilding;
		this.acroom = acroom;
		this.acuserid = acuserid;
		this.actime = actime;
		this.acstate = acstate;
		this.xraydevice = xraydevice;
		this.xraydevices = xraydevices;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getAcmodel() {
		return acmodel;
	}
	public void setAcmodel(String acmodel) {
		this.acmodel = acmodel;
	}
	public String getAcmanufacturer() {
		return acmanufacturer;
	}
	public void setAcmanufacturer(String acmanufacturer) {
		this.acmanufacturer = acmanufacturer;
	}
	public String getAcion() {
		return acion;
	}
	public void setAcion(String acion) {
		this.acion = acion;
	}
	public String getAcenergy() {
		return acenergy;
	}
	public void setAcenergy(String acenergy) {
		this.acenergy = acenergy;
	}
	public String getAcstrong() {
		return acstrong;
	}
	public void setAcstrong(String acstrong) {
		this.acstrong = acstrong;
	}
	public String getAcuse() {
		return acuse;
	}
	public void setAcuse(String acuse) {
		this.acuse = acuse;
	}
	public String getAcnote() {
		return acnote;
	}
	public void setAcnote(String acnote) {
		this.acnote = acnote;
	}
	public String getAcwaste() {
		return acwaste;
	}
	public void setAcwaste(String acwaste) {
		this.acwaste = acwaste;
	}
	public String getAcwastenum() {
		return acwastenum;
	}
	public void setAcwastenum(String acwastenum) {
		this.acwastenum = acwastenum;
	}
	public String getAcwasteactivity() {
		return acwasteactivity;
	}
	public void setAcwasteactivity(String acwasteactivity) {
		this.acwasteactivity = acwasteactivity;
	}
	public String getAcradioactive() {
		return acradioactive;
	}
	public void setAcradioactive(String acradioactive) {
		this.acradioactive = acradioactive;
	}
	public String getAcwastewhere() {
		return acwastewhere;
	}
	public void setAcwastewhere(String acwastewhere) {
		this.acwastewhere = acwastewhere;
	}
	public String getAcgasnum() {
		return acgasnum;
	}
	public void setAcgasnum(String acgasnum) {
		this.acgasnum = acgasnum;
	}
	public String getAcgasactivity() {
		return acgasactivity;
	}
	public void setAcgasactivity(String acgasactivity) {
		this.acgasactivity = acgasactivity;
	}
	public String getAcgasradioactive() {
		return acgasradioactive;
	}
	public void setAcgasradioactive(String acgasradioactive) {
		this.acgasradioactive = acgasradioactive;
	}
	public String getAcgaswhere() {
		return acgaswhere;
	}
	public void setAcgaswhere(String acgaswhere) {
		this.acgaswhere = acgaswhere;
	}
	public String getAcliquidnum() {
		return acliquidnum;
	}
	public void setAcliquidnum(String acliquidnum) {
		this.acliquidnum = acliquidnum;
	}
	public String getAcliquidactivity() {
		return acliquidactivity;
	}
	public void setAcliquidactivity(String acliquidactivity) {
		this.acliquidactivity = acliquidactivity;
	}
	public String getAcliquidradioactive() {
		return acliquidradioactive;
	}
	public void setAcliquidradioactive(String acliquidradioactive) {
		this.acliquidradioactive = acliquidradioactive;
	}
	public String getAcliquidwhere() {
		return acliquidwhere;
	}
	public void setAcliquidwhere(String acliquidwhere) {
		this.acliquidwhere = acliquidwhere;
	}
	public String getAcliquidnactivityumber() {
		return acliquidnactivityumber;
	}
	public void setAcliquidnactivityumber(String acliquidnactivityumber) {
		this.acliquidnactivityumber = acliquidnactivityumber;
	}
	public String getAcsolidactivity() {
		return acsolidactivity;
	}
	public void setAcsolidactivity(String acsolidactivity) {
		this.acsolidactivity = acsolidactivity;
	}
	public String getAcsolidradioactive() {
		return acsolidradioactive;
	}
	public void setAcsolidradioactive(String acsolidradioactive) {
		this.acsolidradioactive = acsolidradioactive;
	}
	public String getAcsolidwhere() {
		return acsolidwhere;
	}
	public void setAcsolidwhere(String acsolidwhere) {
		this.acsolidwhere = acsolidwhere;
	}
	public String getAcusetime() {
		return acusetime;
	}
	public void setAcusetime(String acusetime) {
		this.acusetime = acusetime;
	}
	public String getAcbuilding() {
		return acbuilding;
	}
	public void setAcbuilding(String acbuilding) {
		this.acbuilding = acbuilding;
	}
	public String getAcroom() {
		return acroom;
	}
	public void setAcroom(String acroom) {
		this.acroom = acroom;
	}
	public String getAcuserid() {
		return acuserid;
	}
	public void setAcuserid(String acuserid) {
		this.acuserid = acuserid;
	}
	public Date getActime() {
		return actime;
	}
	public void setActime(Date actime) {
		this.actime = actime;
	}
	public Integer getAcstate() {
		return acstate;
	}
	public void setAcstate(Integer acstate) {
		this.acstate = acstate;
	}
	public Xraydevice getXraydevice() {
		return xraydevice;
	}
	public void setXraydevice(Xraydevice xraydevice) {
		this.xraydevice = xraydevice;
	}
	public Set<Xraydevice> getXraydevices() {
		return xraydevices;
	}
	public void setXraydevices(Set<Xraydevice> xraydevices) {
		this.xraydevices = xraydevices;
	}
}
