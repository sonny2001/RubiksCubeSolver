package solver;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import solver.Movement;

public class Main {

    // *****print out the spreadsheet i sent (the net of the cube) and fold it.
    // it'll be more helpful. face 1 (front) towards you and face 4 (top) up

    public static int[][] cube = new int[6][9]; // the array that represents the cube (look at attached spreadsheet that
						// is in the net of the cube. print and fold)
    public static String[] solutionSteps = new String[10000000]; // string array that will hold the solution steps

    /*
     * for every [x][y] position in the array, - x represent faces (0=left side,
     * 1=front, 2=right side, 3=back side, 4=top, 5=bottom) - y represents spots on
     * that face (0=top left, 1=top middle, 2=top right, 3=middle left, 4=middle
     * middle, 5=middle right, 6=bottom right, 7=bottom middle, 8=bottom right) -
     * the values at that address is the color (the color that would be at the
     * corresponding x in this case: 0=orange, 1=green, 2=red, 3=blue,
     * 4=black,5=yellow
     */

    public static void populateCube() { // populates the original condition of
					// the unsolved cube

	Scanner input = new Scanner(System.in);

	System.out.println("enter the left/orange center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[0][y] = input.nextInt();
	}

	System.out.println("enter the front/green center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[1][y] = input.nextInt();
	}

	System.out.println("enter the right/red center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[2][y] = input.nextInt();
	}

	System.out.println("enter the back/blue center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[3][y] = input.nextInt();
	}

	System.out.println("enter the top/black center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[4][y] = input.nextInt();
	}

	System.out.println("enter the bottom/yellow center piece side");
	for (int y = 0; y < 9; y++) {
	    cube[5][y] = input.nextInt();
	}

	input.close();

    }

    public static void solveTopCross() { // master method for solving the top cross

	solveRight_TopEdge();
	solveFront_TopEdge();
	solveLeft_TopEdge();
	solveBack_TopEdge();

    }

    public static void solveRight_TopEdge() { // finds and solves the right-top edge or the black-red edge

	while (true) { // begin while loop

	    cube = Movement.returnCube();

	    if (cube[4][5] == 4 && cube[2][1] == 2) // if the edge if solved, break and end method
		break;

	    else if (cube[4][5] == 2 && cube[2][1] == 4) { // when the edge is in the correct spot but inverted
		Movement.rightBW();
		Movement.frontCW();
		Movement.bottomR();
		Movement.frontCCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[1][5] == 4 && cube[2][3] == 2) { // when the edge is at the front-right with black facing
							   // front
		Movement.rightFW();
	    }

	    else if (cube[1][5] == 2 && cube[2][3] == 4) { // when the edge is at the front-right with red facing front
		Movement.frontCW();
		Movement.bottomR();
		Movement.frontCCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[3][3] == 4 && cube[2][5] == 2) { // when the edge is at the back-right with black facing back
		Movement.rightBW();
	    }

	    else if (cube[3][3] == 2 && cube[2][5] == 4) { // when the edge is at the back-right with red facing back
		Movement.backCW();
		Movement.bottomL();
		Movement.backCCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[5][5] == 4 && cube[2][7] == 2) { // when the edge is at the bottom-right with black facing
							   // bottom
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[5][5] == 2 && cube[2][7] == 4) { // when the edge is at the bottom-right with red facing
							   // bottom
		Movement.rightFW();
		Movement.frontCW();
		Movement.bottomR();
		Movement.frontCCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[4][7] == 4 && cube[1][1] == 2) { // when the edge is at front-top with black facing top
		Movement.frontCW();
		Movement.frontCW();
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[4][7] == 2 && cube[1][1] == 4) { // when the edge is at front-top with red facing top
		Movement.frontCW();
		Movement.rightBW();
	    }

	    else if (cube[4][1] == 4 && cube[3][1] == 2) { // when the edge is at the back-top with black facing top
		Movement.backCW();
		Movement.backCW();
		Movement.bottomL();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[4][1] == 2 && cube[3][1] == 4) { // when the edge is at the back-top with red facing top
		Movement.backCW();
		Movement.rightBW();
	    }

	    else if (cube[5][1] == 4 && cube[1][7] == 2) { // when the edge is at the front-bottom with black facing
							   // bottom
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[5][1] == 2 && cube[1][7] == 4) { // when the edge is at the front-bottom with red facing
							   // bottom
		Movement.frontCCW();
		Movement.rightFW();
		Movement.frontCW();
	    }

	    else if (cube[5][7] == 4 && cube[3][7] == 2) { // when the edge is at the back-bottom with black facing
							   // bottom
		Movement.bottomL();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[5][7] == 2 && cube[3][7] == 4) { // when the edge is at the back-bottom with red facing bottom
		Movement.backCCW();
		Movement.rightBW();
		Movement.backCW();
	    }

	    else if (cube[4][3] == 4 && cube[0][1] == 2) { // when the edge is at the top-left with black facing top
		Movement.leftBW();
		Movement.leftBW();
		Movement.bottomR();
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[4][3] == 2 && cube[0][1] == 4) { // when the edge is at the top-left with red facing top
		Movement.leftBW();
		Movement.frontCCW();
		Movement.bottomR();
		Movement.frontCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][5] == 4 && cube[1][3] == 2) { // when the edge is at the front-left with red facing front
		Movement.frontCCW();
		Movement.bottomR();
		Movement.frontCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][5] == 2 && cube[1][3] == 4) { // when the edge is at the front-left with black facing front
		Movement.leftBW();
		Movement.bottomR();
		Movement.leftFW();
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][3] == 4 && cube[3][5] == 2) { // when the edge is at the back-left with red facing back
		Movement.backCCW();
		Movement.bottomL();
		Movement.backCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][3] == 2 && cube[3][5] == 4) { // when the edge is at the back-left with black facing back
		Movement.leftFW();
		Movement.bottomR();
		Movement.leftBW();
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][7] == 2 && cube[5][3] == 4) { // when the edge is at the bottom-left with black facing
							   // bottom
		Movement.bottomR();
		Movement.bottomR();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else if (cube[0][7] == 4 && cube[5][3] == 2) { // when the edge is at the bottom-left with red facing bottom
		Movement.bottomL();
		Movement.bottomL();
		Movement.rightFW();
		Movement.frontCW();
		Movement.bottomR();
		Movement.frontCCW();
		Movement.rightFW();
		Movement.rightFW();
	    }

	    else
		System.out.println("error");

	} // end while loop

    }

    public static void solveFront_TopEdge() { // fonds and solves the front-top edge or the black-green edge

	while (true) { // begin while loop

	    cube = Movement.returnCube();

	    if (cube[1][1] == 1 && cube[4][7] == 4) // if the edge if solved, break and end method
		break;

	    if (cube[1][1] == 4 && cube[4][7] == 1) { // when the edge is in the correct spot but inverted
		Movement.frontCCW();
		Movement.leftBW();
		Movement.bottomR();
		Movement.leftFW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[1][5] == 1 && cube[2][3] == 4) { // when the edge is at the front-right with green facing
							   // front
		Movement.frontCCW();
	    }

	    else if (cube[1][5] == 4 && cube[2][3] == 1) { // when the edge is at the front-right with black facing
							   // front
		Movement.rightBW();
		Movement.bottomL();
		Movement.rightFW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[3][3] == 4 && cube[2][5] == 1) { // when the edge is at the back-right with black facing back
		Movement.rightFW();
		Movement.bottomL();
		Movement.rightBW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[3][3] == 1 && cube[2][5] == 4) { // when the edge is at the back-right with green facing back
		Movement.backCW();
		Movement.bottomL();
		Movement.backCCW();
		Movement.bottomL();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[5][5] == 4 && cube[2][7] == 1) { // when the edge is at the bottom-right with black facing
							   // bottom
		Movement.bottomL();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[5][5] == 1 && cube[2][7] == 4) { // when the edge is at the bottom-right with green facing
							   // bottom
		Movement.rightFW();
		Movement.frontCCW();
		Movement.rightBW();
	    }

	    else if (cube[4][5] == 4 && cube[2][1] == 1) { // when the edge is at top-right with black facing top
		Movement.rightBW();
		Movement.rightBW();
		Movement.bottomL();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[4][5] == 1 && cube[2][1] == 4) { // when the edge is at top-right with green facing top
		Movement.rightBW();
		Movement.frontCCW();
		Movement.rightFW();
	    }

	    else if (cube[4][1] == 4 && cube[3][1] == 1) { // when the edge is at the back-top with black facing top
		Movement.backCW();
		Movement.backCW();
		Movement.bottomR();
		Movement.bottomR();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[4][1] == 1 && cube[3][1] == 4) { // when the edge is at the back-top with green facing top
		Movement.backCW();
		Movement.rightFW();
		Movement.bottomR();
		Movement.rightBW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[5][1] == 4 && cube[1][7] == 1) { // when the edge is at the front-bottom with black facing
							   // bottom
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[5][1] == 1 && cube[1][7] == 4) { // when the edge is at the front-bottom with green facing
							   // bottom
		Movement.bottomR();
		Movement.rightFW();
		Movement.frontCCW();
		Movement.rightBW();
	    }

	    else if (cube[5][7] == 4 && cube[3][7] == 1) { // when the edge is at the back-bottom with black facing
							   // bottom
		Movement.bottomL();
		Movement.bottomL();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[5][7] == 1 && cube[3][7] == 4) { // when the edge is at the back-bottom with green facing
							   // bottom
		Movement.backCCW();
		Movement.rightFW();
		Movement.backCW();
		Movement.bottomL();
		Movement.rightBW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[4][3] == 4 && cube[0][1] == 1) { // when the edge is at the top-left with black facing top
		Movement.leftBW();
		Movement.leftBW();
		Movement.bottomR();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[4][3] == 1 && cube[0][1] == 4) { // when the edge is at the top-left with green facing top
		Movement.leftBW();
		Movement.frontCW();
	    }

	    else if (cube[0][5] == 4 && cube[1][3] == 1) { // when the edge is at the front-left with green facing front
		Movement.frontCW();
	    }

	    else if (cube[0][5] == 1 && cube[1][3] == 4) { // when the edge is at the front-left with black facing front
		Movement.leftBW();
		Movement.bottomR();
		Movement.leftFW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[0][3] == 4 && cube[3][5] == 1) { // when the edge is at the back-left with green facing back
		Movement.backCCW();
		Movement.bottomL();
		Movement.backCW();
		Movement.bottomL();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[0][3] == 1 && cube[3][5] == 4) { // when the edge is at the back-left with black facing back
		Movement.leftFW();
		Movement.bottomR();
		Movement.leftBW();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[0][7] == 1 && cube[5][3] == 4) { // when the edge is at the bottom-left with black facing
							   // bottom
		Movement.bottomR();
		Movement.frontCW();
		Movement.frontCW();
	    }

	    else if (cube[0][7] == 4 && cube[5][3] == 1) { // when the edge is at the bottom-left with green facing
							   // bottom
		Movement.leftFW();
		Movement.frontCW();
		Movement.leftBW();
	    }

	    else
		System.out.println("error");

	} // end while loop
    }

    public static void solveLeft_TopEdge() { // finds and solves the left-top edge or the black-orange edge

	while (true) { // begin while loop

	    cube = Movement.returnCube();

	    if (cube[0][1] == 0 && cube[4][3] == 4) // if the edge if solved, break and end method
		break;

	    if (cube[0][1] == 4 && cube[4][3] == 0) { // when the edge is in the correct spot but inverted
		Movement.leftBW();
		Movement.frontCCW();
		Movement.bottomL();
		Movement.frontCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[1][5] == 0 && cube[2][3] == 4) { // when the edge is at the front-right with orange facing front
		Movement.frontCW();
		Movement.bottomL();
		Movement.frontCCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[1][5] == 4 && cube[2][3] == 0) { // when the edge is at the front-right with black facing front
		Movement.rightBW();
		Movement.bottomL();
		Movement.rightFW();
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[3][3] == 4 && cube[2][5] == 0) { // when the edge is at the back-right with black facing back
		Movement.rightFW();
		Movement.bottomL();
		Movement.rightBW();
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[3][3] == 0 && cube[2][5] == 4) { // when the edge is at the back-right with orange facing back
		Movement.backCW();
		Movement.bottomR();
		Movement.backCCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[5][5] == 4 && cube[2][7] == 0) { // when the edge is at the bottom-right with black facing bottom
		Movement.bottomL();
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[5][5] == 0 && cube[2][7] == 4) { // when the edge is at the bottom-right with orange facing bottom
		Movement.rightFW();
		Movement.frontCW();
		Movement.rightBW();
		Movement.bottomL();
		Movement.frontCCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[4][5] == 4 && cube[2][1] == 0) { // when the edge is at top-right with black facing top
		Movement.rightBW();
		Movement.rightBW();
		Movement.bottomL();
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[4][5] == 0 && cube[2][1] == 4) { // when the edge is at top-right with orange facing top
		Movement.rightBW();
		Movement.frontCW();
		Movement.bottomL();
		Movement.frontCCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[4][1] == 4 && cube[3][1] == 0) { // when the edge is at the back-top with black facing top
		Movement.backCW();
		Movement.backCW();
		Movement.bottomR();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[4][1] == 0 && cube[3][1] == 4) { // when the edge is at the back-top with orange facing top
		Movement.backCCW();
		Movement.leftBW();
	    }

	    else if (cube[5][1] == 4 && cube[1][7] == 0) { // when the edge is at the front-bottom with black facing bottom
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[5][1] == 0 && cube[1][7] == 4) { // when the edge is at the front-bottom with orange facing bottom
		Movement.frontCW();
		Movement.leftFW();
		Movement.frontCCW();
	    }

	    else if (cube[5][7] == 4 && cube[3][7] == 0) { // when the edge is at the back-bottom with black facing bottom
		Movement.bottomR();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[5][7] == 0 && cube[3][7] == 4) { // when the edge is at the back-bottom with orange facing bottom
		Movement.backCW();
		Movement.leftBW();
		Movement.backCCW();
	    }

	    else if (cube[4][7] == 4 && cube[1][1] == 0) { // when the edge is at the top-front with black facing top
		Movement.frontCW();
		Movement.frontCW();
		Movement.bottomL();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[4][7] == 0 && cube[1][1] == 4) { // when the edge is at the top-front with orange facing top
		Movement.frontCCW();
		Movement.leftFW();
	    }

	    else if (cube[0][5] == 4 && cube[1][3] == 0) { // when the edge is at the front-left with orange facing front
		Movement.frontCCW();
		Movement.bottomL();
		Movement.frontCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[0][5] == 0 && cube[1][3] == 4) { // when the edge is at the front-left with black facing front
		Movement.leftFW();
	    }

	    else if (cube[0][3] == 4 && cube[3][5] == 0) { // when the edge is at the back-left with orange facing back
		Movement.backCCW();
		Movement.bottomL();
		Movement.backCW();
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[0][3] == 0 && cube[3][5] == 4) { // when the edge is at the back-left with black facing back
		Movement.leftBW();
	    }

	    else if (cube[0][7] == 0 && cube[5][3] == 4) { // when the edge is at the bottom-left with black facing bottom
		Movement.leftFW();
		Movement.leftFW();
	    }

	    else if (cube[0][7] == 4 && cube[5][3] == 0) { // when the edge is at the bottom-left with orange facing bottom
		Movement.bottomR();
		Movement.frontCW();
		Movement.leftFW();
		Movement.frontCCW();
	    }

	    else
		System.out.println("error");

	} // end while loop
    }

    public static void solveBack_TopEdge() { // finds and solves the back-top edge or the black-blue edge

	while (true) { // begin while loop

	    cube = Movement.returnCube();

	    if (cube[4][1] == 4 && cube[3][1] == 3) // if the edge if solved, break and end method
		break;

	    if (cube[4][1] == 3 && cube[3][1] == 4) { // when the edge is in the correct spot but inverted
		Movement.backCCW();
		Movement.leftFW();
		Movement.bottomL();
		Movement.leftBW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[1][5] == 4 && cube[2][3] == 3) { // when the edge is at the front-right with black facing
							   // front
		Movement.rightBW();
		Movement.bottomR();
		Movement.rightFW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[1][5] == 3 && cube[2][3] == 4) { // when the edge is at the front-right with blue facing front
		Movement.frontCW();
		Movement.bottomR();
		Movement.frontCCW();
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[3][3] == 4 && cube[2][5] == 3) { // when the edge is at the back-right with black facing back
		Movement.rightFW();
		Movement.bottomR();
		Movement.rightBW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[3][3] == 3 && cube[2][5] == 4) { // when the edge is at the back-right with blue facing back
		Movement.backCCW();
	    }

	    else if (cube[5][5] == 4 && cube[2][7] == 3) { // when the edge is at the bottom-right with black facing
							   // bottom
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[5][5] == 3 && cube[2][7] == 4) { // when the edge is at the bottom-right with blue facing
							   // bottom
		Movement.rightBW();
		Movement.backCCW();
		Movement.rightFW();
	    }

	    else if (cube[4][7] == 4 && cube[1][1] == 3) { // when the edge is at front-top with black facing top
		Movement.frontCW();
		Movement.frontCW();
		Movement.bottomR();
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[4][7] == 3 && cube[1][1] == 4) { // when the edge is at front-top with blue facing top
		Movement.frontCW();
		Movement.rightBW();
		Movement.bottomR();
		Movement.rightFW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[4][5] == 4 && cube[2][1] == 3) { // when the edge is at the top-right with black facing top
		Movement.rightFW();
		Movement.rightFW();
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[4][5] == 3 && cube[2][1] == 4) { // when the edge is at the top-right with blue facing top
		Movement.rightFW();
		Movement.backCCW();
	    }

	    else if (cube[5][1] == 4 && cube[1][7] == 3) { // when the edge is at the front-bottom with black facing
							   // bottom
		Movement.bottomR();
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[5][1] == 3 && cube[1][7] == 4) { // when the edge is at the front-bottom with blue facing
							   // bottom
		Movement.bottomR();
		Movement.rightBW();
		Movement.backCCW();
		Movement.rightFW();
	    }

	    else if (cube[5][7] == 4 && cube[3][7] == 3) { // when the edge is at the back-bottom with black facing
							   // bottom
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[5][7] == 3 && cube[3][7] == 4) { // when the edge is at the back-bottom with blue facing
							   // bottom
		Movement.bottomL();
		Movement.rightBW();
		Movement.backCCW();
		Movement.rightFW();
	    }

	    else if (cube[4][3] == 4 && cube[0][1] == 3) { // when the edge is at the top-left with black facing top
		Movement.leftBW();
		Movement.leftBW();
		Movement.bottomL();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[4][3] == 3 && cube[0][1] == 4) { // when the edge is at the top-left with blue facing top
		Movement.leftFW();
		Movement.backCW();
	    }

	    else if (cube[0][5] == 4 && cube[1][3] == 3) { // when the edge is at the front-left with blue facing front
		Movement.frontCCW();
		Movement.bottomR();
		Movement.frontCW();
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[0][5] == 3 && cube[1][3] == 4) { // when the edge is at the front-left with black facing front
		Movement.leftBW();
		Movement.bottomR();
		Movement.leftFW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[0][3] == 4 && cube[3][5] == 3) { // when the edge is at the back-left with blue facing back
		Movement.backCW();
	    }

	    else if (cube[0][3] == 3 && cube[3][5] == 4) { // when the edge is at the back-left with black facing back
		Movement.leftFW();
		Movement.bottomR();
		Movement.leftBW();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[0][7] == 3 && cube[5][3] == 4) { // when the edge is at the bottom-left with black facing
							   // bottom
		Movement.bottomR();
		Movement.backCW();
		Movement.backCW();
	    }

	    else if (cube[0][7] == 4 && cube[5][3] == 3) { // when the edge is at the bottom-left with blue facing
							   // bottom
		Movement.leftBW();
		Movement.backCW();
		Movement.leftFW();
	    }

	    else
		System.out.println("error");

	} // end while loop
    }

    public static void solveTopCorner() { // master method for solving the top corners

	solveTop_Left_FrontCorner();
	solveTop_Right_FrontCorner();
	solveTop_Right_BackCorner();
	solveTop_Left_BackCorner();
	
    }

    public static void solveTop_Left_FrontCorner() { // solve the top-left-front corner or the black-orange-green

	cube = Movement.returnCube();

	if (cube[4][6] != 4 || cube[1][0] != 1 || cube[0][2] != 0) { // if the corner is not in the correct spot, else finish the method
	    
	    if (cube[4][6] == 4 || cube[1][0] == 4 || cube[0][2] == 4) // when the corner is positioned top-left-front
		if (cube[4][6] == 1 || cube[1][0] == 1 || cube[0][2] == 1)
		    if (cube[4][6] == 0 || cube[1][0] == 0 || cube[0][2] == 0) {

			Movement.leftBW();
			Movement.bottomR();
			Movement.leftFW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-front

	    if (cube[4][8] == 4 || cube[1][2] == 4 || cube[2][0] == 4) // when the corner is positioned top-right-front
		if (cube[4][8] == 1 || cube[1][2] == 1 || cube[2][0] == 1)
		    if (cube[4][8] == 0 || cube[1][2] == 0 || cube[2][0] == 0) {

			Movement.rightBW();
			Movement.bottomL();
			Movement.rightFW();
			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-front

	    if (cube[5][0] == 4 || cube[1][6] == 4 || cube[0][8] == 4) // when the corner is positioned bottom-left-front
		if (cube[5][0] == 1 || cube[1][6] == 1 || cube[0][8] == 1)
		    if (cube[5][0] == 0 || cube[1][6] == 0 || cube[0][8] == 0) {

			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-front

	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned bottom-right-front
		if (cube[5][2] == 1 || cube[1][8] == 1 || cube[2][6] == 1)
		    if (cube[5][2] == 0 || cube[1][8] == 0 || cube[2][6] == 0) {

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-right-front

	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned top-right-back
		if (cube[5][2] == 1 || cube[1][8] == 1 || cube[2][6] == 1)
		    if (cube[5][2] == 0 || cube[1][8] == 0 || cube[2][6] == 0) {

			Movement.backCW();
			Movement.bottomL();
			Movement.backCCW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-back

	    if (cube[5][8] == 4 || cube[3][6] == 4 || cube[2][8] == 4) // when the corner is positioned bottom-right-back
		if (cube[5][8] == 1 || cube[3][6] == 1 || cube[2][8] == 1)
		    if (cube[5][8] == 0 || cube[3][6] == 0 || cube[2][8] == 0) {

			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();
			
		    } // end corner is positioned bottom-right-back

	    if (cube[5][6] == 4 || cube[3][8] == 4 || cube[0][6] == 4) // when the corner is positioned bottom-left-back
		if (cube[5][6] == 1 || cube[3][8] == 1 || cube[0][6] == 1)
		    if (cube[5][6] == 0 || cube[3][8] == 0 || cube[0][6] == 0) {

			Movement.bottomL();
			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-back

	    if (cube[4][0] == 4 || cube[3][2] == 4 || cube[0][0] == 4) // when the corner is positioned top-left-back
		if (cube[4][0] == 1 || cube[3][2] == 1 || cube[0][0] == 1)
		    if (cube[4][6] == 0 || cube[3][2] == 0 || cube[0][0] == 0) {

			Movement.backCCW();
			Movement.bottomR();
			Movement.backCW();
			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[1][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.leftBW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;
			    
			    if (cube[1][6] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.leftFW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.leftFW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-back

	} // end if the corner is not in the correct spot

    }

    public static void solveTop_Left_BackCorner() {// solves the top-left-back corner or the black-orange-blue

	cube = Movement.returnCube();
	
	if (cube[4][0] != 4 || cube[3][2] != 3 || cube[0][0] != 0) { // if the corner is not already solved

	    if (cube[4][0] == 4 || cube[3][2] == 4 || cube[0][0] == 4) // when the corner is positioned top-left-back
		if (cube[4][0] == 3 || cube[3][2] == 3 || cube[0][0] == 3)
		    if (cube[4][6] == 0 || cube[3][2] == 0 || cube[0][0] == 0) {

			Movement.backCCW();
			Movement.bottomR();
			Movement.backCW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-back

	    if (cube[4][8] == 4 || cube[1][2] == 4 || cube[2][0] == 4) // when the corner is positioned top-right-front
		if (cube[4][8] == 3 || cube[1][2] == 3 || cube[2][0] == 3)
		    if (cube[4][8] == 0 || cube[1][2] == 0 || cube[2][0] == 0) {

			Movement.rightBW();
			Movement.bottomL();
			Movement.rightFW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-front

	    if (cube[5][0] == 4 || cube[1][6] == 4 || cube[0][8] == 4) // when the corner is positioned bottom-left-front
		if (cube[5][0] == 3 || cube[1][6] == 3 || cube[0][8] == 3)
		    if (cube[5][0] == 0 || cube[1][6] == 0 || cube[0][8] == 0) {

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-front

	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned bottom-right-front
		if (cube[5][2] == 3 || cube[1][8] == 3 || cube[2][6] == 3)
		    if (cube[5][2] == 0 || cube[1][8] == 0 || cube[2][6] == 0) {

			Movement.bottomL();
			cube = Movement.returnCube();
			
			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-right-front

	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned top-right-back
		if (cube[5][2] == 3 || cube[1][8] == 3 || cube[2][6] == 3)
		    if (cube[5][2] == 0 || cube[1][8] == 0 || cube[2][6] == 0) {

			Movement.backCW();
			Movement.bottomL();
			Movement.backCCW();
			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-back

	    if (cube[5][8] == 4 || cube[3][6] == 4 || cube[2][8] == 4) // when the corner is positioned bottom-right-back
		if (cube[5][8] == 3 || cube[3][6] == 3 || cube[2][8] == 3)
		    if (cube[5][8] == 0 || cube[3][6] == 0 || cube[2][8] == 0) {

			Movement.bottomL();
			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-right-back

	    if (cube[5][6] == 4 || cube[3][8] == 4 || cube[0][6] == 4) // when the corner is positioned bottom-left-back
		if (cube[5][6] == 3 || cube[3][8] == 3 || cube[0][6] == 3)
		    if (cube[5][6] == 0 || cube[3][8] == 0 || cube[0][6] == 0) {

			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-back

	    if (cube[4][6] == 4 || cube[1][0] == 4 || cube[0][2] == 4) // when the corner is positioned top-left-front
		if (cube[4][6] == 3 || cube[1][0] == 3 || cube[0][2] == 3)
		    if (cube[4][6] == 0 || cube[1][0] == 0 || cube[0][2] == 0) {

			Movement.frontCCW();
			Movement.bottomL();
			Movement.frontCW();
			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[0][6] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomL();
			    Movement.backCCW();
			    Movement.bottomR();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[0][6] != 4) { // if the conditions are not met, then it sets up for the loop again
				Movement.bottomR();
				Movement.backCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCW(); // turns the corner up so it's solved.
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-front

	} // end if the corner is not in the correct spot

    }

    public static void solveTop_Right_FrontCorner() {// solves the top-right-front corner or the black-red-green

	cube = Movement.returnCube();
	
	if (cube[4][8] != 4 || cube [1][2] != 1 || cube[2][0] != 2) {//if the corner is not in the correct spot
	
	    if (cube[4][8] == 4 || cube[1][2] == 4 || cube[2][0] == 4) // when the corner is positioned top-right-front
        	    	if (cube[4][8] == 1 || cube[1][2] == 1 || cube[2][0] == 1)
        	    	    if (cube[4][8] == 2 || cube[1][2] == 2 || cube[2][0] == 2) {
        
        	    		Movement.rightBW();
        	    		Movement.bottomL();
        	    		Movement.rightFW();
        	    		cube = Movement.returnCube();
        	    		
        	    		boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        	    		Movement.rightFW(); // turns the corner up so it's solved.
        	    		cube = Movement.returnCube();
        
        	    	    } // end corner is positioned top-right-front
        
	    if (cube[4][6] == 4 || cube[1][0] == 4 || cube[0][2] == 4) // when the corner is positioned top-left-front
        		if (cube[4][6] == 1 || cube[1][0] == 1 || cube[0][2] == 1)
        		    if (cube[4][6] == 2 || cube[1][0] == 2 || cube[0][2] == 2) {
        
        			Movement.frontCCW();
        			Movement.bottomL();
        			Movement.frontCW();
        			Movement.bottomR();
        			cube = Movement.returnCube();
        
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned top-left-front
        
        	    if (cube[5][0] == 4 || cube[1][6] == 4 || cube[0][8] == 4) // when the corner is positioned bottom-left-front
        		if (cube[5][0] == 1 || cube[1][6] == 1 || cube[0][8] == 1)
        		    if (cube[5][0] == 2 || cube[1][6] == 2 || cube[0][8] == 2) {
        
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned bottom-left-front
        
        	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned bottom-right-front
        		if (cube[5][2] == 1 || cube[1][8] == 1 || cube[2][6] == 1)
        		    if (cube[5][2] == 2 || cube[1][8] == 2 || cube[2][6] == 2) {
        
        			Movement.bottomL();
        			cube = Movement.returnCube();
        			
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned bottom-right-front
        
        	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned top-right-back
        		if (cube[5][2] == 1 || cube[1][8] == 1 || cube[2][6] == 1)
        		    if (cube[5][2] == 2 || cube[1][8] == 2 || cube[2][6] == 2) {
        
        			Movement.backCW();
        			Movement.bottomL();
        			Movement.backCCW();
        			Movement.bottomL();
        			cube = Movement.returnCube();
        
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        			
        		    } // end corner is positioned top-right-back
        
        	    if (cube[5][8] == 4 || cube[3][6] == 4 || cube[2][8] == 4) // when the corner is positioned bottom-right-back
        		if (cube[5][8] == 1 || cube[3][6] == 1 || cube[2][8] == 1)
        		    if (cube[5][8] == 2 || cube[3][6] == 2 || cube[2][8] == 2) {
        
        			Movement.bottomL();
        			Movement.bottomL();
        			cube = Movement.returnCube();
        
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned bottom-right-back
        
        	    if (cube[5][6] == 4 || cube[3][8] == 4 || cube[0][6] == 4) // when the corner is positioned bottom-left-back
        		if (cube[5][6] == 1 || cube[3][8] == 1 || cube[0][6] == 1)
        		    if (cube[5][6] == 2 || cube[3][8] == 2 || cube[0][6] == 2) {
        
        			Movement.bottomR();
        			cube = Movement.returnCube();
        			
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned bottom-left-back
        
        	    if (cube[4][0] == 4 || cube[3][2] == 4 || cube[0][0] == 4) // when the corner is positioned top-left-back
        		if (cube[4][0] == 1 || cube[3][2] == 1 || cube[0][0] == 1)
        		    if (cube[4][6] == 2 || cube[3][2] == 2 || cube[0][0] == 2) {
        
        			Movement.backCCW();
        			Movement.bottomR();
        			Movement.backCW();
        			cube = Movement.returnCube();
        
        			boolean good = true;
        	    		while (cube[1][8] != 4 || good) { // while the spot is not in the correct position
        	    		    Movement.bottomR();
        	    		    Movement.rightBW();
        	    		    Movement.bottomL();
        	    		    cube = Movement.returnCube();
        	    		    good = false;
        
        	    		    if (cube[1][8] != 4) { // if the conditions are not met, then it sets up for the loop again
        	    			Movement.bottomL();
        	    			Movement.rightFW();
        	    			cube = Movement.returnCube();
        	    			good = true;
        	    		    }
        	    		} // end while loop
        
        			Movement.rightFW(); // turns the corner up so it's solved.
        			cube = Movement.returnCube();
        
        		    } // end corner is positioned top-left-back
        
        	} // end if the corner is not in the correct spot
    }
    
    public static void solveTop_Right_BackCorner() {// solves the top-right-back corner or the black-red-blue

	cube = Movement.returnCube();

	if (cube[4][2] != 4 || cube[3][0] != 3 || cube[2][2] != 2) { // if the corner is not in the correct spot, else finish the method
	    
	    if (cube[1][2] == 4 || cube[4][8] == 4 || cube[2][0] == 4) // when the corner is positioned top-right-back
		if (cube[1][2] == 3 || cube[4][8] == 3 || cube[2][0] == 3)
		    if (cube[1][2] == 2 || cube[4][8] == 2 || cube[2][0] == 2) {

			Movement.backCW();
			Movement.bottomL();
			Movement.backCCW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-back

	    if (cube[4][8] == 4 || cube[1][2] == 4 || cube[2][0] == 4) // when the corner is positioned top-right-front
		if (cube[4][8] == 3 || cube[1][2] == 3 || cube[2][0] == 3)
		    if (cube[4][8] == 2 || cube[1][2] == 2 || cube[2][0] == 2) {

			Movement.rightBW();
			Movement.bottomL();
			Movement.rightFW();
			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			}//end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-right-front

	    if (cube[5][0] == 4 || cube[1][6] == 4 || cube[0][8] == 4) // when the corner is positioned bottom-left-front
		if (cube[5][0] == 3 || cube[1][6] == 3 || cube[0][8] == 3)
		    if (cube[5][0] == 2 || cube[1][6] == 2 || cube[0][8] == 2) {

			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-front

	    if (cube[5][2] == 4 || cube[1][8] == 4 || cube[2][6] == 4) // when the corner is positioned bottom-right-front
		if (cube[5][2] == 3 || cube[1][8] == 3 || cube[2][6] == 3)
		    if (cube[5][2] == 2 || cube[1][8] == 2 || cube[2][6] == 2) {

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-right-front

	    if (cube[4][6] == 4 || cube[1][0] == 4 || cube[0][2] == 4) // when the corner is positioned top-left-front
		if (cube[4][6] == 3 || cube[1][0] == 3 || cube[0][2] == 3)
		    if (cube[4][6] == 2 || cube[1][0] == 2 || cube[0][2] == 2) {

			Movement.leftBW();
			Movement.bottomR();
			Movement.leftFW();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-front

	    if (cube[5][8] == 4 || cube[3][6] == 4 || cube[2][8] == 4) // when the corner is positioned bottom-right-back
		if (cube[5][8] == 3 || cube[3][6] == 3 || cube[2][8] == 3)
		    if (cube[5][8] == 2 || cube[3][6] == 2 || cube[2][8] == 2) {

			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();
			
		    } // end corner is positioned bottom-right-back

	    if (cube[5][6] == 4 || cube[3][8] == 4 || cube[0][6] == 4) // when the corner is positioned bottom-left-back
		if (cube[5][6] == 3 || cube[3][8] == 3 || cube[0][6] == 3)
		    if (cube[5][6] == 2 || cube[3][8] == 2 || cube[0][6] == 2) {

			Movement.bottomL();
			Movement.bottomL();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned bottom-left-back

	    if (cube[4][0] == 4 || cube[3][2] == 4 || cube[0][0] == 4) // when the corner is positioned top-left-back
		if (cube[4][0] == 3 || cube[3][2] == 3 || cube[0][0] == 3)
		    if (cube[4][6] == 2 || cube[3][2] == 2 || cube[0][0] == 2) {

			Movement.backCCW();
			Movement.bottomR();
			Movement.backCW();
			Movement.bottomR();
			cube = Movement.returnCube();

			boolean good = true;
			while (cube[2][8] != 4 || good) { // while the spot is not in the correct position
			    Movement.bottomR();
			    Movement.backCW();
			    Movement.bottomL();
			    cube = Movement.returnCube();
			    good = false;

			    if (cube[2][8] != 4) { // if the condition is not met, then it sets up for the loop again
				Movement.bottomL();
				Movement.backCCW();
				cube = Movement.returnCube();
				good = true;
			    }
			} // end while loop

			Movement.backCCW(); // turns the corner up so it's solved
			cube = Movement.returnCube();

		    } // end corner is positioned top-left-back

	} // end if the corner is not in the correct spot
	
    }
    
    public static void solveMiddleLayer() { //solves the middle layer
	
	while (cube [1][3] != 1 || cube [1][5] != 1 || cube [2][3] != 2 || cube [2][5] != 2 || cube [3][3] != 3 || cube [3][5] != 3 || cube [0][3] != 0 || cube [0][5] != 0) {

        	cube = Movement.returnCube();
        	
        	int counter = 0; //used ints for identification
        	int address = 0;
        	boolean isMatch = false;
        	boolean broken = false;
        	
        	for (address = 0; address < 4; address++) {        //searching for a match
        	    for (counter = 0; counter < 4; counter++) {
        		if (cube [counter][7] == cube [address][4]) {
        		    isMatch = true;
        		    broken = true;
        		    break;
        		}
        	    }
        	    if (broken) 
        		break;
        	}
        	
            	if(address-counter > 0 && isMatch == true) //if the bottom needs to turn right
            	    for (int count = 0; count < (address-counter); count++) 
            		Movement.bottomR();
            	    
            	else if (address - counter < 0 && isMatch == true) //if the bottom need to turn left
            	    for (int count = 0; count < (counter-address); count++) 
            		Movement.bottomL();
            	
            	else if ((address - counter) == 0 && isMatch == true) { //if they are above each other
            	    
            	    if(address == 0 ) { //address is orange
            		if(cube [5][3] == 3)
            		    counter = 10;
            		else if(cube [5][3] == 1)
            		    counter = 9;
            	    }
            	    else if(address == 1) { //address if green
            		if(cube [5][1] == 0)
            		    counter = 10;
            		else if (cube [5][1] == 2)
            		    counter = 9;
            	    }
            	    else if (address == 2) { //address is red
            		if(cube [5][5] == 1)
            		    counter = 10;
            		else if (cube [5][5] == 3)
            		    counter = 9;
            	    }
            	    else if (address == 3) { //address is blue
            		if(cube [5][7] == 2)
            		    counter = 10;
            		else if (cube [5][7] == 0)
            		    counter = 9;
            	    }
            		
            	}
            	
            	else if ((address - counter) == 0 && isMatch == false)  //if there are no matches
            	   for (int count = 0; count < 4; count++) {
            	       if(cube [count][3] != cube [count][4]) {
            		   address=count;
            		   counter=10;
            		   break;
            	       }
            	       else if (cube [count][5] != count) {
            		   address=count;
            		   counter=9;
            		   break;
            	       }
            	   }
            	else
            	    System.out.println("error");
            	
            	//following are algorithms to solve using the identification given above
            	
            	cube = Movement.returnCube();
            	
            	if(address == 0) {
            	    if(cube [5][3] == 3 || counter == 10) {
            		Movement.bottomR();
            		Movement.backCCW();
            		Movement.bottomL();
            		Movement.backCW();
            		Movement.bottomL();
            		Movement.leftFW();
            		Movement.bottomR();
            		Movement.leftBW();
            		cube = Movement.returnCube();
            	    }
            	    else if (cube [5][3] == 1 || counter == 9) {
            		Movement.bottomL();
            		Movement.frontCCW();
            		Movement.bottomR();
            		Movement.frontCW();
            		Movement.bottomR();
            		Movement.leftBW();
            		Movement.bottomL();
            		Movement.leftFW();
            		cube = Movement.returnCube();
            	    }
            	}
            	
            	else if (address == 1) {
            	    if(cube [5][1] == 0 || counter == 10) {
            		Movement.bottomR();
            		Movement.leftBW();
            		Movement.bottomL();
            		Movement.leftFW();
            		Movement.bottomL();
            		Movement.frontCCW();
            		Movement.bottomR();
            		Movement.frontCW();
            		cube = Movement.returnCube();
            	    }
            	    else if(cube [5][1] == 2 || counter == 9) {
            		Movement.bottomL();
            		Movement.rightBW();
            		Movement.bottomR();
            		Movement.rightFW();
            		Movement.bottomR();
            		Movement.frontCW();
            		Movement.bottomL();
            		Movement.frontCCW();
            		cube = Movement.returnCube();
            	    }
            	}
            	
            	else if (address == 2) {
            	    if(cube [5][5] == 1 || counter == 10) {
            		Movement.bottomR();
            		Movement.frontCW();
            		Movement.bottomL();
            		Movement.frontCCW();
            		Movement.bottomL();
            		Movement.rightBW();
            		Movement.bottomR();
            		Movement.rightFW();
            		cube = Movement.returnCube();
            	    }
            	    else if (cube [5][5] == 3 || counter == 9) {
            		Movement.bottomL();
            		Movement.backCW();
            		Movement.bottomR();
            		Movement.backCCW();
            		Movement.bottomR();
            		Movement.rightFW();
            		Movement.bottomL();
            		Movement.rightBW();
            		cube = Movement.returnCube();
            	    }
            	}
            	
            	else if (address == 3) {
            	    if(cube [5][7] == 2 || counter == 10) {
            		Movement.bottomR();
            		Movement.rightFW();
            		Movement.bottomL();
            		Movement.rightBW();
            		Movement.bottomL();
            		Movement.backCW();
            		Movement.bottomR();
            		Movement.backCCW();
            		cube = Movement.returnCube();
            	    }
            	    else if (cube [5][7] == 0 || counter == 9) {
            		Movement.bottomL();
            		Movement.leftFW();
            		Movement.bottomR();
            		Movement.leftBW();
            		Movement.bottomR();
            		Movement.backCCW();
            		Movement.bottomL();
            		Movement.backCW();
            		cube = Movement.returnCube();
            	    }
            	}
	}
    
    } 

    public static void solveBottomCross() { // method for solving the bottom cross
	
	boolean topSolved = false;
	
	if (cube [5][1] != 5 || cube [5][3] != 5 || cube [5][5] != 5 || cube [5][7] != 5) {
    		while (topSolved == false) {
               
    		    for (int rotate = 0; rotate < 4; rotate++) {
                	    
            		cube = Movement.returnCube();
                	    
            		if (cube [5][5] == 5 && cube [5][7] == 5) { //if the top is yellow L shape
            		    Movement.frontCW();
            		    Movement.leftFW();
            		    Movement.frontCCW();
            		    Movement.leftBW();
            		    Movement.bottomR();
            		    Movement.leftBW();
            		    Movement.bottomL();
            		    Movement.leftBW();
            		    topSolved = true;
            		    break;
            		}
            		
            		else 
            		    Movement.bottomL();
                	    
    		}
    	    
    		    Movement.frontCW();
    		    Movement.leftFW();
    		    Movement.frontCCW();
    		    Movement.leftBW();
    		    Movement.bottomR();
    		    Movement.leftBW();
    		    Movement.bottomL();
    		    Movement.leftBW();
    	    
    		}
	}
	
    }

    public static void solveBottomFace() { // method for solving the bottom face

	while (cube [5][0] != 5 || cube [5][1] != 5 || cube [5][2] != 5 || cube [5][3] != 5 || cube [5][4] != 5 || cube [5][5] != 5 || cube [5][6] != 5 || cube [5][7] != 5 || cube [5][8] != 5) {
	    
	    for (int rotate = 0; rotate < 4; rotate++) {
		
		if(cube [5][0] != 5 && cube [5][1] == 5 && cube [5][2] != 5 && cube [5][3] == 5 && cube [5][4] == 5 && cube [5][5] == 5 && cube [5][6] == 5 && cube [5][7] == 5 && cube [5][8] != 5) { 
		    Movement.leftBW();
		    Movement.bottomR();
		    Movement.leftFW();
		    Movement.bottomR();
		    Movement.leftBW();
		    Movement.bottomR();
		    Movement.bottomR();
		}
		
		else
		    Movement.bottomL();
	    }
	    
	    Movement.leftBW();
	    Movement.bottomR();
	    Movement.leftFW();
	    Movement.bottomR();
	    Movement.leftBW();
	    Movement.bottomR();
	    Movement.bottomR();
	    
	}
	
    }

    public static void solveBottomLayerCorner() { // method for solving the bottom layer corners

	while(cube [0][0] != 0 && cube [0][2] != 0 && cube [1][0] != 1 && cube [1][2] != 1 && cube [2][0] != 2 && cube [2][2] != 2 && cube [3][0] != 3 && cube [3][2] != 3) {
	    
	    cube = Movement.returnCube();
    	
	    int counter = 0; //used ints for identification
	    int address = 0;
	    boolean good = false;
    	
	    for (address = 0; address < 4; address++) {        //searching for a set
		cube = Movement.returnCube();
    	    	for (counter = 0; counter < 4; counter++) 
    	    	    if (cube [counter][6] == counter && cube [counter][8] == counter) {
    	    		good = true;
    	    		break;
    	    	    }
    	    	
    	    	Movement.bottomL();
	    }
	    
	    //following are algorithms
	    
	    if (good == false) {
		Movement.frontCCW();
		Movement.rightFW();
		Movement.frontCCW();
		Movement.leftBW();
		Movement.leftBW();
		Movement.frontCW();
		Movement.rightBW();
		Movement.frontCCW();
		Movement.leftBW();
		Movement.leftBW();
		Movement.frontCCW();
		Movement.frontCCW();
		Movement.bottomL();
		cube = Movement.returnCube();
	    }
	    
	    else if (counter == 0) {
		Movement.frontCCW();
		Movement.rightFW();
		Movement.frontCCW();
		Movement.leftBW();
		Movement.leftBW();
		Movement.frontCW();
		Movement.rightBW();
		Movement.frontCCW();
		Movement.leftBW();
		Movement.leftBW();
		Movement.frontCCW();
		Movement.frontCCW();
		Movement.bottomL();
		cube = Movement.returnCube();
	    }
	    
	    else if (counter == 1) {
		Movement.rightBW();
		Movement.backCCW();
		Movement.frontCCW();
		Movement.frontCCW();
		Movement.rightFW();
		Movement.backCW();
		Movement.rightBW();
		Movement.frontCCW();
		Movement.frontCCW();
		Movement.rightBW();
		Movement.rightBW();
		Movement.bottomL();
		cube = Movement.returnCube();
	    }
	    
	    else if (counter == 2) {
		Movement.backCW();
		Movement.leftBW();
		Movement.backCW();
		Movement.rightBW();
		Movement.rightBW();
		Movement.backCCW();
		Movement.leftFW();
		Movement.backCW();
		Movement.rightBW();
		Movement.rightBW();
		Movement.backCCW();
		Movement.backCCW();
		Movement.bottomL();
		cube = Movement.returnCube();
	    }
	    
	    else if (counter == 3) {
		Movement.leftFW();
		Movement.frontCW();
		Movement.leftFW();
		Movement.backCCW();
		Movement.backCCW();
		Movement.leftBW();
		Movement.frontCCW();
		Movement.leftFW();
		Movement.backCCW();
		Movement.backCCW();
		Movement.leftBW();
		Movement.leftBW();
		Movement.bottomL();
		cube = Movement.returnCube();
	    }
	    
	}
	
    }

    public static void solveBottomLayerEdge() { // method for solving the bottom layer edges and the cube

	while(cube [0][7] != 0 && cube [1][7] != 1 && cube [2][7] != 2 && cube [3][7] != 3) {
	    
	    cube = Movement.returnCube();
	    
	    if(cube [0][7] == 0) { //correct orange 
		Movement.rightBW();
		Movement.rightBW();
		
		if(cube [2][7] == 3) { // use the un-returned cube to advantage. to the right
		    Movement.bottomR();
		    Movement.backCCW();
		    Movement.frontCCW();
		    Movement.rightBW();
		    Movement.rightBW();
		    Movement.frontCW();
		    Movement.backCW();
		    Movement.bottomR();
		    Movement.rightBW();
		    Movement.rightBW();
		    cube = Movement.returnCube();
		}
		if(cube [2][7] == 1) { // to the left
		    Movement.bottomL();
		    Movement.backCCW();
		    Movement.frontCCW();
		    Movement.rightBW();
		    Movement.rightBW();
		    Movement.frontCW();
		    Movement.backCW();
		    Movement.bottomL();
		    Movement.rightBW();
		    Movement.rightBW();
		    cube = Movement.returnCube();
		}
	    }
	    
	    else if(cube [1][7] == 1) { //correct green
		Movement.backCCW();
		Movement.backCCW();
		
		if(cube [3][7] == 2) { //to the left
		    Movement.bottomL();
		    Movement.leftBW();
		    Movement.rightBW();
		    Movement.backCW();
		    Movement.backCW();
		    Movement.rightFW();
		    Movement.leftFW();
		    Movement.bottomL();
		    Movement.backCCW();
		    Movement.backCCW();
		    cube = Movement.returnCube();
		}
		if (cube [3][7] == 0) { // to the right
		    Movement.bottomR();
		    Movement.leftBW();
		    Movement.rightBW();
		    Movement.backCW();
		    Movement.backCW();
		    Movement.rightFW();
		    Movement.leftFW();
		    Movement.bottomR();
		    Movement.backCCW();
		    Movement.backCCW();
		    cube = Movement.returnCube();
		}
	    }
	    
	    else if(cube [2][7] == 2) { //correct red
		Movement.leftBW();
		Movement.leftBW();
		
		if(cube [0][7] == 1) { //to the right
		    Movement.bottomR();
		    Movement.frontCW();
		    Movement.backCW();
		    Movement.leftBW();
		    Movement.leftBW();
		    Movement.frontCCW();
		    Movement.backCCW();
		    Movement.bottomR();
		    Movement.leftBW();
		    Movement.leftBW();
		}
		if(cube [0][7] == 3) { //to the left
		    Movement.bottomL();
		    Movement.frontCW();
		    Movement.backCW();
		    Movement.leftBW();
		    Movement.leftBW();
		    Movement.frontCCW();
		    Movement.backCCW();
		    Movement.bottomL();
		    Movement.leftBW();
		    Movement.leftBW();
		}
	    }
	    
	    else if(cube [3][7] == 3) { //correct blue
		Movement.frontCCW();
		Movement.frontCCW();
		
		if(cube [1][7] == 2) { //to the right
		    Movement.bottomR();
		    Movement.rightFW();
		    Movement.leftFW();
		    Movement.frontCCW();
		    Movement.frontCCW();
		    Movement.rightBW();
		    Movement.leftBW();
		    Movement.bottomR();
		    Movement.frontCCW();
		    Movement.frontCCW();
		}
		if(cube [1][7] == 0) { //to the left
		    Movement.bottomL();
		    Movement.rightFW();
		    Movement.leftFW();
		    Movement.frontCCW();
		    Movement.frontCCW();
		    Movement.rightBW();
		    Movement.leftBW();
		    Movement.bottomL();
		    Movement.frontCCW();
		    Movement.frontCCW();
		}
	    }
	    
	    else {
		Movement.rightBW();
	   	Movement.rightBW();
		Movement.bottomR();
	    	Movement.backCCW();
	    	Movement.frontCCW();
            	Movement.rightBW();
            	Movement.rightBW();
            	Movement.frontCW();
            	Movement.backCW();
            	Movement.bottomR();
         	Movement.rightBW();
         	Movement.rightBW();
         	cube = Movement.returnCube();
	    }
	}
	
    }

    public static void display() { // displays the cube for testing 
    
	for (int face = 0; face < 6; face++) {
	    for (int square = 0; square < 9; square++) {
		if ((square + 1) % 3 == 0)
		    System.out.println(cube[face][square]);
		else
		    System.out.print(cube[face][square] + " ");
	    }
	    System.out.println("\n");
	}
	
    }
    
    public static void testPop() { //Populates the cube in a specific way for testing
	
	cube[0][0] = 5;
	cube[0][1] = 5;
	cube[0][2] = 5;
	cube[0][3] = 5;
	cube[0][4] = 0;
	cube[0][5] = 0;
	cube[0][6] = 5;
	cube[0][7] = 0;
	cube[0][8] = 0;
	
	cube[1][0] = 2;
	cube[1][1] = 2;
	cube[1][2] = 2;
	cube[1][3] = 3;
	cube[1][4] = 1;
	cube[1][5] = 1;
	cube[1][6] = 3;
	cube[1][7] = 1;
	cube[1][8] = 1;
	
	cube[2][0] = 3;
	cube[2][1] = 3;
	cube[2][2] = 4;
	cube[2][3] = 4;
	cube[2][4] = 2;
	cube[2][5] = 2;
	cube[2][6] = 4;
	cube[2][7] = 2;
	cube[2][8] = 2;
	
	cube[3][0] = 0;
	cube[3][1] = 0;
	cube[3][2] = 0;
	cube[3][3] = 3;
	cube[3][4] = 3;
	cube[3][5] = 0;
	cube[3][6] = 3;
	cube[3][7] = 3;
	cube[3][8] = 0;
	
	cube[4][0] = 1;
	cube[4][1] = 1;
	cube[4][2] = 1;
	cube[4][3] = 1;
	cube[4][4] = 4;
	cube[4][5] = 4;
	cube[4][6] = 1;
	cube[4][7] = 4;
	cube[4][8] = 4;
	
	cube[5][0] = 4;
	cube[5][1] = 2;
	cube[5][2] = 2;
	cube[5][3] = 4;
	cube[5][4] = 5;
	cube[5][5] = 5;
	cube[5][6] = 3;
	cube[5][7] = 5;
	cube[5][8] = 5;
	
    }
    
    public static void testDebugger() { // Test face rotation methods, as well as cube passing methods.

	//solveTopCross();
	//solveTopCorner();
	
	solveMiddleLayer();
	
    }

    public static void writer() throws Exception { // writes the solution string array to a file

	solutionSteps = Movement.returnSoultionSteps();

	File solution = new File("solution_key.txt");
	PrintWriter writer = new PrintWriter(solution);
	
	for (int counter = 0; counter < 100000; counter++) {

	    try {
		if(solutionSteps [counter] == null) {
		    writer.println("The cube is now solved");
		    break;
		}
		else
		    writer.println(solutionSteps[counter]);
	    } catch (Exception e) {
		System.err.println(e.getMessage());
	    }

	}

	writer.close();

    }

    public static void main(String[] args) throws Exception {

	//populateCube();
	testPop();
	
	Movement.cubePull(cube, solutionSteps);

	//testDebugger();
	
	solveTopCross();
	solveTopCorner();
	solveMiddleLayer();
	solveBottomCross();
	solveBottomFace();
	solveBottomLayerCorner();
	solveBottomLayerEdge();

	cube = Movement.returnCube();

	display();
	writer();

    }
}
