package xin.diaoyc.service;

import java.util.List;

import xin.diaoyc.domain.Cust;

public interface CustService {
	/**
	 * ��ӿͻ�
	 * @param cust ��װ�ͻ���Ϣ��bean
	 */
	void addCust(Cust cust);
	/**
	 * ��ѯ���пͻ���Ϣ
	 * @return
	 */
	List<Cust> getAllCust();

}
