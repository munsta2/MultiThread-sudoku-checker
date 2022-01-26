class threeByThree implements Runnable {

    public void run(){

        System.out.println("x");
    }

}



public class sudokuChecker {
    public static void main(String[] args) {


        int[][] board = new int[9][9]; 
        
        printBoard(board);
        threeByThree x = new threeByThree();
        Thread t = new Thread(x);

        t.start();
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
