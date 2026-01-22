class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().isEmpty()){
            return 0;
        }
        String[] result = s.trim().split("\\s+");
        int n = result.length;
        
        return result[n - 1].length();
    }
}