class Solution {
  public String removeDuplicateLetters(String s) {
    int[] freqs = new int[26]; 
    char[] chs = s.toCharArray(); 
    for(char c : chs)
      freqs[c-'a']++;
    
    boolean[] vis = new boolean[26]; // is char already in stack?
    Stack<Character> stack = new Stack<>(); 
    for(char c : chs){
      int idx = c-'a'; 
      freqs[idx]--; // freqs[i] = how many of char i left to be analyzed 
      if(vis[idx])
        continue; 
      
      // c is lexicographically smaller than [stack char], and there are more of [stack char] to be processed later
      while(!stack.isEmpty() && c < stack.peek() && freqs[stack.peek()-'a'] != 0)
        vis[stack.pop()-'a'] = false; 
      
      stack.push(c); 
      vis[idx] = true; 
    }
    
    StringBuilder sb = new StringBuilder(); 
    while(!stack.isEmpty())
      sb.insert(0, stack.pop()); 
    return sb.toString(); 
  }
}