package com.sumit.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {

    // customizing TTL for the cache
    // objects in studentCache will have TTL = 30 seconds
    // objects in professorCache will have TTL = 30 minutes
    @Bean
    public RedisCacheManagerBuilderCustomizer customizer(){
        return (builder) -> builder
                .withCacheConfiguration("studentCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)))
                .withCacheConfiguration("professorCache", RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30)));
    }


    /*@Bean
    public RedisTemplate<String, ?> redisTemplate(RedisConnectionFactory connectionFactory){
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        RedisTemplate<String, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        //redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }*/

}