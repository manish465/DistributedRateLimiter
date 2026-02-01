package com.manish.ratelimit.aop;

import com.manish.ratelimit.annotation.RateLimited;
import com.manish.ratelimit.core.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class RateLimiterAspect {
    private final RateLimiter rateLimiter;

    public RateLimiterAspect(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Around("@annotation(rateLimited)")
    public Object enforceRateLimit(
            ProceedingJoinPoint joinPoint,
            RateLimited rateLimited
    ) throws Throwable {

        boolean allowed = rateLimiter.allow(
                rateLimited.key(),
                rateLimited.limit(),
                rateLimited.windowSeconds()
        );

        if (!allowed) {
            throw new RuntimeException("Rate limit exceeded");
        }

        return joinPoint.proceed();
    }
}
