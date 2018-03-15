
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SudokuExample {
    public static void main(String[] args) throws MalformedURLException {



        //World's hardest sudoku
        int[][] board = {
                {8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0},
        };

        Sudoku test = new Sudoku(board);

        test.solve();
        test.print();


        //Project Euler Problem 96
        URL file = new URL("https://projecteuler.net/project/resources/p096_sudoku.txt");
        int sum = 0;

        //whole text file
        String s = "";

        try {
            Scanner scanner = new Scanner(file.openStream());


            while(scanner.hasNextLine()) {

                s += scanner.nextLine() + "\n";


            }

        } catch (IOException e) {
            System.out.println(e);
        }

        //Array of lines of the text
        String[] lines = s.split(System.getProperty("line.separator"));

        //Goes over each line
        for(int i = 0; i < lines.length; i++) {

            int[][] sudoku96 = new int[9][9];

            //If line is not a title, stores it in a 2D array
            if(lines[i].contains("Grid")) {
                for(int r = 0; r < sudoku96.length; r++) {
                    for(int c = 0; c < sudoku96[r].length; c++) {

                        sudoku96[r][c] = Character.getNumericValue(lines[i+ r + 1].charAt(c));


                    }
                }

                //Sudoku class
                Sudoku sudokuSolver = new Sudoku(sudoku96);
                sudokuSolver.solve();
                sudoku96 = sudokuSolver.getBoard();
                String digits = sudoku96[0][0] + "" + sudoku96[0][1] + "" + sudoku96[0][2];
                sum += Integer.parseInt(digits);

            }



        }

        System.out.println();
        System.out.println(sum);

    }
}
