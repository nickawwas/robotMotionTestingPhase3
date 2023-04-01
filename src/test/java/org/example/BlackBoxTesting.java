package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BlackBoxTesting {
    private Robot robo2;
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

        
        assertEquals(2, robot.turnRight());

        assertEquals(".\t.\t.\t.\t\n" +
                     "↓\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n" +
                     "*\t.\t.\t.\t\n", robot.printBoard());

        assertEquals(3, robot.turnRight());

        assertEquals(".\t.\t.\t.\t\n" +
                    "←\t.\t.\t.\t\n" +
                    "*\t.\t.\t.\t\n" +
                    "*\t.\t.\t.\t\n", robot.printBoard());
    }


    /* BlackBox testing */

    /*
     Test Function: 4
     Test type : Functional, blackbox
     Input : <i 10, Please enter a command.", "i 5 i 1, Invalid initialization", "50 i, Error.", "i -1, Error.", "i --10, Error.", "100, Error.", "i 5 i 501">.
     Description : Test different input types for initialization command
     Expected output : <Please enter a command.", "Invalid initialization", "Error.", "Error.", "Error.", "Error.", "Invalid initialization" >
     Tester : Nicholas Harris
     Date : March 30th
     */
    @ParameterizedTest
    @CsvSource({"i 10, Please enter a command.", "i 5 i 1, Invalid initialization", "50 i, Error", "i -1, Error", "i --10, Error", "100, Error.", "i 5 i 501, Invalid initialization"})
    @DisplayName("Test Initialization Command")
    void initializationTest(String input, String expected) {
        input = input.replace("i", "\ni");
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test Function: 5
     Test type : Functional, blackbox
     Input : <"c", "c 10", "10 c", "C", "m 2 c", "d c", "r, c">.
     Description : Test print position command
     Expected output : <"Position: 0, 0 - Pen: up - Facing: north", "Position: 0, 0 - Pen: Up - Facing: North", "Error.", "Position: 0, 0 - Pen: up - Facing: north", "Position: 0, 2 - Pen: up - Facing: north", "Position: 0, 0 - Pen: down - Facing: north.", "Position: 0, 0 - Pen: up - Facing: east">
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
     Input : <"m 2", "m 10", "m 100", "m -1", "m --10">.
     Description : Test move command input
     Expected output : <Position: 0, 2 - Pen: up - Facing: north", "off the board", "off the board", "positive integer.", "positive integer.">
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
     Input : <"d", "d 10", "dd", "C", " D", " D", "D">.
     Description : Test pen down command input
     Expected output : <"Pen: Down", "Pen: Down", "Pen: Down", "Pen: Up", " Pen: Down", " Pen: Down", "Pen: Down">
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"d, Pen: Down", "d 10, Pen: Down", "dd, Pen: Down", "C, Pen: Up", " D, Pen: Down", " D, Pen: Down", "D, Pen: Down"})
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
     Input : <"d u", "u 10", "u 100", "C", " U", " U", "U">.
     Description : Test pen up command input
     Expected output : <"Pen: Up", "Pen: Up", "Pen: Up", "Pen: Up", " Pen: Up", "Pen: Up", "Pen: Up">
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
     Input : <"r", "r r", "r", "r -1", "r r r" , "r 501", "c">.
     Description : Test right command input
     Expected output : <"Facing: East", "Facing: South", "Facing: East", "Facing: East", "Facing: West", "Facing: East", "Facing: North">
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
     Input : <"l, l l, l 100, l -1, l l l , l 501, c>.
     Description : Test left command input
     Expected output : <"Facing: West", "Facing: South", "Facing: West", "Facing: West", "Facing: East", "Facing: West", "Facing: North" >
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
     Input : <q, q 10, Q 100, q -1,  q --10, q, Q>.
     Description : Test quit input
     Expected output : <quit", "quit", "quit", "quit", "quit", "quit", "quit">
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"q, quit", "q 10, quit", "Q 100, quit", "  q -1, quit", "  q --10, quit", " q, quit", "Q, quit"})
    @DisplayName("Test Quit Command")
    void quitTest(String input, String expected) {
        String test = "";

        test = "i 5\n" + input;
    
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 12
     Test type : Functional, blackbox
     Input : <"i 2pq">.
     Description : Test Print Board p Command
     Expected output : <.\t.\t\n↑\t.\t\n>
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"i 2pq, .\t.\t\n↑\t.\t\n"})
    @DisplayName("Test Print Board Command")
    void printBoardTest(String input, String expected) {
        input = input.replace("p", "\np\n");

        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 13
     Test type : Functional, blackbox
     Input : <"i 2pq">.
     Description : Test Print Board P Command
     Expected output : <.\t.\t.\t\n↑\t.\t.\t\n.\t.\t.\t\n>
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @CsvSource({"i 3Pq, .\t.\t.\t\n↑\t.\t.\t\n.\t.\t.\t\n"})
    @DisplayName("Test Print Board Command")
    void printBoardTest2(String input, String expected) {
        input = input.replace("P", "\np\n");

        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 14
     Test type : Functional, blackbox
     Input : <"e", "O", "z", "342", "C50", "p26", "i e", "-502", "-ee">.
     Description : Test invalid commands
     Expected output : <"The command you have entered is not valid, please re-enter a valid command.">
     Tester : Nicholas Harris
     Date : March 30th
    */
    @ParameterizedTest
    @ValueSource(strings={"e", "O", "z", "342", "C50", "p26", "i e", "-502", "-ee.", ".,?!11@#$"})
    @DisplayName("Test Print Board Command")
    void testInvalidCommands(String input) {
        String expected = "The command you have entered is not valid, please re-enter a valid command.";
        input = "i 5\n" + input + "\nq";
        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 15
     Test type : Functional, blackbox
     Input : <Robot(n) 5 move(s) 1 turnRight() currentStateOfTheRobot() move(s) 2 turnRight() setPenDown() currentStateOfTheRobot() turnRight() currentStateOfTheRobot()>.
     Description : Robot getCurrentState tested in every direction with every pen state plus moving robot
     Expected output : < Pen Up and East, Pen Down and South, Pen Down and West>
     Tester : Nicholas Kawwas
     Date : March 31th
    */
    @Test
    @DisplayName("Current State of org.example.Robot for Every Direction")
    void currentStateOfTheRobotEveryDirection() throws Exception {
        robo2 = new Robot(5);
        int[] coordinates  = robo2.move(1);
        robo2.turnRight();
        assertEquals("Position: 0, 1 - Pen: Up - Facing: East", robo2.currentStateOfTheRobot());

        coordinates  = robo2.move(2);
        robo2.turnRight();
        robo2.setPenDown();
        assertEquals("Position: 2, 1 - Pen: Down - Facing: South", robo2.currentStateOfTheRobot());


        robo2.turnRight();
        assertEquals("Position: 2, 1 - Pen: Down - Facing: West", robo2.currentStateOfTheRobot());
    }

    /*
     Test Function: 16
     Test type : Functional, blackbox
     Input : <Robot(n) 1 move(s) 1 Robot(n) 0 move(s) 0 Robot(n) -1>.
     Description : Robot() tested with multiple sizes and try invalid size -1, 1, 0 and move in them
     Expected output : < size 1, Exception -1, Room size 0>
     Tester : Nicholas Kawwas
     Date : March 31th
     */
    @Test
    @DisplayName("Robot() Constructor with Different Sizes")
    void robotConstructorDiffSizes() throws Exception {
        robo2 = new Robot(0);
        robo2.move(0); // Crashes, code should handle no movement here but doesn't

        robo2 = new Robot(1);
        robo2.move(1); // Crashes, code should handle movement to edge here but doesn't

        try {
            robo2 = new Robot(-1);
        } catch (Exception e) {
            assertEquals("-1", e.getMessage());
        }
    }
}