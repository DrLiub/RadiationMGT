package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 房间中的核素表实现类
 * @author Admin
 *2018年9月10日14:10:10
 */
public class Roomnuclide implements Serializable {
	private static final long serialVersionUID = 4988617015092192647L;
	private String roid;// 表ID
	private String ronumber;// 信息编号
	private String roname;//核素的名称
	private String rochemical;// 理化性质
	private String roway;//来源方式
	private String roquantity;// 日最大操作量
	private String royear;// 年最大操作量
	private String rooperation;//操作方式
	private String rocorrection;//操作修正因子
	private String rotoxicity;//毒性修正因子
	private String rouse;// 用途
	private String rostorageway;// 贮存方式
	private String rostorage;// 贮存地点
	private String robiggest;// 日等效最大操作量
	private String rouserid;// 当前登录ID
	private Date rotime;// 当前时间
	private Integer rostate;// 表状态0删除1正常
	private Nonseal nonseal;//非密封放射性物质表实现类
	Set<Nonseal>Nonseals=new HashSet<Nonseal>();
	public Roomnuclide() {
	}
	public Roomnuclide(String roid, String ronumber, String roname, String rochemical, String roway, String roquantity,
			String royear, String rooperation, String rocorrection, String rotoxicity, String rouse,
			String rostorageway, String rostorage, String robiggest, String rouserid, Date rotime, Integer rostate,
			Nonseal nonseal, Set<Nonseal> nonseals) {
		this.roid = roid;
		this.ronumber = ronumber;
		this.roname = roname;
		this.rochemical = rochemical;
		this.roway = roway;
		this.roquantity = roquantity;
		this.royear = royear;
		this.rooperation = rooperation;
		this.rocorrection = rocorrection;
		this.rotoxicity = rotoxicity;
		this.rouse = rouse;
		this.rostorageway = rostorageway;
		this.rostorage = rostorage;
		this.robiggest = robiggest;
		this.rouserid = rouserid;
		this.rotime = rotime;
		this.rostate = rostate;
		this.nonseal = nonseal;
		Nonseals = nonseals;
	}
	public String getRoid() {
		return roid;
	}
	public void setRoid(String roid) {
		this.roid = roid;
	}
	public String getRonumber() {
		return ronumber;
	}
	public void setRonumber(String ronumber) {
		this.ronumber = ronumber;
	}
	public String getRoname() {
		return roname;
	}
	public void setRoname(String roname) {
		this.roname = roname;
	}
	public String getRochemical() {
		return rochemical;
	}
	public void setRochemical(String rochemical) {
		this.rochemical = rochemical;
	}
	public String getRoway() {
		return roway;
	}
	public void setRoway(String roway) {
		this.roway = roway;
	}
	public String getRoquantity() {
		return roquantity;
	}
	public void setRoquantity(String roquantity) {
		this.roquantity = roquantity;
	}
	public String getRoyear() {
		return royear;
	}
	public void setRoyear(String royear) {
		this.royear = royear;
	}
	public String getRooperation() {
		return rooperation;
	}
	public void setRooperation(String rooperation) {
		this.rooperation = rooperation;
	}
	public String getRocorrection() {
		return rocorrection;
	}
	public void setRocorrection(String rocorrection) {
		this.rocorrection = rocorrection;
	}
	public String getRotoxicity() {
		return rotoxicity;
	}
	public void setRotoxicity(String rotoxicity) {
		this.rotoxicity = rotoxicity;
	}
	public String getRouse() {
		return rouse;
	}
	public void setRouse(String rouse) {
		this.rouse = rouse;
	}
	public String getRostorageway() {
		return rostorageway;
	}
	public void setRostorageway(String rostorageway) {
		this.rostorageway = rostorageway;
	}
	public String getRostorage() {
		return rostorage;
	}
	public void setRostorage(String rostorage) {
		this.rostorage = rostorage;
	}
	public String getRobiggest() {
		return robiggest;
	}
	public void setRobiggest(String robiggest) {
		this.robiggest = robiggest;
	}
	public String getRouserid() {
		return rouserid;
	}
	public void setRouserid(String rouserid) {
		this.rouserid = rouserid;
	}
	public Date getRotime() {
		return rotime;
	}
	public void setRotime(Date rotime) {
		this.rotime = rotime;
	}
	public Integer getRostate() {
		return rostate;
	}
	public void setRostate(Integer rostate) {
		this.rostate = rostate;
	}
	public Nonseal getNonseal() {
		return nonseal;
	}
	public void setNonseal(Nonseal nonseal) {
		this.nonseal = nonseal;
	}
	public Set<Nonseal> getNonseals() {
		return Nonseals;
	}
	public void setNonseals(Set<Nonseal> nonseals) {
		Nonseals = nonseals;
	}
}
