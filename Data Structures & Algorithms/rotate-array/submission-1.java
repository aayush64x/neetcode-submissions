class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
         
        int l = 0; 
        int r = nums.length -1; 
        while(l<r){
            int temp = nums[l]; 

            nums[l] = nums[r]; 
            nums[r] = temp; 
            l++; 
            r--; 
        }
        int l1 = 0; 
        int r1 = k-1; 
        while(l1<r1){
            int temp = nums[l1]; 

            nums[l1] = nums[r1]; 
            nums[r1] = temp; 
            l1++; 
            r1--; 
        }
        int l2 = k; 
        int r2 = nums.length-1; 
        while(l2<r2){
            int temp = nums[l2]; 

            nums[l2] = nums[r2]; 
            nums[r2] = temp; 
            l2++; 
            r2--; 
        }
    }
}