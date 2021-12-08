package ua.edu.ukma.schedule.cacheManager;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.lang.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MyCacheManager implements CacheManager, InitializingBean {
    private Collection<? extends Cache> caches = Collections.emptySet();

    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap(16);
    private volatile Set<String> cacheNames = Collections.emptySet();

    public MyCacheManager() {
    }

    public void afterPropertiesSet() {
        this.initializeCaches();
    }

    public void initializeCaches() {
        Collection<? extends Cache> caches = this.loadCaches();
        synchronized(this.cacheMap) {
            this.cacheNames = Collections.emptySet();
            this.cacheMap.clear();
            Set<String> cacheNames = new LinkedHashSet(caches.size());
            Iterator var4 = caches.iterator();

            while(var4.hasNext()) {
                Cache cache = (Cache)var4.next();
                String name = cache.getName();
                this.cacheMap.put(name, this.decorateCache(cache));
                cacheNames.add(name);
            }

            this.cacheNames = Collections.unmodifiableSet(cacheNames);
        }
    }

    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }

    @Nullable
    public Cache getCache(String name) {
        Cache cache = (Cache)this.cacheMap.get(name);
        if (cache != null) {
            return cache;
        } else {
            Cache missingCache = this.getMissingCache(name);
            if (missingCache != null) {
                synchronized(this.cacheMap) {
                    cache = (Cache)this.cacheMap.get(name);
                    if (cache == null) {
                        cache = this.decorateCache(missingCache);
                        this.cacheMap.put(name, cache);
                        this.updateCacheNames(name);
                    }
                }
            }

            return cache;
        }
    }

    public Collection<String> getCacheNames() {
        return this.cacheNames;
    }


    private void updateCacheNames(String name) {
        Set<String> cacheNames = new LinkedHashSet(this.cacheNames);
        cacheNames.add(name);
        this.cacheNames = Collections.unmodifiableSet(cacheNames);
    }

    protected Cache decorateCache(Cache cache) {
        return cache;
    }

    @Nullable
    protected Cache getMissingCache(String name) {
        return null;
    }

    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }

}
