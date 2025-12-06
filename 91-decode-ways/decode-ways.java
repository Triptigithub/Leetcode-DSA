//understand via codewithmik and coded myself
//now tabulation
//did myslef
class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        //array fill nhi krna

        //base case shi kro
        dp[n]=1;

        for(int i=n-1; i>=0;i--){
             if(s.charAt(i) == '0' ){
                dp[i] = 0;
             }else{
                     int first =dp[i+1];
                    int second =0;
                    if(i <= n-2){
                        if(s.charAt(i) == '1' ||( s.charAt(i) =='2' && s.charAt(i+1) <= '6')){
                        second = dp[i+2];
                        }
                    }
                    dp[i]= first+second;
                }
        }



        return dp[0];


    }
}