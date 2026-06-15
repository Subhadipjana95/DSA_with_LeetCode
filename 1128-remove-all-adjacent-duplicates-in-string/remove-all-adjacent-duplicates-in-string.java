class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();

        for(char currChar: s.toCharArray()){
            if(ans.length() > 0 && currChar == ans.charAt(ans.length() - 1)){
                ans.deleteCharAt(ans.length() - 1);
            }
            else{
                ans.append(currChar);
            }
        }
        return ans.toString();
    }
}