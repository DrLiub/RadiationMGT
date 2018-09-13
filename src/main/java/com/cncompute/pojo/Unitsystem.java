package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 单位辐射安全规章制度模块 
 * 单位辐射安全规章制度表实现类
 * @author Admin 
 * 2018年8月28日13:51:04
 */
public class Unitsystem implements Serializable {
	private static final long serialVersionUID = 132791384535058217L;
	private String unid;// 表ID
	private String udnumber;//文件编号
	private String unname;// 规章制度名称
	private String unfile;// 文件号
	private String ununittime;// 开始实施时间
	private String unaddress;// 电子版地址
	private String unuserid;// 当前登录ID
	private Date untime;// 当前时间
	private Integer unstate;// 状态：0删除1正常
    private Filetype filetype;	
    Set<Filetype> filetypes=new HashSet<Filetype>();
	public Unitsystem() {
	}
	public Unitsystem(String unid, String udnumber, String unname, String unfile, String ununittime, String unaddress,
			String unuserid, Date untime, Integer unstate, Filetype filetype, Set<Filetype> filetypes) {
		super();
		this.unid = unid;
		this.udnumber = udnumber;
		this.unname = unname;
		this.unfile = unfile;
		this.ununittime = ununittime;
		this.unaddress = unaddress;
		this.unuserid = unuserid;
		this.untime = untime;
		this.unstate = unstate;
		this.filetype = filetype;
		this.filetypes = filetypes;
	}
	public String getUnid() {
		return unid;
	}
	public void setUnid(String unid) {
		this.unid = unid;
	}
	public String getUdnumber() {
		return udnumber;
	}
	public void setUdnumber(String udnumber) {
		this.udnumber = udnumber;
	}
	public String getUnname() {
		return unname;
	}
	public void setUnname(String unname) {
		this.unname = unname;
	}
	public String getUnfile() {
		return unfile;
	}
	public void setUnfile(String unfile) {
		this.unfile = unfile;
	}
	public String getUnunittime() {
		return ununittime;
	}
	public void setUnunittime(String ununittime) {
		this.ununittime = ununittime;
	}
	public String getUnaddress() {
		return unaddress;
	}
	public void setUnaddress(String unaddress) {
		this.unaddress = unaddress;
	}
	public String getUnuserid() {
		return unuserid;
	}
	public void setUnuserid(String unuserid) {
		this.unuserid = unuserid;
	}
	public Date getUntime() {
		return untime;
	}
	public void setUntime(Date untime) {
		this.untime = untime;
	}
	public Integer getUnstate() {
		return unstate;
	}
	public void setUnstate(Integer unstate) {
		this.unstate = unstate;
	}
	public Filetype getFiletype() {
		return filetype;
	}
	public void setFiletype(Filetype filetype) {
		this.filetype = filetype;
	}
	public Set<Filetype> getFiletypes() {
		return filetypes;
	}
	public void setFiletypes(Set<Filetype> filetypes) {
		this.filetypes = filetypes;
	}
}
