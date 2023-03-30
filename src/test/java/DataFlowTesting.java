import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataFlowTesting {

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Data-Flow, White-Box
    // Input: < 1 >
    // Description: Cover the dpu {(3,4)} for the “move()” function by attempting to move towards the north beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseNorthException() {
        Robot robot = new Robot(1);
        try {
            robot.move(1);
        } catch (Exception e) {
            String expectedMessage = "Movement request would make the robot fall off the board.";
            String receivedMessage = e.getMessage();
            assertTrue(receivedMessage.contains(expectedMessage));
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Data-Flow, White-Box
    // Input: < 1 >
    // Description: Cover the dpu {7,8)} for the “move()” function by attempting to move towards the east beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseEastException() {
        Robot robot = new Robot(1);
        robot.turnRight();
        try {
            robot.move(1);
        } catch (Exception e) {
            String expectedMessage = "Movement request would make the robot fall off the board.";
            String receivedMessage = e.getMessage();
            assertTrue(receivedMessage.contains(expectedMessage));
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Data-Flow, White-Box
    // Input: < 1 >
    // Description: Covers the dpu {(11,12)} for the “move()” function by attempting to move towards the south beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseSouthException() {
        Robot robot = new Robot(1);
        robot.turnRight();
        robot.turnRight();
        try {
            robot.move(1);
        } catch (Exception e) {
            String expectedMessage = "Movement request would make the robot fall off the board.";
            String receivedMessage = e.getMessage();
            assertTrue(receivedMessage.contains(expectedMessage));
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Data-Flow, White-Box
    // Input: < 1 >
    // Description: Covers the dpu {(15,16)} for the “move()” function by attempting to move towards the west beyond the board limits.
    // Expected: < "Movement request would make the robot fall off the board." >
    @Test
    void moveDefUseWestException() {
        Robot robot = new Robot(1);
        robot.turnLeft();
        try {
            robot.move(1);
        } catch (Exception e) {
            String expectedMessage = "Movement request would make the robot fall off the board.";
            String receivedMessage = e.getMessage();
            assertTrue(receivedMessage.contains(expectedMessage));
        }
    }

    // Tester: Matthew Sklivas
    // Date: 2023/03/30
    // Type: Data-Flow, White-Box
    // Input: < 1, 1 >
    // Description: Covers the dcu {6} and dpus {(3,5), (5,6), (5,19)} for the “move()” function,
    // moving towards the north, followed by the dcu {14} and dpus {(11,13), (13,14), (13,19)}, moving towards the south.
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
    // Type: Data-Flow, White-Box
    // Input: < 1, 1 >
    // Description: Covers the dcu {10} and dpus {(7,9), (9,10), (9,19)} for the “move()”
    // function, moving towards the east, followed by the dcu {18} and dpus {(15,17), (17,18), (17,19)},
    // moving towards the west.
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
