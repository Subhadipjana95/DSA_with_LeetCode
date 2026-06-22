class Solution {
    public int maxNumberOfBalloons(String text) {
        int b_Count = 0;
        int a_Count = 0;
        int l_Count = 0;
        int o_Count = 0;
        int n_Count = 0;
        for(char c: text.toCharArray()){
            if(c == 'b') b_Count++;
            if(c == 'a') a_Count++;
            if(c == 'l') l_Count++;
            if(c == 'o') o_Count++;
            if(c == 'n') n_Count++;
        }
        
        return Math.min(Math.min(Math.min(b_Count, a_Count), Math.min(l_Count/2, o_Count/2)), n_Count);
    }
}