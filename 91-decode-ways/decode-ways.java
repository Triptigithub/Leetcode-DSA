//understand via codewithmik and coded myself
//memo byme
class Solution {
    public int solver(int i, String s,int n,int[] dp){
        if(i>n)return 0;
         if(i==n)return 1;

        if(s.charAt(i) == '0' )return 0;
       
        if(dp[i]!= -1)return dp[i];
        int first =solver(i+1,s,n,dp);
        int second =0;
        if(i <= n-2){
        if(s.charAt(i) == '1' ||( s.charAt(i) =='2' && s.charAt(i+1) <= '6')){
            second = solver(i+2,s,n,dp);
        }}
        return dp[i]= first+second;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
       return solver(0,s,n,dp);
        
    }
}