import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * @program: javaSE_review
 * @description: 获取网站数据
 * @author: ActStrady
 * @create: 2019-03-22 11:12
 **/
public class GetData {

    public static final String DOUBAN_MOV = "https://movie.douban.com/explore#!type=movie&tag=%E7%83%AD%E9%97%A8&sort" +
            "=recommend&page_limit=20&page_start=0";

    @Test
    public void getDouBanMovImage() {
        try {
            URL url = new URL(DOUBAN_MOV);
            InputStream inputStream = url.openStream();
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
