class Solution {
    public int maxProfit(int[] prices) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;

        int[][] dp = new int[n + 2][2]; //see we are making array of n+2 this time to avoid out of bound 
        

        /**
         if (i >= n)
            return 0;
        //here prev ques also we were only doing dp[n][0] = dp[n][1] = 0 
        //but here we are doing for n+1 as well becasue 
        //in case of sell -> buy = 0 = max(sell+not sell)  -> so in case of sell we are saying to go and check i+2
        //lets say i = 4 so i+2 = 6 so we need to have this 6 th index as well indp array to avoid out of bound error
        */
        dp[n+1][0] = 0;
        dp[n+1][1] = 0;
        dp[n][0] = 0;
        dp[n][1] = 0;

    


        //in memo we were going from i = 0 to n
        //buy = 1 to 2 can be naything this time

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;

                if (buy == 1) {
                    //deciding buy
                    //profit = max(you buy +you not buy)
                    profit = Math.max(-prices[i] + dp[i + 1][0],
                            0 + dp[i + 1][1]);
                } else {
                    //deciding sell
                    //profit = max(sell,not sell)
                    //here in sell case --> prev it was (i+1,1) in case that means in next state or at next index you are allowed to buy again but here you will see
                    //our cooldown clause say after one transaction i.e buy and sell we should not allow to buy on immediate next day
                    //so we just do i+2 we skip one index and then allowed to buy i.e (i+2,1) -> on next to next day you are allowed ot buy 

                    //                      <----- crucial part ---> doing i+2
                    profit = Math.max(prices[i] + dp[i + 2][1],
                            0 + dp[i + 1][0]);
                }

                dp[i][buy] = profit;
            }
        }

        //we have infinite transaction we can buy ans sell as much time as we want
        //i,buy,prices arr ,arr lengtth
        return dp[0][1];
    }
}