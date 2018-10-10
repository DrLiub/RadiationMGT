package com.cncompute.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 许可种类与范围实现类
 * @author Admin 
 * 2018年10月10日11:35:01
 */
public class Typelicense implements Serializable {
	private static final long serialVersionUID = -4216166284867646265L;
	private String tyid;//表ID
	private String tynumber;//信息编号
	private String tysales;//放射源销售
	private String tysalesa;//放射源销Ⅰ类
	private String tysalesb;//放射源销Ⅱ类
	private String tysalesc;//放射源销Ⅲ类
	private String tysalesd;//放射源销Ⅳ类
	private String tysalese;//放射源销Ⅴ类
	private String tyuse;//放射源使用
	private String tyusea;//放射源使Ⅰ类
	private String tyuseb;//放射源使Ⅱ类
	private String tyusec;//放射源使Ⅲ类
	private String tyused;//放射源使Ⅳ类
	private String tyusee;//放射源使Ⅴ类
	private String typroduction;//非甲级生产
	private String typroductionpet;//非制备PET用放射性药物
	private String tyfsales;//非销售
	private String tyfuse;//非使用
	private String tyfb;//非乙
	private String tyfc;//非丙
	private String tysproduction;//射线装置生产
	private String tysproductionb;//射线装置生产Ⅱ类
	private String tysproductionc;//射线装置生产Ⅲ类
	private String tyssales;//射线装置销售
	private String tyssalesb;//射线装置销售Ⅱ类
	private String tyssalesc;//射线装置销售Ⅲ类
	private String tysuse;//射线装置使用
	private String tysuseb;//射线装置使用Ⅱ类
	private String tysusec;//射线装置使用Ⅲ类
	private String tyuserid;//当前登录用户
	private String tytime;//当前时间
	private String tystaty;//表状态
	
	private Protectionfile protectionfile;//环保手续文件实现类
	Set<Protectionfile> protectionfiles=new HashSet<Protectionfile>();
	public Typelicense() {
	}
	public Typelicense(String tyid, String tynumber, String tysales, String tysalesa, String tysalesb, String tysalesc,
			String tysalesd, String tysalese, String tyuse, String tyusea, String tyuseb, String tyusec, String tyused,
			String tyusee, String typroduction, String typroductionpet, String tyfsales, String tyfuse, String tyfb,
			String tyfc, String tysproduction, String tysproductionb, String tysproductionc, String tyssales,
			String tyssalesb, String tyssalesc, String tysuse, String tysuseb, String tysusec, String tyuserid,
			String tytime, String tystaty, Protectionfile protectionfile, Set<Protectionfile> protectionfiles) {
		this.tyid = tyid;
		this.tynumber = tynumber;
		this.tysales = tysales;
		this.tysalesa = tysalesa;
		this.tysalesb = tysalesb;
		this.tysalesc = tysalesc;
		this.tysalesd = tysalesd;
		this.tysalese = tysalese;
		this.tyuse = tyuse;
		this.tyusea = tyusea;
		this.tyuseb = tyuseb;
		this.tyusec = tyusec;
		this.tyused = tyused;
		this.tyusee = tyusee;
		this.typroduction = typroduction;
		this.typroductionpet = typroductionpet;
		this.tyfsales = tyfsales;
		this.tyfuse = tyfuse;
		this.tyfb = tyfb;
		this.tyfc = tyfc;
		this.tysproduction = tysproduction;
		this.tysproductionb = tysproductionb;
		this.tysproductionc = tysproductionc;
		this.tyssales = tyssales;
		this.tyssalesb = tyssalesb;
		this.tyssalesc = tyssalesc;
		this.tysuse = tysuse;
		this.tysuseb = tysuseb;
		this.tysusec = tysusec;
		this.tyuserid = tyuserid;
		this.tytime = tytime;
		this.tystaty = tystaty;
		this.protectionfile = protectionfile;
		this.protectionfiles = protectionfiles;
	}
	public String getTyid() {
		return tyid;
	}
	public void setTyid(String tyid) {
		this.tyid = tyid;
	}
	public String getTynumber() {
		return tynumber;
	}
	public void setTynumber(String tynumber) {
		this.tynumber = tynumber;
	}
	public String getTysales() {
		return tysales;
	}
	public void setTysales(String tysales) {
		this.tysales = tysales;
	}
	public String getTysalesa() {
		return tysalesa;
	}
	public void setTysalesa(String tysalesa) {
		this.tysalesa = tysalesa;
	}
	public String getTysalesb() {
		return tysalesb;
	}
	public void setTysalesb(String tysalesb) {
		this.tysalesb = tysalesb;
	}
	public String getTysalesc() {
		return tysalesc;
	}
	public void setTysalesc(String tysalesc) {
		this.tysalesc = tysalesc;
	}
	public String getTysalesd() {
		return tysalesd;
	}
	public void setTysalesd(String tysalesd) {
		this.tysalesd = tysalesd;
	}
	public String getTysalese() {
		return tysalese;
	}
	public void setTysalese(String tysalese) {
		this.tysalese = tysalese;
	}
	public String getTyuse() {
		return tyuse;
	}
	public void setTyuse(String tyuse) {
		this.tyuse = tyuse;
	}
	public String getTyusea() {
		return tyusea;
	}
	public void setTyusea(String tyusea) {
		this.tyusea = tyusea;
	}
	public String getTyuseb() {
		return tyuseb;
	}
	public void setTyuseb(String tyuseb) {
		this.tyuseb = tyuseb;
	}
	public String getTyusec() {
		return tyusec;
	}
	public void setTyusec(String tyusec) {
		this.tyusec = tyusec;
	}
	public String getTyused() {
		return tyused;
	}
	public void setTyused(String tyused) {
		this.tyused = tyused;
	}
	public String getTyusee() {
		return tyusee;
	}
	public void setTyusee(String tyusee) {
		this.tyusee = tyusee;
	}
	public String getTyproduction() {
		return typroduction;
	}
	public void setTyproduction(String typroduction) {
		this.typroduction = typroduction;
	}
	public String getTyproductionpet() {
		return typroductionpet;
	}
	public void setTyproductionpet(String typroductionpet) {
		this.typroductionpet = typroductionpet;
	}
	public String getTyfsales() {
		return tyfsales;
	}
	public void setTyfsales(String tyfsales) {
		this.tyfsales = tyfsales;
	}
	public String getTyfuse() {
		return tyfuse;
	}
	public void setTyfuse(String tyfuse) {
		this.tyfuse = tyfuse;
	}
	public String getTyfb() {
		return tyfb;
	}
	public void setTyfb(String tyfb) {
		this.tyfb = tyfb;
	}
	public String getTyfc() {
		return tyfc;
	}
	public void setTyfc(String tyfc) {
		this.tyfc = tyfc;
	}
	public String getTysproduction() {
		return tysproduction;
	}
	public void setTysproduction(String tysproduction) {
		this.tysproduction = tysproduction;
	}
	public String getTysproductionb() {
		return tysproductionb;
	}
	public void setTysproductionb(String tysproductionb) {
		this.tysproductionb = tysproductionb;
	}
	public String getTysproductionc() {
		return tysproductionc;
	}
	public void setTysproductionc(String tysproductionc) {
		this.tysproductionc = tysproductionc;
	}
	public String getTyssales() {
		return tyssales;
	}
	public void setTyssales(String tyssales) {
		this.tyssales = tyssales;
	}
	public String getTyssalesb() {
		return tyssalesb;
	}
	public void setTyssalesb(String tyssalesb) {
		this.tyssalesb = tyssalesb;
	}
	public String getTyssalesc() {
		return tyssalesc;
	}
	public void setTyssalesc(String tyssalesc) {
		this.tyssalesc = tyssalesc;
	}
	public String getTysuse() {
		return tysuse;
	}
	public void setTysuse(String tysuse) {
		this.tysuse = tysuse;
	}
	public String getTysuseb() {
		return tysuseb;
	}
	public void setTysuseb(String tysuseb) {
		this.tysuseb = tysuseb;
	}
	public String getTysusec() {
		return tysusec;
	}
	public void setTysusec(String tysusec) {
		this.tysusec = tysusec;
	}
	public String getTyuserid() {
		return tyuserid;
	}
	public void setTyuserid(String tyuserid) {
		this.tyuserid = tyuserid;
	}
	public String getTytime() {
		return tytime;
	}
	public void setTytime(String tytime) {
		this.tytime = tytime;
	}
	public String getTystaty() {
		return tystaty;
	}
	public void setTystaty(String tystaty) {
		this.tystaty = tystaty;
	}
	public Protectionfile getProtectionfile() {
		return protectionfile;
	}
	public void setProtectionfile(Protectionfile protectionfile) {
		this.protectionfile = protectionfile;
	}
	public Set<Protectionfile> getProtectionfiles() {
		return protectionfiles;
	}
	public void setProtectionfiles(Set<Protectionfile> protectionfiles) {
		this.protectionfiles = protectionfiles;
	}
}
