class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = nums[i];
                nums[i] = temp;

                lastNonZeroIndex++;
            }
        }
    }
}