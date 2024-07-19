class Solution {
    public int[] solution(String s) {
        int zero_cnt = 0;
        int convert_cnt = 0;
        
        while (!s.equals("1")) {
            zero_cnt += s.length() - s.replace("0","").length();
            s = s.replace("0","");
            int s_len = s.length();
            String tmp = "";
            while (true) {
                tmp = (s_len % 2) + tmp;
                if (s_len / 2 == 0) break;
                s_len = s_len / 2;
            }
            s = tmp;
            convert_cnt++;
        }
        
        return new int[]{convert_cnt , zero_cnt};
    }
}