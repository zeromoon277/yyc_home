package com.yyc.learn.sort;

/**
 * @Author: yyc_love_lulu
 * @Date: 2020-06-03 22:39
 */
public class BubbleSort {
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
            for (int j = i + 1; j < length; j++) {
                size++;
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(size);
        return array;
    }


    private static int[] sort2(int[] numbers) {
        //冒泡排序算法
        int i, j;
        for (i = 0; i < numbers.length - 1; i++) {
            for (j = 0; j < numbers.length - 1 - i; j++) {
                size++;
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
}
