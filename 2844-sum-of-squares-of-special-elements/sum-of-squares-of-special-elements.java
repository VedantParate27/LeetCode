class Solution {
    public int sumOfSquares(int[] nums) {
        int score=0;

        for(int i=0; i<nums.length; i++){
            if(nums.length%(i+1) == 0)
                score += nums[i]*nums[i];
        }

        return score;
    }
}