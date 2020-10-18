//Possible Bipartition

//PROBLEM:
/*
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

*/
//SOLUTION
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] G = new int[N][N];
        for (int[] d : dislikes) {
            int i = d[0]-1, j = d[1]-1;
            G[i][j] = G[j][i] = 1;
        }
        for (int i = 0; i < N; i++) {
            if (G[i][i] != 0) continue;
            if (!dfs(G, 2, i)) return false;
        }
        return true;
    }
    
    private boolean dfs(int[][] G, int color, int i) {        
        G[i][i] = color;
        for (int j = 0; j < G.length; j++) {
            if (i == j) continue;
            if (G[i][j] == 0) continue; // no relationship
            if (G[j][j] == -color) continue; // adjacent node is painted properly
            if (G[j][j] == color) return false;  // adjacent node is pained wrongly
            if (!dfs(G, -color, j)) return false;
        }
        return true;
    }
}
