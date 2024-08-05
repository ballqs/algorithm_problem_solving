import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        char zero = '0';
        for (int i = 0; i < numbers.length; i++) {
            String str = Long.toBinaryString(numbers[i]);
            if (str.chars().anyMatch(cv -> cv == '0')) {
                char[] c = str.toCharArray();

                for (int j = c.length - 1; j >= 0; j--) {
                    if (c[j] == '0') {
                        c[j] = '1';
                        if (j + 1 < c.length) {
                            c[j + 1] = '0';
                        }
                        break;
                    }
                }
                str = new String(c);
            } else {
                str = "10" + str.substring(1);
            }
            answer[i] = Long.parseLong(str , 2);
        }
        return answer;
    }
}