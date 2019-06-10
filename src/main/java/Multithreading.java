/**
 * @program: javaSE-review
 * @description: 多线程学习
 * @author: ActStrady
 * @create: 2019-03-26 20:50
 **/
public class Multithreading extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Multithreading s = new Multithreading();
        s.run();
    }
}
