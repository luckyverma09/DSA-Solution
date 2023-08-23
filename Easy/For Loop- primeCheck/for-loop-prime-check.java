//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // take testcases
        int t = sc.nextInt();
        while (t-- > 0) {
            // taking the number
            int n = sc.nextInt();
            Geeks obj = new Geeks();

            // caling isPrime method
            // with n as argument
            System.out.println(obj.isPrime(n));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Geeks {
    static String isPrime(int n) {
        int count = 0;
        if (n <= 1) return "No";  // 1 is not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                break;  // Exit the loop as soon as a divisor is found
            }
        }
        if (count > 0)
            return "No";  // n is not prime
        else
            return "Yes"; // n is prime
    }
}
