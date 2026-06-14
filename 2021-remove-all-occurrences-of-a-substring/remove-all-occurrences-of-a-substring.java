class Solution {
    public String removeOccurrences(String s, String part) {
        if(s.length() < part.length()){
            return s;
        }
        
        while(s.contains(part)){
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length(), s.length());
        }
        return s;
    }
}