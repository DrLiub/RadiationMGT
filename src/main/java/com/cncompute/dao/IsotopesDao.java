package com.cncompute.dao;

import java.util.List;
import com.cncompute.pojo.Isotopes;
import com.cncompute.pojo.Radioactiveentry;
import com.cncompute.pojo.Sealentry;
/**
 * 放射性同位素Dao层
 * @author Admin
 *2018年9月6日17:39:35
 */
public interface IsotopesDao {
	/**
	 * 查询放射性同位素全部信息
	 * @return
	 */
	public List<Isotopes> isotAll();
	/**
	 * 添加放射源
	 * @param isot
	 */
	public void isotAdd(Isotopes isot);
	/**
	 * 查询-开放射性同位全部信息id
	 * @param raid
	 * @return
	 */
	public List<Isotopes> radioAll(String raid);
	/**
	 * 查询-密封源录入信息id
	 * @param seid
	 * @return
	 */
	public List<Isotopes> sealAll(String seid);
	/**
	 * 添加-开放性同位素
	 * @param radi
	 */
	public void radioaAdd(Radioactiveentry radi);
	/**
	 * 修改-开放性同位素
	 * @param radi
	 */
	public void updateRadi(Radioactiveentry radi);
	/**
	 * 查询-开放性同位素(通过信息ID)
	 * @param raentry
	 * @return
	 */
	public Isotopes radiSelect(String raentry);
	/**
	 * 添加-密封源录入信息
	 * @param seal
	 */
	public void sealeAdd(Sealentry seal);
	/**
	 * 修改-密封源录入信息
	 * @param seal
	 */
	public void updateSeal(Sealentry seal);
	/**
	 * 查询-密封源录入信息(通过信息ID)
	 * @param seentry
	 * @return
	 */
	public Isotopes selectSeal(String seentry);
	/**
	 * 通过ID查询安全措施表
	 * @param raid
	 */
	public List<Isotopes> queryAux(String auid);
	/**
	 * 修改放射源
	 * @param isid
	 */
	public void upIsotopes(Isotopes isot);
	/**
	 * 通过ID查询放射源
	 * @param isid
	 */
	public Isotopes queryIsid(String isid);
	
}
