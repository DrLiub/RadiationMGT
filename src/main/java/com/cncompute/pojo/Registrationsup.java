package com.cncompute.pojo;

import java.io.Serializable;
/**
 * 监测设备、报警仪器和辐射防护用品登记表的实现类
 * @author Admin
 *2018年8月20日10:19:45
 */
public class Registrationsup implements Serializable {
	private static final long serialVersionUID = -7067370037886136252L;
	private String reid;// 表ID
	private Integer retable;// 1：辐射环境监测设备2：辐射环境安全报警仪器3：辐射防护用品
	private String renameof;// 名称
	private String remodel;// 型号
	private String rebuytime;// 购置日期
	private String reitemssatte;// 状态
	private String renum;// 数量
	private String rebrand;// 品牌
	private String relocation;// 位置信息
	private String rehead;// 管理责任人
	private String reuserid;// 当前登录ID
	private String retime;// 当前时间
	private Integer restate;// 状态：0删除1正常
	public Registrationsup() {
	}
	public Registrationsup(String reid, Integer retable, String renameof, String remodel, String rebuytime,
			String reitemssatte, String renum, String rebrand, String relocation, String rehead, String reuserid,
			String retime, Integer restate) {
		this.reid = reid;
		this.retable = retable;
		this.renameof = renameof;
		this.remodel = remodel;
		this.rebuytime = rebuytime;
		this.reitemssatte = reitemssatte;
		this.renum = renum;
		this.rebrand = rebrand;
		this.relocation = relocation;
		this.rehead = rehead;
		this.reuserid = reuserid;
		this.retime = retime;
		this.restate = restate;
	}
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public Integer getRetable() {
		return retable;
	}
	public void setRetable(Integer retable) {
		this.retable = retable;
	}
	public String getRenameof() {
		return renameof;
	}
	public void setRenameof(String renameof) {
		this.renameof = renameof;
	}
	public String getRemodel() {
		return remodel;
	}
	public void setRemodel(String remodel) {
		this.remodel = remodel;
	}
	public String getRebuytime() {
		return rebuytime;
	}
	public void setRebuytime(String rebuytime) {
		this.rebuytime = rebuytime;
	}
	public String getReitemssatte() {
		return reitemssatte;
	}
	public void setReitemssatte(String reitemssatte) {
		this.reitemssatte = reitemssatte;
	}
	public String getRenum() {
		return renum;
	}
	public void setRenum(String renum) {
		this.renum = renum;
	}
	public String getRebrand() {
		return rebrand;
	}
	public void setRebrand(String rebrand) {
		this.rebrand = rebrand;
	}
	public String getRelocation() {
		return relocation;
	}
	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}
	public String getRehead() {
		return rehead;
	}
	public void setRehead(String rehead) {
		this.rehead = rehead;
	}
	public String getReuserid() {
		return reuserid;
	}
	public void setReuserid(String reuserid) {
		this.reuserid = reuserid;
	}
	public String getRetime() {
		return retime;
	}
	public void setRetime(String retime) {
		this.retime = retime;
	}
	public Integer getRestate() {
		return restate;
	}
	public void setRestate(Integer restate) {
		this.restate = restate;
	}
}
