public class Sudoku {

    private  int[][] board;

    //constructor
    public Sudoku (int[][] board) {
        this.board = board;
    }

    //get board
    public int[][] getBoard() {
        return board;
    }


    //solve method helper
    public void solve() {
        solve(0,0);
    }

    //solves the next position and returns true if it is possible
    private boolean nextPos(int row, int col) {

        if (col < 8) {
            return solve(row, col + 1);
        } else {
            return solve(row + 1, 0);
        }
    }

    //solves the sudoku
    private boolean solve(int row, int col) {

        //base case
        if(row > 8) {
            return true;
        }

        //checks for already existing numbers
        if(board[row][col] != 0) {
            if(check(row, col, board[row][col])) {
                return nextPos(row, col);
            }
        }

        //checks each number from 1 to 9
        for(int i = 1; i < 10; i++) {

            if(check(row, col, i)) {

                board[row][col] = i;
                if(nextPos(row, col)) {
                    return true;
                }
            }

            //clears the previous positions
            board[row][col] = 0;
        }

        return false;
    }

    //checks for each scenario
    public boolean check(int row, int col, int x) {

        //checks for rows and  column
        for(int i = 0; i < board.length; i++) {
            if(i != row && board[i][col] == x) {
                return false;
            }

            if(i != col && board[row][i] == x) {
                return false;
            }
        }


        int squareRow = (row/3) * 3;
        int squareCol = (col/3) * 3;


        //checks for 3x3
        for(int i = squareRow; i < squareRow+3; i++) {
            for(int j = squareCol; j < squareCol+3; j++) {
                if((j != col || i != row) && board[i][j] == x) {
                    return false;
                }
            }
        }

        return true;
    }



    //prints the board
    public void print() {
        for(int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++)
                System.out.print(board[r][c] + " ");
            System.out.println();
        }
    }


}
