class Solution {
    public void moveZeroes(int[] nums) {
        int [] copy = new int[nums.length];
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                copy[k++] = nums[i];
            else continue;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0)
                copy[k++] = 0;
            else continue;
        }

        for(int i=0; i<nums.length; i++){
            nums[i] = copy[i];
        }
    }
}