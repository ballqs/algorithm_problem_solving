import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        // 요일
        String yoil[] = {"MON","TUE","WED","THU","FRI","SAT","SUN"};

        // 1. LocalDate 생성
        LocalDate ymd = LocalDate.of(2016, a, b);
        // 2. DayOfWeek 객체 구하기
        DayOfWeek yoil_str = ymd.getDayOfWeek();
        // 3. 숫자 요일 구하기
        int yoil_val = yoil_str.getValue();
        
        answer = yoil[yoil_val - 1];
        
        return answer;
    }
}