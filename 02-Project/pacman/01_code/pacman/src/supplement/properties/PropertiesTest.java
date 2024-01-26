package supplement.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description: TODO
 * @Author 远志 zhangsong@cskaoyan.onaliyun.com
 * @Date 2024/1/26 15:02
 * @Version V1.0
 **/
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        //如果我们希望去读取properties配置文件里面的内容，其实非常简单，只需要借助于Properties类即可
        Properties properties = new Properties();
        //需要取读取加载数据的来源
        //在项目的根目录中有一个app.properties文件，如何获取其输入流
        FileInputStream inputStream = new FileInputStream(new File("app.properties"));
        properties.load(inputStream);

        //后续使用，直接从properties类中取出对应的键值对即可，根据key取出value值
        String app = properties.getProperty("app");
        String order = properties.getProperty("order");
        System.out.println(app);
        System.out.println(order);
    }
}
