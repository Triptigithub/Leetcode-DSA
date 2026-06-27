class Solution {
    public int maxProfit(int[] prices) {
        //buy = 1 (we can buy stock if we want to we are not holding  any stock)
        //buy = 0 (we prev has buyed one stock we need to sell that before buy any more)

        //here we find out that previously when we were using dp arr
        //we were actually using the current index arr value at [i][0] and [i][1] and the next index value only [i+1][0] and [i+1][1] 
        //here we just declare that variable only at last switching them to compute next values

        int n = prices.length;
        int profit = 0;
        int[] frontarr = new int[2];
        int[] curarr = new int[2];

        frontarr[0] = 0;
        frontarr[1] = 0;

        //base case
        

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                profit = 0;
                if (buy == 1) {
                    //profit = max(you buy + you did not buy)
                    profit = Math.max(-prices[i] + frontarr[0],
                            0 + frontarr[1]);
                } else {
                    //profit = max(you sell stock, you didnot sell stk)
                    profit = Math.max(prices[i] + frontarr[1],
                            0 + frontarr[0]);
                }
                curarr[buy] = profit;
            }

            //switching
            frontarr = curarr;

        }

        return frontarr[1];
      

    }
}