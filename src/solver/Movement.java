package solver;

public class Movement {

    static int[][] cube;

    public static void cubePull(int pushedCube[][]) {
        cube = pushedCube;
    }

    public static void leftFW() { // moves the left side forward

        int copy1 = cube[4][0];
        int copy2 = cube[4][3]; // copies of the top 3 edges
        int copy3 = cube[4][6];

        cube[4][0] = cube[3][8];
        cube[4][3] = cube[3][5]; // swapping the top 3 edges with the back 3 edges
        cube[4][6] = cube[3][2];

        cube[3][8] = cube[5][0];
        cube[3][5] = cube[5][3]; // swapping the back 3 edges with the bottom 3 edges
        cube[3][2] = cube[5][6];

        cube[5][0] = cube[1][0];
        cube[5][3] = cube[1][3]; // swapping the bottom 3 edges with front 3 edges
        cube[5][6] = cube[1][6];

        cube[1][0] = copy1;
        cube[1][3] = copy2; // swapping the front 3 edges with the original copies of the top 3 edges
        cube[1][6] = copy3;

        copy1 = cube[0][0];
        copy2 = cube[0][1]; // copy top 3 on left face
        copy3 = cube[0][2];

        cube[0][0] = cube[0][6];
        cube[0][1] = cube[0][3]; // swapping the top with back on face
        cube[0][2] = cube[0][0];

        cube[0][6] = cube[0][8];
        cube[0][3] = cube[0][7]; // swapping the back with bottom on face

        cube[0][8] = copy3;
        cube[0][7] = cube[0][5]; // swapping the bottom with front on face

        cube[0][2] = copy1;
        cube[0][5] = copy2; // swapping the front with original top copies on face

    }

    public static void leftBW() { // moves the left side backward

        int copy1 = cube[4][0];
        int copy2 = cube[4][3]; // copies of the top 3 edges
        int copy3 = cube[4][6];

        cube[4][0] = cube[1][0];
        cube[4][3] = cube[1][3]; // swapping the top 3 edges with the front 3 edges
        cube[4][6] = cube[1][6];

        cube[1][0] = cube[5][0];
        cube[1][3] = cube[5][3]; // swapping the front 3 edges with the bottom 3 edges
        cube[1][6] = cube[5][6];

        cube[5][0] = cube[3][8];
        cube[5][3] = cube[3][5]; // swapping the bottom 3 edges with back 3 edges
        cube[5][6] = cube[3][2];

        cube[3][8] = copy1;
        cube[3][5] = copy2; // swapping the back 3 edges with the copies of original top 3 edges
        cube[3][2] = copy3;

        copy1 = cube[0][0];
        copy2 = cube[0][1]; // copy top 3 on left face
        copy3 = cube[0][2];

        cube[0][0] = cube[0][2];
        cube[0][1] = cube[0][5]; // swapping the top with front on face
        cube[0][2] = cube[0][8];

        cube[0][5] = cube[0][7]; // swapping the front with bottom on face
        cube[0][8] = cube[0][6];

        cube[0][7] = cube[0][3]; // swapping the bottom with back on face
        cube[0][6] = copy1;

        cube[0][3] = copy2; // swapping the back with original top copies on face
        cube[0][0] = copy3;

    }

    public static void rightFW() { // moves the right side forwards

        int copy1 = cube[4][8];
        int copy2 = cube[4][5]; // copies of the top 3 edges
        int copy3 = cube[4][2];

        cube[4][8] = cube[3][0];
        cube[4][5] = cube[3][3]; // swapping the top 3 with the back 3 edges
        cube[4][2] = cube[3][6];

        cube[3][0] = cube[5][8];
        cube[3][3] = cube[5][5]; // swapping the back 3 edges with the bottom top 3 edges
        cube[3][6] = cube[5][2];

        cube[5][8] = cube[1][8];
        cube[5][5] = cube[1][5]; // swapping the bottom 3 edges with front 3 edges
        cube[5][2] = cube[1][2];

        cube[1][8] = copy1;
        cube[1][5] = copy2; // swapping the front 3 edges with the original copies top 3 edges
        cube[1][2] = copy3;

        copy1 = cube[2][0];
        copy2 = cube[2][1]; // copy top 3 on left face
        copy3 = cube[2][2];

        cube[2][0] = cube[2][2];
        cube[2][1] = cube[2][5]; // swapping the top with back on face
        cube[2][2] = cube[2][8];

        cube[2][5] = cube[2][7]; // swapping the back with bottom on face
        cube[2][8] = cube[2][6];

        cube[2][7] = cube[2][3]; // swapping the bottom with front on face
        cube[2][6] = copy1;

        cube[2][3] = copy2; // swapping the front with original copies top on face
        cube[2][0] = copy3;

    }

    public static void rightBW() {// moves the right side backwards

        int copy1 = cube[4][8];
        int copy2 = cube[4][5]; // copies of the top 3 edges
        int copy3 = cube[4][2];

        cube[4][8] = cube[1][8];
        cube[4][5] = cube[1][5]; // swapping the top 3 with the front 3 edges
        cube[4][2] = cube[1][2];

        cube[1][8] = cube[5][8];
        cube[1][5] = cube[5][5]; // swapping the front 3 edges with the bottom 3 edges
        cube[1][2] = cube[5][2];

        cube[5][8] = cube[3][0];
        cube[5][5] = cube[3][3]; // swapping the bottom 3 edges with back 3 edges
        cube[5][2] = cube[3][6];

        cube[3][0] = copy1;
        cube[3][3] = copy2; // swapping the back 3 edges with the copies of original top 3 edges
        cube[3][6] = copy3;

        copy1 = cube[2][0];
        copy2 = cube[2][1]; // copy top 3 on left face
        copy3 = cube[2][2];

        cube[2][0] = cube[2][6];
        cube[2][1] = cube[2][3]; // swapping the top with front on face
        cube[2][2] = cube[2][0];

        cube[2][6] = cube[2][8];
        cube[2][3] = cube[2][7]; // swapping the front with bottom on face

        cube[2][8] = copy3;
        cube[2][7] = cube[2][5]; // swapping the bottom with back on face

        cube[2][2] = copy1;
        cube[2][5] = copy2; // swapping the back with original top copies on face

    }

    public static void frontCW() { // moves the front side clockwise

        int copy1 = cube[4][6];
        int copy2 = cube[4][7]; // copies of the top 3 edges
        int copy3 = cube[4][8];

        cube[4][6] = cube[0][8];
        cube[4][7] = cube[0][5]; // swapping the top 3 with the left 3 edges
        cube[4][8] = cube[0][2];

        cube[0][8] = cube[5][2];
        cube[0][5] = cube[5][1]; // swapping the left 3 with the bottom 3 edges
        cube[0][2] = cube[5][0];

        cube[5][2] = cube[2][0];
        cube[5][1] = cube[2][3]; // swapping the bottom 3 with the right 3 edges
        cube[5][0] = cube[2][6];

        cube[2][0] = copy1;
        cube[2][3] = copy2; // swapping the the right 3 with the original copies of the top 3 edges
        cube[2][6] = copy3;

        copy1 = cube[1][0];
        copy2 = cube[1][1]; // copies of the top 3 on face
        copy3 = cube[1][2];

        cube[1][0] = cube[1][6];
        cube[1][1] = cube[1][3]; // swapping the top 3 with the left 3 on face
        cube[1][2] = cube[1][0];

        cube[1][6] = cube[1][8];
        cube[1][3] = cube[1][7]; // swapping the left 3 with the bottom 3 on face

        cube[1][8] = copy3;
        cube[1][7] = cube[1][5]; // swapping the bottom 3 with the right 3 on face

        cube[1][2] = copy1;
        cube[1][5] = copy2; // swapping the right 3 with the original copies top 3 on face

    }

    public static void frontCCW() { // moves the front side counter clockwise

        int copy1 = cube[4][6];
        int copy2 = cube[4][7]; // copies of the top 3 edges
        int copy3 = cube[4][8];

        cube[4][6] = cube[2][0];
        cube[4][7] = cube[2][3]; // swapping the top 3 with the right 3 edges
        cube[4][8] = cube[2][6];

        cube[2][0] = cube[5][2];
        cube[2][3] = cube[5][1]; // swapping the the right 3 with the bottom 3 edges
        cube[2][6] = cube[5][0];

        cube[5][2] = cube[0][8];
        cube[5][1] = cube[0][5]; // swapping the bottom 3 with the left 3 edges
        cube[5][0] = cube[0][2];

        cube[0][8] = copy1;
        cube[0][5] = copy2; // swapping the left 3 with the original copies of top 3 edges
        cube[0][2] = copy3;

        copy1 = cube[1][0];
        copy2 = cube[1][1]; // copies of the top 3 on face
        copy3 = cube[1][2];

        cube[1][0] = cube[1][2];
        cube[1][1] = cube[1][5]; // swapping the top 3 with the right 3 on face
        cube[1][2] = cube[1][8];

        cube[1][5] = cube[1][7]; // swapping the right 3 with the bottom 3 on face
        cube[1][8] = cube[1][6];

        cube[1][7] = cube[1][3]; // swapping the bottom 3 with the left 3 on face
        cube[1][6] = copy1;

        cube[1][3] = copy2; // swapping the left 3 with the original copies top 3 on face
        cube[1][0] = copy3;

    }

    public static void backCW() { // moves the back back clockwise (front of cube facing the person)

        int copy1 = cube[4][2];
        int copy2 = cube[4][1]; // copies of the top 3 edges
        int copy3 = cube[4][0];

        cube[4][2] = cube[0][0];
        cube[4][1] = cube[0][3]; // swapping the top 3 with the left 3 edges
        cube[4][0] = cube[0][6];

        cube[0][0] = cube[5][6];
        cube[0][3] = cube[5][7]; // swapping the left 3 with the bottom 3 edges
        cube[0][6] = cube[5][8];

        cube[5][6] = cube[2][8];
        cube[5][7] = cube[2][5]; // swapping the bottom 3 with the right 3 edges
        cube[5][8] = cube[2][2];

        cube[2][8] = copy1;
        cube[2][5] = copy2; // swapping the the right 3 with the original copies of the top 3 edges
        cube[2][2] = copy3;

        copy1 = cube[3][0];
        copy2 = cube[3][1]; // copies of the top 3 on face
        copy3 = cube[3][2];

        cube[3][0] = cube[3][2];
        cube[3][1] = cube[3][5]; // swapping the top 3 with the left 3 on face
        cube[3][2] = cube[3][8];

        cube[3][5] = cube[3][7]; // swapping the left 3 with the bottom 3 on face
        cube[3][8] = cube[3][6];

        cube[3][7] = cube[3][3]; // swapping the bottom 3 with the right 3 on face
        cube[3][6] = copy1;

        cube[3][3] = copy2; // swapping the right 3 with the original copies top 3 on face
        cube[3][0] = copy3;

    }

    public static void backCCW() { // moves the back side counter clockwise

        int copy1 = cube[4][2];
        int copy2 = cube[4][1]; // copies of the top 3 edges
        int copy3 = cube[4][0];

        cube[4][2] = cube[2][8];
        cube[4][1] = cube[2][5]; // swapping the top 3 with the right 3 edges
        cube[4][0] = cube[2][2];

        cube[2][8] = cube[5][6];
        cube[2][5] = cube[5][7]; // swapping the the right 3 with bottom 3 edges
        cube[2][2] = cube[5][8];

        cube[5][6] = cube[0][0];
        cube[5][7] = cube[0][3]; // swapping the bottom 3 with the left 3 edges
        cube[5][8] = cube[0][6];

        cube[0][0] = copy1;
        cube[0][3] = copy2; // swapping the left 3 with the original copies top 3 edges
        cube[0][6] = copy3;

        copy1 = cube[3][0];
        copy2 = cube[3][1]; // copies of the top 3 on face
        copy3 = cube[3][2];

        cube[3][0] = cube[3][6];
        cube[3][1] = cube[3][3]; // swapping the top 3 with the right 3 on face
        cube[3][2] = cube[3][0];

        cube[3][6] = cube[3][8];
        cube[3][3] = cube[3][7]; // swapping the right 3 with the bottom 3 on face
        cube[3][0] = cube[3][6];

        cube[3][8] = copy3;
        cube[3][7] = cube[3][5]; // swapping the bottom 3 with the left 3 on face
        cube[3][6] = cube[3][8];

        cube[3][2] = copy1;
        cube[3][5] = copy2; // swapping the left 3 with the bottom 3 on face
        cube[3][8] = copy3;

    }

    public static void topL() { // moves the top side left-wards

        int copy1 = cube[1][0];
        int copy2 = cube[1][1]; // copy front 3 edges
        int copy3 = cube[1][2];

        cube[1][0] = cube[2][0];
        cube[1][1] = cube[2][1]; // swapping the front 3 with the right 3 edges
        cube[1][2] = cube[2][2];

        cube[2][0] = cube[3][0];
        cube[2][1] = cube[3][1]; // swapping the right 3 with the back 3 edges
        cube[2][2] = cube[3][2];

        cube[3][0] = cube[0][0];
        cube[3][1] = cube[0][1]; // swapping the back 3 with the left 3 edges
        cube[3][2] = cube[0][2];

        cube[0][0] = copy1;
        cube[0][1] = copy2; // swapping the left 2 with the front 3 edges
        cube[0][2] = copy3;

        copy1 = cube[4][6];
        copy2 = cube[4][7]; // copy the front 3 on face
        copy3 = cube[4][8];

        cube[4][6] = cube[4][8];
        cube[4][7] = cube[4][5]; // swapping the front 3 with the right 3 on edge
        cube[4][8] = cube[4][2];

        cube[4][5] = cube[4][1]; // swapping the right 3 with the back 3 on face
        cube[4][2] = cube[4][0];

        cube[4][1] = cube[4][3]; // swapping the back 3 with the left 3 on face
        cube[4][0] = copy1;

        cube[4][3] = copy2; // swapping the left 3 with the original copies of the front 3 on face
        cube[4][6] = copy3;

    }

    public static void topR() { // moves the top side right-wards

        int copy1 = cube[1][0];
        int copy2 = cube[1][1]; // copy front 3 edges
        int copy3 = cube[1][2];

        cube[1][0] = cube[0][0];
        cube[1][1] = cube[0][1]; // swapping the front 3 with the left 3 edges
        cube[1][2] = cube[0][2];

        cube[0][0] = cube[3][0];
        cube[0][1] = cube[3][1]; // swapping the left 3 with the back 3 edges
        cube[0][2] = cube[3][2];

        cube[3][0] = cube[2][0];
        cube[3][1] = cube[2][1]; // swapping the back 3 with the right 3 edges
        cube[3][2] = cube[2][2];

        cube[2][0] = copy1;
        cube[2][1] = copy2; // swapping the left 2 with the front 3 edges
        cube[2][2] = copy3;

        copy1 = cube[4][6];
        copy2 = cube[4][7]; // copy the front 3 on face
        copy3 = cube[4][8];

        cube[4][6] = cube[4][0];
        cube[4][7] = cube[4][3]; // swapping the front 3 with the left 3 on edge
        cube[4][8] = cube[4][6];

        cube[4][0] = cube[4][2];
        cube[4][3] = cube[4][1]; // swapping the left 3 with the back 3 on face
        cube[4][6] = cube[4][0];

        cube[4][2] = copy3;
        cube[4][1] = cube[4][5]; // swapping the back 3 with the right 3 on face
        cube[4][0] = cube[4][2];

        cube[4][8] = copy1;
        cube[4][5] = copy2; // swapping the left 3 with the original copies of the front 3 on face
        cube[4][2] = copy3;

    }

    public static void bottomL() { // moves the bottom side left-wards

        int copy1 = cube[1][6];
        int copy2 = cube[1][7]; // copy front 3 edges
        int copy3 = cube[1][8];

        cube[1][6] = cube[2][6];
        cube[1][7] = cube[2][7]; // swapping the front 3 with the right 3 edges
        cube[1][8] = cube[2][8];

        cube[2][6] = cube[3][6];
        cube[2][7] = cube[3][7]; // swapping the right 3 with the back 3 edges
        cube[2][8] = cube[3][8];

        cube[3][6] = cube[0][6];
        cube[3][7] = cube[0][7]; // swapping the back 3 with the right 3 edges
        cube[3][8] = cube[0][8];

        cube[0][6] = copy1;
        cube[0][7] = copy2; // swapping the left 2 with the front 3 edges
        cube[0][8] = copy3;

        copy1 = cube[5][0];
        copy2 = cube[5][1]; // coping the front 3 on face
        copy3 = cube[5][2];

        cube[5][0] = cube[5][2];
        cube[5][1] = cube[5][5]; // swapping the front 3 with the right 3 on face
        cube[5][2] = cube[5][8];

        cube[5][5] = cube[5][7]; // swapping the right 3 with the back 3 on face
        cube[5][8] = cube[5][6];

        cube[5][7] = cube[5][3]; // swapping the back 3 with the left 3 on face
        cube[5][6] = copy1;

        cube[5][3] = copy2; // swapping the left 3 with the front 3 on face
        cube[5][0] = copy3;

    }

    public static void bottomR() { // moves the bottom side right-wards

        int copy1 = cube[1][6];
        int copy2 = cube[1][7]; // copy front 3 edges
        int copy3 = cube[1][8];

        cube[1][6] = cube[0][6];
        cube[1][7] = cube[0][7]; // swapping the front 3 with the left 3 edges
        cube[1][8] = cube[0][8];

        cube[0][6] = cube[3][6];
        cube[0][7] = cube[3][7]; // swapping the left 3 with the back 3 on face
        cube[0][8] = cube[3][8];

        cube[3][6] = cube[2][6];
        cube[3][7] = cube[2][7]; // swapping the back 3 with the right 3 edges
        cube[3][8] = cube[2][8];

        cube[2][6] = copy1;
        cube[2][7] = copy2; // swapping the right 2 with the front 3 edges
        cube[2][8] = copy3;

        copy1 = cube[5][0];
        copy2 = cube[5][1]; // coping the front 3 on face
        copy3 = cube[5][2];

        cube[5][0] = cube[5][6];
        cube[5][1] = cube[5][3]; // swapping the front 3 with the left 3 on face
        cube[5][2] = cube[5][0];

        cube[5][6] = cube[5][8];
        cube[5][3] = cube[5][7]; // swapping the left 3 with the back 3 on face

        cube[5][8] = copy3;
        cube[5][7] = cube[5][5]; // swapping the back 3 with the right 3 on face

        cube[5][2] = copy1;
        cube[5][5] = copy2; // swapping the left 3 with the front 3 on face

    }

    public static int[][] returnCube(){
        return cube[][]
    }

}
