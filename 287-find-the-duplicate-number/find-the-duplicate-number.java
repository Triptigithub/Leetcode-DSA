class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];


        slow = nums[slow];
        fast = nums[nums[fast]];



//find intersection
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];

        }

//move one to start
            slow = nums[0];
            while(slow!=fast){
                slow = nums[slow];
                fast = nums[fast];
            }

return slow;
    
    }
}