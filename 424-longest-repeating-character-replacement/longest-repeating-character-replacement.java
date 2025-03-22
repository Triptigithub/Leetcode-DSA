//similar to my previous submit just made code more cleaner
class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        int maxFreq= 0;

        while (j < s.length()) {
            char ch = s.charAt(j);  
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            //here we dont need to explixitylu find out suma nd max
            //in prev code also sum represent the lengtth of window
            //and max represent maxfreq
            
            int rest = (j-i+1) - maxFreq;

            if (rest <= k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                    char first = s.charAt(i);
                     map.put(first, map.get(first) - 1);
                     i++;  // Move left pointer
                
                j++;
            }
            
           
        }
        
        return ans;
    }
}

 