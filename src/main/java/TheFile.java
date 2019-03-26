import java.io.*;
import java.util.Date;

/**
 * @program: javaSE-review
 * @description: File类相关操作
 * @author: ActStrady
 * @create: 2019-03-25 20:29
 **/
public class TheFile {
    public static void main(String[] args) throws IOException {
        // 创建文件夹
        File file = new File("D:/wangqiang");
        file.mkdir();

        // 创建文件
        File file1 = new File("D:/wangqiang/wangqiang.txt");
        file1.createNewFile();

        // 可读？
        System.out.println(file.canRead());
        // 可写？
        System.out.println(file.canWrite());
        // 路径
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        // 绝对路径
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalPath());
        // 相对路径
        System.out.println(file1.getPath());
        // 长度
        System.out.println(file.length());
        // 最后修改时间
        System.out.println(new Date(file.lastModified()));

        // 写入文字
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        bufferedWriter.write("姓名：王强" + "\n");
        bufferedWriter.write("性别：男" + "\n");
        bufferedWriter.write("年龄：20" + "\n");
        bufferedWriter.write("班级：1826" + "\n");
        bufferedWriter.close();

        // 读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();

        // 列出所有文件
        File files = new File("src/main/java");
        File[] files1 = files.listFiles();
        for (File file2 : files1) {
            String path = file2.getPath();
            if (path.contains(".java")) {
                System.out.println(path.substring(path.lastIndexOf("\\") + 1));
            }
        }

        // 复制几个文件
        copy("src/main/java/Basic.java", file.getPath() + "/Basic.java");
        copy("E:\\OneDrive\\Photos\\书桌.jpg", file.getPath() + "/书桌.jpg");
        copy("D:/wangqiang/wangqiang.txt", file.getPath() + "/wangqiang.txt");
    }

    /**
     * 复制文件
     *
     * @param path 文件路径
     * @throws IOException io异常
     */
    private static void copy(String path, String newPath) throws IOException {
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(path));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(newPath));
        String line1;
        while ((line1 = bufferedReader1.readLine()) != null) {
            bufferedWriter1.write(line1 + "\n");
        }
        bufferedReader1.close();
        bufferedWriter1.close();
    }
}
