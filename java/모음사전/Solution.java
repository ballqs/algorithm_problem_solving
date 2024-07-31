import java.util.*;
class Solution {
    final int max = 5;
    final String[] gather = new String[]{"A", "E", "I", "O", "U"};
    final Map<String , Integer> as = new HashMap<>();
    
    public int solution(String word) {
        return dfs("A" , 1 , word);
    }
    
    public int dfs(String str , int num , String word) {
        if (str.equals(word)) {
            return num;
        }
        
        int result = 0;
        int len = str.length();
        as.put(str , num);
        
        if (!str.equals("UUUUU")) {
            if (str.length() < max) {
                result = dfs(str + "A" , num + 1 , word);
            } else {
                String last = str.charAt(len - 1) + "";
                
                if (!last.equals("U")) {
                    String next = nextStr(last);
                    result = dfs(str.substring(0 , len - 1) + next , num + 1 , word);
                } else {
                    int idx = 0;
                    for (int i = 4; i >= 0; i--) {
                        if (!(str.charAt(i) + "").equals("U")) {
                            idx = i;
                            break;
                        }
                    }
                    result = dfs(str.substring(0 , idx) + nextStr(str.charAt(idx) + "") , num + 1 , word);
                }
            }
        }
        
        return result;
    }
    public String nextStr(String s) {
        return gather[Arrays.asList(gather).indexOf(s) + 1];
    }
}