package session1;

import java.util.ArrayList;
import java.util.List;

class App1 {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            doSomething();
            Thread.sleep(1000);
        }
    }


    private static int AMOUNT = 200_000;
    private static void doSomething() {
        List<Object> objects = new ArrayList<>(AMOUNT);
        for (int i = 0; i < AMOUNT; i++) {
            objects.add(new Object());
        }
    }
}
