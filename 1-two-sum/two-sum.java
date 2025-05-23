
//we just used the simple hashing technique
//loop over arr if 
//val1 is arr[i]  and val2 = t-arr[i];
//now check if the val2 is presentin our map then we got hte ans return index of nums[i] and val2; i.e i and val2 index is store in map
//and if we didnot found the val2 we just simply add current num and its index in map

//strriver better approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            //so
            int val1 = nums[i];
            int val2 = target-nums[i];

            if(map.containsKey(val2) == true){
                int[] arr =new int[2];
                arr[0] = i;
                arr[1] = map.get(val2);
                return arr;
            }else{
                map.put(nums[i],i);
            }

        }
        return new int[1];
    }
}