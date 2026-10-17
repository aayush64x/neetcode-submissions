class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0; 
        int sum = 0;
        for(int weight : weights){
            max = Math.max(weight, max);
            sum += weight;
        }

        int start = max; 
        int end = sum; 
        for(int i = start; i<end; i++){
            if(isValid(weights, days, i)){
                return i; 
            }
        }
        return end; 
    }
    public boolean isValid(int[] weights, int days, int c){
        int daysPassed = 1; 
        int load = 0; 
        for(int weight : weights){
            if(load + weight > c){
                load = 0; 
                daysPassed += 1; 
            }
            load += weight; 
        }
        return daysPassed <= days; 
    }
}