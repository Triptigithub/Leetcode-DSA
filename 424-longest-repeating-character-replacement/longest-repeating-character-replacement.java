//did on my own
//here what we did is we fill the elemnt in hashmap one by one
//now we check ki ek toh max element h aur jo baki element h unki frequebcy ka sum jo h vo given k ke sath kesa h 
///agar chota ya euqal  ht oh ans compute kro 

//nhi to agar bda h toh shrink kro hmare window
//now while shrink if you simply do rest-- that will fail bcz
//ex arr  = b b a z r --> here max element is b if freuency 2
//sumof all is 5 so rest is 5-2 that is rest is 3
//now if ypu are doing rest-- you are saying that we are reomving element from (a z r)

//but thats not the case here we are removing max element b here 
//so make sure whenever you are remiving the element you recompute the rest 

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < s.length()) {
            char ch = s.charAt(j);  
            if (map.containsKey(ch)) {
                int cnt = map.get(ch);
                cnt++;
                map.put(ch, cnt);
            } else {
                map.put(ch, 1);
            }

            // Compute max frequency and sum of frequencies
            int max = 0;
            int sum = 0;
            for (int value : map.values()) {
                if (value > max) max = value;
                sum += value;
            }
            int rest = sum - max;










            if (rest <= k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                while (rest > k) {
                    char first = s.charAt(i);
                    if (map.containsKey(first)) {
                        int frequency = map.get(first);
                        if (frequency <= 1) {
                            map.remove(first);
                        } else {
                            map.put(first, frequency - 1);
                        }
                    }

                    // Recompute max and sum only after removing elements
                    max = 0;
                    sum = 0;
                    for (int value : map.values()) {
                        if (value > max) max = value;
                        sum += value;
                    }
                    rest = sum - max;
                    
                    i++;  // Move left pointer
                }
                j++;
            }
            
           
        }
        
        return ans;
    }
}

 