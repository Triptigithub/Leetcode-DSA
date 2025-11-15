//memo  = 0(n2)
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solver(s, i, j, dp) == 1) cnt++;
            }
        }
        return cnt;
    }

    public int solver(String s, int i, int j, int[][] dp) {
        if (i >= j) return dp[i][j] = 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solver(s, i+1, j-1, dp);
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }
}
