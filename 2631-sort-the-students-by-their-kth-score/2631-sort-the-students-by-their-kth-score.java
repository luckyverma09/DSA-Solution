class Solution {
    public static void swap(int mat[][],int a, int b, int row1, int row2){
        int temp = mat[row1][a];
        mat[row1][a] = mat[row2][b];
        mat[row2][b] = temp;
    }
    public static void swapRow(int mat[][], int row1, int row2){
        for(int i =0 ; i< mat[0].length; i++){
            swap(mat, i, i, row1, row2);
        }
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        int j = 0;
        int n = score.length;
        
        while(j < n){

            int maxEleRow = j;
            int maxScore = score[j][k];

            for(int i = j + 1; i< n ; i++){
                if(score[i][k] > maxScore){
                    maxScore = score[i][k];
                    maxEleRow = i;
                }
            }
            swapRow(score, j, maxEleRow);
            j++;
        }
        return score;
    }
}