class Solution {
    public int maxProfit(int[] prices, int fee) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;
        int[] ahead = new int[2];
        int[] cur = new int[2];

        //  if (i == n)return 0;
        ahead[0] = 0;
        ahead[1] = 0;

        
        for(int i = n-1 ; i>=0 ; i--){
            for (int buy = 0; buy < 2; buy++){
                int profit =0;
                if(buy == 1){
                   //deciding buy
                   //profit = max(you buy +you not buy)
                   profit = Math.max(-prices[i]+ahead[0],
                                        0 + ahead[1]); 
                }else{
                    //deciding sell
                    //profit = max(sell,not sell)
                    //here in sell case --> when you are complete one transaction you need to subtract the fee from profit
                    profit = Math.max(-fee + prices[i]+ahead[1],
                                     0+ahead[0]);
                }
              
              cur[buy] = profit;
            }
            //here we reused the same old ahead arr becasue once you do ahead  =curr now old ahead array is of no use so you can use that same arras curr arr instead of creating new 
            int[] temp = ahead;
            ahead = cur;
            cur = temp;
        }
        
        //we have infinite transaction we can buy ans sell as much time as we want
        //i,buy,prices arr ,arr lengtth,fee,dp
        return ahead[1];
    }
}