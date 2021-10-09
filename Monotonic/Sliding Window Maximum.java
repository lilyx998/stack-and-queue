class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deq = new ArrayDeque<>(); 
    int[] res = new int[nums.length - k + 1]; 
    for(int i = 0; i < nums.length; i++){
      if(!deq.isEmpty() && i-deq.peekFirst() == k)
        deq.pollFirst(); 
      while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i])
        deq.pollLast(); 
      deq.offerLast(i); 
      if(i >= k-1)
        res[i-k+1] = nums[deq.peekFirst()];
    }
    return res; 
  }
}