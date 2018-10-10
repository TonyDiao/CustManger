package xin.diaoyc.service;

import java.util.List;

import xin.diaoyc.domain.Cust;

public interface CustService {
	/**
	 * 添加客户
	 * @param cust 封装客户信息的bean
	 */
	void addCust(Cust cust);
	/**
	 * 查询所有客户信息
	 * @return
	 */
	List<Cust> getAllCust();

}
