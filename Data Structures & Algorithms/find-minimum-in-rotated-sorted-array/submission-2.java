class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;   // min is to the right of m
            } else {
                r = m;       // m could be the min, keep it
            }
        }
        return nums[l];
    }
}