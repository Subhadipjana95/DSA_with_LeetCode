class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int w = words.length;
        StringBuilder ans = new StringBuilder();
        for (String s : words) {
            int weight = 0;
            for (int j = 0; j < s.length(); j++) {
                char currChar = s.charAt(j);
                int currWeight = (int) (currChar - 'a');
                weight += weights[currWeight];
            }
            int reverseIndex = 25 - weight % 26;
            ans.append((char) (reverseIndex + 'a'));
        }
        return ans.toString();
    }
}