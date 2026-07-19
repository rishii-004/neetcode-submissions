class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] ans = new int[n];

        // calculate pref and suff 
        pref[0] = nums[0];
        suff[n-1] = nums[n-1];
        for(int i = 1; i < nums.length; i++){
            pref[i] = nums[i] * pref[i-1];
        }
        for(int i = n-2; i >= 0; i--){
            suff[i] = nums[i] * suff[i+1];
        }
        ans[0] = suff[1];
        ans[n-1] = pref[n-2];
        for(int i = 1; i < n-1; i++){
            ans[i] = pref[i-1] * suff[i+1];
        }
        return ans;
    }
}  


/*
[1, 2, 8, 48]
[48, 48, 24, 6]
[48, 24, 12, 8]

prefix prod and suff prod
for every elt we can do pref[i-1] * suff[i+1];
*/