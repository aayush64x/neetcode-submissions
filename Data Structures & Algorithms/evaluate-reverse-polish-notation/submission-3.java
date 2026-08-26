class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>(); 
        int a; 
        int b; 
        int result = 0; 
        for(String s : tokens){
            switch(s){
                    case "+":
                        a = Integer.parseInt(stack.pop());
                        b = Integer.parseInt(stack.pop()); 
                        result = a + b;
                        stack.push(String.valueOf(result));
                        break;
                    case "-":
                        a = Integer.parseInt(stack.pop());
                        b = Integer.parseInt(stack.pop()); 
                        result = b - a;
                        stack.push(String.valueOf(result));
                        break;
                    case "*":
                        a = Integer.parseInt(stack.pop());
                        b = Integer.parseInt(stack.pop()); 
                        result = a * b;
                        stack.push(String.valueOf(result));
                        break;
                    case "/":
                        a = Integer.parseInt(stack.pop());
                        b = Integer.parseInt(stack.pop()); 
                        result = b / a;
                        stack.push(String.valueOf(result));
                        break;
                    default: 
                        result = Integer.parseInt(s);
                        stack.push(s);

                }
        }
        return result; 

        
    }
}
