package com.cncompute.pojo;

import java.io.Serializable;
/**
 * 安全措施表实现类
 * @author Admin
 *2018年9月4日11:58:50
 */
public class Safetysheet implements Serializable{
	private static final long serialVersionUID = -8827009438858823255L;
    private String saname;//表名
    private String sanumber;//表编号
    private String sapage;//表地址
    private String saattribute;//表类别1、生产放射性同位素2、非医用放射性同位素使用3、非医用射线装置使用4、医用放射性同位素使用5、医用射线装置使用
    private String sanameof;//表名字
    private String sastate;//是否已选取
	public Safetysheet() {
	}
	public Safetysheet(String saname, String sanumber, String sapage, String saattribute, String sanameof,
			String sastate) {
		this.saname = saname;
		this.sanumber = sanumber;
		this.sapage = sapage;
		this.saattribute = saattribute;
		this.sanameof = sanameof;
		this.sastate = sastate;
	}
	public String getSaname() {
		return saname;
	}
	public void setSaname(String saname) {
		this.saname = saname;
	}
	public String getSanumber() {
		return sanumber;
	}
	public void setSanumber(String sanumber) {
		this.sanumber = sanumber;
	}
	public String getSapage() {
		return sapage;
	}
	public void setSapage(String sapage) {
		this.sapage = sapage;
	}
	public String getSaattribute() {
		return saattribute;
	}
	public void setSaattribute(String saattribute) {
		this.saattribute = saattribute;
	}
	public String getSanameof() {
		return sanameof;
	}
	public void setSanameof(String sanameof) {
		this.sanameof = sanameof;
	}
	public String getSastate() {
		return sastate;
	}
	public void setSastate(String sastate) {
		this.sastate = sastate;
	}
}
