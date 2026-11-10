
class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(n == 3) return 2;

        int n1 = 1;
        int n2 = 1;
        int n3 = 2;
        int curr = 0;

        for(int i = 4; i <= n; i++) {
            curr = n1 + n2 + n3;

            n1 = n2;
            n2 = n3;
            n3 = curr;
        }

        return curr;
    }
}
