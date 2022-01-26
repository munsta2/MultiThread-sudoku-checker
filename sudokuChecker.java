import java.util.Arrays;

class threeByThree implements Runnable {

    int[] validArray;
    int[][] board;
    int index;
    int row;
    int col;

    // @constructor
    public threeByThree(int[] validArray, int[][] board, int index, int row, int col) {
        this.validArray = validArray;
        this.board = board;
        this.index = index;
        this.row = row;
        this.col = col;
    }

    public void run() {

        boolean[] uniqueElements = new boolean[board.length + 1];
        Arrays.fill(uniqueElements, false);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {

                int Element = board[i][j];
                // check to see if elemente is a dublicate or is not a valid number in sudoku
                if (Element > 9 || Element < 1 || uniqueElements[Element]) {
                    validArray[index] = -1;
                    return;
                }
                uniqueElements[Element] = true;
            }
        }
    }
}

class validRow implements Runnable {

    int[] validArray;
    int[][] board;
    int index;

    // @constructor
    public validRow(int[] validArray, int[][] board, int index) {
        this.validArray = validArray;
        this.board = board;
        this.index = index;

    }

    public void run() {
        boolean[] uniqueElements = new boolean[board.length + 1];
        for (int i = 0; i < board.length; i++) {

            Arrays.fill(uniqueElements, false);

            for (int j = 0; j < board.length; j++) {

                int Element = board[i][j];

                // check to see if elemente is a dublicate or is not a valid number in sudoku
                if (Element > 9 || Element < 1 || uniqueElements[Element]) {
                    validArray[1] = -1;
                    return;
                }
                uniqueElements[Element] = true;
            }
        }
    }
}

class validCol implements Runnable {

    //
    int[] validArray;
    int[][] board;
    int index;

    // @constructor
    public validCol(int[] validArray, int[][] board, int index) {
        this.validArray = validArray;
        this.board = board;
        this.index = index;
    }

    public void run() {

        boolean[] uniqueElements = new boolean[board.length + 1];
        for (int i = 0; i < board.length; i++) {

            Arrays.fill(uniqueElements, false);

            for (int j = 0; j < board.length; j++) {

                int Element = board[j][i];

                // check to see if elemente is a dublicate or is not a valid number in sudoku
                if (Element > 9 || Element < 1 || uniqueElements[Element]) {
                    validArray[0] = -1;
                    return;
                }
                uniqueElements[Element] = true;
            }

        }

    }
}

public class sudokuChecker {
    public static void main(String[] args) throws InterruptedException {

        // Array to keep track of threads and their outputs
        int[] validArray = new int[11];
        // Sudoku board
        int[][] board = {
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 }
        };

        printBoard(board);

        // Thread to check the rows
        validRow x2 = new validRow(validArray, board, 0);
        Thread t1 = new Thread(x2);

        // thread to check the columns
        validCol x = new validCol(validArray, board, 1);
        Thread t2 = new Thread(x);

        // intializing array to hold threads to check 3x3 blocks
        threeByThree[] arrThreeByThrees = new threeByThree[9];
        Thread[] arrThread = new Thread[9];
        int row;
        int col = 0;

        // Starting Threads for each 3x3 block
        for (int i = 0; i < arrThreeByThrees.length; i++, col += 3) {
            if (col > 6)
                col = 0;
            if (i < 3)
                row = 0;
            else if (i >= 3 && i < 6)
                row = 3;
            else
                row = 6;

            arrThreeByThrees[i] = new threeByThree(validArray, board, i + 2, row, col);
            arrThread[i] = new Thread(arrThreeByThrees[i]);
            arrThread[i].start();

        }

        // Starting other threads
        t1.start();
        t2.start();

        // Wating for all threads to finish
        for (int i = 0; i < arrThread.length; i++)
            arrThread[i].join();

        t1.join();
        t2.join();

        // finally check if solution is valid or not
        checkSolution(validArray);

    }

    public static void checkSolution(int[] validArray) {
        for (int i = 0; i < validArray.length; i++) {
            if (validArray[i] == -1) {
                System.out.println("Invalid Solution!");
                return;
            }
        }
        System.out.println("valid Solution!");
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0) {
                System.out.println("----------------------");
            }
            for (int j = 0; j < board[0].length; j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j] + " ");
                if (j == board[0].length - 1)
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

}
