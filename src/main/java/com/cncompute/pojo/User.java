package com.cncompute.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表user的实现类
 * @author 劉
 *2018年7月24日09:23:27
 */
public class User implements Serializable{
	private static final long serialVersionUID = 6020501469958820126L;
    private String userid;//用户ID
    private String password;//密码
    private String username;//姓名
    private Integer permissions;//权限2为普通用户1为超级用户
    private String userperm;//权限
    private Date usertime;//当前时间
    private String question;//找回密码问题
    private String answer;//找回密码答案
    private Date updatetime;//最后一次更新时间
    private Integer userstate;//状态
	public User() {
	}
	public User(String userid, String password, String username, Integer permissions, String userperm, Date usertime,
			String question, String answer, Date updatetime, Integer userstate) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.permissions = permissions;
		this.userperm = userperm;
		this.usertime = usertime;
		this.question = question;
		this.answer = answer;
		this.updatetime = updatetime;
		this.userstate = userstate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getPermissions() {
		return permissions;
	}
	public void setPermissions(Integer permissions) {
		this.permissions = permissions;
	}
	public String getUserperm() {
		return userperm;
	}
	public void setUserperm(String userperm) {
		this.userperm = userperm;
	}
	public Date getUsertime() {
		return usertime;
	}
	public void setUsertime(Date usertime) {
		this.usertime = usertime;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getUserstate() {
		return userstate;
	}
	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}
}
