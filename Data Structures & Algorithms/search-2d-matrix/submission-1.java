class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length; 
        int columns = matrix[0].length; 
        int positions = rows * columns; 
        int left = 0; 
        int right = positions -1; 
        while(left <= right){
            int m = left + (right - left)/2; 
            int row = m / columns; 
            int col = m % columns; 

            if(matrix[row][col] == target){
                return true; 
            }
            else if (matrix[row][col] > target){
                right = m - 1; 
            }
            else if(matrix[row][col] < target){
                left = m + 1; 
            }
        }
        return false; 

    }
}
