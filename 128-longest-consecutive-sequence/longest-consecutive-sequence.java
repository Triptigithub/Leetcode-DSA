//using optimal strriver approach
//using hashset
//we will firstly fill the set with array val
//now loop over set values;
//check agar current value se pichle va;ue exist krti h toh cur element is not starting pt so skip it


//agar cur val se piche vali value exist nhi krti mean cur element is our starting pt
//now what we will do is we take that element as stsrting no and run a while loop until cur +1 is present in set and also make sure to increase cnt and update cur element

class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        //fill no in set
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int longest = 0;

        //now again loop over set
        for(int it : set){
          if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    
    }
}