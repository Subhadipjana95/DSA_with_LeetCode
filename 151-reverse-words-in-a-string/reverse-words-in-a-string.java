class Solution {
    public String reverseWords(String s) {
        // Trim all the starting & ending trailing spaces
        s = s.trim();

        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;

        // Traverse from last to first  
        while (i >= 0) {
            // Check if 'i' has become less than 0
            if (i < 0)
                break;

            int j = i;
            // Move 'j' to the start index of the word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            // Append the word in ans
            ans.append(s.substring(j + 1, i + 1));

            // Clear all the trailing ' '(spaces) between two words
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            // Now append ' '(space) only if its not the first word
            if (j >= 0) { // Check 'j' has been not on the previous index the first index of first word
                ans.append(' ');
            }
            // Set the position of 'i' at 'j'th position 
            i = j;
        }

        return ans.toString();
    }
}