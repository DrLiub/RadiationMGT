package com.cncompute.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 环保竣工验收监测文件批复
 * @author Admin
 *2018年8月23日17:01:47
 */
public class Completionreply implements Serializable {
	private static final long serialVersionUID = 2666492577839451419L;
	private String coid;//表ID
	private String counit;// 审批单位
	private String cofile;// 批复文件名称
	private String cofileno;// 批复文件号
	private String codate;// 批复日期
	private String coelectronic;// 批复文件电子版地址
	private String cotime;// 当前时间
	private String cousrid;// 当前登录ID
	private String costate;// 表状态0删除1正常
	private Protectionfile protectionfile;//环保手续文件实现类
	Set<Protectionfile> protectionfiles=new HashSet<Protectionfile>();
	public Completionreply() {
	}
	public Completionreply(String coid, String counit, String cofile, String cofileno, String codate,
			String coelectronic, String cotime, String cousrid, String costate, Protectionfile protectionfile,
			Set<Protectionfile> protectionfiles) {
		this.coid = coid;
		this.counit = counit;
		this.cofile = cofile;
		this.cofileno = cofileno;
		this.codate = codate;
		this.coelectronic = coelectronic;
		this.cotime = cotime;
		this.cousrid = cousrid;
		this.costate = costate;
		this.protectionfile = protectionfile;
		this.protectionfiles = protectionfiles;
	}
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public String getCounit() {
		return counit;
	}
	public void setCounit(String counit) {
		this.counit = counit;
	}
	public String getCofile() {
		return cofile;
	}
	public void setCofile(String cofile) {
		this.cofile = cofile;
	}
	public String getCofileno() {
		return cofileno;
	}
	public void setCofileno(String cofileno) {
		this.cofileno = cofileno;
	}
	public String getCodate() {
		return codate;
	}
	public void setCodate(String codate) {
		this.codate = codate;
	}
	public String getCoelectronic() {
		return coelectronic;
	}
	public void setCoelectronic(String coelectronic) {
		this.coelectronic = coelectronic;
	}
	public String getCotime() {
		return cotime;
	}
	public void setCotime(String cotime) {
		this.cotime = cotime;
	}
	public String getCousrid() {
		return cousrid;
	}
	public void setCousrid(String cousrid) {
		this.cousrid = cousrid;
	}
	public String getCostate() {
		return costate;
	}
	public void setCostate(String costate) {
		this.costate = costate;
	}
	public Protectionfile getProtectionfile() {
		return protectionfile;
	}
	public void setProtectionfile(Protectionfile protectionfile) {
		this.protectionfile = protectionfile;
	}
	public Set<Protectionfile> getProtectionfiles() {
		return protectionfiles;
	}
	public void setProtectionfiles(Set<Protectionfile> protectionfiles) {
		this.protectionfiles = protectionfiles;
	}
}
