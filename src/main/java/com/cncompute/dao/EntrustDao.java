package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Entrust;

/**
 * 存放辐射监测单位表Dao层
 * @author Admin
 *2018年8月21日15:47:52
 */
public interface EntrustDao {
	/**
	 * 插入单位信息
	 * @param ent
	 */
	public void enInsert(Entrust ent);
	/**
	 *  查询单位全部信息，返回一个集合对象
	 * @return
	 */
	public List<Entrust> enQuery();
	/**
	 * 根据ID查询单位全部信息返回单位对象
	 * @param enid
	 * @return
	 */
	public Entrust enid(String enid);
	/**
	 * 修改辐射监测单位表信息
	 * @param entr
	 */
	public void enUpdate(Entrust entr);
}
