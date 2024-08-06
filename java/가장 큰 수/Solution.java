import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str ,(s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        
        if(sb.charAt(0) == '0'){
            return "0";
        }
        
        return sb.toString();
    }
}