class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int left = 1; 
        int right = max; 
        int hours = 0; 
        while(left<=right){
            int hrs = 0;
            int m = left+ (right - left )/2;
            for (int pile : piles){
                hrs += ((long)pile + m -1) / m;
            }
            if(hrs > h){
                left = m + 1; 
            }
            else if(hrs <= h){
                right = m -1; 
            }
        }
        return left;
    }
}