package session1;

class App2 {

    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache();
        while (true) {
            doSomething(cache);
            Thread.sleep(1000);
        }
    }

    private static void doSomething(Cache cache) {
        cache.add(new int[200_000]);
    }

}

