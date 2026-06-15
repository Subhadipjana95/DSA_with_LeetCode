class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
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