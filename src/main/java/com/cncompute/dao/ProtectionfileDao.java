package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Completionreply;
import com.cncompute.pojo.Environmental;
import com.cncompute.pojo.License;
import com.cncompute.pojo.Protectionfile;

/**
 * 环保手续文件Dao层
 * @author Admin
 *2018年8月23日17:29:38
 */
public interface ProtectionfileDao {
	/**
	 * 查询全部环保手续文件信息返回一个集合
	 * @return
	 */
	public List<Protectionfile> prall();
	/**
	 * 环保手续文件模糊查询
	 * @param name
	 * @return
	 */
	public List<Protectionfile> fuzzyProt(String name);
	/**
	 * 添加环保手续文件
	 * @param pro
	 */
	public void pradd(Protectionfile pro);
	/**
	 * 通过ID查询许可证表信息
	 * @param liid
	 * @return
	 */
	public Protectionfile liQuery(String liid);
	/**
	 * 通过ID查询环境影响评价文件批复(Environmental)表信息
	 * @param enid
	 * @return
	 */
	public Protectionfile enQuery(String  enid);
	/**
	 * 通过ID查询环保竣工验收监测文件批复(Completionreply表信息
	 * @param coid
	 * @return
	 */
	public Protectionfile coQuery(String coid);
	/**
	 * 根据id添加许可证表
	 * @param liid
	 */
	public void liceadd(String liid);
	/**
	 * 根据ID添加环境影响评价文件批复
	 * @param enid
	 */
	public void enviadd(String enid);
	/**
	 * 根据ID添加环保竣工验收监测文件批复
	 * @param coid
	 */
	public void compadd(String coid);
	/**
	 * 修改许可证表信息
	 * @param lice
	 */
	public void updateLice(License lice);
	/**
	 * 修改环境影响评价文件批复
	 * @param envi
	 */
	public void updateEnvi(Environmental envi);
	/**
	 * 修改环保竣工验收监测文件批复
	 * @param comp
	 */
	public void updateComp(Completionreply comp);
	/**
	 * 通过prid查询环保手续文件全部信息
	 * @param prid
	 */
	public Protectionfile queryAll(String prid);
	/**
	 * 删除环保手续文件
	 * @param prot
	 */
	public void updateProt(Protectionfile prot);
	/**
	 * 通过ID查询环保手续文件全部信息返回Protectionfile对象
	 * @param prid
	 * @return
	 */
	public Protectionfile prIdall(String prid);
}
