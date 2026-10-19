class Solution {
    public int findMin(int[] nums) {
        /*
        normal for loop is trivial
        how can we shorten the time complexity; 
        if it was sorted it will be simple binary search
        but it is not sorted, 
        yet there is a pattern 
        its like section of the number is moved forward or backward in the array. a chunk of the number 
        */
        Arrays.sort(nums);
        return nums[0];
        
    }
}
