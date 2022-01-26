import java.util.Arrays;

class threeByThree implements Runnable {

    int[] validArray;

    public threeByThree(int[] validArray) {
        this.validArray = validArray;
    }

    public void run(){

        System.out.println("x");
        validArray[0] = 100;
    }

}

class validRow implements Runnable {

    //
    int[] validArray;
    int[][] board;

    //@constructor 
    public validRow(int[] validArray, int[][]board) {
        this.validArray = validArray;
        this.board = board;
    }

    public void run(){
        boolean[] uniqueElements = new boolean[board.length + 1];
        for(int i = 0; i <  board.length; i++) {
            
            Arrays.fill(uniqueElements, false);

            for(int j = 0; j < board.length; j++) {

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
 
     //@constructor 
     public validCol(int[] validArray, int[][]board) {
         this.validArray = validArray;
         this.board = board;
     }

    public void run(){

        boolean[] uniqueElements = new boolean[board.length + 1];
        for(int i = 0; i <  board.length; i++) {
            
            Arrays.fill(uniqueElements, false);

            for(int j = 0; j < board.length; j++) {

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

        int[] validArray = new int[11];
        int[][] board ={
            {7, 9, 2, 1, 5, 4, 3, 8, 6}, 
            {6, 4, 3, 8, 2, 7, 1, 5, 9},
            {8, 5, 1, 3, 9, 6, 7, 2, 4},
            {2, 6, 5, 9, 7, 3, 8, 4, 1},
            {4, 8, 9, 5, 6, 1, 2, 7, 3},
            {3, 1, 7, 4, 8, 2, 9, 6, 5},
            {1, 3, 6, 7, 4, 8, 5, 9, 2},
            {9, 7, 4, 2, 1, 5, 6, 3, 8},
            {5, 2, 8, 6, 3, 9, 4, 1, 2}
        }; 
            
        printBoard(board);

        validRow x2 = new validRow(validArray, board);
        Thread t2 = new Thread(x2);

        validCol x = new validCol(validArray, board);
        Thread t = new Thread(x);

        t.start();
        t2.start();

        t.join();
        t2.join();

        for(int i=0; i< validArray.length; i++) {
            System.out.print(validArray[i] + " ");
        }
    }












    public static void printBoard(int[][] board) {
        for(int i = 0; i < board.length; i++){
            if(i%3 == 0) {
                System.out.println("----------------------");
            }
            for(int j = 0; j < board[0].length; j++){
                if(j%3 == 0) {
                    System.out.print("|");
                }
                System.out.print(board[i][j] + " ");
                if(j ==  board[0].length-1 )
                    System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }


}
