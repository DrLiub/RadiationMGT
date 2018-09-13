package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 管理人员信息表的实现类
 * @author 劉
 *2018年8月2日11:11:54
 */
public class Personnel implements Serializable{
	private static final long serialVersionUID = -7803478054636320950L;
	private String peid;//表ID
	private String pename;//机构名称
	private String peinformation;//信息ID
	private String penumber;//机构编号
	private String pemanagement;//管理岗位
	private String peusername;//姓名
	private String pegender;//性别
	private String peposition;//职务或职称
	private String pedepartment;//工作部门
	private String pespecially;//专（兼）职
	private String pewhether;//是否为负责人
	private String perecord;//学历
	private String peprofessional;//专业
	private String pecertificateid;//学历证书ID
	private String peradiationid;//辐射安全培训证书ID
	private String peuserid;//当前登录用户ID
	private Date petime;//当前时间
	private Integer pestate;// 表状态
	private Management management;//辐射安全管理人员表
	Set<Management> managements=new HashSet<Management>();//多对一，多个人员对应一个管理人员表
	public Personnel() {
	}
	public Personnel(String peid, String pename, String peinformation, String penumber, String pemanagement,
			String peusername, String pegender, String peposition, String pedepartment, String pespecially,
			String pewhether, String perecord, String peprofessional, String pecertificateid, String peradiationid,
			String peuserid, Date petime, Integer pestate, Management management, Set<Management> managements) {
		super();
		this.peid = peid;
		this.pename = pename;
		this.peinformation = peinformation;
		this.penumber = penumber;
		this.pemanagement = pemanagement;
		this.peusername = peusername;
		this.pegender = pegender;
		this.peposition = peposition;
		this.pedepartment = pedepartment;
		this.pespecially = pespecially;
		this.pewhether = pewhether;
		this.perecord = perecord;
		this.peprofessional = peprofessional;
		this.pecertificateid = pecertificateid;
		this.peradiationid = peradiationid;
		this.peuserid = peuserid;
		this.petime = petime;
		this.pestate = pestate;
		this.management = management;
		this.managements = managements;
	}
	public String getPeid() {
		return peid;
	}
	public void setPeid(String peid) {
		this.peid = peid;
	}
	public String getPename() {
		return pename;
	}
	public void setPename(String pename) {
		this.pename = pename;
	}
	public String getPeinformation() {
		return peinformation;
	}
	public void setPeinformation(String peinformation) {
		this.peinformation = peinformation;
	}
	public String getPenumber() {
		return penumber;
	}
	public void setPenumber(String penumber) {
		this.penumber = penumber;
	}
	public String getPemanagement() {
		return pemanagement;
	}
	public void setPemanagement(String pemanagement) {
		this.pemanagement = pemanagement;
	}
	public String getPeusername() {
		return peusername;
	}
	public void setPeusername(String peusername) {
		this.peusername = peusername;
	}
	public String getPegender() {
		return pegender;
	}
	public void setPegender(String pegender) {
		this.pegender = pegender;
	}
	public String getPeposition() {
		return peposition;
	}
	public void setPeposition(String peposition) {
		this.peposition = peposition;
	}
	public String getPedepartment() {
		return pedepartment;
	}
	public void setPedepartment(String pedepartment) {
		this.pedepartment = pedepartment;
	}
	public String getPespecially() {
		return pespecially;
	}
	public void setPespecially(String pespecially) {
		this.pespecially = pespecially;
	}
	public String getPewhether() {
		return pewhether;
	}
	public void setPewhether(String pewhether) {
		this.pewhether = pewhether;
	}
	public String getPerecord() {
		return perecord;
	}
	public void setPerecord(String perecord) {
		this.perecord = perecord;
	}
	public String getPeprofessional() {
		return peprofessional;
	}
	public void setPeprofessional(String peprofessional) {
		this.peprofessional = peprofessional;
	}
	public String getPecertificateid() {
		return pecertificateid;
	}
	public void setPecertificateid(String pecertificateid) {
		this.pecertificateid = pecertificateid;
	}
	public String getPeradiationid() {
		return peradiationid;
	}
	public void setPeradiationid(String peradiationid) {
		this.peradiationid = peradiationid;
	}
	public String getPeuserid() {
		return peuserid;
	}
	public void setPeuserid(String peuserid) {
		this.peuserid = peuserid;
	}
	public Date getPetime() {
		return petime;
	}
	public void setPetime(Date petime) {
		this.petime = petime;
	}
	public Integer getPestate() {
		return pestate;
	}
	public void setPestate(Integer pestate) {
		this.pestate = pestate;
	}
	public Management getManagement() {
		return management;
	}
	public void setManagement(Management management) {
		this.management = management;
	}
	public Set<Management> getManagements() {
		return managements;
	}
	public void setManagements(Set<Management> managements) {
		this.managements = managements;
	}
}
