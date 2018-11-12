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
	private String raname;// 名称型号
	private String radevice;//射线装置
	private String ramanufacturer;//生产厂家
	private String rainput;//投入使用时间
	private String rabuilding;//楼宇
	private String raroom;//房间信息
	private String rause;//用途
	private String ranote;//备注
	
	private int pageNumber;//页码
	
	private String rauserid;// 当前登录id
	private Date ratime;// 当前时间
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	private Integer rastate;// 表状态0删除1正常
	
	private Integer rapermit;//辐射安全许可证1选择0取消
	private String rapermitbox;//辐射安全许可证是否选取
	private Integer raassessmen;//环境影响评价批复
	private String raassessmenbox;//环境影响评价批复否选取
	private Integer racompletion;//环保竣工验收批复
	private String racompletionbox;//环保竣工验收批复否选取
	
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
	public Xraydevice(String raid, String raname, String radevice, String ramanufacturer, String rainput,
			String rabuilding, String raroom, String rause, String ranote, String rauserid, Date ratime,
			Integer rastate, Integer rapermit, String rapermitbox, Integer raassessmen, String raassessmenbox,
			Integer racompletion, String racompletionbox, Xaccelerator xaccelerator, Set<Xaccelerator> xaccelerators,
			Xneutron xneutron, Set<Xneutron> xneutrons, Xraymachine xraymachine, Set<Xraymachine> xraymachines,
			Xauxiliary xauxiliary, Set<Xauxiliary> xauxiliarys) {
		this.raid = raid;
		this.raname = raname;
		this.radevice = radevice;
		this.ramanufacturer = ramanufacturer;
		this.rainput = rainput;
		this.rabuilding = rabuilding;
		this.raroom = raroom;
		this.rause = rause;
		this.ranote = ranote;
		this.rauserid = rauserid;
		this.ratime = ratime;
		this.rastate = rastate;
		this.rapermit = rapermit;
		this.rapermitbox = rapermitbox;
		this.raassessmen = raassessmen;
		this.raassessmenbox = raassessmenbox;
		this.racompletion = racompletion;
		this.racompletionbox = racompletionbox;
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
	public String getRadevice() {
		return radevice;
	}
	public void setRadevice(String radevice) {
		this.radevice = radevice;
	}
	public String getRamanufacturer() {
		return ramanufacturer;
	}
	public void setRamanufacturer(String ramanufacturer) {
		this.ramanufacturer = ramanufacturer;
	}
	public String getRainput() {
		return rainput;
	}
	public void setRainput(String rainput) {
		this.rainput = rainput;
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
	public String getRause() {
		return rause;
	}
	public void setRause(String rause) {
		this.rause = rause;
	}
	public String getRanote() {
		return ranote;
	}
	public void setRanote(String ranote) {
		this.ranote = ranote;
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
	public Integer getRapermit() {
		return rapermit;
	}
	public void setRapermit(Integer rapermit) {
		this.rapermit = rapermit;
	}
	public String getRapermitbox() {
		return rapermitbox;
	}
	public void setRapermitbox(String rapermitbox) {
		this.rapermitbox = rapermitbox;
	}
	public Integer getRaassessmen() {
		return raassessmen;
	}
	public void setRaassessmen(Integer raassessmen) {
		this.raassessmen = raassessmen;
	}
	public String getRaassessmenbox() {
		return raassessmenbox;
	}
	public void setRaassessmenbox(String raassessmenbox) {
		this.raassessmenbox = raassessmenbox;
	}
	public Integer getRacompletion() {
		return racompletion;
	}
	public void setRacompletion(Integer racompletion) {
		this.racompletion = racompletion;
	}
	public String getRacompletionbox() {
		return racompletionbox;
	}
	public void setRacompletionbox(String racompletionbox) {
		this.racompletionbox = racompletionbox;
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
