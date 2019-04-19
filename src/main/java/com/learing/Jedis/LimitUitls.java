package com.learing.Jedis;

import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gxy on 2019/1/30.
 */
public class LimitUitls {


    public static Object isLimited(String ip,String timeout,String accessCount){

        try {
            Jedis jedis = JedisUtils.getJedis();

            String ip_limit = "local num = redis.call('incr',KEYS[1])\n" +
                    "if tonumber(num)==1 then\n" +
                    "   redis.call('expire',KEYS[1],ARGV[1])\n" +
                    "   return 1\n" +
                    "elseif tonumber(num)>tonumber(ARGV[2]) then\n" +
                    "   return 0\n" +
                    "else\n" +
                    "   return 1\n" +
                    "end";

            Object result = jedis.eval(ip_limit, Arrays.asList(ip), Arrays.asList(timeout,accessCount));

            System.out.printf("result"+result);
            return result;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Object isShaLimited(String ip,String timeout,String accessCount){

        try {
            Jedis jedis = JedisUtils.getJedis();

            String ip_limit = "local num = redis.call('incr',KEYS[1])\n" +
                    "if tonumber(num)==1 then\n" +
                    "   redis.call('expire',KEYS[1],ARGV[1])\n" +
                    "   return 1\n" +
                    "elseif tonumber(num)>tonumber(ARGV[2]) then\n" +
                    "   return 0\n" +
                    "else\n" +
                    "   return 1\n" +
                    "end";

            Object result = jedis.evalsha(
                    jedis.scriptLoad(ip_limit),  //当脚本信息很大时，将脚本缓冲到redis中，然后使用摘要进行传输，操作
                    Arrays.asList(ip),
                    Arrays.asList(timeout,accessCount));


            System.out.printf("result"+result);
            return result;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
