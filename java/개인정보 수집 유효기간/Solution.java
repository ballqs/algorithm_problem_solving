import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 개인정보 n개
        // 모든 달은 28일 고정!
        // 약관 종류 A 6달 / B 12달 / C 3달
        // 파기해야할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return
        
        String[] today_str = today.split("[.]");    // 오늘날
        int[] now = new int[3];
        now[0] = Integer.parseInt(today_str[0]);    // 년
        now[1] = Integer.parseInt(today_str[1]);    // 월
        now[2] = Integer.parseInt(today_str[2]);    // 일
        
        // 약관 종류 정리
        Map<String , Integer> term_stand = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] arr = terms[i].split(" ");
            term_stand.put(arr[0] , Integer.parseInt(arr[1]));
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            String[] date_str = info[0].split("[.]");    // 수집일자
            
            int[] date = new int[3];
            date[0] = Integer.parseInt(date_str[0]);    // 년
            date[1] = Integer.parseInt(date_str[1]);    // 월
            date[2] = Integer.parseInt(date_str[2]);    // 일
            
            // 일 처리
            if (date[2] - 1 == 0) {
                date[2] = 28;
                date[1]--;
            } else {
                date[2]--;
            }
            
            // 월 처리
            int month = date[1] + term_stand.get(info[1]);
            if (month > 12) {
                date[1] = month % 12 == 0 ? 12 : month % 12;
                // 유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하
                date[0]+= month % 12 == 0 ? month / 12 - 1 : month / 12;
            } else {
                date[1] = month;
            }
            
            // 파기 정보 검증
            if (compare_date(now , date)) {
                result.add(i + 1);
            }
        }
        
        // 파기해야할 개인정보 오름차순으로 정렬
        Collections.sort(result);
        
        // answer에 담기
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    // 파기정보인지 날짜 비교
    public boolean compare_date(int[] now , int[] date) {
        boolean result = false;
        if (date[0] < now[0]) {
            result = true;
        } else if (date[0] == now[0]) {
            if (date[1] < now[1]) {
                result = true;
            } else if (date[1] == now[1]) {
                if (date[2] < now[2]) {
                    result = true;
                }
            }
        }
        return result;
    }
}