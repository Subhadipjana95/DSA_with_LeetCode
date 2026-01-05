class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        for(String s: strs){
            if(s.length() == 0){
                return "";
            }
        }
        if(strs.length == 1){
            return strs[0];
        }
        else{

            String compare = strs[0];

            for(int i = 1; i < strs.length; i++){
                String s = strs[i];
                int j = 0;
                for(; j < Math.min(s.length(), compare.length()); j++){
                    if(s.charAt(j) != compare.charAt(j)){
                        break;
                    }
                }
                compare = compare.substring(0, j);
            }
            return compare;
        }
    }
}