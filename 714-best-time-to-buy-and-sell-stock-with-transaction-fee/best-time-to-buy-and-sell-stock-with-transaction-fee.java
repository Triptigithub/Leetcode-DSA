class Solution {
    public int solver(int i, int buy, int[] prices, int n,int fee,int[][] dp){
        if(i==n)return 0; 
        
        
        int profit =0;
        if(dp[i][buy] !=-1)return dp[i][buy];
        if(buy == 1){
            //deciding buy
            //profit = max(you buy +you not buy)
            profit = Math.max(-prices[i]+solver(i+1,0,prices,n,fee,dp),
                               0 + solver(i+1,1,prices,n,fee,dp)); 
        }else{
            //deciding sell
            //profit = max(sell,not sell)
            //here in sell case --> when you are complete one transaction you need to subtract the fee from profit
            profit = Math.max(-fee + prices[i]+solver(i+1,1,prices,n,fee,dp),
                                     0+ solver(i+1,0,prices,n,fee,dp));
        }

        return dp[i][buy] = profit;

    }
    public int maxProfit(int[] prices, int fee) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0; i<n+1; i++){
            Arrays.fill(dp[i],-1);
        }
        //we have infinite transaction we can buy ans sell as much time as we want
        //i,buy,prices arr ,arr lengtth,fee,dp
        return solver(0,1,prices,n,fee,dp);
    }
}