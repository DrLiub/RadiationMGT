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
	private Integer tychoose1;//放射源销售
	private Integer tychoose2;//放射源销Ⅰ类
	private Integer tychoose3;//放射源销Ⅱ类
	private Integer tychoose4;//放射源销Ⅲ类
	private Integer tychoose5;//放射源销Ⅳ类
	private Integer tychoose6;//放射源销Ⅴ类
	private Integer tychoose7;//放射源使用
	private Integer tychoose8;//放射源使Ⅰ类
	private Integer tychoose9;//放射源使Ⅱ类
	private Integer tychoose10;//放射源使Ⅲ类
	private Integer tychoose11;//放射源使Ⅳ类
	private Integer tychoose12;//放射源使Ⅴ类
	private Integer tychoose13;//非甲级生产
	private Integer tychoose14;//非制备PET用放射性药物
	private Integer tychoose15;//非销售
	private Integer tychoose16;//非使用
	private Integer tychoose17;//非乙
	private Integer tychoose18;//非丙
	private Integer tychoose19;//射线装置生产
	private Integer tychoose20;//射线装置生产Ⅱ类
	private Integer tychoose21;//射线装置生产Ⅲ类
	private Integer tychoose22;//射线装置销售
	private Integer tychoose23;//射线装置销售Ⅱ类
	private Integer tychoose24;//射线装置销售Ⅲ类
	private Integer tychoose25;//射线装置使用
	private Integer tychoose26;//射线装置使用Ⅱ类
	private Integer tychoose27;//射线装置使用Ⅲ类
	private String tyuserid;//当前登录用户
	private String tytime;//当前时间
	private Integer tystaty;//表状态
	
	private Protectionfile protectionfile;//环保手续文件实现类
	Set<Protectionfile> protectionfiles=new HashSet<Protectionfile>();
	public Typelicense() {
	}
	public Typelicense(String tyid, String tynumber, Integer tychoose1, Integer tychoose2, Integer tychoose3,
			Integer tychoose4, Integer tychoose5, Integer tychoose6, Integer tychoose7, Integer tychoose8,
			Integer tychoose9, Integer tychoose10, Integer tychoose11, Integer tychoose12, Integer tychoose13,
			Integer tychoose14, Integer tychoose15, Integer tychoose16, Integer tychoose17, Integer tychoose18,
			Integer tychoose19, Integer tychoose20, Integer tychoose21, Integer tychoose22, Integer tychoose23,
			Integer tychoose24, Integer tychoose25, Integer tychoose26, Integer tychoose27, String tyuserid,
			String tytime, Integer tystaty, Protectionfile protectionfile, Set<Protectionfile> protectionfiles) {
		this.tyid = tyid;
		this.tynumber = tynumber;
		this.tychoose1 = tychoose1;
		this.tychoose2 = tychoose2;
		this.tychoose3 = tychoose3;
		this.tychoose4 = tychoose4;
		this.tychoose5 = tychoose5;
		this.tychoose6 = tychoose6;
		this.tychoose7 = tychoose7;
		this.tychoose8 = tychoose8;
		this.tychoose9 = tychoose9;
		this.tychoose10 = tychoose10;
		this.tychoose11 = tychoose11;
		this.tychoose12 = tychoose12;
		this.tychoose13 = tychoose13;
		this.tychoose14 = tychoose14;
		this.tychoose15 = tychoose15;
		this.tychoose16 = tychoose16;
		this.tychoose17 = tychoose17;
		this.tychoose18 = tychoose18;
		this.tychoose19 = tychoose19;
		this.tychoose20 = tychoose20;
		this.tychoose21 = tychoose21;
		this.tychoose22 = tychoose22;
		this.tychoose23 = tychoose23;
		this.tychoose24 = tychoose24;
		this.tychoose25 = tychoose25;
		this.tychoose26 = tychoose26;
		this.tychoose27 = tychoose27;
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
	public Integer getTychoose1() {
		return tychoose1;
	}
	public void setTychoose1(Integer tychoose1) {
		this.tychoose1 = tychoose1;
	}
	public Integer getTychoose2() {
		return tychoose2;
	}
	public void setTychoose2(Integer tychoose2) {
		this.tychoose2 = tychoose2;
	}
	public Integer getTychoose3() {
		return tychoose3;
	}
	public void setTychoose3(Integer tychoose3) {
		this.tychoose3 = tychoose3;
	}
	public Integer getTychoose4() {
		return tychoose4;
	}
	public void setTychoose4(Integer tychoose4) {
		this.tychoose4 = tychoose4;
	}
	public Integer getTychoose5() {
		return tychoose5;
	}
	public void setTychoose5(Integer tychoose5) {
		this.tychoose5 = tychoose5;
	}
	public Integer getTychoose6() {
		return tychoose6;
	}
	public void setTychoose6(Integer tychoose6) {
		this.tychoose6 = tychoose6;
	}
	public Integer getTychoose7() {
		return tychoose7;
	}
	public void setTychoose7(Integer tychoose7) {
		this.tychoose7 = tychoose7;
	}
	public Integer getTychoose8() {
		return tychoose8;
	}
	public void setTychoose8(Integer tychoose8) {
		this.tychoose8 = tychoose8;
	}
	public Integer getTychoose9() {
		return tychoose9;
	}
	public void setTychoose9(Integer tychoose9) {
		this.tychoose9 = tychoose9;
	}
	public Integer getTychoose10() {
		return tychoose10;
	}
	public void setTychoose10(Integer tychoose10) {
		this.tychoose10 = tychoose10;
	}
	public Integer getTychoose11() {
		return tychoose11;
	}
	public void setTychoose11(Integer tychoose11) {
		this.tychoose11 = tychoose11;
	}
	public Integer getTychoose12() {
		return tychoose12;
	}
	public void setTychoose12(Integer tychoose12) {
		this.tychoose12 = tychoose12;
	}
	public Integer getTychoose13() {
		return tychoose13;
	}
	public void setTychoose13(Integer tychoose13) {
		this.tychoose13 = tychoose13;
	}
	public Integer getTychoose14() {
		return tychoose14;
	}
	public void setTychoose14(Integer tychoose14) {
		this.tychoose14 = tychoose14;
	}
	public Integer getTychoose15() {
		return tychoose15;
	}
	public void setTychoose15(Integer tychoose15) {
		this.tychoose15 = tychoose15;
	}
	public Integer getTychoose16() {
		return tychoose16;
	}
	public void setTychoose16(Integer tychoose16) {
		this.tychoose16 = tychoose16;
	}
	public Integer getTychoose17() {
		return tychoose17;
	}
	public void setTychoose17(Integer tychoose17) {
		this.tychoose17 = tychoose17;
	}
	public Integer getTychoose18() {
		return tychoose18;
	}
	public void setTychoose18(Integer tychoose18) {
		this.tychoose18 = tychoose18;
	}
	public Integer getTychoose19() {
		return tychoose19;
	}
	public void setTychoose19(Integer tychoose19) {
		this.tychoose19 = tychoose19;
	}
	public Integer getTychoose20() {
		return tychoose20;
	}
	public void setTychoose20(Integer tychoose20) {
		this.tychoose20 = tychoose20;
	}
	public Integer getTychoose21() {
		return tychoose21;
	}
	public void setTychoose21(Integer tychoose21) {
		this.tychoose21 = tychoose21;
	}
	public Integer getTychoose22() {
		return tychoose22;
	}
	public void setTychoose22(Integer tychoose22) {
		this.tychoose22 = tychoose22;
	}
	public Integer getTychoose23() {
		return tychoose23;
	}
	public void setTychoose23(Integer tychoose23) {
		this.tychoose23 = tychoose23;
	}
	public Integer getTychoose24() {
		return tychoose24;
	}
	public void setTychoose24(Integer tychoose24) {
		this.tychoose24 = tychoose24;
	}
	public Integer getTychoose25() {
		return tychoose25;
	}
	public void setTychoose25(Integer tychoose25) {
		this.tychoose25 = tychoose25;
	}
	public Integer getTychoose26() {
		return tychoose26;
	}
	public void setTychoose26(Integer tychoose26) {
		this.tychoose26 = tychoose26;
	}
	public Integer getTychoose27() {
		return tychoose27;
	}
	public void setTychoose27(Integer tychoose27) {
		this.tychoose27 = tychoose27;
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
	public Integer getTystaty() {
		return tystaty;
	}
	public void setTystaty(Integer tystaty) {
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
