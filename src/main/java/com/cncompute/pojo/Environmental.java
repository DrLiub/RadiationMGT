package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 环境影响评价文件批复
 * @author Admin
 *2018年8月23日16:54:24
 */
public class Environmental implements Serializable {
	private static final long serialVersionUID = 3237514097532457651L;
	private String enid;// 表id
	private String enunit;// 审批单位
	private String enfile;// 批复文件名称
	private String enfileno;// 批复文件号
	private String endate;// 批复日期
	private String enelectronic;// 批复文件电子版地址
	private Date entime;// 当前时间
	private String enuserid;// 当前登录ID
	private String enstate;// 表状态0删除1正常
	private Protectionfile protectionfile;//环保手续文件实现类
	Set<Protectionfile> protectionfiles=new HashSet<Protectionfile>();
	public Environmental() {
	}
	public Environmental(String enid, String enunit, String enfile, String enfileno, String endate, String enelectronic,
			Date entime, String enuserid, String enstate, Protectionfile protectionfile,
			Set<Protectionfile> protectionfiles) {
		this.enid = enid;
		this.enunit = enunit;
		this.enfile = enfile;
		this.enfileno = enfileno;
		this.endate = endate;
		this.enelectronic = enelectronic;
		this.entime = entime;
		this.enuserid = enuserid;
		this.enstate = enstate;
		this.protectionfile = protectionfile;
		this.protectionfiles = protectionfiles;
	}
	public String getEnid() {
		return enid;
	}
	public void setEnid(String enid) {
		this.enid = enid;
	}
	public String getEnunit() {
		return enunit;
	}
	public void setEnunit(String enunit) {
		this.enunit = enunit;
	}
	public String getEnfile() {
		return enfile;
	}
	public void setEnfile(String enfile) {
		this.enfile = enfile;
	}
	public String getEnfileno() {
		return enfileno;
	}
	public void setEnfileno(String enfileno) {
		this.enfileno = enfileno;
	}
	public String getEndate() {
		return endate;
	}
	public void setEndate(String endate) {
		this.endate = endate;
	}
	public String getEnelectronic() {
		return enelectronic;
	}
	public void setEnelectronic(String enelectronic) {
		this.enelectronic = enelectronic;
	}
	public Date getEntime() {
		return entime;
	}
	public void setEntime(Date entime) {
		this.entime = entime;
	}
	public String getEnuserid() {
		return enuserid;
	}
	public void setEnuserid(String enuserid) {
		this.enuserid = enuserid;
	}
	public String getEnstate() {
		return enstate;
	}
	public void setEnstate(String enstate) {
		this.enstate = enstate;
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
