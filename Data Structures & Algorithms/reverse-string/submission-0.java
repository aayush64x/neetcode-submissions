class Solution {
    public void reverseString(char[] s) {
       int left = 0;
       int right = s.length - 1; 
       while(left<right){
        char a = s[right];
        char b = s[left];
        s[left] = a;
        s[right] = b;
        left++;
        right--;
       }
    }
}