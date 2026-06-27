class Solution {
    public int maxProfit(int[] prices) {
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)

        int n = prices.length;
        int profit = 0;
        int[][][] dp = new int[n + 1][2][3];
        

        //if(i == n || cap == 0) return 0;
        //so for i == n -> buy and cap can be anything
        //1 base case
        for(int buy = 0; buy<2 ;buy++){
            for(int cap = 0; cap<3;cap++){
                dp[n][buy][cap] = 0;
            }
        }

        //if cap == 0 -> i and buy can be anything
        for(int i =0 ; i<n+1; i++){
            for(int buy = 0; buy<2; buy++){
                dp[i][buy][0] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for(int cap=1; cap<=2; cap++){  //cap start from 1 as we handle cap =0 in base case
                profit = 0;
                if (buy == 1) {
                    //profit = max(you buy + you did not buy)
                    profit = Math.max(-prices[i] + dp[i + 1][0][cap],
                            0 + dp[i + 1][1][cap]);
                } else {
                    //profit = max(you sell stock, you didnot sell stk)
                    profit = Math.max(prices[i] + dp[i + 1][1][cap-1],
                            0 + dp[i + 1][0][cap]);
                }
                dp[i][buy][cap] = profit;
            }
        }}

        return dp[0][1][2];
        //we return dp[0][1] because this is the state where we start solving problem 
        //it says we are starting at idx 0 and buy state is 1 means we can buy stk if we want
        //we cannot return dp[0][0] as ans becasue it sasys we are at index 0 and currently you can sell stk but you didnot buy stk how you are selling
        //we are able to return dp[0][1] -> bcz this is tabulation we filled ans in reverse frrom base case

    }
}