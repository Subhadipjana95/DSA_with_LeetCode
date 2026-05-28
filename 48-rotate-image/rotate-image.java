class Solution {
    public void rotate(int[][] matrix) {
        int N =  matrix.length;

        //Getting the transpose of the given matrix
        for(int i=0; i<N; i++){
            //Swap the diagonal positions
            for(int j=i+1; j<N; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse the elements of row
        for(int row=0; row<N; row++){
            int start = 0;
            int end = N-1;
            while(start<=end){
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;

                start++;
                end--;
            }
        }
    }
}