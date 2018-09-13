package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.User;

/**
 * user表的Dao方法
 * @author 劉 
 * 2018年7月24日09:48:03
 */
public interface UserDao {
	/**
	 * 通过用户ID查询用户信息，返回一个用户对象
	 * @param userid
	 * @return
	 */
	public User getUserAll(String userid);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> AllUser();
    /**
     * 注册新用户
     * @param user
     */
	public void addUser(User user);
	/**
	 * 修改密码
	 * @param user
	 */
	public void modify(User user);
}
