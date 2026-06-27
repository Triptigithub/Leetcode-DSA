class Solution {
    public int maxProfit(int[] prices) {
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)

        int n = prices.length;
        int profit = 0;
        int[][] dp = new int[n + 1][2];
        // for(int i= 0; i<n+1 ; i++){
        //     for(int j=0; j<2; j++){
        //         dp[i][j] = -1;
        //     }
        // }


        //base case
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                profit = 0;
                if (buy == 1) {
                    //profit = max(you buy + you did not buy)
                    profit = Math.max(-prices[i] + dp[i + 1][0],
                            0 + dp[i + 1][1]);
                } else {
                    //profit = max(you sell stock, you didnot sell stk)
                    profit = Math.max(prices[i] + dp[i + 1][1],
                            0 + dp[i + 1][0]);
                }
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
        //we return dp[0][1] because this is the state where we start solving problem 
        //it says we are starting at idx 0 and buy state is 1 means we can buy stk if we want
        //we cannot return dp[0][0] as ans becasue it sasys we are at index 0 and currently you can sell stk but you didnot buy stk how you are selling
        //we are able to return dp[0][1] -> bcz this is tabulation we filled ans in reverse frrom base case

    }
}