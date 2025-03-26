
//here its is variable length slidng window problem but withliitle twist

//here we take prefixsum
//we found new element we add that value in prefixsum

//agr hmara sum chota h target se then we did j++;
//jab hmara sum bda ya equal ho gya tab hmne ek while loop lgaya aur uske andar apna ans compute kiya

//loop ke bhar aya h mtlb sum choata ho gya target se so just do j++;


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int i=0;
        int j=0;
        int prefixsum = 0;
        while(j<nums.length){
            prefixsum+=nums[j];

            if(prefixsum < target){
                j++;
            }else if(prefixsum >= target){
                //remove i
                while(prefixsum>=target){
                ans = Math.min(ans,j-i+1); //here we are computing ans jab tk sum bda h ya equal h target k
                prefixsum = prefixsum-nums[i];
                i++;
                }
                

                //we came here means prefixsum chota h target se jo just did j++ to increase window length
                j++;
            }

        }

        return ans == Integer.MAX_VALUE?0:ans;
        }
}