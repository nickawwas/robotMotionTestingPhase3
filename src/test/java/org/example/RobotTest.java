package org.example;

import org.example.Robot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private final Robot robot = new Robot(4);

    @Test
    @DisplayName("Set Pen Up Test")
    void setPenUp() {
        robot.setPenUp();
        assertFalse(robot.getPenIsDown());
    }

    @Test
    @DisplayName("Set Pen Down Test")
    void setPenDown() {
        robot.setPenDown();
        assertTrue(robot.getPenIsDown());
    }

    @Test
    @DisplayName("org.example.Robot Turn Left Test")
    void turnLeft() {
        assertEquals(3, robot.turnLeft());
        assertEquals(2, robot.turnLeft());
        assertEquals(1, robot.turnLeft());
        assertEquals(0, robot.turnLeft());
    }

    @Test
    @DisplayName("org.example.Robot Turn Right Test")
    void turnRight() {
        assertEquals(1, robot.turnRight());
        assertEquals(2, robot.turnRight());
        assertEquals(3, robot.turnRight());
        assertEquals(0, robot.turnRight());
    }

    @Test
    @DisplayName("org.example.Robot Move Test")
    void move() throws Exception {
        int[] array = {0,2};
        assertArrayEquals(array, robot.move(2));
    }

    @Test
    @DisplayName("Print Board Test")
    void printBoard() throws Exception {

        assertEquals(".\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t\n" +
                "↑\t.\t.\t.\t\n", robot.printBoard());

        robot.setPenDown();
        robot.move(2);
        assertEquals(".\t.\t.\t.\t\n" +
                "↑\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t\n", robot.printBoard());
    }

    @Test
    @DisplayName("Current State of org.example.Robot")
    void currentStateOfTheRobot() {
        assertEquals("Position: 0, 0 - Pen: Up - Facing: North", robot.currentStateOfTheRobot());
    }


    /* Additional missing test cases */

    // Robot() only tested with one size array
    // 	- TODO: Test with multiple sizes and try invalid size -1, 1, 0

    // 	printBoard only tests for robot to move within bounds and with one direction only
    // 	- TODO: Write test case for robot moving in multiple directions
    // 	- TODO: Write test case for robot moving with Pen up, no stars should appear

    // 	currentState only tests for robot at default position
    // 	- TODO: Move robot to different position, try with pen set down as well, and facing in all directions

    // 	Didn't directly test markBoard()

    /*
     Test Function Test moving in all directions
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Kawwas
     Date : 26th February
     */
    @Test
    @DisplayName("Robot move in all directions Test")
    void moveAllDirections() throws Exception {
        int[] array = {0,2};
        assertArrayEquals(array, robot.move(2));
        assertEquals(1, robot.turnRight());
        int[] array2 = {3,2};
        assertArrayEquals(array2, robot.move(3));
        assertEquals(2, robot.turnRight());
        int[] array3 = {3,0};
        assertArrayEquals(array3, robot.move(2));
        assertEquals(3, robot.turnRight());
        int[] array4 = {1,0};
        assertArrayEquals(array4, robot.move(2));
    }

    /*
     Test Function Test moving out of bounds
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Kawwas
     Date : 26th February
     */
    @Test
    @DisplayName("Robot move out of bounds Test")
    void moveOutOfBounds() throws Exception {
        try {
            robot.move(5);
        } catch (Exception e) {
            Exception exception = assertThrows(Exception.class, () -> {
                robot.move(5);
            });
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertEquals(1, robot.turnRight());
        try {
            robot.move(5);
        } catch (Exception e) {
            Exception exception = assertThrows(Exception.class, () -> {
                robot.move(5);
            });
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertEquals(2, robot.turnRight());
        try {
            robot.move(5);
        } catch (Exception e) {
            Exception exception = assertThrows(Exception.class, () -> {
                robot.move(5);
            });
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertEquals(3, robot.turnRight());
        try {
            robot.move(5);
        } catch (Exception e) {
            Exception exception = assertThrows(Exception.class, () -> {
                robot.move(5);
            });
            assertEquals(exception.getMessage(), e.getMessage());
        }

        assertEquals(0, robot.turnRight());
    }


    /*
     Test Function: Test Print board with robot out of bounds
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Kawwas
     Date : 26th February
     */
    @Test
    @DisplayName("Print Board Test")
    void printBoardOutOfBounds() throws Exception {

        assertEquals(".\t.\t.\t.\t\n" +
                     ".\t.\t.\t.\t\n" +
                     ".\t.\t.\t.\t\n" +
                     "↑\t.\t.\t.\t\n", robot.printBoard());

        robot.setPenDown();
        robot.move(2);
        assertEquals(".\t.\t.\t.\t\n" +
                     "↑\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n", robot.printBoard());

        assertEquals(1, robot.turnRight());
        try {
            robot.move(100);
        } catch (Exception e) {
            Exception exception = assertThrows(Exception.class, () -> {
                robot.move(100);
            });
            assertEquals(exception.getMessage(), e.getMessage());
        }
        assertEquals(".\t.\t.\t.\t\n" +
                     "→\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n", robot.printBoard());
    }


}