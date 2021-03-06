package kr.seok.testdome;

import org.junit.jupiter.api.Test;

class CacheTest {

    @Test
    void testCase1() {
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = optimizedDiskCache;
    }

    @Test
    void testCase2() {
        MemoryCache memoryCache = new MemoryCache();
        Cache cache = memoryCache;
        DiskCache diskCache = (DiskCache) cache;
    }

    @Test
    void testCase3() {
        DiskCache diskCache = new DiskCache();
//        OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;
    }

    @Test
    void testCase4() {
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
//        DiskCache diskCache = optimizedDiskCache;
    }

    @Test
    void testCase5() {
        Cache cache = new Cache();
        MemoryCache memoryCache = (MemoryCache) cache;
    }

    @Test
    void testCase6() {
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = optimizedDiskCache;
        DiskCache diskCache = (DiskCache) cache;
    }
}
