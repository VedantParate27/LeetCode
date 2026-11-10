class Solution {
    public int fib(int n) {
        if(n==0)  return 0;
        if(n==1 || n==2)    return 1;
        int n1 = 1;
        int n2 = 1;
        int curr = 0;
        for(int i=3; i<=n; i++){
            curr = n1+n2;
            n2 = n1;
            n1 = curr;
        }

        return curr;
    }
}