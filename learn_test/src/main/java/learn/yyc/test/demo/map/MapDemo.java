package learn.yyc.test.demo.map;

import java.util.TreeMap;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/7/20 0020 下午 17:32
 */
public class MapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "1");
        treeMap.put(4, "4");
        treeMap.put(2, "2");
        treeMap.put(3, "3");

        for (Integer integer : treeMap.keySet()) {
            System.out.println(integer + ":" + treeMap.get(integer));
        }

    }
}
