class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid has landed on ascending slope?
            if (arr[mid] < arr[mid + 1]) {
                // Move the low after mid
                low = mid + 1;
            } else {
                // Condition: arr[mid] >= arr[mid+1]
                // Mid has landed on the descending slope...
                // Store the possible peak index to ans
                ans = mid;
                //  Move the low before mid 
                high = mid - 1;
            }
        }
        return ans;
    }
}