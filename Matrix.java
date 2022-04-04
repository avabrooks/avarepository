package src;


public class Matrix {
    private final int[][] matrix;

    // store matrix
    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

  // Hack: create toString method using nested for loops to format output of a matrix

    
    // toString method to format matrix
    public String toString() {
        StringBuilder output = new StringBuilder();
      //use for loop to iterate through rows
        for (int[] row : matrix) {
            // nested loop for columns 
            for (int cell : row) {
                output.append((cell==-1) ? " " : String.format("%d",cell)).append(" "); 
            }
        }
        return output.toString();
    }
  // print same matrix just backwards 
    public String reverse() {
        // start at the other side of the row 
        StringBuilder output = new StringBuilder();
        for (int i = matrix.length;  0 < i; i--) {
            // nested loop to start at other side
            for (int j =  matrix[i-1].length; 0 < j; j--) {
                output.append((matrix[i-1][j-1]==-1) ? " " : String.format("%x",matrix[i-1][j-1])).append(" ");
            }
        }
        return output.toString();
    }

    
  

    // declare and initialize a matrix for a keypad
    static int[][] keypad() {
        return new int[][]{ { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, {-1, 0, -1} };
    }

    // declare and initialize a random length arrays
    static int[][] numbers() {
        return new int[][]{ { 0, 1 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 } };
    }

    // tester method
    public static void main(String[] args) {
        Matrix m0 = new Matrix(keypad());
        System.out.println("Keypad:");
        System.out.println(m0);
        System.out.println(m0.reverse());


        Matrix m1 = new Matrix(numbers());
        System.out.println("Numbers Systems:");
        System.out.println(m1);
        System.out.println(m1.reverse());

    }

}
