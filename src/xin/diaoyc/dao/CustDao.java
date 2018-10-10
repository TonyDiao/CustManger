package xin.diaoyc.dao;

import java.util.List;

import xin.diaoyc.domain.Cust;

public interface CustDao {
	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return ����Ҳ����û�����NULL
	 */
	Cust findUserByName(String name);
	/**
	 * ��ӿͻ�
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * ��ѯ���пͻ�
	 * @return
	 */
	List<Cust> getAllCust();


}
