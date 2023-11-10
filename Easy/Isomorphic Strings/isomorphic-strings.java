//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    public static boolean areIsomorphic(String str1, String str2)
    {
        HashMap<Character, Character> mp1 = new HashMap<>(), mp2 = new HashMap<>();
        int i = 0, n = str1.length(), m = str2.length();
        
        if(n != m)
            return false;
            
        for(; i < n; i++)
        {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if ((mp1.containsKey(ch1) && mp1.get(ch1) != ch2) ||
                (mp2.containsKey(ch2) && mp2.get(ch2) != ch1))
                return false;
            
            mp1.put(ch1, ch2);
            mp2.put(ch2, ch1);
        }
        
        return true;
    }
}

