//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new Solution().modified(a));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find minimum number of characters which Ishaan must insert  
    //such that string doesn't have three consecutive same characters.
    public static long modified(String a)
    {
        // Your code here
        int j=0;
        for(int i=0;i<a.length()-2;i++){
            if(a.charAt(i)==a.charAt(i+1) && a.charAt(i+1)==a.charAt(i+2)){
                j++;
                i++;
            }
        }
        return j;
    }
}