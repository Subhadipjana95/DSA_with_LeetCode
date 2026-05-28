class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0;
        int endRow = m-1;
        int startCol = 0;
        int endCol = n-1;

        List<Integer> output = new ArrayList<>();

        while(startRow <= endRow && startCol <= endCol){
            // Traverse Row-wise from startCol to endCol
            for(int col=startCol; col<=endCol; col++){
                output.add(matrix[startRow][col]);
            }
            startRow++;

            // Traverse Col-wise from startRow to endRow
            for(int row=startRow; row<=endRow; row++){
                output.add(matrix[row][endCol]);
            }
            endCol--;

            // Check if there exist more than one Row or not
            if(startRow <= endRow){
                // Traverse Row-wise from endCol to startCol
                for(int col=endCol; col>=startCol; col--){
                    output.add(matrix[endRow][col]);
                }
                endRow--;
            }

            // Check if there exist more than one Col or not
            if(startCol <= endCol){
                // Traverse Col-wise from endRow to startRow
                for(int row=endRow; row>=startRow; row--){
                    output.add(matrix[row][startCol]);
                }
                startCol++;
            }
        }

        return output;
    }
}