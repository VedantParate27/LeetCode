class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int count=0;

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                count++;
                dec = Math.max(dec, count+1);
            }
            else count = 0;
        }

        count = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                count++;
                inc = Math.max(inc, count+1);
            }
            else count = 0;
        }

        return Math.max(dec, inc);
    }
}