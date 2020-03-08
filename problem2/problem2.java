/**
 * Second problem in the Workiva interview prep
 * Given a matrix, print the matrix, rotate the matrix 90 degrees, and print again.
 */
class Matrix {

    private int[][] matrix = new int[4][4];

    /**
     * Constructor initializes the matrix to values given in the problem statement
     * Could be reconfigured to read in a file, receive strings, etc.
     */
    public Matrix() {
        // Set matrix values
        this.matrix[0][0] = 1;
        this.matrix[0][1] = 2;
        this.matrix[0][2] = 3;
        this.matrix[0][3] = 4;
        this.matrix[1][0] = 6; 
        this.matrix[1][1] = 2;
        this.matrix[1][2] = 7;
        this.matrix[1][3] = 8;
        this.matrix[2][0] = 2;
        this.matrix[2][1] = 2;
        this.matrix[2][2] = 1;
        this.matrix[2][3] = 9;
        this.matrix[3][0] = 0;
        this.matrix[3][1] = 5;
        this.matrix[3][2] = 2;
        this.matrix[3][3] = 7;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Prints the matrix
     * @param matrix
     */
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    /**
     * simple swap function
     * @param row   the current row of the matrix
     * @param a     integer representing the first position to be swapped
     * @param b     integer representing the second position to be swapped
     * @return      returns the row after values are swapped.
     */
    public int[] swap(int[] row, int a, int b) {
        int temp;
        
        temp = row[a];
        row[a] = row[b];
        row[b] = temp;

        return row;
    }

    /**
     * Recursively reverses the order of the given row
     * @param row   a single row in a square matrix
     * @param posA  initially stores the 0th position in the row
     * @param posB  initially stores the final position in the row
     * @return      returns the reversed row when base case is satisfied
     */
    public int[] reverseRow(int[] row, int posA, int posB) {
        // base case
        if (posA >= posB) {
            return row;
        } else {
            row = swap(row, posA, posB);
            return reverseRow(row, ++posA, --posB);
        }
    }

    /**
     * Rotates the given matrix 90 degrees to the right
     * @param matrix    The matrix to be rotated
     * @return          Returns the rotated matrix
     */
    public int[][] rotateMatrix(int[][] matrix) {
        int len = matrix.length;

        int[][] rotatedCopy = new int[len][len];
        // switch rows and columns
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rotatedCopy[i][j] = matrix[j][i];
            }
        }

        // reverse all rows to complete 90 degree rotation
        for (int k = 0; k < len; k++) {
            reverseRow(rotatedCopy[k], 0, len - 1);
        }
        
        return rotatedCopy;
    }

    /**
     * Main function
     */
    public static void main(String[] args) {
        Matrix matrixObj = new Matrix();
        int[][] matrix = matrixObj.getMatrix();

        matrixObj.printMatrix(matrix);

        matrix = matrixObj.rotateMatrix(matrix);
        matrixObj.printMatrix(matrix);
    }
}

