//brute force
class Solution {
    public int countSubstrings(String s) {
      int ans =0; 
       
       for(int i=0; i<s.length();i++){
        ans += solver(s,i,i);
        ans+=solver(s,i,i+1);
       }
       return ans;
    }

    public int solver(String s, int l , int r){
        int cnt =0;


        while(l>=0 &&  r<s.length() &&   s.charAt(l) == s.charAt(r)){
            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
}