//TAB
class Solution {
    

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first
        int[][] ahead = new int[2][k+1];
        int[][] cur = new int[2][k+1];

        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < k + 1; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        //deciding buy
                        //profit = max(you buy +you not buy)
                        profit = Math.max(-prices[i] + ahead[0][cap],
                                0 + ahead[1][cap]);
                    } else {
                        //deciding sell
                        //profit = max(sell,not sell)
                        //here in sell we did cap-1 because here 1 transaciton happen entire end to end b and s
                        profit = Math.max(prices[i] + ahead[1][cap - 1],
                                0 + ahead[0][cap]);
                    }

                    cur[buy][cap] = profit;

                }
            }
            ahead = cur;
        }

        //i,buy,trasnaction cap,prices arr ,arr lengtth
        return ahead[1][k];
        //i = 0ton
        //buy = 0 to1
        //cap = k to 0
    }
}