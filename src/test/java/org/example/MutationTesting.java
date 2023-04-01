package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MutationTesting {

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1 >
    // Description: Cover the path of the “move()” function which involves handling moving towards
    // the north beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseNorthException() {
        Robot robot = new Robot(1);
        try {
            robot.move(1);
            fail("Exception expected was not thrown.");
        } catch (Exception e) {
            assertEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1 >
    // Description: Cover the path of the “move()” function which involves handling moving towards
    // the east beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseEastException() {
        Robot robot = new Robot(1);
        robot.turnRight();
        try {
            robot.move(1);
            fail("Exception expected was not thrown.");
        } catch (Exception e) {
            assertEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1 >
    // Description: Cover the path of the “move()” function which involves handling moving towards
    // the south beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseSouthException() {
        Robot robot = new Robot(1);
        robot.turnRight();
        robot.turnRight();
        try {
            robot.move(1);
            fail("Exception expected was not thrown.");
        } catch (Exception e) {
            assertEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1 >
    // Description: Cover the path of the “move()” function which involves handling moving towards
    // the west beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseWestException() {
        Robot robot = new Robot(1);
        robot.turnLeft();
        try {
            robot.move(1);
            fail("Exception expected was not thrown.");
        } catch (Exception e) {
            assertEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1, 1 >
    // Description: Covers the paths for the “move()” function involving moving towards the north
    // as well as moving towards the south.
    // Expected: < [0,1], [0,0] >
    @Test
    void moveDefUseNorthSouth() throws Exception {
        int[] expectedCoordinatesNorth = {0,1};
        int[] expectedCoordinatesSouth = {0,0};
        Robot robot = new Robot(2);
        assertArrayEquals(expectedCoordinatesNorth, robot.move(1));
        robot.turnRight();
        robot.turnRight();
        assertArrayEquals(expectedCoordinatesSouth, robot.move(1));
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Mutation, White-Box
    // Input: < 1, 1 >
    // Description: Covers the paths for the “move()” function involving moving towards the east
    // as well as moving towards the west.
    // Expected: < [1,0], [0,0] >
    @Test
    void moveDefUseEastWest() throws Exception {
        int[] expectedCoordinatesEast = {1,0};
        int[] expectedCoordinatesWest = {0,0};
        Robot robot = new Robot(2);
        robot.turnRight();
        assertArrayEquals(expectedCoordinatesEast, robot.move(1));
        robot.turnRight();
        robot.turnRight();
        assertArrayEquals(expectedCoordinatesWest, robot.move(1));
    }
}
