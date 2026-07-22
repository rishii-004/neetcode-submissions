class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {

            // skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++;
                    right--;

                    // skip duplicates for second number
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // skip duplicates for third number
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    // need a bigger sum
                    left++;

                } else {
                    // need a smaller sum
                    right--;
                }
            }
        }

        return ans;
    }
}

/*
sort the array 
*/





