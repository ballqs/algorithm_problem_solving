class Solution
{
    public int solution(int n, int a, int b)
    {
        int game_cnt = 1;
        while (true) {
            if (Math.abs(a - b) == 1) {
                if (a > b && a % 2 == 0 || a < b && b % 2 == 0) {
                    break;
                }
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            game_cnt++;
        }
        return game_cnt;
    }
}