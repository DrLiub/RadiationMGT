package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Xaccelerator;
import com.cncompute.pojo.Xauxiliary;
import com.cncompute.pojo.Xneutron;
import com.cncompute.pojo.Xraydevice;
import com.cncompute.pojo.Xraymachine;

/**
 * 射线装备Dao层
 * @author Admin
 *2018年8月30日15:26:55
 */
public interface XraydeviceDao {
	/**
	 * 查询(射线装置) 全部信息
	 * @return
	 */
	public List<Xraydevice> raydAll();
	/**
	 * 通过ID查询(射线装置)
	 * @param raid
	 * @return
	 */
	public Xraydevice raydID(String raid);
	/**
	 * 添加(射线装置)
	 * @param rayd
	 */
	public void addRaydevice(Xraydevice rayd);
	/**
	 * 修改(射线装置) 通过ID
	 * @param raid
	 */
	public void updateRayd(Xraydevice rayd);
	/**
	 * 添加 (加速器)id
	 * @param acce
	 */
	public void addAccelerator(String acid);
	/**
	 * 查询 根据ID(加速器)返回射线装置对象
	 * @param acid
	 * @return
	 */
	public Xraydevice acceleratorId(String acid);
	/**
	 * 录入 (加速器)
	 * @param acce
	 */
	public void insertAccel(Xaccelerator acce);
	/**
	 * 添加 (中子发生器)id
	 * @param neut
	 */
	public void addNeutron(String neid);
	/**
	 * 查询(中子发生器)
	 * @param neid
	 * @return
	 */
	public Xraydevice queryNeut(String neid); 
	/**
	 * 录入(中子发生器)
	 * @param neut
	 */
	public void insertNeut(Xneutron neut);
	/**
	 * 添加(X射线机)id
	 * @param raid
	 */
	public void addRaymachine(String raid);
	/**
	 * 查询(X射线机)
	 * @return
	 */
	public Xraydevice queryRayma(String raid);
	/**
	 * 录入(X射线机)
	 * @param raym
	 */
	public void insertRayma(Xraymachine raym);
	/**
	 * 添加(辅助决策)
	 * @param auid
	 */
	public void addAuxiliary(Xauxiliary auxi);
	/**
	 * 通过ID查询辅助决策全部信息
	 * @return
	 */
	public List<Xraydevice> queryRaidauxi(String auid);
	/**
	 * 修改辅助决策
	 * @param auxi
	 */
	public void qudatAuxi(Xauxiliary auxi);
	/**
	 * 查询射线装置全部信息
	 * @param raid
	 */
	public Xraydevice queryAll(String raid);
}
