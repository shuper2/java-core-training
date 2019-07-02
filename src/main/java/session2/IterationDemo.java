package session2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class IterationDemo {
    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (Integer integer : list) {
            list.add(2);
        }
    }
}

class IterationDemo2 {
    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.add(2);
            iterator.add(3);
        }

        System.out.println(list.stream().map(String::valueOf).reduce("", (s1, s2) -> s1 + s2));
    }
}
