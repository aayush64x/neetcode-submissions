class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> map = new HashMap<>(); 

        for(int i = 0; i<position.length; i++){
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        int[] reversed = new int[position.length];
        int l = 0; 
        int r = position.length -1; 

        while(l<=r){
            int temp = position[l];
            reversed[l] = position[r];
            reversed[r] = temp; 
            l++; 
            r--; 
        }
        Stack<Double> stack = new Stack<>(); 

        for(int pos : reversed){
            double time = (double) (target - pos) / (double)map.get(pos);
            if(stack.isEmpty()){
                stack.push(time);
            }
            else if(!stack.isEmpty() && time > stack.peek()){
                stack.push(time);
            }

        }

        return stack.size(); 
    }
}
