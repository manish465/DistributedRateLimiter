package com.manish.ratelimit.core;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

public class RedisFixedWindowRateLimiter implements RateLimiter {
    private final StringRedisTemplate redisTemplate;

    public RedisFixedWindowRateLimiter(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean allow(String key, int limit, int windowSeconds) {
        String redisKey = "rate:limit:" + key;

        Long count = redisTemplate.opsForValue().increment(redisKey);

        if (count == 1) {
            redisTemplate.expire(redisKey, Duration.ofSeconds(windowSeconds));
        }

        return count <= limit;
    }
}
