package com.learing.Jedis;

/**
 * Created by Gxy on 2019/1/30.
 */
public class LimitTest {

    public static void main(String[] args) {


//        Object limited = LimitUitls.isLimited("127.0.0.1", "1000", "2");
        Object limited = LimitUitls.isShaLimited("127.0.0.2", "1000", "2");

    }
}
