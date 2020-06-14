package learn.yyc.test.demo;

import java.util.Arrays;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/5 0005 下午 15:14
 */
public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,4,7};
//        String s = "a", t = "";
        System.out.println(findLengthOfLCIS(a));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()){
            return true;
        }
        char[] chart = t.toCharArray();
        int index = 0;
        for (char c : chart) {
            if(c == s.charAt(index)){
                if((index + 1) == s.length()){
                    return true;
                }else{
                    index++;
                }
            }
        }
        return false;

    }



    public static int heightChecker(int[] heights) {
        int[] ints = Arrays.copyOfRange(heights, 0, heights.length);
        sort_shell(heights);
        int count=0;
        for (int i = 0; i < heights.length; i++) {
            if(ints[i] != heights[i]){
                count++;
            }
        }
        return count;
    }



    private static int[] sort_shell(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }



    public int missingNumber(int[] nums) {
        int[] tong = new int[nums.length + 1];
        for (int num : nums) {
            tong[num]++;
        }

        for (int i = 0; i < tong.length; i++) {
            if(tong[i] == 0) {
                return i;
            }
        }

        return 0;


    }

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length <=1){
            return nums.length;
        }
        int pre = nums[0];
        int size = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if(pre < nums[i]){
                size++;
            }else{
                size=1;
            }
            max = Math.max(max, size);
            pre = nums[i];

        }
        return max;


    }

}
