package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 非密封放射性物质表实现类
 * @author Admin
 *2018年9月10日14:09:32
 */
public class Nonseal implements Serializable {
	private static final long serialVersionUID = -7306561820825941898L;
	private String noid;//表ID
	private String noname;//表名字
	private Integer nolicense;//辐射安全许可证
	private Integer noimpact;//环境影响评价批复
	private Integer noreply;// 环保竣工验收批复
	private String nolicensebox;//
	private String noimpactbox;//
	private String noreplybox;//
	private String nouserid;//当前登录用户ID
	private Date notime;//当前时间
	private Integer nostate;// 表状态0删除1正常
	private String nobuiding;//楼宇
	private String nofloor;//楼层
	private String noroomid;//房间ID
	private String nolevel;//所在场所等级
	private String nolimit;//是否超出限值
	private String a;//甲
	private String b;//乙
	private String c;//丙
	private Roomnuclide roomnuclide;//房间中的核素
	Set<Roomnuclide> roomnuclides=new HashSet<Roomnuclide>();
	private Xauxiliary xauxiliary;//辅助决策
	Set<Xauxiliary> xauxiliarys=new HashSet<Xauxiliary>();
	public Nonseal() {
	}
	public Nonseal(String noid, String noname, Integer nolicense, Integer noimpact, Integer noreply, String nouserid,
			Date notime, Integer nostate, String nobuiding, String nofloor, String noroomid, String nolevel,
			String nolimit, String a, String b, String c, Roomnuclide roomnuclide, Set<Roomnuclide> roomnuclides,
			Xauxiliary xauxiliary, Set<Xauxiliary> xauxiliarys) {
		this.noid = noid;
		this.noname = noname;
		this.nolicense = nolicense;
		this.noimpact = noimpact;
		this.noreply = noreply;
		this.nouserid = nouserid;
		this.notime = notime;
		this.nostate = nostate;
		this.nobuiding = nobuiding;
		this.nofloor = nofloor;
		this.noroomid = noroomid;
		this.nolevel = nolevel;
		this.nolimit = nolimit;
		this.a = a;
		this.b = b;
		this.c = c;
		this.roomnuclide = roomnuclide;
		this.roomnuclides = roomnuclides;
		this.xauxiliary = xauxiliary;
		this.xauxiliarys = xauxiliarys;
	}
	public String getNoid() {
		return noid;
	}
	public void setNoid(String noid) {
		this.noid = noid;
	}
	public String getNoname() {
		return noname;
	}
	public void setNoname(String noname) {
		this.noname = noname;
	}
	public Integer getNolicense() {
		return nolicense;
	}
	public void setNolicense(Integer nolicense) {
		this.nolicense = nolicense;
	}
	public Integer getNoimpact() {
		return noimpact;
	}
	public void setNoimpact(Integer noimpact) {
		this.noimpact = noimpact;
	}
	public Integer getNoreply() {
		return noreply;
	}
	public void setNoreply(Integer noreply) {
		this.noreply = noreply;
	}
	public String getNouserid() {
		return nouserid;
	}
	public void setNouserid(String nouserid) {
		this.nouserid = nouserid;
	}
	public Date getNotime() {
		return notime;
	}
	public void setNotime(Date notime) {
		this.notime = notime;
	}
	public Integer getNostate() {
		return nostate;
	}
	public void setNostate(Integer nostate) {
		this.nostate = nostate;
	}
	public String getNobuiding() {
		return nobuiding;
	}
	public void setNobuiding(String nobuiding) {
		this.nobuiding = nobuiding;
	}
	public String getNofloor() {
		return nofloor;
	}
	public void setNofloor(String nofloor) {
		this.nofloor = nofloor;
	}
	public String getNoroomid() {
		return noroomid;
	}
	public void setNoroomid(String noroomid) {
		this.noroomid = noroomid;
	}
	public String getNolevel() {
		return nolevel;
	}
	public void setNolevel(String nolevel) {
		this.nolevel = nolevel;
	}
	public String getNolimit() {
		return nolimit;
	}
	public void setNolimit(String nolimit) {
		this.nolimit = nolimit;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public Roomnuclide getRoomnuclide() {
		return roomnuclide;
	}
	public void setRoomnuclide(Roomnuclide roomnuclide) {
		this.roomnuclide = roomnuclide;
	}
	public Set<Roomnuclide> getRoomnuclides() {
		return roomnuclides;
	}
	public void setRoomnuclides(Set<Roomnuclide> roomnuclides) {
		this.roomnuclides = roomnuclides;
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
	public String getNolicensebox() {
		return nolicensebox;
	}
	public void setNolicensebox(String nolicensebox) {
		this.nolicensebox = nolicensebox;
	}
	public String getNoimpactbox() {
		return noimpactbox;
	}
	public void setNoimpactbox(String noimpactbox) {
		this.noimpactbox = noimpactbox;
	}
	public String getNoreplybox() {
		return noreplybox;
	}
	public void setNoreplybox(String noreplybox) {
		this.noreplybox = noreplybox;
	}
}
