class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack<>(); 
        int a; 
        int b; 
        int result = 0; 
        for(String s : tokens){
            if(!operators.contains(s)){
                stack.push(s);
                result = Integer.parseInt(s); 
            }
            else{
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

                }
            }
        }
        return result; 

        
    }
}
