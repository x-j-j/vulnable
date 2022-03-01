package base.leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

//[2, 3]
//https://mp.weixin.qq.com/s?__biz=MzI2MTcxNjg5OA==&mid=2247483821&idx=1&sn=54c8ccfc9ea3d1f6305d884465309484&chksm=ea576f60dd20e6760eb1be19671232808bd869e425fa72856f69e39b8565d47862c1a397e4b1&scene=21#wechat_redirect
class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
