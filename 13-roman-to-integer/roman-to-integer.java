class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for(int i=0; i<s.length(); i++){
            int curr = value(s.charAt(i));
            int next = 0;

            if(i+1<s.length() && curr<value(s.charAt(i+1))){
                result -= curr;
            }
            else{
                result += curr;
            }
        }
        return result;
    }

    private int value(char c){
        if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
    }
}