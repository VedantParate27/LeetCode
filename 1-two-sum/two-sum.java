class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer>freq = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int req = target - nums[i];
            if(freq.containsKey(req)){
                return new int[] {freq.get(req), i };
            }
            freq.put(nums[i], i);
        }
        return new int [] {};   
    }
}