package com.yyc.learn.bean;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-14 20:47
 */
/**
 * 类的初始化顺序
 * 静态变量->静态初始化块->变量->初始化块->构造器
 * @author xiayunan
 * @date   2018年7月5日
 *
 */
public class InitialOrderTest {

    // 静态变量

    public static String staticField = "静态变量";

    // 变量
    public String field = "变量";

    // 静态初始化块
    static {
        System.out.println(staticField);
        System.out.println("静态初始化块");
    }

    // 初始化块
    {
        System.out.println(field);
        System.out.println("初始化块");
    }

    // 构造器
    public InitialOrderTest() {
        System.out.println("构造器");
    }

    public static void main(String[] args) {
        new InitialOrderTest();
    }
}
