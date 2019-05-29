package session1;

import java.util.*;

class App3 {

    private static final int queueCap = 700_000;
    private static final Queue<Object> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        for (int i = 0; i < 200_000; i++) {
            cache.add(new Object());
        }
        System.out.println("Start working!");
        while (true) {
            doSomething();
            Thread.sleep(1000);
        }
    }

    private static int AMOUNT = 200_000;

    private static void doSomething() {
        for (int i = 0; i < AMOUNT; i++) {
            queue.offer(new Object());
            if (queue.size() > queueCap) queue.poll();
        }
    }


}
