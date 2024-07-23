import java.util.*;
class Solution {
    public int solution(int[] elements) {
        // 연속 부분 수열의 합 중복을 제거하기 위한 Set
        Set<Integer> set = new HashSet<>();
        int number = 0;
        // number가 주어진 elements값보다 작을때!
        while (number < elements.length) {
            // idx + α 만큼 sum를 해야하기에 조건문에 + number
            for (int i = 0; i < elements.length + number; i++) {
                int sum = 0;
                // sum 하는 부분
                for (int j = 0; j <= number; j++) {
                    sum += elements[(i + j) % elements.length];
                }
                set.add(sum);
            }
            number++;
        }
        return set.size();
    }
}