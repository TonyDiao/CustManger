package xin.diaoyc.service;

import java.util.List;

import xin.diaoyc.dao.CustDao;
import xin.diaoyc.domain.Cust;
import xin.diaoyc.factory.BasicFactory;

public class CustServiceImpl implements CustService{
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	@Override
	public void addCust(Cust cust) {
		
		// 1.����û����Ƿ����
		if (dao.findUserByName(cust.getName()) != null) {
			throw new RuntimeException("�û����Ѿ�����");
		}
		//2.����dao�еķ��������û�
		dao.addCust(cust);
	}
	@Override
	public List<Cust> getAllCust() {
		
		return dao.getAllCust();
	}

}
