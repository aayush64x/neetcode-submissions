class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        int a; 
        int b; 
        int result = 0; 
        for(String s : tokens){
            switch(s){
                    case "+":
                        a = stack.pop();
                        b = stack.pop(); 
                        result = a + b;
                        stack.push(result);
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop(); 
                        result = b - a;
                        stack.push(result);
                        break;
                    case "*":
                        a = stack.pop();
                        b = stack.pop(); 
                        result = a * b;
                        stack.push(result);
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop(); 
                        result = b / a;
                        stack.push(result);
                        break;
                    default: 
                        result = Integer.parseInt(s);
                        stack.push(result);

                }
        }
        return result; 

        
    }
}
