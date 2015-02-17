public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max = 0;
        
        LinkedList<Character> section = new LinkedList<Character>();
        int length = s.length();
        int start = 0;
        int end = 0;
        while(start < length){
            
            int offset = -1;
            
            while(end < length) {
                Character c = s.charAt(end);
                offset = section.indexOf(c);
                if(offset != -1){
                    break;
                }
                section.add(c);
                end++;
            }
            
            if(max < end-start){
                max = end-start;
            }
            
            if(offset > -1){
                start += offset+1;
                while(offset-->=0){
                    section.poll();
                }
            }else{
                start++;
                section.poll();
            }
        }
        
        return max;
    }
}