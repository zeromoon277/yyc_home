package com.yyc.learn.sort;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-03 23:08
 */
public class SelectSort {
    private static int size = 0;
    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 4, 6, 2, 12, 15, 8, 9, 11};
        for (int i : sort(array)) {
            System.out.println(i);
        }

        System.out.println("循环次数====" + size);
    }


    private static int[] sort(int[] array) {

        int length = array.length;
        int temp;

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;


    }
}
