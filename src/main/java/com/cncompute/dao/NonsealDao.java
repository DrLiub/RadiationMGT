package com.cncompute.dao;

import java.util.List;

import com.cncompute.pojo.Nonseal;
import com.cncompute.pojo.Roomnuclide;

/**
 * 非密封放射性物质表Dao层
 * @author Admin
 * 2018年9月10日14:12:42
 */
public interface NonsealDao {
	/**
	 * 查询-非密封放射性物质全部信息
	 * @return
	 */
	public List<Nonseal> nonsAll();
	/**
	 * 模糊查询-非密封放射性物质
	 * @param name
	 * @return
	 */
	public List<Nonseal> fuzzyNons(String name);
	/**
	 * 添加-非密封放射性物质
	 * @param nons
	 */
	public void nonsAdd(Nonseal nons);
	/**
	 * 修改-非密封放射性物质
	 * @param nons
	 */
	public void updateNonseal(Nonseal nons);
	/**
	 * 查询-通过ID找非密封放射性物质
	 * @param noid
	 * @return
	 */
	public Nonseal queryNonsid(String noid);
	/**
	 * 添加-房间中核素
	 * @param room
	 */
	public void roomAdd(Roomnuclide room);
	/**
	 * 查询辅助决策全部信息
	 * @param auid
	 * @return
	 */
	public List<Nonseal> queryNons(String auid);
	/**
	 * 通过ID查询房间中核素
	 * @param roid
	 * @return
	 */
	public List<Nonseal> queryRoom(String roid);
	/**
	 * 通过编号查询房间核素
	 * @param ronumber
	 * @return
	 */
	public Nonseal roomNumber(String ronumber);
	/**
	 * 修改房间中核素信息
	 * @param room
	 */
	public void updateRoom(Roomnuclide room);
}
