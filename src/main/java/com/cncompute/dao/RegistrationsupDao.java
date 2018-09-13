package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Registrationsup;

/**
 * 监测设备、报警仪器和辐射防护用品登记表的Dao层
 * @author Admin
 *2018年8月20日10:21:16
 */
public interface RegistrationsupDao {
	/**
	 * 插入表信息
	 * @param reg
	 */
	public void reInsert(Registrationsup reg);
	/**
	 * 根据表编号查询监测设备、报警仪器和辐射防护用品信息
	 * @param retable
	 */
	public List<Registrationsup> reQuery(Integer retable);
	/**
	 * 根据ID删除信息
	 * @param reid
	 */
	public void reDelete(String reid);
	/**
	 * 修改监测设备、报警仪器和辐射防护用品登记表信息
	 * @param reg
	 */
	public void reUpdate(Registrationsup reg);
	/**
	 * 通过reid查询出信息，返回Registrationsup对象
	 * @param reid
	 * @return
	 */
	public Registrationsup reReid(String reid);
}
