class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];


        // Prefix
        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
            }
        }

        // Postfix
        for (int i = nums.length - 1; i >= 0; i--) {

            if (i == nums.length - 1) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = postfix[i + 1] * nums[i];
            }
        }

        // Product except self
        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                postfix[i] = postfix[i + 1];
            } 
            else if (i == nums.length - 1) {
                postfix[i] = prefix[i - 1];
            } 
            else {
                postfix[i] = prefix[i - 1] * postfix[i + 1];
            }
        }

        return postfix;
    }
}
