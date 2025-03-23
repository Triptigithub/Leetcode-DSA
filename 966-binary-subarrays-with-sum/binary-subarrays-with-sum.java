//this question is similar to the 
//560. Subarray Sum Equals K

//this type of question look like can be solved by sliding window but they diidnot bcz
//either they include -ve number or 0 in array



class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);

        int prefixsum = 0;
        int cnt = 0;



        for(int i=0; i<nums.length;i++){
              prefixsum+=nums[i];

              int x = prefixsum - goal;
              if(map.containsKey(x)){
                cnt+=map.get(x);
              }

              if(map.containsKey(prefixsum)){
                map.put(prefixsum,map.get(prefixsum)+1);
              }else{
                map.put(prefixsum,1);
              }
        }

        return cnt;
    }
}