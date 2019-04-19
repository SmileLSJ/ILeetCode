package com.learing.Jedis;

import redis.clients.jedis.Jedis;

/**
 * Created by Gxy on 2019/1/29.
 */
public class test {

    public static void main(String[] args) {

        try {
            Jedis jedis = JedisUtils.getJedis();

            jedis.set("hello","111122");

            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
