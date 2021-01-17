package com.pablopb3.tiempoemojis.infrastructure;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

public class CacheConfig {

    @Configuration
    @EnableCaching
    public class CachingConfig {
    }
}
