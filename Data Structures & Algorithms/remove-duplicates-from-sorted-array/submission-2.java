class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Put all unique values into the set
        for (int num : nums) {
            set.add(num);
        }

        // Put the unique values back into nums
        int k = 0;
        for (int num : set) {
            nums[k] = num;
            k++;
        }
        Arrays.sort(nums, 0, k);

        return k;
    }
}