import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    private int hits = 0;
    private int misses = 0;

    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            hits++;
            return cache.get(key);
        }

        misses++;
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public void displayCache() {
        System.out.println("Cache: " + cache);
    }

    public void displayStats() {
        System.out.println("Hits: " + hits);
        System.out.println("Misses: " + misses);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);

        cache.displayCache();

        System.out.println("Get 1: " + cache.get(1)); // Hit

        cache.put(4, 40); // Evicts key 2

        cache.displayCache();

        System.out.println("Get 2: " + cache.get(2)); // Miss
        System.out.println("Get 3: " + cache.get(3)); // Hit
        System.out.println("Get 4: " + cache.get(4)); // Hit

        cache.displayStats();
    }
}
