package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Filetype;
import com.cncompute.pojo.Unitsystem;

/**
 * 单位辐射安全规章制度模块 
 * 文件类别表Dao层
 * @author Admin
 *2018年8月28日14:02:46
 */
public interface FiletypeDao {
	/**
	 * 查询所有文件类别表信息
	 * @return
	 */
	public List <Filetype> fileAll();
	/**
	 * 单位辐射规章制度模糊查询
	 * @param name
	 * @return
	 */
	public List<Filetype> fuzzyFile(String name);
	/**
	 * 查询全部未创建的flname
	 * @return
	 */
	public List<Filetype> flnameALL();
	/**
	 * 自定义添加环保手续文件
	 * @param file
	 */
	public void addFile(Filetype file);
	/**
	 * 通过flname(文件类别名称)修改环保手续文件
	 * @param file
	 */
	public void updateName(Filetype file);
	/**
	 * 通过flid修改环保手续文件
	 * @param file
	 */
	public void updateId(Filetype file);
	/**
	 * 通过ID查询规章制度全部信息返回一个集合
	 * @param flid
	 */
	public List<Filetype> fileIdall(String flid);
	/**
	 * 添加规章制度
	 * @param unit
	 */
	public void addUnitsystem(Unitsystem unit);
	/**
	 * 修改规章制度
	 * @param unit
	 */
	public void updateUnit(Unitsystem unit);
	/**
	 * 通过nunumber查询规章制度信息返回Unitsystem对象
	 * @param unit
	 * @return
	 */
	public Filetype fileNunumber(Unitsystem unit);
}
