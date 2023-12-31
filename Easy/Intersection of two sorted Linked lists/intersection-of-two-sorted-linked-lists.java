//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        if(head1 == null && head2 == null)return null;
        if(head1 == null)return head2;
        if(head2 == null)return head1;
        
        Node resHead = new Node(-1);
        Node res = resHead;
        
        Node curr1 = head1;
        Node curr2 = head2;
        
        while(curr1 != null && curr2 != null){
            if(curr1.data < curr2.data){
                curr1 = curr1.next;
            }else if(curr1.data > curr2.data){
                curr2 = curr2.next;
            }else{
                res.next = new Node(curr1.data);
                curr1 = curr1.next;
                curr2 = curr2.next;
                res = res.next;
            }
        }
        return resHead.next;
    }
}