class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] arr = new int[nums.length];
        int pre = 1; 
        int pos = 1; 
        for (int i = 0; i < nums.length; i++){
            if(i == 0){
                prefix[i] = nums[i];
            }
            else{
                prefix[i] = prefix[i-1] * nums[i];
            }
            
        }
        for (int j = nums.length-1; j >= 0; j--){
            if(j == nums.length -1){
                postfix[j] = nums[j];
            }
            else{
                postfix[j] = postfix[j+1] * nums[j];
            }
            
        }
        for (int i = 0; i < nums.length; i++){
            if(i == 0){
                arr[i] = postfix[i+1];
            }
            else if(i == nums.length -1){
                arr[i] = prefix[i-1];
            }
            else{
                arr[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return arr; 

    }
}  
