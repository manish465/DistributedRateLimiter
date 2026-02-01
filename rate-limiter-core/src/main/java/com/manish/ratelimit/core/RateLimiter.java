package com.manish.ratelimit.core;

public interface RateLimiter {
    boolean allow(String key, int limit, int windowSeconds);
}
