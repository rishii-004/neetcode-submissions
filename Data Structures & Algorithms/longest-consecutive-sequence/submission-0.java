class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxCount = 0;

        for (int num : set) {

            // Start only if num is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}


// add all the elements into a hashset, the values in the set will lie between min and max 
// run a loop from min to max to find the sequence, if found then update the count and maxcount 

// to reduce time we will have to traverse the elements in the set itself, for each element we will see if there is num-1 present if yes then go till the smallest 
// start searching if num + 1 present and update count and maxcount 