class FreqStack {
    Map<Integer, Stack<Integer>> freqMap; // <freq, stack of nums>
    Map<Integer, Integer> numFreq; // <num, freq>
    int maxFreq=0;
    
    public FreqStack() {
        freqMap=new HashMap<Integer, Stack<Integer>>();    
        numFreq = new HashMap<Integer, Integer>();
    }

    
    public void push(int val) {
        int freq = numFreq.getOrDefault(val, 0) + 1;
        freqMap.putIfAbsent(freq, new Stack<>()); 
        freqMap.get(freq).push(val); 
        numFreq.put(val, freq); 
        maxFreq = Math.max(maxFreq, freq); 
    }
    
    public int pop() {
        Stack<Integer> stack = freqMap.get(maxFreq); 
        int res = stack.pop(); 
        numFreq.put(res, maxFreq-1); 
        if(stack.isEmpty())
            maxFreq--;
        return res; 
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */