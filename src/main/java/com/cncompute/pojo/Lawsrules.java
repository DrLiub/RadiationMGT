package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 法律法规表实现类
 * @author Admin 
 * 2018年8月29日16:25:20
 */
public class Lawsrules implements Serializable {
	private static final long serialVersionUID = 545465322208150952L;
	private String laid;//表ID
	private String laname;//名称
	private String lanumber;//编号
	private String laorgan;//发文机关
	private String lastarttime;//开始实施时间
	private String laelectronicid;//电子版ID
	private String lauserid;//当前登录用户ID
	private Date latime;//当前时间
	private Integer lastate;//表状态0删除1正常
	public Lawsrules() {
	}
	public Lawsrules(String laid, String laname, String lanumber, String laorgan, String lastarttime,
			String laelectronicid, String lauserid, Date latime, Integer lastate) {
		this.laid = laid;
		this.laname = laname;
		this.lanumber = lanumber;
		this.laorgan = laorgan;
		this.lastarttime = lastarttime;
		this.laelectronicid = laelectronicid;
		this.lauserid = lauserid;
		this.latime = latime;
		this.lastate = lastate;
	}
	public String getLaid() {
		return laid;
	}
	public void setLaid(String laid) {
		this.laid = laid;
	}
	public String getLaname() {
		return laname;
	}
	public void setLaname(String laname) {
		this.laname = laname;
	}
	public String getLanumber() {
		return lanumber;
	}
	public void setLanumber(String lanumber) {
		this.lanumber = lanumber;
	}
	public String getLaorgan() {
		return laorgan;
	}
	public void setLaorgan(String laorgan) {
		this.laorgan = laorgan;
	}
	public String getLastarttime() {
		return lastarttime;
	}
	public void setLastarttime(String lastarttime) {
		this.lastarttime = lastarttime;
	}
	public String getLaelectronicid() {
		return laelectronicid;
	}
	public void setLaelectronicid(String laelectronicid) {
		this.laelectronicid = laelectronicid;
	}
	public String getLauserid() {
		return lauserid;
	}
	public void setLauserid(String lauserid) {
		this.lauserid = lauserid;
	}
	public Date getLatime() {
		return latime;
	}
	public void setLatime(Date latime) {
		this.latime = latime;
	}
	public Integer getLastate() {
		return lastate;
	}
	public void setLastate(Integer lastate) {
		this.lastate = lastate;
	}
}
