class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int low1 = nums[nums.length-1] - nums[2];
        int low2 = nums[nums.length-2] - nums[1];
        int low3 = nums[nums.length-3] - nums[0];

        return Math.min(low1, Math.min(low3, low2));
    }
}