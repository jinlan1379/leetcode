import java.util.HashMap;
import java.util.Map;

//至少有K个重复字符的最长子串
public class Solution395 {
    public int longestSubstring(String s, int k) {
        Map<String,Integer> c = new HashMap<String,Integer>();
        Map<String,Integer> rs = new HashMap<String,Integer>();
        for(int i=0; i<s.length(); i++){
            String ch = String.valueOf(s.charAt(i));
            if(c.get(ch)!=null) c.put(ch, c.get(ch)+1);
            else c.put(ch, 1);

            if(c.get(ch).intValue()>=k) rs.put(ch,c.get(ch));
        }
        int r = 0;
        for (String key : rs.keySet()) r = r + rs.get(key);
        return r;
    }
}
