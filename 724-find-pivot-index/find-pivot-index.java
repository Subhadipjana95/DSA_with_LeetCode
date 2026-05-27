class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        // Filling LeftSum Array elements
        leftSum[0] = nums[0];
        for(int i=1; i<n; i++){
            leftSum[i] = leftSum[i-1] + nums[i];
        }

        // Filling rightSum Array elements
        rightSum[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            rightSum[i] = rightSum[i+1] + nums[i];
        }

        // Find the Pivot in nums array
        for(int i=0; i<n; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }

        return -1;
    }
}