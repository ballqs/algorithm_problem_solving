import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 진행중인게 있더라도 우선순위가 더 높은 프로세스가 있다면 다시 큐에 집어 넣고 우선순위가 높은걸 꺼냄
        // 만약 그렇지 않다면 프로세스를 실행하여 종료(큐에 다시 넣지 않음)
        
        // 큐 선언 및 프로세스 담기 작업
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }
        
        // 큐 반복문
        while (!queue.isEmpty()) {
            // 큐에 존재하는 우선순위 최대값 알아내기
            int priority = Collections.max(queue);   
            // 꺼내기
            int now = queue.poll();
            
            // 최대값과 비교 작업
            if (now < priority) {
                // 큐 맨뒤에 넣기
                queue.add(now);
                // location가 0인 경우 맨 뒤로 넣음으로써 큐의 길이만큼 재할당
                if (location == 0) {
                    location = queue.size();
                }
            } else {
                // 최대값과 같다는 것을 의미(실행 후 종료)
                answer++;
                // location가 0인 경우 내가 얻고자 하는 프로세스가 종료됨을 알림
                if (location == 0) {
                    break;
                }
            }
            // 로직이 끝날때마다 location가 감소
            location--;
        }
        
        return answer;
    }
}