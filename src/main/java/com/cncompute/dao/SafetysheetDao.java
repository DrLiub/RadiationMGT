package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Safetysheet;

/**
 * 安全措施表Dao层
 * @author Admin
 *2018年9月4日12:00:11
 */
public interface SafetysheetDao {
	/**
	 * 查询安全措施表
	 * @param number1
	 * @param number2
	 * @return
	 */
	public List<Safetysheet> queryRayma(Integer number1,Integer number2);
	/**
	 * 查询安全措施表
	 * @param number
	 * @return
	 */
	public List<Safetysheet> queryRay(Integer number);
	/**
	 * 通过ID查询安全措施表
	 * @param saname
	 * @return
	 */
	public Safetysheet queryAuid(String saname);
}
