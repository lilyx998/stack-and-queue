class MyCircularQueue {
    int[] q;
    int start, end, size; 
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q=new int[k];
        start = -1; 
        end = -1; 
        size = k; 
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            start = 0; 
        }
        end = (end+1)%size; 
        q[end]=value;
        return true; 
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(start==end){
            start = -1; 
            end = -1; 
            return true;
        }
        start++;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty())
            return q[start];
        return -1; 
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty())
            return q[end];
        return -1; 
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return start==-1;        
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (end+1)%size == start;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */