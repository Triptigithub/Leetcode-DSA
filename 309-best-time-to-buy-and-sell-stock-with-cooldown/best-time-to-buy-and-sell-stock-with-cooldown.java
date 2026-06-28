class Solution {
    public int solver(int i, int buy, int[] prices, int n,int[][] dp ){
        if(i>=n)return 0; 
        //because we are doing i+2 in case of buy = 0 sell so ther may be case we go beyond n also therefore i am saying if i got n or n se aage return profit 0
        
        int profit =0;
        if(dp[i][buy] != -1)return dp[i][buy];
        if(buy == 1){
            //deciding buy
            //profit = max(you buy +you not buy)
            profit = Math.max(-prices[i]+solver(i+1,0,prices,n,dp),
                               0 + solver(i+1,1,prices,n,dp)); 
        }else{
            //deciding sell
            //profit = max(sell,not sell)
            //here in sell case --> prev it was (i+1,1) in case that means in next state or at next index you are allowed to buy again but here you will see
            //our cooldown clause say after one transaction i.e buy and sell we should not allow to buy on immediate next day
            //so we just do i+2 we skip one index and then allowed to buy i.e (i+2,1) -> on next to next day you are allowed ot buy 
            profit = Math.max(prices[i]+solver(i+2,1,prices,n,dp),
                                     0+ solver(i+1,0,prices,n,dp));
        }

        return dp[i][buy] = profit;

    }
    public int maxProfit(int[] prices) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;

        int[][] dp = new int[n+1][2];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }

        //we have infinite transaction we can buy ans sell as much time as we want
        //i,buy,prices arr ,arr lengtth
        return solver(0,1,prices,n,dp);
    }
}