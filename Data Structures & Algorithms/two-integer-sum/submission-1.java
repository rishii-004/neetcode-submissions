class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < n; i++){
            int x = target - nums[i];
            if(map.containsKey(x) && map.get(x) != i){
                return new int[]{i, map.get(x)};
            }
        }
        return new int[]{-1, -1};
    }
}


/*
    store all the elts with indices
    calculate the complement, and find it in the map 
    if found return a new arr 
    if not return [-1, -1]



*/