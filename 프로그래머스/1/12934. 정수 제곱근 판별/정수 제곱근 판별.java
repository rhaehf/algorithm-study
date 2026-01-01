class Solution {
    public long solution(long n) {
        double result = Math.sqrt(n);
        long test = (long) result;
        
        if (test * test == n)
            return (test + 1) * (test + 1);
        else
            return -1;
    }
}
