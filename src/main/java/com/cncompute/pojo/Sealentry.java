package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 密封源录入信息
 * @author Admin
 *2018年9月6日17:09:57
 */
public class Sealentry implements Serializable {
	private static final long serialVersionUID = -9089640202767379542L;
	private String seid;// 表ID
	private String seentry;//录入ID
	private String sename;// 核素名称
	private String selive;// 放射性活度
	private String senumber;// 编号
	private String sephysical;// 物理、化学性状
	private String secategory;// 类别
	private String seoperation;//操作放射
	private String seplace;// 贮存方式与地点
	private String secountry;// 国别
	private String setablename;// 表名/表编号
	private String seuserid;// 当前登录ID
	private Date setime;//当前时间
	private Integer sestate;// 状态：0删除1正常
	
	private String sefactory;//生产厂家
	private String seoutfactory;//出厂活度（Bq）
	private String seproduction;//生产日期
	private String secoding;//出厂编码
	private String seuse;//用途
	private String sedecay;//衰变常数
	private String seactivity;//当前活度值
	
	private Isotopes isotopes;//放射性同位素
	Set<Isotopes> isotopess=new HashSet<Isotopes>();
	public Sealentry() {
	}
	public Sealentry(String seid, String seentry, String sename, String selive, String senumber, String sephysical,
			String secategory, String seoperation, String seplace, String secountry, String setablename,
			String seuserid, Date setime, Integer sestate, String sefactory, String seoutfactory, String seproduction,
			String secoding, String seuse, String sedecay, String seactivity, Isotopes isotopes,
			Set<Isotopes> isotopess) {
		super();
		this.seid = seid;
		this.seentry = seentry;
		this.sename = sename;
		this.selive = selive;
		this.senumber = senumber;
		this.sephysical = sephysical;
		this.secategory = secategory;
		this.seoperation = seoperation;
		this.seplace = seplace;
		this.secountry = secountry;
		this.setablename = setablename;
		this.seuserid = seuserid;
		this.setime = setime;
		this.sestate = sestate;
		this.sefactory = sefactory;
		this.seoutfactory = seoutfactory;
		this.seproduction = seproduction;
		this.secoding = secoding;
		this.seuse = seuse;
		this.sedecay = sedecay;
		this.seactivity = seactivity;
		this.isotopes = isotopes;
		this.isotopess = isotopess;
	}
	public String getSeid() {
		return seid;
	}
	public void setSeid(String seid) {
		this.seid = seid;
	}
	public String getSeentry() {
		return seentry;
	}
	public void setSeentry(String seentry) {
		this.seentry = seentry;
	}
	public String getSename() {
		return sename;
	}
	public void setSename(String sename) {
		this.sename = sename;
	}
	public String getSelive() {
		return selive;
	}
	public void setSelive(String selive) {
		this.selive = selive;
	}
	public String getSenumber() {
		return senumber;
	}
	public void setSenumber(String senumber) {
		this.senumber = senumber;
	}
	public String getSephysical() {
		return sephysical;
	}
	public void setSephysical(String sephysical) {
		this.sephysical = sephysical;
	}
	public String getSecategory() {
		return secategory;
	}
	public void setSecategory(String secategory) {
		this.secategory = secategory;
	}
	public String getSeoperation() {
		return seoperation;
	}
	public void setSeoperation(String seoperation) {
		this.seoperation = seoperation;
	}
	public String getSeplace() {
		return seplace;
	}
	public void setSeplace(String seplace) {
		this.seplace = seplace;
	}
	public String getSecountry() {
		return secountry;
	}
	public void setSecountry(String secountry) {
		this.secountry = secountry;
	}
	public String getSetablename() {
		return setablename;
	}
	public void setSetablename(String setablename) {
		this.setablename = setablename;
	}
	public String getSeuserid() {
		return seuserid;
	}
	public void setSeuserid(String seuserid) {
		this.seuserid = seuserid;
	}
	public Date getSetime() {
		return setime;
	}
	public void setSetime(Date setime) {
		this.setime = setime;
	}
	public Integer getSestate() {
		return sestate;
	}
	public void setSestate(Integer sestate) {
		this.sestate = sestate;
	}
	public String getSefactory() {
		return sefactory;
	}
	public void setSefactory(String sefactory) {
		this.sefactory = sefactory;
	}
	public String getSeoutfactory() {
		return seoutfactory;
	}
	public void setSeoutfactory(String seoutfactory) {
		this.seoutfactory = seoutfactory;
	}
	public String getSeproduction() {
		return seproduction;
	}
	public void setSeproduction(String seproduction) {
		this.seproduction = seproduction;
	}
	public String getSecoding() {
		return secoding;
	}
	public void setSecoding(String secoding) {
		this.secoding = secoding;
	}
	public String getSeuse() {
		return seuse;
	}
	public void setSeuse(String seuse) {
		this.seuse = seuse;
	}
	public String getSedecay() {
		return sedecay;
	}
	public void setSedecay(String sedecay) {
		this.sedecay = sedecay;
	}
	public String getSeactivity() {
		return seactivity;
	}
	public void setSeactivity(String seactivity) {
		this.seactivity = seactivity;
	}
	public Isotopes getIsotopes() {
		return isotopes;
	}
	public void setIsotopes(Isotopes isotopes) {
		this.isotopes = isotopes;
	}
	public Set<Isotopes> getIsotopess() {
		return isotopess;
	}
	public void setIsotopess(Set<Isotopes> isotopess) {
		this.isotopess = isotopess;
	}
}
