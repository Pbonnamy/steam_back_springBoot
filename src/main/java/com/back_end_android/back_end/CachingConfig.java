package com.back_end_android.back_end;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManagerMost() {
        return new ConcurrentMapCacheManager("most", "most2", "most3", "most4", "most5");
    }



}
