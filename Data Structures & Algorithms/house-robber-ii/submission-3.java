class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        int num1[] = new int[n-1];
        int num2[] = new int[n-1];

        if(n==1) return nums[0];
        for(int i=1; i<n; i++){
            num1[i-1] = nums[i];
        } 
        for(int i=0; i<n-1; i++){
            num2[i] = nums[i];
        }

        int first = supp(num1, n-2, dp1);
        int last = supp(num2, n-2, dp2);
        return Math.max(first, last);
    }
    public int supp(int[] nums, int n, int[] dp){
        if(n<0) return 0;

        if(dp[n]!=-1) return dp[n];

        int pick = nums[n]+supp(nums, n-2, dp);
        int notpick= 0+supp(nums, n-1, dp);

        return dp[n]=Math.max(pick, notpick);
    }
}
