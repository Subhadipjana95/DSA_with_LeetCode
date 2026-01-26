class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder CT = new StringBuilder();

        while(columnNumber > 0){
            columnNumber--;
            int rem = columnNumber % 26;
            CT.append((char)('A' + rem));
            columnNumber /=26;
        }

        return CT.reverse().toString();
    }
}