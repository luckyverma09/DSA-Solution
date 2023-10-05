//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    String longestCommonPrefix(String arr[], int n) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        String S = "";

        for (int i = 0; i < n; i++) {
            int len = arr[i].length();
            if (len < min) {
                min = len;
                S = arr[i];
            }
        }
        
        for (int i = 0; i < min; i++) {
            int flag = 0; // Reset flag for each character position
            for (int j = 0; j < n; j++) {
                if (arr[j].charAt(i) != S.charAt(i)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
            count++;
        }
        
        if (count == 0) {
            return "-1";
        } else {
            return S.substring(0, count);
        }
    }
}
