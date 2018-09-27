package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Oneself;

/**
 * 表oneself(辐射环境监测数据)表的Dao层
 * @author Admin
 *2018年8月21日14:03:44
 */
public interface OneselfDao {
	/**
	 * 插入oneself表信息
	 * @param one
	 */
	public void onInsert(Oneself one);
	/**
	 * 根据表编号查oneself表信息 
	 * 1位单位2位委托
	 * @param notag
	 */
	public List<Oneself> onQuery(String noid, Integer notag);
	/**
	 * 模糊查询
	 * @param name
	 * @param notag
	 * @return
	 */
	public List<Oneself> fuzzyOnes(String name,Integer notag);
	/**
	 * 根据notag查询信息返回一个集合
	 * 1位单位2位委托
	 * @param notag
	 * @return
	 */
	public List<Oneself> queryEntrust(Integer notag);
	/**
	 * 根据ID删除信息
	 * @param nonumberid
	 */
	public void onDelete(String nonumberid);
	/**
	 * 修改oneself表信息
	 * @param ones
	 */
	public void onUpdate(Oneself ones);
	/**
	 * 通过nonumberid查询出信息，返回Oneself对象
	 * @param nonumberid
	 * @return
	 */
	public Oneself onOnid(String nonumberid);
}
