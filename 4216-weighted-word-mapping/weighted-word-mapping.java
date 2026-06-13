class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int w = words.length;
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<w; i++){
            int weight = 0;
            for(int j=0; j<words[i].length(); j++){
                char currChar = words[i].charAt(j);
                int currWeight = (int)(currChar - 'a');
                weight += weights[currWeight];
            }
           int reverseIndex = 25 - weight %26;
           ans.append((char)(reverseIndex + 'a'));
        }
        return ans.toString();
    }
}