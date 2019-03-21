import org.junit.Test;

import java.io.*;

/**
 * @program: javase_review
 * @description: IO类的使用
 * @author: ActStrady
 * @create: 2019-03-21 09:45
 **/
public class IOUse {
    /**
     * 字节输入流
     * 按字节读取文件
     * 不能处理中文（中文两个字节）
     */
    @Test
    public void byteRead() {
        // jdk1.7 开始在try后的括号里的内容可以自己close
        try (InputStream inputStream = new FileInputStream("src/main/java/Basic.java")) {
            int oneByte = inputStream.read();
            while (oneByte != -1) {
                System.out.print((char) oneByte);
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符输入流
     * 按字符读取文件
     * 可以处理中文
     */
    @Test
    public void charRead() {
        try (Reader reader = new FileReader("src/main/java/Basic.java")) {
            int oneChar = reader.read();
            while (oneChar != -1) {
                System.out.print((char) oneChar);
                oneChar = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节输出流
     * 就是写文件
     */
    @Test
    public void byteWrite() {
        try (InputStream inputStream = new FileInputStream("src/main/java/Basic.java");
             OutputStream outputStream = new FileOutputStream("src/main/resources/byte.txt")) {
            int read = inputStream.read();
            while (read != -1) {
                outputStream.write(read);
                read = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符输出流
     * 写入文件
     */
    @Test
    public void charWriter() {
        try (Writer writer = new FileWriter("src/main/resources/char.txt")) {
            writer.write("我咋会少年锦时的本身就是不就是把就把大家非常不受到");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
