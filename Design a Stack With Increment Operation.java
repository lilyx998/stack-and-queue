class CustomStack {
    int n;
    Stack<Integer> stack;
    int[] inc; //stores the increments
    
    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new Stack<>();
        inc = new int[n];
    }
    
    public void push(int x) {
        if(stack.size()<n) stack.push(x);
    }
    
    public int pop() {
        if(stack.size()==0) return -1;
        int i = stack.size()-1;         
        if(i>0) inc[i-1]+=inc[i];
        int res = stack.pop()+inc[i];
        inc[i]=0;
        return res; 
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, stack.size())-1;
        if(k>=0) inc[k]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */