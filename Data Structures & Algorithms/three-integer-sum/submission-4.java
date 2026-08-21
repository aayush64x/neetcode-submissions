class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> list = new ArrayList<>();
        for (int i =0; i<nums.length; i++){
            int l = i + 1; 
            int r = nums.length-1; 
            while(l<r){
                if(nums[i] + nums[l]+ nums[r] == 0){
                    if(!list.contains(Arrays.asList(nums[i], nums[l], nums[r]))){
                        list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    
                    }
                    l+=1; 
                    r-=1; 
                }
                else if(nums[i] + nums[l] + nums[r] > 0){
                    r -=1; 
                }
                else if(nums[i] + nums[l]+ nums[r] < 0){
                    l +=1; 
                }
            }
        }
        return list; 
    }
}
