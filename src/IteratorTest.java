import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        final List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        final Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            final Integer next = iterator.next();
            if (next == 3){
                iterator.remove();
            }
            System.out.println(list);
            System.out.println(next);
        }

    }
}
