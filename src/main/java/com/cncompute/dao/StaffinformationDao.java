package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Staffinformation;

/**
 * 辐射员工表的Dao层
 * @author 劉
 *2018年8月9日14:17:04
 */
public interface StaffinformationDao {
	/**
	 * 更具ID查询所有的员工的信息
	 * @return
	 */
	public List<Staffinformation> queryStaff(Staffinformation staff);
	/**
	 * 插辐射人员员工信息
	 * @param staff
	 */
	public void addStaff(Staffinformation staff);
	/**
	 * 修改辐射工作人员信息
	 * @param staff
	 */
	public void stupdate(Staffinformation staff);
	/**
	 * 删除辐射工作人员信息
	 * @param staff
	 */
	public void stdelete(Staffinformation staff);
    /**
     * 根据stnumber查询员工所以信息
     * @param staff
     */
	public Staffinformation stquery(Staffinformation staff);
	/**
	 * 查询全部信息
	 * @return
	 */
	public  List<Staffinformation> stallAll();
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	public  List<Staffinformation> fuzzyQueryst(String name);
	
}
