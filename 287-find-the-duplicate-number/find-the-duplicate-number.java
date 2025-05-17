class Solution {
    public int findDuplicate(int[] nums) {
        //my initial approach by my own is to do sort and check adjacent
        Arrays.sort(nums);
        int n = nums.length;
        int one=nums[0];
        for(int i=1;i<n;i++){
            if(one == nums[i]){
                return nums[i];
            }else{
                one = nums[i];
            }

        }
  return 0;
    }
}