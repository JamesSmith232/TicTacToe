/** 
Allows two users to play a game of TicTacToe against eachother 
    
Author: James Hunter Smith
Email: jsmith1863@kctcs.edu
Last changed: November 8, 2018
**/

import java.util.Scanner; 

public class TicTacToe {
    
    static Scanner keyboard = new Scanner(System.in);
    
    //constants for game options
    static final int GAME = 0; 
    static final int QUIT = -1; 
    
    //constants for the number of rows and columns in a standard TicTacToe grid
    static final int GRID_ROWS = 3; 
    static final int GRID_COLUMNS = 3; 
    
    //two-dimensional array to represent a TicTacToe grid
    static char[][] grid = new char[GRID_ROWS][GRID_COLUMNS];
    
    //variable to keep a running count of the players' turns 
    static int playCount; 
    static boolean isOtherTurn; 
    
    public static void main(String[] args) {
        int userChoice = QUIT; 
        boolean done = false; 
        
        displayBanner(); 
        
        do {
            displayMenu(); 
            userChoice = getUserChoice(); 
            
            switch (userChoice) {
                case GAME: 
                    runGame(); 
                    break; 
                case QUIT: 
                    done = true; 
                    break; 
                default: 
                    System.out.println("Wrong choice, please enter 0 or 1"); 
            }
        } while(!done); 
    }
    
    static void displayBanner() {
        System.out.println("\n********************************************");
        System.out.println("Welcome to the Tic Tac Toe!"); 
        System.out.println("Let's play!!!");
        System.out.println("********************************************"); 
    } //end of displayBanner()
    
    static void displayMenu() {
    System.out.println("\nPress:");
    System.out.println("\t" + GAME + "\tTo play a standard Tic Tac Toe game\n");
    System.out.println("\t" + QUIT + "\tTo exit|n");
    } //end of displayMenu()
    
    static void runGame() {
        int position = QUIT; 
        char playerChar = 'X'; 
        boolean isGameOver = false; 
        
        playCount = 0; 
        fillPositions(); 
        
        System.out.println("Choose a posistion to play.\n"); 
        displayGrid(); 
        
        do {
            System.out.println(); 
            System.out.print("Player " + playerChar + " (Enter a position or " + QUIT + " to resign): ");
            position = keyboard.nextInt(); 
            
            play(position, playerChar); 
            displayGrid();
            
            if (isWin()) {
                System.out.print("\nPlayer " + playerChar + " WINS!!!\n");
                isGameOver = true; 
            } else if (isTie()) {
                System.out.print("\nTIE.\n");
                isGameOver = true; 
            } else {
                //switch players because game is not over
                if (playerChar == 'X') playerChar = 'O'; 
                else playerChar = 'X';
            }
        } while(!isGameOver && position != QUIT);
    } //end of runStandardGame method
    
    static void play(int position, char playerChar) {
        //if the player wants to play 'X' in position 7, this 
        //means the 'X' must go into row 2, column 0 of the array
        int row = 0; 
        int column = 0; 
    
        if (position > 0 && position <= (GRID_ROWS * GRID_COLUMNS)) {
            row = (position - 1) / GRID_ROWS; 
            column = (position - 1) % GRID_COLUMNS;
            grid[row][column] = playerChar;    
            playCount++; 
        }
    } //end of play method
    
    static boolean isWin() {
        boolean isWin = false;
        final int MINIMUM_WIN = 5; 
        
        if (playCount >= MINIMUM_WIN) {
            if (isRowWin() || isColumnWin() || isDiagonalWin()) isWin = true; 
        }
        
        return isWin; 
    } //end of isWin() method
    
    static boolean isTie() {
        boolean isTie = false; 
        final int MINIMUM_TIE = 8; 
        
        if (playCount >= MINIMUM_TIE) {
            if (isRowTie() || isColumnTie() || isDiagonalTie()) isTie = true;     
        } 
        
        return isTie; 
    } //end of isTie() method
    
    static boolean isRowWin() {
        boolean isRowWin = false; 
        int column = 0; 
        
        for (int row = 0; row < GRID_ROWS && !isRowWin; row++) {
            //checks to see if one of the rows is a win 
            if (grid[row][column] == grid[row][column + 1] && grid[row][column + 1] == grid[row][column + 2]) isRowWin = true; 
        }
        
        return isRowWin; 
    } //end of isRowWin() method
    
    static boolean isRowTie() {
    boolean isRowTie = false; 
    int column = 0; 
    
    for (int row = 0; row < GRID_ROWS && !isRowTie; row++) {
        //checks to see if one of the rows is a tie
            if (grid[row][column] != grid[row][column + 1] || grid[row][column + 1] != grid[row][column + 2]) isRowTie = true;
    }
    
    return isRowTie; 
    } //end of isRowTie() method
    
    static boolean isColumnWin() {
        boolean isColumnWin = false; 
        int row = 0; 
        
        for (int column = 0; column < GRID_COLUMNS && !isColumnWin; column++) {
            if (grid[row][column] == grid[row + 1][column] && grid[row + 1][column] == grid[row + 2][column]) isColumnWin = true; 
        }
        
        return isColumnWin; 
    } //end of isColumnWin() method
    
    static boolean isColumnTie() {
        boolean isColumnTie = false; 
        int row = 0; 
        
        for (int column = 0; column < GRID_COLUMNS && !isColumnTie; column++) {
            if (grid[row][column] != grid[row + 1][column] || grid[row + 1][column] != grid[row + 2][column]) isColumnTie = true; 
        }
        
        return isColumnTie; 
    } //end of isColumnTie() method
    
    static boolean isDiagonalWin() {
        boolean isDiagonalWin = false; 
        int row = 0; 
        int column = 0; 
        
        //checks to see if diagonal top left --> bottom right is a win
        if (grid[row][column] == grid[row + 1][column + 1] && grid[row + 1][column + 1] == grid[row + 2][column + 2]) isDiagonalWin = true; 
        //checks to see if diagonal bottom left --> top right is a win    
        if (grid[row][column + 2] == grid[row + 1][column + 1] && grid[row + 1][column + 1] == grid[row + 2][column]) isDiagonalWin = true; 
        
        return isDiagonalWin; 
    } //end of isRowWin() method
    
    static boolean isDiagonalTie() {
        boolean isDiagonalTie = false; 
        int row = 0; 
        int column = 0; 
        
        //checks to see if diagonal top left --> bottom right is a tie
        if (grid[row][column] != grid[row + 1][column + 1] || grid[row + 1][column + 1] != grid[row + 2][column + 2]) isDiagonalTie = true; 
        //checks to see if diagonal top left --> bottom right is a tie
        if (grid[row][column + 2] != grid[row + 1][column + 1] || grid[row + 1][column + 1] != grid[row + 2][column]) isDiagonalTie = true; 
        
        return isDiagonalTie; 
    } //end of isDiagonalTie() method
    
    static int getUserChoice() {        
        System.out.print("Please enter your choice: "); 
        int choice = keyboard.nextInt(); 
        
        return choice; 
    } //end of getUserChoice() method
    
    static void fillPositions() {
        char position = '1';
        
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int column = 0; column < GRID_COLUMNS; column++) {
            grid[row][column] = position; 
            position++; 
            }
        }
    } //end of fillPositions() method

    static void displayGrid() {
        for (int rows = 0; rows < GRID_ROWS; rows++) { 
            for (int columns = 0; columns < GRID_COLUMNS; columns++) {
            System.out.print(" " + grid[rows][columns] + " ");
            if (columns != 2) System.out.print("|");
            else System.out.println();
            }
                
            if (rows != 2) System.out.println("-----------");
        }
    } //end of displayGrid() method
    
} //end of class



















