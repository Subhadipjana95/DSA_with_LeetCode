class Solution {
    int getPivot(int[] arr){
        int n = arr.length;
        int low =0;
        int high = n-1;
        int pivot=-1;
        // If starting element < ending element = the array is already sorted, no pivot element here
        if(arr[0] < arr[n-1]){
            return -1;
        }

        // If Array not sorted - let's find the Pivot
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= arr[n-1]){ // Mid landed on S2 slope(The slope starts after Pivot)
                high = mid-1;
            }
            else{                    // Mid landed on S1 slope(The slope before Pivot)
                pivot = mid; // Then store the probable pivot(current mid)
                // If the current mid is not pivot
                low = mid+1; 
            }
        }
        return pivot;
    }

    int binarySearch(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = getPivot(nums);

        if(pivot == -1){ // Array is already sorted, no need for considering pivot. Just do normal binary search 
            int ans = binarySearch(nums, 0, n-1, target);
            return ans;
        }
        
        // Start & End of S1 slope
        int s1Start = 0;
        int s1End = pivot;

        // Start & End of S2 slope
        int s2Start = pivot+1;
        int s2End = n-1;

        if(target >= nums[s1Start] && target <= nums[s1End]){ // If target is within S1 part do binary search on S1 part
            int ans = binarySearch(nums, s1Start, s1End, target);
            return ans;
        }

        if(target >= nums[s2Start] && target <= nums[s2End]){ // If target is within S2 part do binary search on S2 part
            int ans = binarySearch(nums, s2Start, s2End, target);
            return ans;
        }

        // If target not found after all that = target is not present in the array
        return -1; 
    }
}