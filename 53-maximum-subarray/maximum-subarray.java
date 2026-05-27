class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++){
            // Step 1: Update the sum with array elements
            sum += nums[i];

            // Step 2: Update the maxSum value from sum
            maxSum = Math.max(maxSum, sum);

            // Step 3: Check is the sum is -ve or not.
            if(sum < 0){
                sum = 0;
            }
        }

        return maxSum;
    }
}