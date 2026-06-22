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
        int count1 = Math.min(b_Count, a_Count);
        int count2 = Math.min(l_Count/2, o_Count/2);
        int count3 = Math.min(count1, count2);
        int count = Math.min(count3, n_Count);
        return count;

    }
}