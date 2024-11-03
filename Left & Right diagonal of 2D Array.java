
public class DiagonalSum {
    
    // Function to calculate the left diagonal sum
    public static int leftDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    // Function to calculate the right diagonal sum
    public static int rightDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - i - 1];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        // Define a square matrix
        int[][] matrix = {
            {22,33,44},
            {55,66,77},
            {88,99,11},
            
        };
        
        // Calculate and print the left and right diagonal sums
        int leftSum = leftDiagonalSum(matrix);
        int rightSum = rightDiagonalSum(matrix);
        
        System.out.println("Left Diagonal Sum: " + leftSum);
        System.out.println("Right Diagonal Sum: " + rightSum);
    }
}









