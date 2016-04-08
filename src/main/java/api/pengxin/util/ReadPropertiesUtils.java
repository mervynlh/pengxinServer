package api.pengxin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesUtils {
	public  static Properties loadProperties(String resources){
		 // 使用InputStream得到一个资源文件
		   InputStream inputstream = ReadPropertiesUtils.class.getResourceAsStream(resources);
		   Properties properties = new Properties();
		   try {
		   // 加载配置文件
		      properties.load(inputstream);
		      return properties;
		   } catch (IOException e) {
		      throw new RuntimeException(e);
		   } finally {
		      try {
		    	  inputstream.close();
		      } catch (IOException e) {
		         throw new RuntimeException(e);
		      }
		   }
	}
}
