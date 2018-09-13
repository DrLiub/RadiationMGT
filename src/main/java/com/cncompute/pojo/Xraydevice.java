package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 射线装置表实现类
 * @author Admin
 *2018年8月30日14:40:05
 */
public class Xraydevice implements Serializable {
	private static final long serialVersionUID = -3723508046404400546L;
	private String raid;// 表ID
	private String raname;// 射线装置名称
	private String rauserid;// 当前登录id
	private Date ratime;// 当前时间
	private Integer rastate;// 表状态0删除1正常
	
	private Xaccelerator xaccelerator;//射线装置-加速器表
	Set<Xaccelerator> xaccelerators=new HashSet<Xaccelerator>();
	private Xneutron xneutron;//射线装置-中子发生器
	Set<Xneutron> xneutrons=new HashSet<Xneutron>();
	private Xraymachine xraymachine;//射线装置-X射线机
	Set<Xraymachine> xraymachines=new HashSet<Xraymachine>();
    private Xauxiliary xauxiliary;//辅助决策
	Set<Xauxiliary> xauxiliarys=new HashSet<Xauxiliary>();
    public Xraydevice() {
	}
	public Xraydevice(String raid, String raname, String rauserid, Date ratime, Integer rastate,
			Xaccelerator xaccelerator, Set<Xaccelerator> xaccelerators, Xneutron xneutron, Set<Xneutron> xneutrons,
			Xraymachine xraymachine, Set<Xraymachine> xraymachines, Xauxiliary xauxiliary,
			Set<Xauxiliary> xauxiliarys) {
		this.raid = raid;
		this.raname = raname;
		this.rauserid = rauserid;
		this.ratime = ratime;
		this.rastate = rastate;
		this.xaccelerator = xaccelerator;
		this.xaccelerators = xaccelerators;
		this.xneutron = xneutron;
		this.xneutrons = xneutrons;
		this.xraymachine = xraymachine;
		this.xraymachines = xraymachines;
		this.xauxiliary = xauxiliary;
		this.xauxiliarys = xauxiliarys;
	}
	public String getRaid() {
		return raid;
	}
	public void setRaid(String raid) {
		this.raid = raid;
	}
	public String getRaname() {
		return raname;
	}
	public void setRaname(String raname) {
		this.raname = raname;
	}
	public String getRauserid() {
		return rauserid;
	}
	public void setRauserid(String rauserid) {
		this.rauserid = rauserid;
	}
	public Date getRatime() {
		return ratime;
	}
	public void setRatime(Date ratime) {
		this.ratime = ratime;
	}
	public Integer getRastate() {
		return rastate;
	}
	public void setRastate(Integer rastate) {
		this.rastate = rastate;
	}
	public Xaccelerator getXaccelerator() {
		return xaccelerator;
	}
	public void setXaccelerator(Xaccelerator xaccelerator) {
		this.xaccelerator = xaccelerator;
	}
	public Set<Xaccelerator> getXaccelerators() {
		return xaccelerators;
	}
	public void setXaccelerators(Set<Xaccelerator> xaccelerators) {
		this.xaccelerators = xaccelerators;
	}
	public Xneutron getXneutron() {
		return xneutron;
	}
	public void setXneutron(Xneutron xneutron) {
		this.xneutron = xneutron;
	}
	public Set<Xneutron> getXneutrons() {
		return xneutrons;
	}
	public void setXneutrons(Set<Xneutron> xneutrons) {
		this.xneutrons = xneutrons;
	}
	public Xraymachine getXraymachine() {
		return xraymachine;
	}
	public void setXraymachine(Xraymachine xraymachine) {
		this.xraymachine = xraymachine;
	}
	public Set<Xraymachine> getXraymachines() {
		return xraymachines;
	}
	public void setXraymachines(Set<Xraymachine> xraymachines) {
		this.xraymachines = xraymachines;
	}
	public Xauxiliary getXauxiliary() {
		return xauxiliary;
	}
	public void setXauxiliary(Xauxiliary xauxiliary) {
		this.xauxiliary = xauxiliary;
	}
	public Set<Xauxiliary> getXauxiliarys() {
		return xauxiliarys;
	}
	public void setXauxiliarys(Set<Xauxiliary> xauxiliarys) {
		this.xauxiliarys = xauxiliarys;
	}
}
