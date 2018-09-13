package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Management;
import com.cncompute.pojo.Personnel;

/**
 * 辐射安全管理人员表的dao方法
 * @author 劉
 *2018年8月3日14:23:58
 */
public interface ManagementDao {
	/**
	 * 新建管理机构，插入数据
	 * @param man
	 */
	public void insertMangemen(Management man);
	/**
	 * 向机构中添加管理人员插入信息
	 * @param per
	 */
	public void insertPersonnel(Personnel per);
	/**
	 * 查询辐射安全管理人员表信息
	 * @return
	 */
	public List<Management> queryMang();
	/**
	 * 通过ID查询辐射安全管理人员表,管理人员信息表信息
	 * @param man
	 * @return
	 */
	public List<Management> queryId(Management man);
	/**
	 * 修改辐射管理人员
	 * @param per
	 */
	public void maModify(Personnel per);
	/**
	 * 删除辐射管理人员
	 * @param per
	 */
	public void maDelete(Personnel per);
	/**
	 * 通过ID查询personnel表内容
	 * @param man
	 * @return
	 */
	public Management perId(Personnel per);
	/**
	 * 通过maid查询部门
	 * @param man
	 * @return
	 */
	public Management queryMaid(Management man);
}
