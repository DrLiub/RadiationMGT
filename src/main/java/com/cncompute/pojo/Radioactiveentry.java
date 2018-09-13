package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 放射性同位素录入信息实现类
 * @author Admin
 *2018年9月6日17:02:42
 */
public class Radioactiveentry implements Serializable {
	private static final long serialVersionUID = -5129800279807437724L;
	private String raid;// 表ID
	private String raentry;// 录入信息ID
	private String raname;// 核素名称
	private String radosage;// 年最大用量
	private String raphysical;// 物理化学性状
	private String raquantity;// 日等效操作量
	private String rayears;// 年等效用量
	private String raway;//操作方式
	private String raplace;// 贮存方式与地点
	private String racountry;// 国别
	private String ranumber;//表名/表编号
	private Date ratime;// 当前时间
	private String rauserid;// 当前登录ID
	private Integer rastate;// 状态：0删除1正常
	private Isotopes isotopes;//放射性同位素
	Set<Isotopes> isotopess=new HashSet<Isotopes>();
	public Radioactiveentry() {
	}
	public Radioactiveentry(String raid, String raentry, String raname, String radosage, String raphysical,
			String raquantity, String rayears, String raway, String raplace, String racountry, String ranumber,
			Date ratime, String rauserid, Integer rastate, Isotopes isotopes, Set<Isotopes> isotopess) {
		this.raid = raid;
		this.raentry = raentry;
		this.raname = raname;
		this.radosage = radosage;
		this.raphysical = raphysical;
		this.raquantity = raquantity;
		this.rayears = rayears;
		this.raway = raway;
		this.raplace = raplace;
		this.racountry = racountry;
		this.ranumber = ranumber;
		this.ratime = ratime;
		this.rauserid = rauserid;
		this.rastate = rastate;
		this.isotopes = isotopes;
		this.isotopess = isotopess;
	}
	public String getRaid() {
		return raid;
	}
	public void setRaid(String raid) {
		this.raid = raid;
	}
	public String getRaentry() {
		return raentry;
	}
	public void setRaentry(String raentry) {
		this.raentry = raentry;
	}
	public String getRaname() {
		return raname;
	}
	public void setRaname(String raname) {
		this.raname = raname;
	}
	public String getRadosage() {
		return radosage;
	}
	public void setRadosage(String radosage) {
		this.radosage = radosage;
	}
	public String getRaphysical() {
		return raphysical;
	}
	public void setRaphysical(String raphysical) {
		this.raphysical = raphysical;
	}
	public String getRaquantity() {
		return raquantity;
	}
	public void setRaquantity(String raquantity) {
		this.raquantity = raquantity;
	}
	public String getRayears() {
		return rayears;
	}
	public void setRayears(String rayears) {
		this.rayears = rayears;
	}
	public String getRaway() {
		return raway;
	}
	public void setRaway(String raway) {
		this.raway = raway;
	}
	public String getRaplace() {
		return raplace;
	}
	public void setRaplace(String raplace) {
		this.raplace = raplace;
	}
	public String getRacountry() {
		return racountry;
	}
	public void setRacountry(String racountry) {
		this.racountry = racountry;
	}
	public String getRanumber() {
		return ranumber;
	}
	public void setRanumber(String ranumber) {
		this.ranumber = ranumber;
	}
	public Date getRatime() {
		return ratime;
	}
	public void setRatime(Date ratime) {
		this.ratime = ratime;
	}
	public String getRauserid() {
		return rauserid;
	}
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}
	public Integer getRastate() {
		return rastate;
	}
	public void setRastate(Integer rastate) {
		this.rastate = rastate;
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
