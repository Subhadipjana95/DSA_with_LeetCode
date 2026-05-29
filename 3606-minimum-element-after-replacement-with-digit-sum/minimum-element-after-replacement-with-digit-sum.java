class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int elementSum = 0;
            while (nums[i] > 0) {
                int digit = nums[i] % 10;
                elementSum += digit;
                nums[i] /= 10;
            }

            if (elementSum < min) {
                min = elementSum;
            }
        }
        return min;
    }
}