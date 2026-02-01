package com.manish.ratelimit.config;

import com.manish.ratelimit.aop.RateLimiterAspect;
import com.manish.ratelimit.core.RateLimiter;
import com.manish.ratelimit.core.RedisFixedWindowRateLimiter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
@ConditionalOnProperty(
        prefix = "rate-limiter",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class RateLimiterAutoConfiguration {
    @Bean
    public RateLimiter rateLimiter(StringRedisTemplate redisTemplate) {
        return new RedisFixedWindowRateLimiter(redisTemplate);
    }

    @Bean
    public RateLimiterAspect rateLimiterAspect(RateLimiter rateLimiter) {
        return new RateLimiterAspect(rateLimiter);
    }
}
