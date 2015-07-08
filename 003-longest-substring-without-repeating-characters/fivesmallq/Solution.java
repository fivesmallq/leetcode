import java.util.Hashtable;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuffer str = new StringBuffer(s);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            int index = sb.indexOf(c.toString());
            if (index == -1) {
                sb.append(c);
                max = Math.max(max, sb.length());
            } else {
                int lastIndex = 0;
                lastIndex = str.indexOf(c.toString());
                if(lastIndex==0){
                    lastIndex=1;
                }
                if(c.equals(sb.charAt(sb.length()-1))){
                    str=new StringBuffer(str.substring(i));
                }else{
                    str=new StringBuffer(str.substring(lastIndex));
                }
                i = -1;
                sb = new StringBuffer();
            }
        }
        return max;
    }

}