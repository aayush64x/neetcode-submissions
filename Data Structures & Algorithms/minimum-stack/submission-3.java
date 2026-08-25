class MinStack {
    int top; 
    int[] arr; 
    int min; 
    Stack<Integer> stack; 

    public MinStack() {
        arr = new int[30000];
        top = -1; 
        stack = new Stack<>(); 
    }
    
    public void push(int val) {
        if(top == -1){
            min = val;
            stack.push(min);
        }
        else{
            if(val <= min){
                min = val; 
                stack.push(min);
            }
        }
        top++; 
        arr[top] = val; 
    }
    
    public void pop() {
        if(top == -1) return; 
        if(arr[top] == stack.peek()){
            stack.pop();
        }
        top--;
    }
    
    public int top() {
        return arr[top]; 
    }
    
    public int getMin() {
        return stack.peek();
    }
}
