//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution {
    // Function to perform a DFS traversal and check if a vertex is a mother vertex.
    private void DFSUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, adj, visited);
            }
        }
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int motherVertex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, adj, visited);
                // After the DFS traversal, if all vertices are visited, i is a potential mother vertex.
                motherVertex = i;
            }
        }

        // Now, we need to check if the potential mother vertex can reach all other vertices.
        Arrays.fill(visited, false);
        DFSUtil(motherVertex, adj, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // The potential mother vertex cannot reach all vertices.
                return -1;
            }
        }

        return motherVertex;
    }
}