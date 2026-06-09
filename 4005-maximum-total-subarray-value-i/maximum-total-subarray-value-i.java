class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = Arrays.stream(nums).max().getAsInt();
        long min = Arrays.stream(nums).min().getAsInt();
        long value = max - min;

        return k * value;
    }
}