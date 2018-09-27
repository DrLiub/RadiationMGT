package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Lawsrules;

/**
 * 法律法规表Dao层
 * @author Admin
 *2018年8月29日16:32:59
 */
public interface LawsrulesDao {
	/**
	 * 查询法律法规表的全部信息
	 * @return
	 */
	public List<Lawsrules> queryLaws();
	/**
	 * 法律法规模糊查询
	 * @param name
	 * @return
	 */
	public List<Lawsrules> fuzzyLaws(String name);
	/**
	 * 添加法律法规
	 * @param laws
	 */
	public void addLaws(Lawsrules laws);
}
