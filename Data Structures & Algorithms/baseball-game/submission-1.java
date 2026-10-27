class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>(); 

        for(String score : operations){
            if (score.equals("C")) {
                stack.pop();
            }
            else if(score.equals("D")){
                int last = stack.peek();
                stack.push(last * 2);
            }
            else if (score.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();
                stack.push(last);
                stack.push(last + secondLast);
            }
            else {
                stack.push(Integer.parseInt(score));
            }
        }
        int total = 0; 
        while(!stack.isEmpty()){
            total += stack.pop(); 
        }
        return total; 
    }
}