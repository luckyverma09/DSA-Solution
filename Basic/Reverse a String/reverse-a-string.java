//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
public static String reverseWord(String str)
{
    // Create a StringBuilder to store the reversed string
    StringBuilder reversed = new StringBuilder();

    // Iterate through the characters in reverse order and append to the StringBuilder
    for (int i = str.length() - 1; i >= 0; i--) {
        reversed.append(str.charAt(i));
    }

    // Convert the StringBuilder to a String and return
    return reversed.toString();
}

}