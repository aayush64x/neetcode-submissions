class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if( c == '(' || c == '{' || c == '['){
                stack.push(c); 
            }
            else if( c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty()){
                    return false; 
                }
                if( c == ')'){
                    char a = stack.pop();
                    if(a != '('){
                        return false; 
                    }
                }
                else if (c == '}'){
                    char a = stack.pop();
                    if(a != '{'){
                        return false; 
                    }
                }
                else if (c == ']'){
                    char a = stack.pop();
                    if(a != '['){
                        return false; 
                    }
                }
            }
        }
        return stack.isEmpty();
        
    }
}
