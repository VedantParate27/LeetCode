class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count=0; 

        for(int i: nums)
            max = Math.max(max, i);

        for(int i: nums)
            count += max - i;
        
        return count;
    }
}