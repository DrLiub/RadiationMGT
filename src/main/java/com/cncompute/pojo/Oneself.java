package com.cncompute.pojo;

import java.io.Serializable;
/**
 * 表oneself(辐射环境监测数据)表的实现类
 * @author Admin
 *2018年8月21日14:03:47
 */
public class Oneself implements Serializable {
	private static final long serialVersionUID = 6478041039570975898L;
	private String noid;// 表ID
	private Integer notag;// 1位单位2位委托
	private String nounit;// 单位名称
	private String noproject;// 监测项目名称
	private String nonumber;// 监测项目编号
	private String notimeno;// 监测时间
	private String nopeople;// 监测执行人
	private String noplace;// 监测地点
	private String notype;// 选择监测类型
	private String nodata;// 监测数据地址
	private String nouserid;// 当前登录用户ID
	private String notime;// 当前时间
	private Integer nostate;// 表状态0删除1正常
	private String nonumberid;//信息ID
	private String maplng;//经度
	private String maplat;//维度
	private Integer maplong;//覆盖点个数
	public Oneself() {
	}
	public Oneself(String noid, Integer notag, String nounit, String noproject, String nonumber, String notimeno,
			String nopeople, String noplace, String notype, String nodata, String nouserid, String notime,
			Integer nostate, String nonumberid, String maplng, String maplat, Integer maplong) {
		this.noid = noid;
		this.notag = notag;
		this.nounit = nounit;
		this.noproject = noproject;
		this.nonumber = nonumber;
		this.notimeno = notimeno;
		this.nopeople = nopeople;
		this.noplace = noplace;
		this.notype = notype;
		this.nodata = nodata;
		this.nouserid = nouserid;
		this.notime = notime;
		this.nostate = nostate;
		this.nonumberid = nonumberid;
		this.maplng = maplng;
		this.maplat = maplat;
		this.maplong = maplong;
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public Integer getNotag() {
		return notag;
	}
	public void setNotag(Integer notag) {
		this.notag = notag;
	}
	public String getNounit() {
		return nounit;
	}
	public void setNounit(String nounit) {
		this.nounit = nounit;
	}
	public String getNoproject() {
		return noproject;
	}
	public void setNoproject(String noproject) {
		this.noproject = noproject;
	}
	public String getNonumber() {
		return nonumber;
	}
	public void setNonumber(String nonumber) {
		this.nonumber = nonumber;
	}
	public String getNotimeno() {
		return notimeno;
	}
	public void setNotimeno(String notimeno) {
		this.notimeno = notimeno;
	}
	public String getNopeople() {
		return nopeople;
	}
	public void setNopeople(String nopeople) {
		this.nopeople = nopeople;
	}
	public String getNoplace() {
		return noplace;
	}
	public void setNoplace(String noplace) {
		this.noplace = noplace;
	}
	public String getNotype() {
		return notype;
	}
	public void setNotype(String notype) {
		this.notype = notype;
	}
	public String getNodata() {
		return nodata;
	}
	public void setNodata(String nodata) {
		this.nodata = nodata;
	}
	public String getNouserid() {
		return nouserid;
	}
	public void setNouserid(String nouserid) {
		this.nouserid = nouserid;
	}
	public String getNotime() {
		return notime;
	}
	public void setNotime(String notime) {
		this.notime = notime;
	}
	public Integer getNostate() {
		return nostate;
	}
	public void setNostate(Integer nostate) {
		this.nostate = nostate;
	}
	public String getNonumberid() {
		return nonumberid;
	}
	public void setNonumberid(String nonumberid) {
		this.nonumberid = nonumberid;
	}
	public String getMaplng() {
		return maplng;
	}
	public void setMaplng(String maplng) {
		this.maplng = maplng;
	}
	public String getMaplat() {
		return maplat;
	}
	public void setMaplat(String maplat) {
		this.maplat = maplat;
	}
	public Integer getMaplong() {
		return maplong;
	}
	public void setMaplong(Integer maplong) {
		this.maplong = maplong;
	}
}
