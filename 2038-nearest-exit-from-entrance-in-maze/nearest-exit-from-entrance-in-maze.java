class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], -1);
        }

        int enti = entrance[0];
        int entj = entrance[1];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(enti, entj));
        vis[enti][entj] = 0;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                int row = p.first;
                int col = p.second;

                // Check if it's a valid exit (but not the entrance)
                if ((row != enti || col != entj) &&
                    (row == 0 || row == n - 1 || col == 0 || col == m - 1)) {
                    return steps;
                }

                // Explore neighbors
                for (int dir = 0; dir < 4; dir++) {
                    int newRow = row + delrow[dir];
                    int newCol = col + delcol[dir];

                    if (newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        maze[newRow][newCol] == '.' &&
                        vis[newRow][newCol] == -1) {

                        vis[newRow][newCol] = 0;
                        q.add(new Pair(newRow, newCol));
                    }
                }
            }
            steps++;
        }

        return -1; // No exit found
    }
}
