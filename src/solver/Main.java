package solver;

import java.util.Scanner;
import solver.Movement;

public class Main {

	public static int[][] cube = new int[6][9]; // the array that represents the
												// cube (look at attached spread
												// sheet
	// that is in the net of the cube. print and fold)
	/*
	 * for every [x][y] position in the array, - x represent faces (0=left side,
	 * 1=front, 2=right side, 3=back side, 4=top, 5=bottom) - y represents spots
	 * on that face (0=top left, 1=top middle, 2=top right, 3=middle left,
	 * 4=middle middle, 5=middle right, 6=bottom right, 7=bottom middle,
	 * 8=bottom right) - the values at that address is the color (the color that
	 * would be at the corresponding x in this case: 0=orange, 1=green, 2=red,
	 * 3=blue, 4=black,5=yellow
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

	public static void solveTopCross() {

	}

	public static void testRotations(){ //Test face rotation methods, as well as cube passing methods.
	    populateCube();
            Movement.cubePull(cube);
            
            Movement.leftBW();
            
            Movement.rightBW();
            
            Movement.frontCCW();
            
            Movement.backCCW();
            
            Movement.topL();
            
            Movement.bottomL();
            cube = Movement.returnCube();
    
            for(int face =  0; face < 6; face++) {
                for (int square = 0; square < 9; square++) {
                    if ((square + 1) % 3 == 0)
                        System.out.println(cube[face][square]);
                    else
                        System.out.print(cube[face][square] + " ");
                }
                System.out.println("\n");
            }

	}

	public static void main(String[] args) {
		
	    Movement.cubePull(cube);

	    //testRotations();

	    populateCube();
	    solveTopCross();

	}
}
