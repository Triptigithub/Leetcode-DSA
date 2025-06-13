//by striver
//using hashmap,index
//i coded on my own

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        if(s.length() == 1)return 1;
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=1;
        int cnt= 1;
        map.put(s.charAt(i),0);

        int n = s.length();
        while(j<n){
           if(!map.containsKey(s.charAt(j))){
            map.put(s.charAt(j),j);
            cnt = Math.max(cnt,j-i+1);
            j++;
           }else{
             i = Math.max(i, map.get(s.charAt(j)) + 1);//as hmare map mein purane value bhi h toh kabhi winow piche slide na ho jaye isliye


             cnt = Math.max(cnt,j-i+1);

             //now update the index of a in map
             map.put(s.charAt(j),j);
             j++;
           }
           

        }
        return cnt;
    }
}