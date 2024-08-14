import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Long> firstQueue = new LinkedList<>();
        Queue<Long> secondQueue = new LinkedList<>();
        Long first = 0L;
        Long second = 0L;
        Long sum = 0L;
        for (int i : queue1) {
            first += i;
            sum += i;
            firstQueue.offer((long) i);
        }
        for (int i : queue2) {
            second += i;
            sum += i;
            secondQueue.offer((long) i);
        }
        
        if (sum % 2L == 1L) return -1;
        if (first.equals(second)) return 0;
        
        sum /= 2;
        
        while (true) {
            if (first > sum) {
                first -= firstQueue.peek();
                second += firstQueue.peek();
                secondQueue.add(firstQueue.poll());
            } else if(second > sum) {
                second -= secondQueue.peek();
                first += secondQueue.peek();
                firstQueue.add(secondQueue.poll());
            }
            
            answer++;
            if (first.equals(second)) {
                break;
            }
            
            if (answer > 1000000) return -1;
        }
        
        return answer;
    }
}