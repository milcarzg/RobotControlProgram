# RobotControlProgram
simple project for interview purposes

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------

ORIGINAL TASK

ROBOT CONTROL PROGRAM

You are tasked with creating the guidance program for a robot. The robot is very simple, it can walk around a room arranged as a grid of places. The input will be two numbers which tell the robot how big the room is.

  5 7

means 5 columns and 7 rows of places.

After the size of the room the robot guidance program should input two numbers and a letter, to indicate the starting position as a column and row number, and the compass orientation of the robot (North, South, East, West). Example:

  3 3 N

means that the robot should be in column 3 and row 3, and point to the north. 

Once positioned, the robot should be able to receive a number of navigation commands, in the form of letters. There are only three commands, L (turn left), R (turn right) and F (move 1 step forward).

E￼xample:  LFFRFRFRFF

After the last command is received, the robot should report its current location and direction.

Example:

5 5
1 2 N 
RFRFFRFRF 
Robot reports: 1 3 N

5 5
0 0 E
RFLFFLRF
Robot reports: 3 1 E

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------

CHANGES

From the description one can read that first input should create a grid created of X columns and Y rows
input 5 7 - means 5 columns and 7 rows
Next input sets the origin of the robot
input 3 3 - means column 3 and row 3

Taking that into account second example could not be executed since there is no row 0 nad column 0
To unify the program couple of decisions was made:
- origin of the robot can not be smaller than 1 1

- description does say "After the size of the room the robot guidance program should input two numbers and a letter" that sentance is not clear:
    - should the program input random origin position?
- to unify the program user is asked to input origin position of the robot

- there was no description of how to handle user trying to walk into the wall of the room
    - robot acts like the move is not possible to make and counts "wall walk" attempts to display at the end 

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------

HOW TO

1. You can download the source code and import the program to eclipse. 
    - Pressing Run() will start the program in Eclipse console
    
2.  You can choose to download only the precompiled robot.jar file.
    - start Terminal
    - find the robot.jar file
    - execute 'java -jar robot.jar'
    - Program will start in Terminal and ask for input

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------

EXAMPLES:

1.

  Enter size of the room :  (X Y format)

  5 5 

  Enter start point and orientation :  (X Y Z format)

  1 2 N

  Enter movements :  (XYZ format)

  RFRFFRFRF

  1 3 N

2.

  Enter size of the room :  (X Y format)  
  
  5 5 
  
  Enter start point and orientation :  (X Y Z format) 
 
  0 0 E 
 
  Origin position has to be between 1 1 and 5 5 
  
  Enter start point and orientation :  (X Y Z format) 
  
  1 1 E 
  
  Enter movements :  (XYZ format) 
  
  RFLFFLRF  
  
  4 2 E 
  
--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------

TESTS

There are couple of tests created to verify that core methods are working correctly
Test passed 9/9

To run tests import project into Eclipse and run Tests.java class as jUnit Test.



