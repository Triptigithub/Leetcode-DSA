//just upgraded the n/2 wala code
//this code is extended version of moores voting algo



class Solution {
    public List<Integer> majorityElement(int[] nums) {
    int n = nums.length;

    int el1 = Integer.MIN_VALUE;
        int cnt1 =0;

    int el2 = Integer.MIN_VALUE;
    int cnt2 =0;

        for(int i=0; i<nums.length; i++){
              if(cnt1 == 0 && nums[i]!=el2){
                el1 = nums[i];
                cnt1++;
              }else if(cnt2 == 0 && nums[i] != el1){
                 el2 = nums[i];
                 cnt2++;
             }else if(nums[i] == el1){
                    cnt1++;
             }else if(nums[i] == el2){
                    cnt2++;
             }else{
                    cnt1--;
                    cnt2--;

              }

        
        }


//we are here validating the cnt 
//as boore voting law only gives us correct element no its correct cnt
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }

        // Check final counts
        List<Integer> result = new ArrayList<>();
        //int n = nums.length;
        if (cnt1 > n / 3) result.add(el1);
        if (cnt2 > n / 3) result.add(el2);
        return result;
    }
}
