package com.cncompute.pojo;

import java.io.Serializable;

/**
 * 存放辐射监测单位表实现类
 * @author Admin
 * 2018年8月21日15:43:21
 */
public class Entrust implements Serializable {
	private static final long serialVersionUID = -5731477314685265691L;
	private String enid;// 表ID
	private String entypeen;// 单位名称
	private String enproject;// 负责人
	private String enunit;// 电话
	private String enuserid;// 当前登录用户
	private String entime;// 当前时间
	private Integer enstate;// 表状态0删除1正常
	
	private int pageNumber;//序号
	
	public Entrust() {
	}
	public Entrust(String enid, String entypeen, String enproject, String enunit, String enuserid, String entime,
			Integer enstate) {
		this.enid = enid;
		this.entypeen = entypeen;
		this.enproject = enproject;
		this.enunit = enunit;
		this.enuserid = enuserid;
		this.entime = entime;
		this.enstate = enstate;
	}
	public String getEnid() {
		return enid;
	}
	public void setEnid(String enid) {
		this.enid = enid;
	}
	public String getEntypeen() {
		return entypeen;
	}
	public void setEntypeen(String entypeen) {
		this.entypeen = entypeen;
	}
	public String getEnproject() {
		return enproject;
	}
	public void setEnproject(String enproject) {
		this.enproject = enproject;
	}
	public String getEnunit() {
		return enunit;
	}
	public void setEnunit(String enunit) {
		this.enunit = enunit;
	}
	public String getEnuserid() {
		return enuserid;
	}
	public void setEnuserid(String enuserid) {
		this.enuserid = enuserid;
	}
	public String getEntime() {
		return entime;
	}
	public void setEntime(String entime) {
		this.entime = entime;
	}
	public Integer getEnstate() {
		return enstate;
	}
	public void setEnstate(Integer enstate) {
		this.enstate = enstate;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
}
