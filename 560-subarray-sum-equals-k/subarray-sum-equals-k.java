//to deeply understand its approach check this vedio
//https://www.youtube.com/watch?v=xvNwoz-ufXA
//else notes notebook mmumy wali sliding window wale part mein


class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer,Integer>  map = new HashMap<>(); //stores prefixsum , frequency
        map.put(0,1); // necessary says ki 0 sum ki ek occurance h

        int cnt=0;
        int prefixsum = 0;

        for(int i=0; i<arr.length;i++){
           prefixsum += arr[i];  

          int x = prefixsum - k;
          if(map.containsKey(x)){
             cnt+=map.get(x);
          }


           //this ensure that if the prefixsum is present phle he then simply increase its frequency
          if(map.containsKey(prefixsum)){
             map.put(prefixsum,map.get(prefixsum)+1);
          }else{
            map.put(prefixsum,1);
          }
         
        }
       return cnt;
            
    }
}