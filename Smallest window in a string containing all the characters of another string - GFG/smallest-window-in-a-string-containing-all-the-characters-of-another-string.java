//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        int i=-1,j=-1,dcnt=p.length(),count=0;
        String ans="";
        HashMap<Character,Integer> hm2=new HashMap<>();
        for(int k=0;k<p.length();k++){
            char ch=p.charAt(k);
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer> hm1=new HashMap<>();
        while(true){
            boolean flag1=false;
            boolean flag2=false;
            while(i<s.length()-1 && count<dcnt){
                i++;
                char ch=s.charAt(i);
                hm1.put(ch,hm1.getOrDefault(ch,0)+1);
                if(hm1.getOrDefault(ch,0)<=hm2.getOrDefault(ch,0)){
                    count++;
                }
                flag1=true;
            }
            while(j<i && count==dcnt){
                String pans=s.substring(j+1,i+1);
                if(ans.length()==0 || pans.length()<ans.length()){
                    ans=pans;
                }
                j++;
                char ch=s.charAt(j);
                if(hm1.get(ch)==1)
                    hm1.remove(ch);
                else
                    hm1.put(ch,hm1.get(ch)-1);
                if(hm1.getOrDefault(ch,0)<hm2.getOrDefault(ch,0)){
                   count--;
                }
                 flag2=true;   
            }
            if(flag1==false && flag2==false)
                break;
        }
        if(ans.length()==0)
            return "-1";
        return ans;
    }
}