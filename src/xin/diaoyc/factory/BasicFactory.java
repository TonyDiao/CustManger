package xin.diaoyc.factory;

import java.io.FileReader;
import java.util.Properties;
/**
 * 通用工程类
 * @author TonyDyc
 *
 */
public class BasicFactory {
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	//构造方法私有化
	private BasicFactory() {
		
	}
	
	public static BasicFactory getFactory() {
		return factory;
	}
	//读取配置文件的静态代码块
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
	 * 定义 返回值为泛型的方法  实现不管用户需要得到daoimpl或者serviceimpl都可以通过传入的dao或者service获取到
	 * @param clazz  传入泛型数据   此处传入：xxx.class 接口名字
	 * @return 泛型值的类
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
