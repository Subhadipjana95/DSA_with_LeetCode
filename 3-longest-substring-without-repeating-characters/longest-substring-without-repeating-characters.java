class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128]; // ASCII characters
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c]++;

            while (freq[c] > 1) {
                freq[s.charAt(left)]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
