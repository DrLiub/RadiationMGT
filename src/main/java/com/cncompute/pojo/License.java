package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 许可证表实现类
 * @author Admin
 *2018年8月23日16:51:17
 */
public class License implements Serializable {
	private static final long serialVersionUID = -1983202386382361332L;
	private String liid;// 表ID
	private String liunit;//发证单位
	private String linumber;// 许可证编号
	private String lidate;// 发证日期
	private String livalidity;// 有限期
	private String lispeciesid;// 许可种类与范围编号
	private String licertificateid;// 许可证电子版地址
	private Date litime;// 当前时间
	private String liuserid;// 当前登录ID
	private Integer listate;// 表状态0删除1正常
	private Protectionfile protectionfile;//环保手续文件实现类
	Set<Protectionfile> protectionfiles=new HashSet<Protectionfile>();
	public License() {
	}
	public License(String liid, String liunit, String linumber, String lidate, String livalidity, String lispeciesid,
			String licertificateid, Date litime, String liuserid, Integer listate, Protectionfile protectionfile,
			Set<Protectionfile> protectionfiles) {
		this.liid = liid;
		this.liunit = liunit;
		this.linumber = linumber;
		this.lidate = lidate;
		this.livalidity = livalidity;
		this.lispeciesid = lispeciesid;
		this.licertificateid = licertificateid;
		this.litime = litime;
		this.liuserid = liuserid;
		this.listate = listate;
		this.protectionfile = protectionfile;
		this.protectionfiles = protectionfiles;
	}
	public String getLiid() {
		return liid;
	}
	public void setLiid(String liid) {
		this.liid = liid;
	}
	public String getLiunit() {
		return liunit;
	}
	public void setLiunit(String liunit) {
		this.liunit = liunit;
	}
	public String getLinumber() {
		return linumber;
	}
	public void setLinumber(String linumber) {
		this.linumber = linumber;
	}
	public String getLidate() {
		return lidate;
	}
	public void setLidate(String lidate) {
		this.lidate = lidate;
	}
	public String getLivalidity() {
		return livalidity;
	}
	public void setLivalidity(String livalidity) {
		this.livalidity = livalidity;
	}
	public String getLispeciesid() {
		return lispeciesid;
	}
	public void setLispeciesid(String lispeciesid) {
		this.lispeciesid = lispeciesid;
	}
	public String getLicertificateid() {
		return licertificateid;
	}
	public void setLicertificateid(String licertificateid) {
		this.licertificateid = licertificateid;
	}
	public Date getLitime() {
		return litime;
	}
	public void setLitime(Date litime) {
		this.litime = litime;
	}
	public String getLiuserid() {
		return liuserid;
	}
	public void setLiuserid(String liuserid) {
		this.liuserid = liuserid;
	}
	public Integer getListate() {
		return listate;
	}
	public void setListate(Integer listate) {
		this.listate = listate;
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
