class Solution {
    public String solution(String s) {
        String answer = "";
        // 이 문제의 핵심 : 공백문자가 연속해서 나올 수 있음
        
        s = s.toLowerCase();
        
        String[] divide = s.split(" ");
        
        String last = divide[divide.length - 1].charAt(divide[divide.length - 1].length() - 1) + "";
        String space = s.substring(s.lastIndexOf(last) + 1);
        
        for (int i = 0; i < divide.length; i++) {
            if (divide[i].length() > 0) {
                answer += divide[i].substring(0, 1).toUpperCase() + divide[i].substring(1);
                if (i < divide.length - 1) {
                    answer+=" ";
                }
            } else {
                answer += " ";
            }
        }
        return answer + space;
    }
}