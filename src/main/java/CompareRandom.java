import java.util.Hashtable;
import java.util.Random;

/**
 * @program: javase_review
 * @description: 比较随机数生成的效率和分布
 * @author: ActStrady
 * @create: 2019-03-19 11:07
 **/
public class CompareRandom {
    private static final int COUNT = 10000;

    /**
     * 数学类的随机方法和Random类的随机方法的比较
     * 结论：Math其实是调用了Random类的nextDouble方法
     *      其实效率和分布两个差别并不大
     */
    private static void compare() {
        int ranNum;
        Integer showCount;
        Hashtable<Integer, Integer> randoms = new Hashtable<>();
        // 数学类实现随机数
        // 当前时间
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            // Math.random生成0-1的数包含0不含1
            ranNum = (int)(Math.random() * 20) + 1;
            showCount = randoms.get(ranNum);
            // 三目运算符，给Hashtable 键对应的值初始化和统计分布
            randoms.put(ranNum, showCount != null ? showCount + 1 : 0);
        }
        long mathTime = System.currentTimeMillis() - start1;
        System.out.println("Math need " + mathTime + " millisecond");
        for (Integer integer : randoms.keySet()) {
            System.out.println(integer + "-->" + randoms.get(integer));
        }
        // 清空HashTable
        randoms.clear();
        // Random类实现随机数
        long start2 = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            ranNum = random.nextInt(20) + 1;
            showCount = randoms.get(ranNum);
            randoms.put(ranNum, showCount != null ? showCount + 1 : 0);
        }
        long randomTime = (System.currentTimeMillis() - start2);
        System.out.println("Random need " + randomTime + " millisecond");
        for (Integer integer : randoms.keySet()) {
            System.out.println(integer + "-->" + randoms.get(integer));
        }
    }
    public static void main(String[] args) {
        compare();
    }
}
