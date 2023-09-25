//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
public ArrayList<ArrayList<Integer>> fourSum(int[] A, int K) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if (A == null || A.length < 4) {
            return result;
        }
        
        Arrays.sort(A); // Sort the array to simplify the process
        
        int n = A.length;
        
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue; // Skip duplicates
            }
            
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && A[j] == A[j - 1]) {
                    continue; // Skip duplicates
                }
                
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    int sum = A[i] + A[j] + A[left] + A[right];
                    
                    if (sum == K) {
                        ArrayList<Integer> quadruple = new ArrayList<>();
                        quadruple.add(A[i]);
                        quadruple.add(A[j]);
                        quadruple.add(A[left]);
                        quadruple.add(A[right]);
                        result.add(quadruple);
                        
                        while (left < right && A[left] == A[left + 1]) {
                            left++;
                        }
                        
                        while (left < right && A[right] == A[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < K) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
         
    }
}