//MEMO
class Solution {
    public int solver(int i, int buy, int cap, int[] prices, int n,int[][][] dp){
        if(i==n)return 0;
        if(cap ==0)return 0;
        int profit =0;
        if(dp[i][buy][cap]!= -1)return dp[i][buy][cap];
        if(buy == 1){
            //deciding buy
            //profit = max(you buy +you not buy)
            profit = Math.max(-prices[i]+solver(i+1,0,cap,prices,n,dp),
                               0 + solver(i+1,1,cap,prices,n,dp));
        }else{
            //deciding sell
            //profit = max(sell,not sell)
            //here in sell we did cap-1 because here 1 transaciton happen entire end to end b and s
            profit = Math.max(prices[i]+solver(i+1,1,cap-1,prices,n,dp),
                                     0+ solver(i+1,0,cap,prices,n,dp));
        }

        return dp[i][buy][cap] = profit;

    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first
        int[][][] dp = new int[n+1][2][k+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<2;j++){
              for(int l=0; l<k+1;l++){
                dp[i][j][l] = -1;
              }
            }
        }

        
        //i,buy,trasnaction cap,prices arr ,arr lengtth
        return solver(0,1,k,prices,n,dp);
    }
}