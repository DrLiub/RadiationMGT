package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 射线装置-中子发生器
 * @author Admin
 *2018年8月30日15:14:24
 */
public class Xneutron implements Serializable {
	private static final long serialVersionUID = -6215528928652291264L;
	private String neid;// 表ID
	private String nemodel;// 型号
	private String nemanufacturer;// 生产厂家
	private String nevoltage;// 电压
	private String nebeflow;// 靶流
	private String neneutron;// 中子强度
	private String neuse;// 用途
	private String nenote;// 备注
	private String negasactivity;// 氚气-活度
	private String negasway;// 氚气-保管方式
	private String negasnote;// 氚气-备注
	private String negasnum;// 氚气-数量
	private String newasteactivity;// 废气-总活度
	private String newastered;// 废气-放射性同位素
	private String newastewhere;// 废气-废物去向
	private String neliquidlive;// 氚液-活度
	private String neliquidway;// 氚液保管方式
	private String neliquidnote;// 氚液-备注
	private String neliquidnum;// 氚液-数量
	private String nelwanum;// 废液-数量
	private String nelwalive;// 废液-总活度
	private String nelwarad;// 废液-放射性同位素
	private String nelwawhere;// 废液-废物去向
	private String netsolive;// 氚固-活度
	private String netsoway;// 氚固-保管方式
	private String netsonote;// 氚固-备注
	private String nersonum;// 氚固-数量
	private String neswanum;// 废固-数量
	private String neswalive;// 废固-总活度
	private String neswarad;// 废固-放射性同位素
	private String neswawhere;// 废固-去向
	private String neswainput;// 投入使用时间
	private String nebuikding;// 楼宇
	private String neroom;// 房间信息
	private String neswauserid;// 当前登录用户ID
	private Date netime;// 当前时间
	private Integer nestate;// 表状态0删除1正常
	private Xraydevice xraydevice;// 射线装置表实现类
	Set<Xraydevice> xraydevices = new HashSet<Xraydevice>();
	public Xneutron() {
	}
	public Xneutron(String neid, String nemodel, String nemanufacturer, String nevoltage, String nebeflow,
			String neneutron, String neuse, String nenote, String negasactivity, String negasway, String negasnote,
			String negasnum, String newasteactivity, String newastered, String newastewhere, String neliquidlive,
			String neliquidway, String neliquidnote, String neliquidnum, String nelwanum, String nelwalive,
			String nelwarad, String nelwawhere, String netsolive, String netsoway, String netsonote, String nersonum,
			String neswanum, String neswalive, String neswarad, String neswawhere, String neswainput, String nebuikding,
			String neroom, String neswauserid, Date netime, Integer nestate, Xraydevice xraydevice,
			Set<Xraydevice> xraydevices) {
		this.neid = neid;
		this.nemodel = nemodel;
		this.nemanufacturer = nemanufacturer;
		this.nevoltage = nevoltage;
		this.nebeflow = nebeflow;
		this.neneutron = neneutron;
		this.neuse = neuse;
		this.nenote = nenote;
		this.negasactivity = negasactivity;
		this.negasway = negasway;
		this.negasnote = negasnote;
		this.negasnum = negasnum;
		this.newasteactivity = newasteactivity;
		this.newastered = newastered;
		this.newastewhere = newastewhere;
		this.neliquidlive = neliquidlive;
		this.neliquidway = neliquidway;
		this.neliquidnote = neliquidnote;
		this.neliquidnum = neliquidnum;
		this.nelwanum = nelwanum;
		this.nelwalive = nelwalive;
		this.nelwarad = nelwarad;
		this.nelwawhere = nelwawhere;
		this.netsolive = netsolive;
		this.netsoway = netsoway;
		this.netsonote = netsonote;
		this.nersonum = nersonum;
		this.neswanum = neswanum;
		this.neswalive = neswalive;
		this.neswarad = neswarad;
		this.neswawhere = neswawhere;
		this.neswainput = neswainput;
		this.nebuikding = nebuikding;
		this.neroom = neroom;
		this.neswauserid = neswauserid;
		this.netime = netime;
		this.nestate = nestate;
		this.xraydevice = xraydevice;
		this.xraydevices = xraydevices;
	}
	public String getNeid() {
		return neid;
	}
	public void setNeid(String neid) {
		this.neid = neid;
	}
	public String getNemodel() {
		return nemodel;
	}
	public void setNemodel(String nemodel) {
		this.nemodel = nemodel;
	}
	public String getNemanufacturer() {
		return nemanufacturer;
	}
	public void setNemanufacturer(String nemanufacturer) {
		this.nemanufacturer = nemanufacturer;
	}
	public String getNevoltage() {
		return nevoltage;
	}
	public void setNevoltage(String nevoltage) {
		this.nevoltage = nevoltage;
	}
	public String getNebeflow() {
		return nebeflow;
	}
	public void setNebeflow(String nebeflow) {
		this.nebeflow = nebeflow;
	}
	public String getNeneutron() {
		return neneutron;
	}
	public void setNeneutron(String neneutron) {
		this.neneutron = neneutron;
	}
	public String getNeuse() {
		return neuse;
	}
	public void setNeuse(String neuse) {
		this.neuse = neuse;
	}
	public String getNenote() {
		return nenote;
	}
	public void setNenote(String nenote) {
		this.nenote = nenote;
	}
	public String getNegasactivity() {
		return negasactivity;
	}
	public void setNegasactivity(String negasactivity) {
		this.negasactivity = negasactivity;
	}
	public String getNegasway() {
		return negasway;
	}
	public void setNegasway(String negasway) {
		this.negasway = negasway;
	}
	public String getNegasnote() {
		return negasnote;
	}
	public void setNegasnote(String negasnote) {
		this.negasnote = negasnote;
	}
	public String getNegasnum() {
		return negasnum;
	}
	public void setNegasnum(String negasnum) {
		this.negasnum = negasnum;
	}
	public String getNewasteactivity() {
		return newasteactivity;
	}
	public void setNewasteactivity(String newasteactivity) {
		this.newasteactivity = newasteactivity;
	}
	public String getNewastered() {
		return newastered;
	}
	public void setNewastered(String newastered) {
		this.newastered = newastered;
	}
	public String getNewastewhere() {
		return newastewhere;
	}
	public void setNewastewhere(String newastewhere) {
		this.newastewhere = newastewhere;
	}
	public String getNeliquidlive() {
		return neliquidlive;
	}
	public void setNeliquidlive(String neliquidlive) {
		this.neliquidlive = neliquidlive;
	}
	public String getNeliquidway() {
		return neliquidway;
	}
	public void setNeliquidway(String neliquidway) {
		this.neliquidway = neliquidway;
	}
	public String getNeliquidnote() {
		return neliquidnote;
	}
	public void setNeliquidnote(String neliquidnote) {
		this.neliquidnote = neliquidnote;
	}
	public String getNeliquidnum() {
		return neliquidnum;
	}
	public void setNeliquidnum(String neliquidnum) {
		this.neliquidnum = neliquidnum;
	}
	public String getNelwanum() {
		return nelwanum;
	}
	public void setNelwanum(String nelwanum) {
		this.nelwanum = nelwanum;
	}
	public String getNelwalive() {
		return nelwalive;
	}
	public void setNelwalive(String nelwalive) {
		this.nelwalive = nelwalive;
	}
	public String getNelwarad() {
		return nelwarad;
	}
	public void setNelwarad(String nelwarad) {
		this.nelwarad = nelwarad;
	}
	public String getNelwawhere() {
		return nelwawhere;
	}
	public void setNelwawhere(String nelwawhere) {
		this.nelwawhere = nelwawhere;
	}
	public String getNetsolive() {
		return netsolive;
	}
	public void setNetsolive(String netsolive) {
		this.netsolive = netsolive;
	}
	public String getNetsoway() {
		return netsoway;
	}
	public void setNetsoway(String netsoway) {
		this.netsoway = netsoway;
	}
	public String getNetsonote() {
		return netsonote;
	}
	public void setNetsonote(String netsonote) {
		this.netsonote = netsonote;
	}
	public String getNersonum() {
		return nersonum;
	}
	public void setNersonum(String nersonum) {
		this.nersonum = nersonum;
	}
	public String getNeswanum() {
		return neswanum;
	}
	public void setNeswanum(String neswanum) {
		this.neswanum = neswanum;
	}
	public String getNeswalive() {
		return neswalive;
	}
	public void setNeswalive(String neswalive) {
		this.neswalive = neswalive;
	}
	public String getNeswarad() {
		return neswarad;
	}
	public void setNeswarad(String neswarad) {
		this.neswarad = neswarad;
	}
	public String getNeswawhere() {
		return neswawhere;
	}
	public void setNeswawhere(String neswawhere) {
		this.neswawhere = neswawhere;
	}
	public String getNeswainput() {
		return neswainput;
	}
	public void setNeswainput(String neswainput) {
		this.neswainput = neswainput;
	}
	public String getNebuikding() {
		return nebuikding;
	}
	public void setNebuikding(String nebuikding) {
		this.nebuikding = nebuikding;
	}
	public String getNeroom() {
		return neroom;
	}
	public void setNeroom(String neroom) {
		this.neroom = neroom;
	}
	public String getNeswauserid() {
		return neswauserid;
	}
	public void setNeswauserid(String neswauserid) {
		this.neswauserid = neswauserid;
	}
	public Date getNetime() {
		return netime;
	}
	public void setNetime(Date netime) {
		this.netime = netime;
	}
	public Integer getNestate() {
		return nestate;
	}
	public void setNestate(Integer nestate) {
		this.nestate = nestate;
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
