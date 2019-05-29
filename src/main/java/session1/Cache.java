package session1;

import java.util.HashSet;
import java.util.Set;

class Cache {
    private final Set<Object> pool = new HashSet<>();

    void add(Object obj){
        pool.add(obj);
    }
}
