package com.cncompute.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 辅助决策
 * @author Admin
 *2018年8月30日15:40:14
 */
public class Xauxiliary implements Serializable {
	private static final long serialVersionUID = -8031523335792341237L;
	private String auid;// 表ID(辅助决策)
	private String aunumber;// 措施编号
	private String ausecurity;// 必备辐射安全措施表地址
	private String auname;// 安全措施名称
	private Integer auexisting;// 表是否已选
	private Integer austate;// 表状态0删除1正常
	private String autime;//当前时间
	private String auserial;//信息编号
	private String aucategory;//类别名称
	private Xraydevice xraydevice;// 射线装置表实现类
	Set<Xraydevice> xraydevices = new HashSet<Xraydevice>();
	public Xauxiliary() {
	}
	public Xauxiliary(String auid, String aunumber, String ausecurity, String auname, Integer auexisting,
			Integer austate, String autime, String auserial, String aucategory, Xraydevice xraydevice,
			Set<Xraydevice> xraydevices) {
		this.auid = auid;
		this.aunumber = aunumber;
		this.ausecurity = ausecurity;
		this.auname = auname;
		this.auexisting = auexisting;
		this.austate = austate;
		this.autime = autime;
		this.auserial = auserial;
		this.aucategory = aucategory;
		this.xraydevice = xraydevice;
		this.xraydevices = xraydevices;
	}
	public String getAuid() {
		return auid;
	}
	public void setAuid(String auid) {
		this.auid = auid;
	}
	public String getAunumber() {
		return aunumber;
	}
	public void setAunumber(String aunumber) {
		this.aunumber = aunumber;
	}
	public String getAusecurity() {
		return ausecurity;
	}
	public void setAusecurity(String ausecurity) {
		this.ausecurity = ausecurity;
	}
	public String getAuname() {
		return auname;
	}
	public void setAuname(String auname) {
		this.auname = auname;
	}
	public Integer getAuexisting() {
		return auexisting;
	}
	public void setAuexisting(Integer auexisting) {
		this.auexisting = auexisting;
	}
	public Integer getAustate() {
		return austate;
	}
	public void setAustate(Integer austate) {
		this.austate = austate;
	}
	public String getAutime() {
		return autime;
	}
	public void setAutime(String autime) {
		this.autime = autime;
	}
	public String getAuserial() {
		return auserial;
	}
	public void setAuserial(String auserial) {
		this.auserial = auserial;
	}
	public String getAucategory() {
		return aucategory;
	}
	public void setAucategory(String aucategory) {
		this.aucategory = aucategory;
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
