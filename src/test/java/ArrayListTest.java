import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javase_review
 * @description: 熟悉ArrayList
 * @author: ActStrady
 * @create: 2019-03-19 15:57
 **/
public class ArrayListTest {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("hahahahaha");
        list.add("hehehe");
        System.out.println(list.size());
    }
}
