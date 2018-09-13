package com.cncompute.pojo;

import java.io.Serializable;

/**
 * 工作人员职业健康情况表实现类
 * @author Admin
 *2018年8月15日13:25:01
 */
public class Insertdata implements Serializable{
	private static final long serialVersionUID = 385605450072608732L;
    private String inid;//表ID
    private String innumber;//信息编号
    private Double inresults;//季度剂量监测数据
    private String inquarterend;//季度是否过量
    private Integer inquartertag;//季度：0正常1超标
    private String inquarcolor;//季度颜色
    private String inyearscolor;//年度颜色
    private Double inyears;//年度剂量监测数据
    private String inyearsend;//年度是否过量
    private Integer inyearstag;//年度：0整除1超标
    private String indepartment;//所属部门
    private String intime;//当前时间
    private String inuser;//当前登录ID
    private Integer instate;//表状态
    private String inname;//姓名
    private String ingender;//性别
    private String inage;//年龄
	public Insertdata() {
	}
	public Insertdata(String inid, String innumber, Double inresults, String inquarterend, Integer inquartertag,
			String inquarcolor, String inyearscolor, Double inyears, String inyearsend, Integer inyearstag,
			String indepartment, String intime, String inuser, Integer instate, String inname, String ingender,
			String inage) {
		this.inid = inid;
		this.innumber = innumber;
		this.inresults = inresults;
		this.inquarterend = inquarterend;
		this.inquartertag = inquartertag;
		this.inquarcolor = inquarcolor;
		this.inyearscolor = inyearscolor;
		this.inyears = inyears;
		this.inyearsend = inyearsend;
		this.inyearstag = inyearstag;
		this.indepartment = indepartment;
		this.intime = intime;
		this.inuser = inuser;
		this.instate = instate;
		this.inname = inname;
		this.ingender = ingender;
		this.inage = inage;
	}
	public String getInid() {
		return inid;
	}
	public void setInid(String inid) {
		this.inid = inid;
	}
	public String getInnumber() {
		return innumber;
	}
	public void setInnumber(String innumber) {
		this.innumber = innumber;
	}
	public Double getInresults() {
		return inresults;
	}
	public void setInresults(Double inresults) {
		this.inresults = inresults;
	}
	public String getInquarterend() {
		return inquarterend;
	}
	public void setInquarterend(String inquarterend) {
		this.inquarterend = inquarterend;
	}
	public Integer getInquartertag() {
		return inquartertag;
	}
	public void setInquartertag(Integer inquartertag) {
		this.inquartertag = inquartertag;
	}
	public String getInquarcolor() {
		return inquarcolor;
	}
	public void setInquarcolor(String inquarcolor) {
		this.inquarcolor = inquarcolor;
	}
	public String getInyearscolor() {
		return inyearscolor;
	}
	public void setInyearscolor(String inyearscolor) {
		this.inyearscolor = inyearscolor;
	}
	public Double getInyears() {
		return inyears;
	}
	public void setInyears(Double inyears) {
		this.inyears = inyears;
	}
	public String getInyearsend() {
		return inyearsend;
	}
	public void setInyearsend(String inyearsend) {
		this.inyearsend = inyearsend;
	}
	public Integer getInyearstag() {
		return inyearstag;
	}
	public void setInyearstag(Integer inyearstag) {
		this.inyearstag = inyearstag;
	}
	public String getIndepartment() {
		return indepartment;
	}
	public void setIndepartment(String indepartment) {
		this.indepartment = indepartment;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getInuser() {
		return inuser;
	}
	public void setInuser(String inuser) {
		this.inuser = inuser;
	}
	public Integer getInstate() {
		return instate;
	}
	public void setInstate(Integer instate) {
		this.instate = instate;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public String getIngender() {
		return ingender;
	}
	public void setIngender(String ingender) {
		this.ingender = ingender;
	}
	public String getInage() {
		return inage;
	}
	public void setInage(String inage) {
		this.inage = inage;
	}
}