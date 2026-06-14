class Solution {
    static boolean freqMatch(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        // S1 Frequency Table
        for (int i = 0; i < s1.length(); i++) {
            char curr = s1.charAt(i);
            int charIndex = curr - 'a';
            s1Freq[charIndex]++;
        }

        int[] s2Freq = new int[26];
        int windowLength = s1.length();
        // First Window Frequency Table
        for (int i = 0; i < windowLength; i++) {
            char curr = s2.charAt(i);
            int charIndex = curr - 'a';
            s2Freq[charIndex]++;
        }

        int j = windowLength;
        if (freqMatch(s1Freq, s2Freq)) {
            return true;
        } else {
            while (j < s2.length()) {
                // Increase next character freqency after current window
                char currChar = s2.charAt(j);
                int currIndex = currChar - 'a';
                s2Freq[currIndex]++;

                // Decrease the previous character frequency just before the current window
                char prevChar = s2.charAt(j - windowLength);
                int prevIndex = prevChar - 'a';
                s2Freq[prevIndex]--;

                // Check if now the frequencies matches or not
                if (freqMatch(s1Freq, s2Freq)) {
                    return true;
                }

                j++;
            }
        }
        return false;
    }
}