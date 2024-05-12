package com.iweb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableCaching
public class RedisConfig {

    @Resource // byId byName
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<String> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(String.class);

        // 推荐使用 json : 效率要高于使用 jdk 的序列化
        // 使用 json 保存仅仅是数据 , jdk 的序列化  除了数据之外还要保存模型(类的结构)
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        return redisTemplate;
    }

    // 配置缓存的 命名空间   注解 cacheNames  对应的 命名空间
    @Bean
    public RedisCacheManager redisCacheManager() {

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext<String, String> stringRedisSerializerPair
                = RedisSerializationContext.fromSerializer(stringRedisSerializer);
        RedisSerializationContext<Object, Object> jackson2JsonRedisSerializerPair
                = RedisSerializationContext.fromSerializer(jackson2JsonRedisSerializer);

        // 配置缓存策略
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(stringRedisSerializerPair.getKeySerializationPair())
                .serializeValuesWith(jackson2JsonRedisSerializerPair.getValueSerializationPair())
                .entryTtl(Duration.ofSeconds(30))
                .disableCachingNullValues();

        // @Cacheable(key = "#methodName", cacheNames = "book")
        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("book");
        // cacheNames ->  RedisCacheConfiguration
        Map<String, RedisCacheConfiguration> redisCacheMap = new HashMap<>();
        redisCacheMap.put("book", configuration);


        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(configuration)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(redisCacheMap)
                .build();
    }


}
