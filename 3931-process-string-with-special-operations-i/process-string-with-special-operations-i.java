class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for(char c: s.toCharArray()){
            if(result.length() > 0 && c == '*'){
                result.deleteCharAt(result.length() -1);
            }
            if(c == '#'){
                result.append(result);
            }
            if(c == '%'){
                result = result.reverse();
            }
            if(c != '*' && c != '#' && c != '%'){
                result.append(c);
            }
        }
        return result.toString();
    }
}