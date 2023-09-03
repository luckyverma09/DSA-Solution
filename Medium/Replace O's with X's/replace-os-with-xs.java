//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static char[][] fill(int n, int m, char a[][]) {
        if (n == 0 || m == 0) {
            return a;
        }

        // Function to perform DFS from an 'O' and mark it as safe
        // Helper function
        class DFSTraverse {
            void dfs(int x, int y) {
                if (x < 0 || x >= n || y < 0 || y >= m || a[x][y] != 'O') {
                    return;
                }
                a[x][y] = 'S'; // Mark it as safe
                dfs(x - 1, y);
                dfs(x + 1, y);
                dfs(x, y - 1);
                dfs(x, y + 1);
            }
        }

        DFSTraverse dfsTraverse = new DFSTraverse();

        // Step 1: Start DFS from 'O's on the border
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && a[i][j] == 'O') {
                    dfsTraverse.dfs(i, j);
                }
            }
        }

        // Step 2: Replace remaining 'O's with 'X' and restore 'S' to 'O'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') {
                    a[i][j] = 'X';
                } else if (a[i][j] == 'S') {
                    a[i][j] = 'O';
                }
            }
        }

        return a;
    }
}