//brute force
class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;

        for(int i=0; i<s.length();i++){
            for(int j = i; j<s.length();j++ ){
                if(solver(s,i,j) == true)cnt++;
            }
        }
        return cnt;
    }

    public boolean solver(String s, int i,int j){
            if(i>j)return true;
            if(s.charAt(i) == s.charAt(j)){
                return solver(s,i+1,j-1);
            }
            return false;
    }

}