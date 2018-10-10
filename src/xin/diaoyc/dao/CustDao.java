package xin.diaoyc.dao;

import java.util.List;

import xin.diaoyc.domain.Cust;

public interface CustDao {
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 如果找不到用户返回NULL
	 */
	Cust findUserByName(String name);
	/**
	 * 添加客户
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * 查询所有客户
	 * @return
	 */
	List<Cust> getAllCust();


}
