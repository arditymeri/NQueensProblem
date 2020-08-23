# N-Queens Problem

Here is a solution to the [N-Queens Problem](https://en.wikipedia.org/wiki/Eight_queens_puzzle) in Java.

## How to run

Start the `AppSolver` class as a Java application. Enter the board size 
Enter `-1` to exit. 

The application prints the total number of solutions, the first 5 solutions, and 5 other random ones. 
Queen positions are denoted with `X`, empty positions with `0`.
Here is an execution example:

```
N-Queens Problem Solver
Enter N:
15


	X 0 0 0 0 0 0 0 0 0 0 0 0 0 0 15
	0 0 X 0 0 0 0 0 0 0 0 0 0 0 0 14
	0 0 0 0 X 0 0 0 0 0 0 0 0 0 0 13
	0 X 0 0 0 0 0 0 0 0 0 0 0 0 0 12
	0 0 0 0 0 0 0 0 0 X 0 0 0 0 0 11
	0 0 0 0 0 0 0 0 0 0 0 X 0 0 0 10
	0 0 0 0 0 0 0 0 0 0 0 0 0 X 0 9
	0 0 0 X 0 0 0 0 0 0 0 0 0 0 0 8
	0 0 0 0 0 0 0 0 0 0 0 0 X 0 0 7
	0 0 0 0 0 0 0 0 X 0 0 0 0 0 0 6
	0 0 0 0 0 X 0 0 0 0 0 0 0 0 0 5
	0 0 0 0 0 0 0 0 0 0 0 0 0 0 X 4
	0 0 0 0 0 0 X 0 0 0 0 0 0 0 0 3
	0 0 0 0 0 0 0 0 0 0 X 0 0 0 0 2
	0 0 0 0 0 0 0 X 0 0 0 0 0 0 0 1
	a b c d e f g h i j k l m n o 
	================
```