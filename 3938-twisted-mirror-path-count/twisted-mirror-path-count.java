/**
Add a direction parameter to your recursive function:
- 0 = arrived by moving RIGHT
- 1 = arrived by moving DOWN
- -1 = starting cell 




for memo
Incoming dir	dirIndex	Meaning
-1	             2      	Starting position
0	             0       	Entered from LEFT (moving RIGHT)
1	             1	        Entered from ABOVE (moving DOWN)

For example, when you call:
*/
class Solution {
    static final int MOD = 1_000_000_007;

    public int solver(int r, int c, int dir,
            int[][] grid, int m, int n, int[][][] dp) {

        if (r >= m || c >= n) {
            return 0;
        }

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        int dirIndex = 0;

        if (dir == -1) {
            dirIndex = 2;
        } else {
            dirIndex = dir;
        }
        if (dp[r][c][dirIndex] != -1) {
            return dp[r][c][dirIndex];
        }
        // Current cell is a mirror
        if (grid[r][c] == 1) {

            if (dir == 0) {
                return solver(r + 1, c, 1, grid, m, n, dp);
            } else {
                return solver(r, c + 1, 0, grid, m, n, dp);
            }
        }

        int right = 0;
        int down = 0;

        // Try moving right
        if (c + 1 < n) {
            right = solver(r, c + 1, 0, grid, m, n, dp);
        }

        // Try moving down
        if (r + 1 < m) {
            down = solver(r + 1, c, 1, grid, m, n, dp);
        }

        return dp[r][c][dirIndex] = (right + down) % MOD;
    }

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][3];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        return solver(0, 0, -1, grid, m, n,dp);
    }
}

// class Solution {

//     public int solver(int r, int c,int[][] grid,int m,int n){

//         if (r >= m || c >= n) {
//     return 0;
// }
//         if(r == m-1 && c==n-1){
//              return 1;
//         }

//          int right = 0;
//          int down = 0;

//           if(c+1 < n){
//          if(grid[r][c+1] == 1){
//             right = solver(r+1,c+1,grid,m,n);
//          }else{
//             right = solver(r,c+1,grid,m,n);
//          }
//           }

//          if(r+1 < m){
//          if(grid[r+1][c] == 1 ){
//             down = solver(r+1,c+1,grid,m,n);
//          }else{
//             down = solver(r+1,c,grid,m,n);
//          }
//          }

//         return right+down;
//     }
//     public int uniquePaths(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//        return solver(0,0,grid,m,n);

//     }
// }