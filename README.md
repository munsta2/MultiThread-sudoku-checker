# MultiThread-sudoku-checker

Student name: Jesse Karwaski	
Student#: 0382722

This implmentation uses 9 Threads to check if the solution is valid or not
and is writeen in java

"class threeByThree" is to check each three by three square and see if it's valid
"validRow" is to check each row and see if it's valid
"validCol" is to check each row and see if it's valid

To use this program follow thsese steps.

open command terminal and navigate to the project folder

in command terminal compile the java file
-javac sudokuChecker.java

once compiled run the file

-java sudokuChecker

output will be printed to the terminal.



to check and see differen't solution I have provided addtional board configurations below to test

INVALIDE BOARD:
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 },
{ 5, 5, 5, 5, 5, 5, 5, 5, 5 }

VALID BOARD:
{7, 9, 2, 1, 5, 4, 3, 8, 6}, 
{6, 4, 3, 8, 2, 7, 1, 5, 9},
{8, 5, 1, 3, 9, 6, 7, 2, 4},
{2, 6, 5, 9, 7, 3, 8, 4, 1},
{4, 8, 9, 5, 6, 1, 2, 7, 3},
{3, 1, 7, 4, 8, 2, 9, 6, 5},
{1, 3, 6, 7, 4, 8, 5, 9, 2},
{9, 7, 4, 2, 1, 5, 6, 3, 8},
{5, 2, 8, 6, 3, 9, 4, 1, 7}

past one of these boards into the code to test. Or use your own solution 