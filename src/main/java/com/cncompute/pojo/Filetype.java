package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 单位辐射安全规章制度模块 
 * 文件类别表实现类
 * @author Admin 
 * 2018年8月28日13:48:23
 */
public class Filetype implements Serializable {
	private static final long serialVersionUID = 751099953309345296L;
	private String flid;// 表ID
	private String flname;// 文件类别名称
	private String fluserid;// 当前登录ID
	private Date fltime;// 当前时间
	private Integer flstate;// 表状态0删除1正常
	private Integer fithere;//0文件不存在1文件存在
	private Unitsystem unitsystem;
	Set<Unitsystem> unitsystems=new HashSet<Unitsystem>();
	public Filetype() {
	}
	public Filetype(String flid, String flname, String fluserid, Date fltime, Integer flstate, Integer fithere,
			Unitsystem unitsystem, Set<Unitsystem> unitsystems) {
		this.flid = flid;
		this.flname = flname;
		this.fluserid = fluserid;
		this.fltime = fltime;
		this.flstate = flstate;
		this.fithere = fithere;
		this.unitsystem = unitsystem;
		this.unitsystems = unitsystems;
	}
	public String getFlid() {
		return flid;
	}
	public void setFlid(String flid) {
		this.flid = flid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public String getFluserid() {
		return fluserid;
	}
	public void setFluserid(String fluserid) {
		this.fluserid = fluserid;
	}
	public Date getFltime() {
		return fltime;
	}
	public void setFltime(Date fltime) {
		this.fltime = fltime;
	}
	public Integer getFlstate() {
		return flstate;
	}
	public void setFlstate(Integer flstate) {
		this.flstate = flstate;
	}
	public Integer getFithere() {
		return fithere;
	}
	public void setFithere(Integer fithere) {
		this.fithere = fithere;
	}
	public Unitsystem getUnitsystem() {
		return unitsystem;
	}
	public void setUnitsystem(Unitsystem unitsystem) {
		this.unitsystem = unitsystem;
	}
	public Set<Unitsystem> getUnitsystems() {
		return unitsystems;
	}
	public void setUnitsystems(Set<Unitsystem> unitsystems) {
		this.unitsystems = unitsystems;
	}
}
