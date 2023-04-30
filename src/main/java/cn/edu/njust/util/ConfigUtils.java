package cn.edu.njust.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
	//私有的属性
		private static ConfigUtils configUtils;
		//用来读取properties 后缀的文件
		private static Properties pro;
		//私有的构造方法
		private ConfigUtils(){
			try {
				//在构造方法里读取配置文件的信息
				//获取文件的地址
				String fileName = "db.properties";
				pro = new Properties();
				//把文件信息读取到输入流
				InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream(fileName);
				//把读取到的信息加载到properties对象里
				pro.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
		//对外的接口
		//用双重锁保证多线程的安全
		public static synchronized ConfigUtils singletonConfigUtils(){
			if(configUtils == null){
				synchronized(ConfigUtils.class){
					if(configUtils == null){
						configUtils = new ConfigUtils();
					}
				}
			}
			return configUtils;
		}
		//通过键来获取值
		public String getValue(String key){
			return pro.getProperty(key);
		}
}


