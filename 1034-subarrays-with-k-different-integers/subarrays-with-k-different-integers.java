class Solution {

     public int solver(int[] arr,int k){
         if (k == 0) return 0; 
    HashMap<Integer,Integer> hs = new HashMap<>();
    int i=0;
    int j=0;
    int res =0;
    
    
    while(j<arr.length){
        
        //do calculation
        //fill the hashmap with the character and its frequency
        
        hs.put(arr[j], hs.getOrDefault(arr[j], 0) + 1);
        
        
        int x = hs.size();
       
            
            //try to shrink
            while(hs.size()>k){
                int y= arr[i];
                if (hs.containsKey(y)) {
                        if (hs.get(y) == 1) {
                            hs.remove(y);  // Properly remove key
                        } else {
                            hs.put(y, hs.get(y) - 1);  // Decrease count safely
                        }
                    }
                
                i++; 
            }
          // Count subarrays ending at j
             res += (j - i + 1);
             j++;  // Expand the window
        
    }
    return res;
    
    }

    public int subarraysWithKDistinct(int[] arr, int k) {
      return solver(arr,k)-solver(arr,k-1);
    }
}