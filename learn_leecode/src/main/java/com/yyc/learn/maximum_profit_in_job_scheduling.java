package com.yyc.learn;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/29 0029 下午 18:08
 */
public class maximum_profit_in_job_scheduling {


    public static void main(String[] args) {
        int startTime[] = {1,2,3,3}, endTime[] = {3,4,5,6}, profit[] = {50,10,40,70};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int length = startTime.length;

        if (length == 1) {
            return profit[0];
        }

        int[] dp = new int[length];
        int[] dp_endtime = new int[length];

        dp[0] = profit[0];
        dp_endtime[0] = endTime[0];


        if(profit[0] >= profit[1]){
            dp[1] = profit[0];
            dp_endtime[1] = endTime[0];
        }else{
            dp[1] = profit[1];
            dp_endtime[1] = endTime[1];
        }


        for (int i = 2; i < length; i++) {
            int pro = 0;


            if(startTime[i] < dp_endtime[i-1]){
                dp_endtime[i] = endTime[i-1];
            }else{
                pro = profit[i];
                dp_endtime[i] = endTime[i];
            }


            dp[i] = Math.max(dp[i - 2] + pro, dp[i - 1]);
        }
        return dp[length - 1];

    }



}
