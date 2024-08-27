class Solution {
    public long solution(long w, long h) {
        return w * h - (w + h - gcd(w , h));
    }
    public long gcd(long n , long m) {
        while (m != 0L) {
            long temp = m;
            m = n % m;
            n = temp;
        }
        return n;
    }
}