package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class MapDemo {
    public static void main(String[] arg) {
        Map<Key, String> map = new HashMap<>();
        map.put(new Key(1), "v1");
    }
}

class Key {
    final int v1;

    Key(int v1) {
        this.v1 = v1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return v1 == key.v1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1);
    }
}
