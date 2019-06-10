import org.junit.Test;

import java.io.*;

/**
 * @program: javase_review
 * @description: IO类的使用
 * @author: ActStrady
 * @create: 2019-03-21 09:45
 **/
public class IOUse {
    private static final String INPUT_PATH = "src/main/java/Basic.java";

    /**
     * 字节输入流
     * 按字节读取文件
     * 不能处理中文（中文两个字节）
     */
    @Test
    public void byteRead() {
        // jdk1.7 开始在try后的括号里的内容可以自己close
        try (InputStream inputStream = new FileInputStream(INPUT_PATH)) {
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
        try (Reader reader = new FileReader(INPUT_PATH)) {
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
        try (InputStream inputStream = new FileInputStream(INPUT_PATH);
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

    /**
     * 缓冲区的字节流输入
     */
    @Test
    public void buffInput() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(INPUT_PATH))) {
            int read = bufferedInputStream.read();
            while (read != -1) {
                System.out.print((char) read);
                read = bufferedInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 缓存区字节流输出, 加上true参数表示追加模式
     */
    @Test
    public void buffOut() {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("src/main/resources/char.txt", true))) {
            bufferedOutputStream.write("你好".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * BufferedReader和BufferWriter
     */
    @Test
    public void bufferedReadWrit() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
            bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/char.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * randomAccessFile
     * 基本取代 DataInputStream 和 DataOutputStream
     */
    @Test
    public void randomAF() {
        // rw 读写模式
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("raf", "rw")) {
            for (int i = 0; i < 10; i++) {
                // 写入
                randomAccessFile.writeDouble(i * 0.5);
                // 指针位置
                System.out.println(randomAccessFile.getFilePointer());
            }
            // 设置指针位置
            randomAccessFile.seek(72);
            // 读取
            System.out.println(randomAccessFile.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * DataInputStream 和 DataOutputStream
     */
    @Test
    public void dataInOut() {
        try (
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("io"));
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream("io"))
        ) {
            for (int i = 0; i < 10; i++) {
                dataOutputStream.writeDouble(i * 0.5);
            }
            dataInputStream.skipBytes(72);
            System.out.println(dataInputStream.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
