class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp,-1);

        return supp(nums, n-1, dp);
        
    }
    public int supp(int[] nums, int n, int[] dp){
        if(n<0) return 0;

        if(dp[n]!=-1) return dp[n];
        
        int pick  = supp(nums, n-2, dp)+nums[n];
        int notpick = supp(nums, n-1, dp)+0;

        return dp[n] = Math.max(pick, notpick);
    }
}
