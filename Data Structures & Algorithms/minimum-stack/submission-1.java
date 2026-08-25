class MinStack {
    int top; 
    int[] arr; 

    public MinStack() {
        arr = new int[30000];
        top = -1; 
    }
    
    public void push(int val) {
        top++; 
        arr[top] = val; 
    }
    
    public void pop() {
        if(top == -1) return; 
        top--;
    }
    
    public int top() {
        return arr[top]; 
    }
    
    public int getMin() {
        int min = arr[0]; 
        for(int i = 1; i <= top; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min; 
    }
}
