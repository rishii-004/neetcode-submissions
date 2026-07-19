class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            // calculate the x 
            int x = target - nums[i];
            // check if map has it
            if(map.containsKey(x)){
                return new int[]{map.get(x), i};
            }
            // push it 
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

/*
    first 

*/
