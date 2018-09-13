package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 辐射安全管理人员表的实现类
 * @author 劉
 *2018年8月2日11:06:11
 */
public class Management implements Serializable{
	private static final long serialVersionUID = -8379765292373845086L;
	private String maid;//表ID
	private String mainformation;//信息ID
	private String manumber;//机构编号
	private String maname;//机构名称
	private String mahead;//负责人
	private String maphone;//电话
	private Date matime;//当前时间
	private String mauserid;//当前登录ID
	private Integer mastate;//表状态0删除1正常
	private Personnel personnel;//管理人员信息表
	Set<Personnel> personnels=new HashSet<Personnel>();//1对多，一个管理人员表对应多个管理人员
	public Management() {
	}
	public Management(String maid, String mainformation, String manumber, String maname, String mahead, String maphone,
			Date matime, String mauserid, Integer mastate, Personnel personnel, Set<Personnel> personnels) {
		this.maid = maid;
		this.mainformation = mainformation;
		this.manumber = manumber;
		this.maname = maname;
		this.mahead = mahead;
		this.maphone = maphone;
		this.matime = matime;
		this.mauserid = mauserid;
		this.mastate = mastate;
		this.personnel = personnel;
		this.personnels = personnels;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public String getMainformation() {
		return mainformation;
	}
	public void setMainformation(String mainformation) {
		this.mainformation = mainformation;
	}
	public String getManumber() {
		return manumber;
	}
	public void setManumber(String manumber) {
		this.manumber = manumber;
	}
	public String getManame() {
		return maname;
	}
	public void setManame(String maname) {
		this.maname = maname;
	}
	public String getMahead() {
		return mahead;
	}
	public void setMahead(String mahead) {
		this.mahead = mahead;
	}
	public String getMaphone() {
		return maphone;
	}
	public void setMaphone(String maphone) {
		this.maphone = maphone;
	}
	public Date getMatime() {
		return matime;
	}
	public void setMatime(Date matime) {
		this.matime = matime;
	}
	public String getMauserid() {
		return mauserid;
	}
	public void setMauserid(String mauserid) {
		this.mauserid = mauserid;
	}
	public Integer getMastate() {
		return mastate;
	}
	public void setMastate(Integer mastate) {
		this.mastate = mastate;
	}
	public Personnel getPersonnel() {
		return personnel;
	}
	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	public Set<Personnel> getPersonnels() {
		return personnels;
	}
	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}
}
