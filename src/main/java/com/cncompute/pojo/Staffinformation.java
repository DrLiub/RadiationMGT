package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 辐射工作人员表实现类
 * @author 劉
 *2018年8月9日14:03:32
 */
public class Staffinformation implements Serializable{
	private static final long serialVersionUID = 4976897340931309117L;
	private String stid;//表ID
	private String stnumber;//信息编号
	private String stinstitutions;//机构编号
	private String stname;//姓名
	private String stgender;//性别
	private String stage;//年龄
	private String stjobs;//工作岗位
	private String stschooling;//学历及专业
	private String sttrainingtime;//培训时间
	private String stbirth;//出生日期
	private String stcertificate;//资格证书编号
	private String stgraduation;//培训毕业时间
	private String stsecurity;//安全培训证书ID
	private String stnote;//备注
	private String stoverdue;//证书是否过期
	private String stdose;//个人剂量监测结果ID
	private String stexcessive;//剂量监测是否超标
	private String stquarter;//个人季度超量
	private String stannual;//个人年度超量
	private String stuserid;//当前登录ID
	private Date sttime;//当前时间
	private Integer ststate;//状态：0删除1正常
	private String stdepartment;//所属部门
	private Integer stoverdueyn;//0没过期1到期
	private String color;
	public Staffinformation() {
	}
	public Staffinformation(String stid, String stnumber, String stinstitutions, String stname, String stgender,
			String stage, String stjobs, String stschooling, String sttrainingtime, String stbirth,
			String stcertificate, String stgraduation, String stsecurity, String stnote, String stoverdue, String stdose,
			String stexcessive, String stquarter, String stannual, String stuserid, Date sttime, Integer ststate,
			String stdepartment, Integer stoverdueyn, String color) {
		this.stid = stid;
		this.stnumber = stnumber;
		this.stinstitutions = stinstitutions;
		this.stname = stname;
		this.stgender = stgender;
		this.stage = stage;
		this.stjobs = stjobs;
		this.stschooling = stschooling;
		this.sttrainingtime = sttrainingtime;
		this.stbirth = stbirth;
		this.stcertificate = stcertificate;
		this.stgraduation = stgraduation;
		this.stsecurity = stsecurity;
		this.stnote = stnote;
		this.stoverdue = stoverdue;
		this.stdose = stdose;
		this.stexcessive = stexcessive;
		this.stquarter = stquarter;
		this.stannual = stannual;
		this.stuserid = stuserid;
		this.sttime = sttime;
		this.ststate = ststate;
		this.stdepartment = stdepartment;
		this.stoverdueyn = stoverdueyn;
		this.color = color;
	}
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	public String getStnumber() {
		return stnumber;
	}
	public void setStnumber(String stnumber) {
		this.stnumber = stnumber;
	}
	public String getStinstitutions() {
		return stinstitutions;
	}
	public void setStinstitutions(String stinstitutions) {
		this.stinstitutions = stinstitutions;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStgender() {
		return stgender;
	}
	public void setStgender(String stgender) {
		this.stgender = stgender;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getStjobs() {
		return stjobs;
	}
	public void setStjobs(String stjobs) {
		this.stjobs = stjobs;
	}
	public String getStschooling() {
		return stschooling;
	}
	public void setStschooling(String stschooling) {
		this.stschooling = stschooling;
	}
	public String getSttrainingtime() {
		return sttrainingtime;
	}
	public void setSttrainingtime(String sttrainingtime) {
		this.sttrainingtime = sttrainingtime;
	}
	public String getStbirth() {
		return stbirth;
	}
	public void setStbirth(String stbirth) {
		this.stbirth = stbirth;
	}
	public String getStcertificate() {
		return stcertificate;
	}
	public void setStcertificate(String stcertificate) {
		this.stcertificate = stcertificate;
	}
	public String getStgraduation() {
		return stgraduation;
	}
	public void setStgraduation(String stgraduation) {
		this.stgraduation = stgraduation;
	}
	public String getStsecurity() {
		return stsecurity;
	}
	public void setStsecurity(String stsecurity) {
		this.stsecurity = stsecurity;
	}
	public String getStnote() {
		return stnote;
	}
	public void setStnote(String stnote) {
		this.stnote = stnote;
	}
	public String getStoverdue() {
		return stoverdue;
	}
	public void setStoverdue(String stoverdue) {
		this.stoverdue = stoverdue;
	}
	public String getStdose() {
		return stdose;
	}
	public void setStdose(String stdose) {
		this.stdose = stdose;
	}
	public String getStexcessive() {
		return stexcessive;
	}
	public void setStexcessive(String stexcessive) {
		this.stexcessive = stexcessive;
	}
	public String getStquarter() {
		return stquarter;
	}
	public void setStquarter(String stquarter) {
		this.stquarter = stquarter;
	}
	public String getStannual() {
		return stannual;
	}
	public void setStannual(String stannual) {
		this.stannual = stannual;
	}
	public String getStuserid() {
		return stuserid;
	}
	public void setStuserid(String stuserid) {
		this.stuserid = stuserid;
	}
	public Date getSttime() {
		return sttime;
	}
	public void setSttime(Date sttime) {
		this.sttime = sttime;
	}
	public Integer getStstate() {
		return ststate;
	}
	public void setStstate(Integer ststate) {
		this.ststate = ststate;
	}
	public String getStdepartment() {
		return stdepartment;
	}
	public void setStdepartment(String stdepartment) {
		this.stdepartment = stdepartment;
	}
	public Integer getStoverdueyn() {
		return stoverdueyn;
	}
	public void setStoverdueyn(Integer stoverdueyn) {
		this.stoverdueyn = stoverdueyn;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
