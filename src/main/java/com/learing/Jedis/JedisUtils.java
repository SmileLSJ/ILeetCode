package com.learing.Jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis工具类
 */
public class JedisUtils {

    private static JedisPool jedisPool;

    static {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        jedisPool = new JedisPool(config,"106.13.48.23",6379);
    }

    public static Jedis getJedis() throws Exception {
        if(jedisPool!=null){
            return jedisPool.getResource();
        }
        throw new Exception("JedisPool is null");
    }
}
