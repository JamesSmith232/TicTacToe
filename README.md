<h1 align="center">TicTacToe</h1>

## Description
Allows two users to play eachtoher in a game of Tic Tac Toe  

This program has sixteen different methods: main, displayBanner, displayMenu, runGame, play, isWin, isTie, (isRowWin, isColumnWin, 
isDiagonalWin), (isRowTie, isColumnTie, isDiagonalTie), getUserChoice, fillPositions, and displayGrid.
 - **_main:_** runs the game with a do-while loop with a switch case inside. Allows the user to decide if they want to play, or quit. 
 - **_displayBanner, displayMenu:_** displays to the user the description and options of the program  
- **_runGame:_** It calls the fillsPosition() and displayGrid() to fill and display the cells in the grid. The do-while loop allows the 
user to choose his position and check if the user has won or tied. If there is no tie or winner, the playerChar variable gets switched to 
the different user. This loop will keep going until one of the users has won, or they tied. 
- **_play:_** takes the position and the user who made that selection as parameters. The position is used to find the correct location 
on the board. This is done by using the '/' operator to assign the row varaible and the '%' operator to assign the column variable. Those
two varaibles are then used as indexes in the array, which gives the correct spot on the board. 
- **_isWin:_** returns true or false boolean after calling each of the win methods (row, column, diagonal) in an if statment and 
seeing if any are true. 
- **_isTie:_** does the same as the isWin() method but checks to see if any of the tie methods are true
- **_isRowWin, isColumnWin, isDiagonalWin:_** these three methods check to see if there was a win. The way they do this is by checking 
the array and the two spots in there respective group. For example the isRowWin() method returns true if the array locations of grid[0][0], 
grid[1][0], and grid[2][0] are the same characters. 
- **_isRowTiw, isColumnTie, isDiagonalTie:_** is similar to the win methods but returns true if the array locations of grid[0][0], 
grid[1][0], and grid[2][0] do not match each other. 
- **_getUserChoice:_** method to get the user's choice to help with code redundancy in the program
- **_fillPositions:_** uses a for loop to fill each of the positions with its respective number. This will be 1-9.
- **_displayGrid:_** displays the Tic Tac Toe board that the users will be playing on. A for loop goes through the array and prints 
them in the correct locations while also printing the lines that make it look like an actualy Tic Tac Toe board. 

## Outcome
<p align="center">
  <img src="https://user-images.githubusercontent.com/80684500/170770232-6630561a-57c6-4490-ac63-0fc00cff203c.JPG" alt="Sublime's custom image"/>
</p>

## Projects
|  Num  | Project                                                                                                 | Author                                            |
| ----- | ------------------------------------------------------------------------------------------------------- | --------------------------------------------------|
|   1   | [Bookstore](https://github.com/JamesSmith232/BookStore)                                                 | [James Smith](https://github.com/JamesSmith232)   |
|   2   | [FizzBuzz](https://github.com/JamesSmith232/FizzBuzz)                                                   | [James Smith](https://github.com/JamesSmith232)   |
|   3   | [RockPaperScissors](https://github.com/JamesSmith232/RockPaperScissors)                                 | [James Smith](https://github.com/JamesSmith232)   |
|   4   | [Grader](https://github.com/JamesSmith232/Grader)                                                       | [James Smith](https://github.com/JamesSmith232)   |
|   5   | [StoreManager](https://github.com/JamesSmith232/StoreManager)                                           | [James Smith](https://github.com/JamesSmith232)   |
|   6   | [TicTacToe](https://github.com/JamesSmith232/TicTacToe)                                                 | [James Smith](https://github.com/JamesSmith232)   |

