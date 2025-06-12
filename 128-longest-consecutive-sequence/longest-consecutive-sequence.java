//

class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if(n==1)return 1;
        if(n==0)return 0;
        int ans =1;
        Arrays.sort(nums);
        int curnum = nums[0];
        int cnt=1;
        for(int i=1;i<n;i++){
             if(nums[i] == curnum){
                continue;
             }else if (nums[i] == curnum+1 ){
                cnt++;
                curnum = nums[i];
                ans = Math.max(ans,cnt);
             }else if(nums[i] != curnum){
                curnum = nums[i];
                cnt = 1;
             }
        }
        return ans;
    }
}