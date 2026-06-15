class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;

        while(readIndex < chars.length){
            char currChar = chars[readIndex];
            int count = 0;

            while(readIndex < chars.length && currChar == chars[readIndex]){
                readIndex++;
                count++;
            }

            chars[writeIndex] = currChar;
            writeIndex++;
            if(count >1){
                String countSTR = String.valueOf(count);
                for(char val: countSTR.toCharArray()){
                    chars[writeIndex] = val;
                    writeIndex++;
                }
            }
        }

        return writeIndex;
    }
}