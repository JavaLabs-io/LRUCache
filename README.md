# LRUCache

A simple LRU Cache implementation in Java.

---

## What is an LRU Cache?

A cache that holds a fixed number of items. When it gets full and a new item comes in, it removes the item that hasn't been used in the longest time.

---

## Usage

-`put(key, value)` — add an item to the cache
- `get(key)` — get an item by key, returns `-1` if it doesn't exist or was removed
- `displayCache()` — show the current cache contents
- `displayStats()` — show cache hits and misses

---

## Example

```java
LRUCache cache = new LRUCache(3);

cache.put(1, 10);
cache.put(2, 20);
cache.put(3, 30);

cache.get(1);     // hit
cache.put(4, 40); // cache is full — removes key 2 (used least recently)

cache.get(2);     // miss
cache.get(3);     // hit
cache.get(4);     // hit

cache.displayCache();
cache.displayStats();
---

## Run it

```
javac LRUCache.java
java -cp . LRUCache
```
