package com.yyc.learn.demo;

import redis.clients.jedis.Jedis;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-05-12 23:35
 */
public class JedisConnectDemo {

    public static void main(String[] args) {
        testJedis();
    }


    private static void testJedis(){
        Jedis jedis = new Jedis("106.13.188.27", 6379);
        jedis.auth("yyc");
        String key1 = jedis.get("key1");
        System.out.println(key1);
    }
}
