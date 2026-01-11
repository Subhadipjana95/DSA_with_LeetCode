class Solution {
    public int romanToInt(String s) {
        int result = 0;

        for(int i=0; i<s.length(); i++){
            int curr = value(s.charAt(i));
            int next = 0;

            if(i+1<s.length()){
                next = value(s.charAt(i+1));
            }

            if(curr<next){
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
        else if(c == 'V') return 5;
        else if(c == 'X') return 10;
        else if(c == 'L') return 50;
        else if(c == 'C') return 100;
        else if(c == 'D') return 500;
        else{
            return 1000;
        }
    }
}