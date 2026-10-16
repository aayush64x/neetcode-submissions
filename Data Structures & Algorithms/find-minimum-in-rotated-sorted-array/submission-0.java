class Solution {
    public int findMin(int[] nums) {
        int l = 0; 
        int r = nums.length - 1; 
        int min = Integer.MAX_VALUE; 
        for(int num : nums){
            min = Math.min(num, min);
        }
        return min;
    }
}
