#include <iostream>

/**
 * Using intention-revealing names to make the code more clean and readable.
 */

// Bad example
int d; // elapsed time in days
// The example above is not clear and it's hard to understand the purpose of the variable.

// Good example
int elapsedTimeInDays;
// The example above is clear and it's easy to understand the purpose of the variable and also its measurement unit.

// Another example in action

int a; // Bad example of variable name for the height of a rectangle

int heightOfRectangle; // Bood example of the variable name for the height of a rectangle

int[] getThem() // Bad example of function name
{
    int[] list1;
    for (int x = 0; x < theList.size(); x++)
    {
        if (theList[x] == 4)
        {
            list1.add(x);
        }
    }
    return list1;
}

int[] getFlaggedCells() // Good example of function name
{
    int[] flaggedCells;
    for (int cell = 0; cell < gameBoard.size(); cell++)
    {
        if (cell == FLAGGED)
        {
            flaggedCells.add(cell);
        }
    }
    return flaggedCells;
} 