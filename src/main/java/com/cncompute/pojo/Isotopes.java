package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 放射性同位素 实现类
 * @author Admin
 *2018年9月6日17:03:02
 */
public class Isotopes implements Serializable {
	private static final long serialVersionUID = 2652765644859005854L;
	private String isid;//表ID
	private String isentry;//录入名称
	private Integer islicense;// 辐射安全许可证(0没有选择1选择)
	private Integer isenviro;//环境影响评价批复(0没有选择1选择)
	private Integer isprotection;// 环保竣工验收批复(0没有选择1选择)
	private String islicensebox;//辐射安全许可证是否选取
	private String isenvirobox;//环境影响评价批复是否选取
	private String isprotectionbox;//环保竣工验收批复是否选取
	private String isuserid;// 当前登录用户ID
	private Date istime;// 当前时间
	private Integer isstate;// 表状态0正常1删除
	private Radioactiveentry radioactiveentry;//放射性同位素录入信息
	Set<Radioactiveentry> radioactiveentrys=new HashSet<Radioactiveentry>();
	private Sealentry sealentry;//密封源录入信息
	Set<Sealentry> sealentrys=new HashSet<Sealentry>();
	private Xauxiliary xauxiliary;//辅助决策
	Set<Xauxiliary> xauxiliarys=new HashSet<Xauxiliary>();
	public Isotopes() {
	}
	public Isotopes(String isid, String isentry, Integer islicense, Integer isenviro, Integer isprotection,
			String islicensebox, String isenvirobox, String isprotectionbox, String isuserid, Date istime,
			Integer isstate, Radioactiveentry radioactiveentry, Set<Radioactiveentry> radioactiveentrys,
			Sealentry sealentry, Set<Sealentry> sealentrys, Xauxiliary xauxiliary, Set<Xauxiliary> xauxiliarys) {
		this.isid = isid;
		this.isentry = isentry;
		this.islicense = islicense;
		this.isenviro = isenviro;
		this.isprotection = isprotection;
		this.islicensebox = islicensebox;
		this.isenvirobox = isenvirobox;
		this.isprotectionbox = isprotectionbox;
		this.isuserid = isuserid;
		this.istime = istime;
		this.isstate = isstate;
		this.radioactiveentry = radioactiveentry;
		this.radioactiveentrys = radioactiveentrys;
		this.sealentry = sealentry;
		this.sealentrys = sealentrys;
		this.xauxiliary = xauxiliary;
		this.xauxiliarys = xauxiliarys;
	}
	public String getIsid() {
		return isid;
	}
	public void setIsid(String isid) {
		this.isid = isid;
	}
	public String getIsentry() {
		return isentry;
	}
	public void setIsentry(String isentry) {
		this.isentry = isentry;
	}
	public Integer getIslicense() {
		return islicense;
	}
	public void setIslicense(Integer islicense) {
		this.islicense = islicense;
	}
	public Integer getIsenviro() {
		return isenviro;
	}
	public void setIsenviro(Integer isenviro) {
		this.isenviro = isenviro;
	}
	public Integer getIsprotection() {
		return isprotection;
	}
	public void setIsprotection(Integer isprotection) {
		this.isprotection = isprotection;
	}
	public String getIslicensebox() {
		return islicensebox;
	}
	public void setIslicensebox(String islicensebox) {
		this.islicensebox = islicensebox;
	}
	public String getIsenvirobox() {
		return isenvirobox;
	}
	public void setIsenvirobox(String isenvirobox) {
		this.isenvirobox = isenvirobox;
	}
	public String getIsprotectionbox() {
		return isprotectionbox;
	}
	public void setIsprotectionbox(String isprotectionbox) {
		this.isprotectionbox = isprotectionbox;
	}
	public String getIsuserid() {
		return isuserid;
	}
	public void setIsuserid(String isuserid) {
		this.isuserid = isuserid;
	}
	public Date getIstime() {
		return istime;
	}
	public void setIstime(Date istime) {
		this.istime = istime;
	}
	public Integer getIsstate() {
		return isstate;
	}
	public void setIsstate(Integer isstate) {
		this.isstate = isstate;
	}
	public Radioactiveentry getRadioactiveentry() {
		return radioactiveentry;
	}
	public void setRadioactiveentry(Radioactiveentry radioactiveentry) {
		this.radioactiveentry = radioactiveentry;
	}
	public Set<Radioactiveentry> getRadioactiveentrys() {
		return radioactiveentrys;
	}
	public void setRadioactiveentrys(Set<Radioactiveentry> radioactiveentrys) {
		this.radioactiveentrys = radioactiveentrys;
	}
	public Sealentry getSealentry() {
		return sealentry;
	}
	public void setSealentry(Sealentry sealentry) {
		this.sealentry = sealentry;
	}
	public Set<Sealentry> getSealentrys() {
		return sealentrys;
	}
	public void setSealentrys(Set<Sealentry> sealentrys) {
		this.sealentrys = sealentrys;
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
