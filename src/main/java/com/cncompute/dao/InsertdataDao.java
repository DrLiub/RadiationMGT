package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Insertdata;

/**
 * 工作人员职业健康情况表Dao层
 * @author 劉
 *2018年8月15日13:37:59
 */
public interface InsertdataDao {
	/**
	 * 插入季度工作人员职业健康情况内容
	 * @param inser
	 */
	public void ininsert(Insertdata inser);
	/**
	 * 查询所有员工职业健康信息
	 * @return
	 */
	public List<Insertdata> queryAll();
	/**
	 *通过信息ID查询员工一年的辐射监测数据
	 * @param inser
	 * @return
	 */
	public List<Insertdata> queryYears(Insertdata inser);
	/**
	 * 修改填写年度表信息
	 * @param inser
	 */
	public void inupdate(Insertdata inser);
    /**
     * 根据信息编号查询出信息内容 
     * 返回Insertdata 对象
     * @param innumber
     * @return
     */
	public Insertdata inserupdate(String innumber);
	/**
	 * 通过名字迷糊查询
	 * @param inname
	 * @return
	 */
	public List<Insertdata> fuzzyQueryin(String inname);
}
