import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++)
        {
            // 직원 별 희망 출근 시간
            int desiredtime = schedules[i];
            // 시간 , 분을 추려내어 10분 더하기
            int hour = desiredtime / 100;
            int minute = desiredtime % 100 + 10;
            
            // 10분 추가 했을 시 60분을 넘길 경우
            if (minute >= 60)
            {
                minute -= 60;
                hour++;
            }
            // 출근 희망시간 재설정
            desiredtime = hour * 100 + minute;
            
            // 이벤트 당첨 여부
            boolean flag = true;
            
            for (int j = 0 , k = 0; j < 7; j++)
            {
                // 시작날짜 - 1 + 더하는 값에 7를 나머지 값 구하여 + 1 처리
                int n = (startday - 1 + k++) % 7 + 1;
                if ( n == 6 || n == 7 ) continue; // 토요일 , 일요일 SKIP
                if( desiredtime < timelogs[i][j] ) // 출근 희망 시간보다 더 늦게 기록이 찍힌 경우
                {
                    flag = false;
                    break;
                }
            }
            
            // 이벤트 당첨된 경우 결과값 증가
            if (flag) answer++;
        }
        
        return answer;
    }
}