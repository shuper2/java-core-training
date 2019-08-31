package session34.patterns.singleton;

import java.io.Serializable;

class SingletonEager implements Serializable {
    private static final SingletonEager singletonEager = new SingletonEager();

    private SingletonEager() {
    }

    public static SingletonEager getInstance() {
        return singletonEager;
    }
}

class SingletonLazy {
    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static synchronized SingletonLazy getInstance() {
        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}

enum SingletonEager2 implements Serializable{
    INSTANCE{
        // implementation..
    };
}

class SingletonLazy2 {
    private SingletonLazy2() {
    }

    public static SingletonLazy2 getInstance() {
        return Holder.singletonLazy;
    }

    private static final class Holder {
        private static SingletonLazy2 singletonLazy = new SingletonLazy2();
    }
}
