package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 射线装置-X射线机
 * @author Admin
 *2018年8月30日15:18:34
 */
public class Xraymachine implements Serializable {
	private static final long serialVersionUID = 8690431794899146652L;
	private String raid;// 表ID
	private String ranumber;// 信息编号
	private String raname;// 名称
	private String ramodel;// 厂家及型号
	private String ravoltage;// 最大管电压
	private String racurrent;//最大输出电流
	private String rause;// 用途
	private String raplace;// 工作场所
	private String racategory;// 类别
	private String ranote;//备注
	private String rainputtime;//投入使用时间
	private String rabuilding;//楼宇
	private String raroom;// 房间信息
	private Date ratime;// 当前时间
	private String rauserid;// 当前登录用户ID
	private Integer rastate;// 表状态0删除1正常
	private Xraydevice xraydevice;//射线装置表实现类
	Set<Xraydevice> xraydevices=new HashSet<Xraydevice>();
	public Xraymachine() {
	}
	public Xraymachine(String raid, String ranumber, String raname, String ramodel, String ravoltage, String racurrent,
			String rause, String raplace, String racategory, String ranote, String rainputtime, String rabuilding,
			String raroom, Date ratime, String rauserid, Integer rastate, Xraydevice xraydevice,
			Set<Xraydevice> xraydevices) {
		this.raid = raid;
		this.ranumber = ranumber;
		this.raname = raname;
		this.ramodel = ramodel;
		this.ravoltage = ravoltage;
		this.racurrent = racurrent;
		this.rause = rause;
		this.raplace = raplace;
		this.racategory = racategory;
		this.ranote = ranote;
		this.rainputtime = rainputtime;
		this.rabuilding = rabuilding;
		this.raroom = raroom;
		this.ratime = ratime;
		this.rauserid = rauserid;
		this.rastate = rastate;
		this.xraydevice = xraydevice;
		this.xraydevices = xraydevices;
	}
	public String getRaid() {
		return raid;
	}
	public void setRaid(String raid) {
		this.raid = raid;
	}
	public String getRanumber() {
		return ranumber;
	}
	public void setRanumber(String ranumber) {
		this.ranumber = ranumber;
	}
	public String getRaname() {
		return raname;
	}
	public void setRaname(String raname) {
		this.raname = raname;
	}
	public String getRamodel() {
		return ramodel;
	}
	public void setRamodel(String ramodel) {
		this.ramodel = ramodel;
	}
	public String getRavoltage() {
		return ravoltage;
	}
	public void setRavoltage(String ravoltage) {
		this.ravoltage = ravoltage;
	}
	public String getRacurrent() {
		return racurrent;
	}
	public void setRacurrent(String racurrent) {
		this.racurrent = racurrent;
	}
	public String getRause() {
		return rause;
	}
	public void setRause(String rause) {
		this.rause = rause;
	}
	public String getRaplace() {
		return raplace;
	}
	public void setRaplace(String raplace) {
		this.raplace = raplace;
	}
	public String getRacategory() {
		return racategory;
	}
	public void setRacategory(String racategory) {
		this.racategory = racategory;
	}
	public String getRanote() {
		return ranote;
	}
	public void setRanote(String ranote) {
		this.ranote = ranote;
	}
	public String getRainputtime() {
		return rainputtime;
	}
	public void setRainputtime(String rainputtime) {
		this.rainputtime = rainputtime;
	}
	public String getRabuilding() {
		return rabuilding;
	}
	public void setRabuilding(String rabuilding) {
		this.rabuilding = rabuilding;
	}
	public String getRaroom() {
		return raroom;
	}
	public void setRaroom(String raroom) {
		this.raroom = raroom;
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
	public Xraydevice getXraydevice() {
		return xraydevice;
	}
	public void setXraydevice(Xraydevice xraydevice) {
		this.xraydevice = xraydevice;
	}
	public Set<Xraydevice> getXraydevices() {
		return xraydevices;
	}
	public void setXraydevices(Set<Xraydevice> xraydevices) {
		this.xraydevices = xraydevices;
	}
}
