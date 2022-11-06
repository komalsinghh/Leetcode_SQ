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
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static void fillLps(String str,int[] arr,int n){
        int len=0,i=1;
        arr[0]=0;
        while(i<n){
            if(str.charAt(i)==str.charAt(len)){
                ++len;
                arr[i]=len;
                i++;
            }
            else{
                if(len==0){
                    arr[i]=0;
                    i++;
                }
                else{
                    len=arr[len-1];
                }
            }
        }
    }   
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=txt.length();
        int m=pat.length();
        int[] lps=new int[m];
        fillLps(pat,lps,m);
        int j=0,i=0;
        while(i<n){
            if(pat.charAt(j)==txt.charAt(i)){
                i++;
                j++;
            }
            if(j==m){
                ans.add(i-j+1);
                j=lps[j-1];
            }
            else if(i<n && pat.charAt(j)!=txt.charAt(i)){
                if(j==0)
                    i++;
                else
                    j=lps[j-1];
            }
        }
       return ans; 
    }
}