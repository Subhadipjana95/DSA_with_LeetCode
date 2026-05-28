class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0][0];

        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int[][] result = new int[totalCols][totalRows];

        for(int i=0; i<totalRows; i++){
            for(int j=0; j<totalCols; j++){
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}