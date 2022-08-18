// Time Complexity : O(N)
// Where N is number of houses
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Bruteforce approach would be exploring all possibilities, at each level we would have two options to
include the house and add the amount exclude next index or ignore current index and jump to next index.
At each level we have two options, so the time complexity would be O(2 power n) where n is number of houses.
If we look it these possibilities, there would be few repeatitions, which we can avoid recomputation by
storing tha result in a datastructure. Here we are solving this problem using top bottom approach.
Where we are constructing the from smallest index to largest. The time complexity for this solution
would O(N). Intially, we would have fill the entire 1D array with the data, then we can figure out the
logic behind how the table is filled. We need to store the maximum value at each index. To get the maximum
value, we would take maximum value of dp[i-2]+nums[i-1] or dp[i-1]
 */

class Solution {
    public int rob(int[] nums) {
        // return helper(nums, 0, 0, -1);
        return helper(nums);
    }

//     public int helper(int[] nums, int amount, int index, int max){
//         if(index>=nums.length){
//             return Math.max(amount, max);
//         }

//         return Math.max(helper(nums, amount+nums[index], index+2, max),
//                        helper(nums, amount, index+1, max));
//     }

    public int helper(int[] nums){
        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        for(int i=1;i<nums.length+1;i++){
            if(i<2){
                dp[i] = nums[i-1];
            }
            else{
                dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
            }
        }

        return dp[nums.length];
    }


}