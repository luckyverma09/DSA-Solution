//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int arr[], int n) {
        
        if(n == 1) return arr[0];
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int currMin = 0;
        int totalsum = 0;
        for (int i = 0; i < n; i++) {

            currMin += arr[i];
            currMax += arr[i];

            minSum = Math.min(minSum, currMin);
            maxSum = Math.max(maxSum,currMax);

            if (currMin > 0) currMin = 0;
            if(currMax < 0) currMax = 0;
            totalsum += arr[i];
        }

        return (totalsum == minSum) ? maxSum : Math.max(maxSum, totalsum - minSum);
    }
    
}

