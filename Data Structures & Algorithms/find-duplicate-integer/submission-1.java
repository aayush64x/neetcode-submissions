class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Phase 1: Find intersection inside the cycle
        do{
            slow = nums[slow]; 
            fast = nums[nums[fast]]; 
        }
        while(slow != fast); 

        int ptr = 0; 
        while (ptr != slow){
            ptr = nums[ptr]; 
            slow = nums[slow];
        }
        return ptr; 
    }
}