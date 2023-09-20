//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
             ArrayList<Integer> al = new ArrayList<>();

D%=16;

 //here we perform & 65535 bcz ans will come

 // only in this range of 16 bit

 //and we use (<<) | (>>) also bcz we have to rotate in 16 bit not in 32

 // use this test case to learn concept

//n=32768 d=1 ans comes 1 16384 imp

//and n = 32767 d=1 ans 65534 49151 imp

     al.add(((N << D) | (N >> 16-D)) & 65535);

     al.add(((N >> D) | (N << 16-D)) & 65535); 

       return al;
    }
}