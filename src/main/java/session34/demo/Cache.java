package session34.demo;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class CacheDemo {
    public static void main(String[] args) {
        CounterCache cache = new CounterCache();
        cache.getMultiple(Arrays.asList("1", "2"));
        assertThat(cache.getGetCnt()).isEqualTo(2);
        System.out.println("Count=" + cache.getGetCnt());
    }
}

class Cache {
    private Map<String, Object> repo = new HashMap<>();

    public void put(String key, Object v) {
        repo.put(key, v);
    }

    public Object get(String key) {
        return repo.get(key);
    }

    public List<Object> getMultiple(List<String> keys) {
        List<Object> res = new ArrayList<>(keys.size());
        for (String key : keys) {
            res.add(repo.get(key));
        }
        return res;
    }
}

class CounterCache extends Cache {
    private int getCnt = 0;

    @Override
    public Object get(String key) {
        getCnt++;
        return super.get(key);
    }

    @Override
    public List<Object> getMultiple(List<String> keys) {
        getCnt += keys.size();
        return super.getMultiple(keys);
    }

    int getGetCnt() {
        return getCnt;
    }
}
