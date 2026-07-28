class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];

        Arrays.fill(dp,-1);

        
        return supp(cost, n, dp);
        

    }

    public int supp(int[] cost, int n, int[] dp){
        if(n==0 || n==1) return 0;

        if(dp[n]!=-1) return dp[n];

        int step1 = supp(cost, n-1, dp) + cost[n-1];
        int step2 = supp(cost, n-2, dp) + cost[n-2];

        dp[n] = Math.min(step1, step2);
        return dp[n];
    }
}
