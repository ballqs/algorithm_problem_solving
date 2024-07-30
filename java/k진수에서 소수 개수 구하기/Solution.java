import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = binaryConversion(n , k);
        for (String num : arr) {
            if (num.length() != 0 && Long.parseLong(num) > 1) {
                if (discriminator(Long.parseLong(num))) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean discriminator(long n) {
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public String[] binaryConversion(int n, int k) {
        List<Integer> arr = new ArrayList<Integer>();
        while (n != 0) {
            arr.add(n % k);
            n = n / k;
        }
        Collections.reverse(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
        }
        return sb.toString().split("0");
    }
}