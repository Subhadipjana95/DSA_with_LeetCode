class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        
        int start = 1;
        int end = x;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == x/mid) { // To avoid integer value outOfBound exception use (mid = x/mid) instead of (mid*mid = x)
                return mid;
            } else if (mid > x/mid) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}