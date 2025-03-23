//similar to ques 	
//Binary subarray with sum


//-> here we replaces the ood number with 1 and even no with 0 




class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        HashMap<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);

        int prefixsum = 0;
        int cnt = 0;



        for(int i=0; i<nums.length;i++){
              prefixsum+=nums[i]%2;

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