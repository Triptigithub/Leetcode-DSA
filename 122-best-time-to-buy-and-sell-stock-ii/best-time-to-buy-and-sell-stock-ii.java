class Solution {
    public int solver(int i , int buy , int[] arr, int n, int[][] dp){
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)
        if(i == n)return 0;
        int profit = 0;

        if(dp[i][buy] != -1)return dp[i][buy];
        if(buy == 1){
            //profit = max(you buy + you did not buy)
            profit = Math.max( -arr[i]+solver(i+1,0,arr,n,dp),
                                     0+solver(i+1,1,arr,n,dp));
        }else{
            //profit = max(you sell stock, you didnot sell stk)
            profit = Math.max( arr[i]+solver(i+1,1,arr,n,dp),
                                    0+solver(i+1,0,arr,n,dp));
        }

        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i= 0; i<n ; i++){
            for(int j=0; j<2; j++){
                dp[i][j] = -1;
            }
        }

        return solver(0,1,prices,n,dp); 
        //checking how much profit we can make if we start from index 0 when buy state is 1 i.e currently we are not holding nay stk
    }
}