package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BlackBoxTesting {

    private final Robot robot = new Robot(4);

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private String getOutput() {
        return testOut.toString();
    }
    public void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    /* Additional missing test cases From */

    // Robot() only tested with one size array
    // 	- TODO: Test with multiple sizes and try invalid size -1, 1, 0

    // 	printBoard only tests for robot to move within bounds and with one direction only
    // 	- TODO: Write test case for robot moving in multiple directions
    // 	- TODO: Write test case for robot moving with Pen up, no stars should appear

    // 	currentState only tests for robot at default position
    // 	- TODO: Move robot to different position, try with pen set down as well, and facing in all directions

    // 	Didn't directly test markBoard()

    /*
     Test Function: 1
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Harris
     Date : March 30th
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
     Test Function: 2
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Harris
     Date : March 30th
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
     Test Function: 3
     Test type : Functional, blackbox
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Print default and changed room floor line by line
     Expected output : < Default empty room floor, Modified room floor >
     Tester : Nicholas Harris
     Date : March 30th
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


    /* BlackBox testing */

    /*
     Test Function: 4
     Test type : Functional, blackbox
     Input : <i 10, Please enter a command.", "i 100, Please enter a command.", "50 i, Error.", "i -1, Error.", "i --10, Error.", "100, Error.", "i 501, 500">.
     Description : Test different input types for initialization command
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
     */
    @ParameterizedTest
    @CsvSource({"i 10, Please enter a command.", "i 100, Please enter a command.", "50 i, Error.", "i -1, Error.", "i --10, Error.", "100, Error.", "i 501, 500"})
    @DisplayName("Test Initialization Command")
    void initializationTest(String input, String expected) {
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test Function: 5
     Test type : Functional, blackbox
     Input : <i 10, Please enter a command.", "i 100, Please enter a command.", "50 i, Error.", "i -1, Error.", "i --10, Error.", "100, Error.", "i 501, 500">.
     Description : Test print position command
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"c, Position: 0, 0 - Pen: up - Facing: north", "c 10, Position: 0, 0 - Pen: Up - Facing: North", "10 c, Error.", "C, Position: 0, 0 - Pen: up - Facing: north", "m 2 c, Position: 0, 2 - Pen: up - Facing: north", "d c, Position: 0, 0 - Pen: down - Facing: north.", "r, c, Position: 0, 0 - Pen: up - Facing: east"})
    @DisplayName("Test print position Command")
    void printPositionTest(String input, String expected) {
        String test = "";

        input = input.replace("c", "\nc\n");
        test = "i 5\n" + input + "\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 6
     Test type : Functional, blackbox
     Input : <"m 2, Position: 0, 2 - Pen: up - Facing: north", "m 10, off the board", "m 100,  off the board", "m -1, positive integer.", "m --10, positive integer.">.
     Description : Test move command input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"m 2, Position: 0, 2 - Pen: up - Facing: north", "m 10, off the board", "m 100,  off the board", "m -1, positive integer.", "m --10, positive integer."})
    @DisplayName("Test Move Command")
    void moveTest(String input, String expected) {
        String test = "";

        test = "i 5\n" + input + "\nC\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test Function: 7
     Test type : Functional, blackbox
     Input : <"d, Position: 0, 0 - Pen: down - Facing: north.", "d 10, Error.", "d 100, Error.", "d -1, Error.", "d --10, Error.", "d 501, Error.", "d 500, Error.">.
     Description : Test pen down command input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"d, Pen: Down", "d 10, Pen: Down", "d 100, Pen: Down", "C, Pen: Up", " D, Pen: Down", " D, Pen: Down", "D, Pen: Down"})
    @DisplayName("Test Pen Down Command")
    void penDownTest(String input, String expected) {
        String test = "";

        input = input.replace("d", "\nd\n");
        test = "i 5\n" + input + "\nC\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 8
     Test type : Functional, blackbox
     Input : <"u, Position: 0, 0 - Pen: up - Facing: north.", "u 10, Error.", "u 100, Error.", "u -1, Error.", "u --10, Error.", "u 501, Error.", "u 500, Error.">.
     Description : Test pen up command input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"d u, Pen: Up", "u 10, Pen: Up", "u 100, Pen: Up", "C, Pen: Up", " U, Pen: Up", " U, Pen: Up", "U, Pen: Up"})
    @DisplayName("Test Pen Up Command")
    void penUpTest(String input, String expected) {
        String test = "";

        input = input.replace("u", "\nu\n");
        test = "i 5\n" + input + "\nC\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 9
     Test type : Functional, blackbox
     Input : <"r, Position: 0, 0 - Pen: up - Facing: east", "r 10, Error.", "r 100, Error.", "r -1, Error.", "r --10, Error.", "r 501, Error.", "r 500, Error.">.
     Description : Test right command input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */

    @ParameterizedTest
    @CsvSource({"r, Facing: East", "r r, Facing: South", "r 100, Facing: East", "r -1, Facing: East", "r r r , Facing: West", "r 501, Facing: East", "c, Facing: North"})
    @DisplayName("Test Turn Right Command")
    void turnRightTest(String input, String expected) {
        String test = "";

        input = input.replace("r", "\nr");
        test = "i 5\n" + input + "\nC\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 10
     Test type : Functional, blackbox
     Input : <"l, Position: 0, 0 - Pen: up - Facing: west", "l 10, Error.", "l 100, Error.", "L -1, Error.", "L --10, Error.", "l 501, Error.", "l 500, Error.">.
     Description : Test left command input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"l, Facing: West", "l l, Facing: South", "l 100, Facing: West", "l -1, Facing: West", "l l l , Facing: East", "l 501, Facing: West", "c, Facing: North"})
    @DisplayName("Test Turn Left Command")
    void turnLeftTest(String input, String expected) {
        String test = "";

        input = input.replace("l", "\nl");
        test = "i 5\n" + input + "\nC\nq";
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 11
     Test type : Functional, blackbox
     Input : <"q, Position: 0, 0 - Pen: up - Facing: north", "q 10, Error.", "q 100, Error.", "q -1, Error.", "q --10, Error.", "q 501, Error.", "q 500, Error.">.
     Description : Test quit input
     Expected output : <Please enter a command.", "Please enter a command.", "Error.", "Error.", "Error.", "Error.", "500" >
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"q, quit", "q 10, quit", "q 100, quit", "  q -1, quit", "  q --10, quit", "q, quit", "Q, quit"})
    @DisplayName("Test Quit Command")
    void quitTest(String input, String expected) {
        String test = "";

        test = "i 5\n" + input;
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    // Test for printing boards

}