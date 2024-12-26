class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        // If the target is not achievable or (sum + target) is negative or odd, return 0
        if (target > sum || (sum + target) < 0 || (sum + target) % 2 == 1) {
            return 0;
        }
        
        // Subset sum problem: find subsets that sum to (sum + target) / 2
        int s = (sum + target) / 2;
        return countSubsets(nums, s);
    }
    
    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to achieve a sum of 0 (by picking no elements)
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}
