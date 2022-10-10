class Solution {
    public boolean isPalindrome(int x) {
         int rem=0,sum=0,temp=x;
        while(x>0){
            rem=x%10;
            sum=sum*10+rem;
            x=x/10;
        }
        if(sum==temp)
            return true;
            return false;
    }
}