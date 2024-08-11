import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> assistance = new Stack<>();
        
        int number = 1;
        int idx = 0;
        
        while (true) {
            if (number <= order.length) {
                if (!assistance.isEmpty()) {
                    if (assistance.peek() == order[idx]) {
                        assistance.pop();
                        answer++;
                        idx++;
                    }
                }
                if (number == order[idx]) {
                    answer++;
                    idx++;
                } else {
                    assistance.add(number);
                }
                number++;
            } else {
                if (!assistance.isEmpty()) {
                    if (assistance.peek() == order[idx]) {
                        assistance.pop();
                        answer++;
                        idx++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return answer;
    }
}