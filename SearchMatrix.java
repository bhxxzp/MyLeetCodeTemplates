package template;

// Leetcode 240
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        if (matrix[0] == null || matrix[0].length == 0) return false;
        // if (target == null || target.length == 0) return true;

        int col = matrix[0].length - 1;
        int row = 0;
        while(row < matrix.length && col >= 0) {
            int temp = matrix[row][col];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                col--;
            } else if (temp < target) {
                row++;
            }
        }
        return false;
    }
}
