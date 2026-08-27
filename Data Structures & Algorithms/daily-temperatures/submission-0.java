class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); 
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) {
                stack.push(i);
                arr[i] = 0; 
            }
            else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    arr[stack.peek()] = i - stack.peek(); 
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return arr; 
    }
}

