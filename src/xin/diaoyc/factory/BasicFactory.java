package xin.diaoyc.factory;

import java.io.FileReader;
import java.util.Properties;
/**
 * ͨ�ù�����
 * @author TonyDyc
 *
 */
public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	//���췽��˽�л�
	private BasicFactory() {
		
	}
	
	public static BasicFactory getFactory() {
		return factory;
	}
	//��ȡ�����ļ��ľ�̬�����
	static {
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * ���� ����ֵΪ���͵ķ���  ʵ�ֲ����û���Ҫ�õ�daoimpl����serviceimpl������ͨ�������dao����service��ȡ��
	 * @param clazz  ���뷺������   �˴����룺xxx.class �ӿ�����
	 * @return ����ֵ����
	 */
	public <T> T getInstance(Class<T> clazz) {
		
		try {
			String cName = clazz.getSimpleName();
			String cImplName = prop.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}  
	}
	
	
}
