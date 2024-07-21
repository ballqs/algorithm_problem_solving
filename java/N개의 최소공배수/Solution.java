import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        // 주어진 arr에 중복으로 주어진 숫자 제거 작업
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : arr) {
            if (!list.contains(n)) {
                list.add(n);
            }
        }
        
        // 모든 숫자의 소인수분해를 통해 숫자별 최대 카운트값 담는 변수
        // 예) [2 , 8 , 14] 로 주어졌을때
        //     2  => 2^1
        //     8  => 2^3
        //     14 => 2 * 7
        //  2라는 숫자에 한해서는 ^3 이 가장 높음
        Map<Integer , Integer> calc = new HashMap<>();
        
        for (int i = 0; i < list.size(); i++) {
            int idx = list.get(i);
            
            // 소인수분해한 숫자 저장 변수
            ArrayList<Integer> store = new ArrayList<>();
            int n = 2;
            while (true) {
                if (idx % n == 0) {
                    idx /= n;
                    store.add(n);
                } else {
                    n++;
                }
                if (idx / n == 0) {
                    break;
                }
            }
            
            // 숫자별 최대 카운트
            Set<Integer> int_set = new HashSet<Integer>(store);
            for (int number : int_set) {
                int cnt = Collections.frequency(store, number);
                if (calc.containsKey(number)) {
                    if (cnt > calc.get(number)) {
                        calc.replace(number , cnt);
                    }
                } else {
                    calc.put(number , cnt);
                }
            }
        }
        
        // 구한 값을 기반으로 결과값 계산
        for (int number : calc.keySet()) {
            answer *= Math.pow(number,calc.get(number));
        }
        
        return answer;
    }
}