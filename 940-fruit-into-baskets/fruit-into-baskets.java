
//same as gfg ->Find length of the longest subarray containing atmost two distinct integers

//check expplanation there


class Solution {
    public int totalFruit(int[] arr) {
     if(arr.length == 1)return 1;
        if(arr.length == 2){
            if(arr[0] == arr[1])return 2;
        }
        int ans =0;

        int i=0;
        int j=0;
        
        HashMap<Integer,Integer> map = new HashMap<>(); //to store distinct element
        //this map stores the arrvalues,frequency
        
        while(j<arr.length){
            
            
            int value = arr[j];
            if(map.containsKey(value)){
                int cnt = map.get(value);
                cnt++;
                map.put(value,cnt);
            }else{
                map.put(value,1);
            }
            
            
            if(map.size() <= 2){
              //compute ans slide the window
                ans = Math.max(ans,j-i+1);
                j++;
            }else if(map.size() > 2){
                //shrink the window
                
                while(map.size() >2){
                    
                    //here we val is present in set remove it
                    int num = arr[i];
                    
                    
                    if(map.containsKey(num)){
                        int cnt = map.get(num);
                        if(cnt <= 1){
                            map.remove(num);
                        }else{
                            cnt = cnt-1;
                            map.put(num,cnt);
                        }
                    }
                    
                    
                    
                    i++;
                    
                    
                }
                j++;//slide the window after shrinking
            }
            
        }
        
        return ans;
        
    }
}