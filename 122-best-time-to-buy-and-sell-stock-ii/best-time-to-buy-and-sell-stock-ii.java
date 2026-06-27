class Solution {
    public int maxProfit(int[] prices) {
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)

        //here we find out that previously when we were using dp arr
        //we were actually using the current index arr value at [i][0] and [i][1] and the next index value only [i+1][0] and [i+1][1] 
        //here we just declare that variable only at last switching them to compute next values

        int n = prices.length;
        int profit =0;
        
        int frontzero = 0;
        int frontone =0;

//base case
        int backzero =0;
        int backone=0;

        
        

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                profit = 0;
                if (buy == 1) {
                    //profit = max(you buy + you did not buy)
                    profit = Math.max(-prices[i] + frontzero,
                            0 + frontone);
                    backone = profit;
                } else {
                    //profit = max(you sell stock, you didnot sell stk)
                    profit = Math.max(prices[i] + frontone,
                            0 + frontzero);
                    backzero = profit;
                }
                
            }

            frontzero = backzero;
               frontone  = backone; 

        }

        return frontone;
      

    }
}