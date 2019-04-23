package com.sj.pmallcommon.redis.jedis;

import redis.clients.jedis.Jedis;

import java.io.IOException;

public interface RedisClientInvoker<T> {
    T invoke(Jedis jedis) throws IOException;

}

