class Solution {
    public int solver(int i , int buy , int cap, int[] arr, int n, int[][][] dp){
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)

        // Base case: If we have processed all stocks or have no capital left, return 0 profit
        if(i == n || cap == 0) return 0;
        int profit = 0;


        if(dp[i][buy][cap] != -1)return dp[i][buy][cap];
       
        if(buy == 1){
            //profit = max(you buy + you did not buy)
            profit = Math.max( -arr[i]+solver(i+1,0,cap,arr,n,dp),
                                     0+solver(i+1,1,cap,arr,n,dp));
        }else{
            //profit = max(you sell stock, you didnot sell stk)
            //here when you sell stock  you complete one transaction
            profit = Math.max( arr[i]+solver(i+1,1,cap-1,arr,n,dp),
                                    0+solver(i+1,0,cap,arr,n,dp));
        }
        

        return dp[i][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i= 0; i<n ; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<3;k++){
                dp[i][j][k] = -1;
            }
        }
        }
        
        //idx,buy,cap
        return solver(0,1,2,prices,n,dp); 
        //checking how much profit we can make if we start from index 0 when buy state is 1 i.e currently we are not holding any stk so we can buy 
    }
}