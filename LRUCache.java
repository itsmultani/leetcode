
import java.util.LinkedHashMap;

public class LRUCache extends LinkedHashMap {

    int MAX_ENTRIES;

    public LRUCache(int capacity) {
        super(capacity);
        MAX_ENTRIES = capacity;
    }

    public void set(int key, int value) {

        remove(key);

        put(key, value);
    }

    public int get(int key) {
        Integer v = (Integer) super.get(key);

        if (v == null) {
            return -1;
        } else {
            set(key, v);
            return v;
        }
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}
