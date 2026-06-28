class Solution {
    public int maxProfit(int[] prices) {
        //so 
        //buy = 1 means we can buy 
        //buy = 0 we are holding stk sell it first

        int n = prices.length;

        int[] ahead = new int[2];
        int[] mid = new int[2];
        int[] cur = new int[2];

        //here change dp[i+1] -> mid
        //dp[i] = cur
        //dp[i+2] = ahead

        //in memo we were going from i = 0 to n
        //buy = 1 to 2 can be naything this time

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit = 0;

                if (buy == 1) {
                    //deciding buy
                    //profit = max(you buy +you not buy)
                    profit = Math.max(-prices[i] + mid[0],
                            0 + mid[1]);
                } else {
                    //deciding sell
                    //profit = max(sell,not sell)
                    //here in sell case --> prev it was (i+1,1) in case that means in next state or at next index you are allowed to buy again but here you will see
                    //our cooldown clause say after one transaction i.e buy and sell we should not allow to buy on immediate next day
                    //so we just do i+2 we skip one index and then allowed to buy i.e (i+2,1) -> on next to next day you are allowed ot buy 

                    //                      <----- crucial part ---> doing i+2
                    profit = Math.max(prices[i] + ahead[1],
                            0 + mid[0]);
                }

                cur[buy] = profit;
            }
            //now do swapping
            int[] temp = ahead;
            //========
            //cur become mid and mid become ahead
            ahead = mid; //jo phle mid tha usse ahead bna do
            mid = cur; //jo phle cur tha usse mid bna do
            //=========
            //here if you see currently ahead is pinting to older mid
            //mid is pointing to older cur
            //but cur is still pointing to mid wala array only like we didnot change cuur as odf now
            //so we should remove cur pointer from here
            //1.approach do here cur = new int[2]; make new cur array every iternation
            //2.that we used her
            //           -> ahead array that we were using initially is of no use reuse that
            //           -> initially he save like int[] temp = ahead;
            //           -> and at last we do after swapping cur = temp
            //here as we are rewriting cur value in every iteration so phle kuch bhi values aye from ahead arr we dont caaaare
            cur = temp;

        }
        //because we are swapping final ans lies in mid[1]
        return mid[1];
    }
}