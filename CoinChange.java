// Time Complexity : O(N*M)
// Where N is number of denominations and M is amount
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Bruteforce approach would be exploring all possibilities, at each level we would have two options to
include the coin and remove the coin from the amount or exclude that coin and move to next denomination.
At each level we have two options, so the time complexity would be O(2 power n) where n is amount. If we look
it these possibilities, there would be few repeatitions, which we can avoid recomputation by storing tha result
in a datastructure. Here we are solving this problem using top bottom approach. Where we are constructing the
from smallest index to largest. The time complexity for this solution would O(N*M). Intially, we would have fill
the entire 2D array with the data, then we can figure out the logic behind how the table is filled. We need to
store the minimum value at each index. To get the minimum value, we would take minimum value of previous coin
and same coin with coins step back.
 */


class Solution {
    public int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0 ) return  -1;
        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;

        for(int j=1;j<n+1;j++){
            dp[0][j] = amount + 1;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
                }
            }
        }

        if(dp[m][n] > amount) return -1;

        return dp[m][n];
    }
}
