class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;          // found it
            } else if (nums[mid] < target) {
                l = mid + 1;         // too small, go right
            } else {
                r = mid - 1;         // too big, go left
            }
        }

        return l;                    // not found: l is where it belongs
    }
}
