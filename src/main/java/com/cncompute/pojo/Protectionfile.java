package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 环保手续文件实现类
 * @author Admin 
 * 2018年8月23日16:45:11
 */
public class Protectionfile implements Serializable {
	private static final long serialVersionUID = 8118243475105437157L;
	private String prid;// 表ID
	private String prname;// 环保手续文件名称
	private String pruserid;// 当前登录ID
	private Date prtime;// 当前时间
	private Integer prstate;// 表状态
	
	private License license;//许可证表实现类
	private Environmental environmental;//环境影响评价文件批复
	private Completionreply completionreply;//环保竣工验收监测文件批复
	private Typelicense typelicense;//许可种类与范围实现类
	Set<Typelicense> typelicenses=new HashSet<Typelicense>();//
	Set<Environmental> environmentals=new HashSet<Environmental>();//1对多，
	Set<License> Licenses=new HashSet<License>();//1对多，1个环保手续文件对应多个许可证
	Set<Completionreply> completionreplys=new HashSet<Completionreply>();//1对多，
	public Protectionfile() {
	}
	public Protectionfile(String prid, String prname, String pruserid, Date prtime, Integer prstate, License license,
			Environmental environmental, Completionreply completionreply, Typelicense typelicense,
			Set<Typelicense> typelicenses, Set<Environmental> environmentals, Set<License> licenses,
			Set<Completionreply> completionreplys) {
		this.prid = prid;
		this.prname = prname;
		this.pruserid = pruserid;
		this.prtime = prtime;
		this.prstate = prstate;
		this.license = license;
		this.environmental = environmental;
		this.completionreply = completionreply;
		this.typelicense = typelicense;
		this.typelicenses = typelicenses;
		this.environmentals = environmentals;
		Licenses = licenses;
		this.completionreplys = completionreplys;
	}
	public String getPrid() {
		return prid;
	}
	public void setPrid(String prid) {
		this.prid = prid;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public String getPruserid() {
		return pruserid;
	}
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	public Date getPrtime() {
		return prtime;
	}
	public void setPrtime(Date prtime) {
		this.prtime = prtime;
	}
	public Integer getPrstate() {
		return prstate;
	}
	public void setPrstate(Integer prstate) {
		this.prstate = prstate;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public Environmental getEnvironmental() {
		return environmental;
	}
	public void setEnvironmental(Environmental environmental) {
		this.environmental = environmental;
	}
	public Completionreply getCompletionreply() {
		return completionreply;
	}
	public void setCompletionreply(Completionreply completionreply) {
		this.completionreply = completionreply;
	}
	public Typelicense getTypelicense() {
		return typelicense;
	}
	public void setTypelicense(Typelicense typelicense) {
		this.typelicense = typelicense;
	}
	public Set<Typelicense> getTypelicenses() {
		return typelicenses;
	}
	public void setTypelicenses(Set<Typelicense> typelicenses) {
		this.typelicenses = typelicenses;
	}
	public Set<Environmental> getEnvironmentals() {
		return environmentals;
	}
	public void setEnvironmentals(Set<Environmental> environmentals) {
		this.environmentals = environmentals;
	}
	public Set<License> getLicenses() {
		return Licenses;
	}
	public void setLicenses(Set<License> licenses) {
		Licenses = licenses;
	}
	public Set<Completionreply> getCompletionreplys() {
		return completionreplys;
	}
	public void setCompletionreplys(Set<Completionreply> completionreplys) {
		this.completionreplys = completionreplys;
	}
}
