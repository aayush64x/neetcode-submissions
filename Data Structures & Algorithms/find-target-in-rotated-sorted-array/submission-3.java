class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // find the fall-off (index of min)
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {     // fixed: compare to nums[r], not r
                l = m + 1;
            } else {
                r = m;
            }
        }
        int index = l;
        int left = 0;
        int m1 = index - 1;
        int m2 = index;
        int right = nums.length - 1;

        // search left piece: 0 .. index-1
        while (left <= m1) {
            int m = left + (m1 - left) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                m1 = m - 1;              // fixed: target is left, shrink right side
            } else {
                left = m + 1;            // fixed
            }
        }

        // search right piece: index .. n-1
        while (m2 <= right) {
            int m = m2 + (right - m2) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                right = m - 1;           // fixed: target is left, shrink right side
            } else {
                m2 = m + 1;              // fixed: was "left"
            }
        }
        return -1;
    }
}