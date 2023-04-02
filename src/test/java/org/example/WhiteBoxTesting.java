package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class WhiteBoxTesting {
    private Robot robo2;
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
     Test : 1
     Test type : Structural, white-box
     Input : < I 10 >.
     Description : Initialize with uppercase I. Covers while(condition || (size < 1 || size > 500)), if(userInputSplit.length > 1)
     Expected output : < Please enter a command. >
     Tester : Ali Turkman
     Date : March 31st
     */
     @Test
     @DisplayName("Initialization 1")
     void Test1() {
         String input = "I 10";
         String expected = "Please enter a command.";
         final String test = input + "\nq";
         provideInput(test);
         Main.main(new String[0]);
         assertTrue(getOutput().contains(expected), getOutput());
     }

    /*
    Test : 2
    Test type : Structural, white-box
    Input : < i 10 >.
    Description : Initialize with lowercase i.
    Expected output : < Please enter a command. >
    Tester : Ali Turkman
    Date : March 31st
    */
    @Test
    @DisplayName("Initialization 2")
    void Test2() {
        String input = "i 10";
        String expected = "Please enter a command.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());


    }

    @Test
    @DisplayName("Initialization 2")
    void Test22() {
        String input = "i 10";
        String expected = "Please enter a command.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());


    }


    /*
    Test : 3
    Test type : Structural, white-box
    Input : < Q >.
    Description : Exit program with uppercase Q.
    Expected output : < Error. Exited without playing our game :( >
    Tester : Ali Turkman
    Date : March 31st
    */
    @Test
    @DisplayName("Initialization 3")
    void Test3() {
        String input = "Q";
        String expected = "Error.";
        String expected2 = "Exited without playing our game :(";
        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
        assertTrue(getOutput().contains(expected2), getOutput());
    }


    /*
     Test : 4
     Test type : Structural, white-box
     Input : < q >.
     Description : Exit program with lowercase q.
     Expected output : < Error. Exited without playing our game :( >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Initialization 4")
    void Test4() {
        String input = "q";
        String expected = "Error.";
        String expected2 = "Exited without playing our game :(";
        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
        assertTrue(getOutput().contains(expected2), getOutput());
    }


    /*
     Test : 5
     Test type : Structural, white-box
     Input : < "Z 500 q then Z q >.
     Description : Invalid command with size and without.
     Expected output : < Error. Please enter the following command to initialize the org.example.Robot: "I x" or "i x", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Initialization 5")
    void Test5() {
        String input = "Z 500\nq";
        String expected = "Error.";
        String expected2 = "Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit.";
        provideInput(input);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
        assertTrue(getOutput().contains(expected2), getOutput());

        String inputSecond = "Z \nq";
        String expectedSecond = "Error.";
        String expected2Second = "Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit.";
        provideInput(inputSecond);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expectedSecond), getOutput());
        assertTrue(getOutput().contains(expected2Second), getOutput());
    }


    /*
     Test : 6
     Test type : Structural, white-box
     Input : < i 1000 >.
     Description : Initialize with larger than 500 size and uppercase I.
     Expected output : < Please enter the following command to initialize the org.example.Robot: "I x" or "i x", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Initialization 6")
    void Test6() {
        String input = "i 1000";
        String expected = "Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 7
     Test type : Structural, white-box
     Input : < i 1000 >.
     Description : Initialize with larger than 500 size and uppercase I.
     Expected output : < Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Initialization 7")
    void Test7() {
        String input = "I 1000";
        String expected = "Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test : 8
     Test type : Structural, white-box
     Input : < i 1000 >.
     Description : Initialize with larger than 500 size and lowercase I.
     Expected output : < Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Initialization 8")
    void Test8() {
        String input = "i 1000";
        String expected = "Please enter the following command to initialize the org.example.Robot: \"I x\" or \"i x\", where x is an integer greater than 0 and smaller than 500. Press Q or q to exit.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 9
     Test type : Structural, white-box
     Input : < i 10 then U >.
     Description : Case U, while Pen already Up.
     Expected output : < org.example.Robot pen is already up. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case U, while Pen already Up")
    void Test9() {
        String input = "i 10\n" + "\nU";
        String expected = "org.example.Robot pen is already up.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 10
     Test type : Structural, white-box
     Input : < i 10 then D then U >.
     Description : Case U, while Pen down.
     Expected output : < org.example.Robot pen is now up. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case U, while Pen down")
    void Test10() {

        String input = "i 10\n" + "\nD\nU";
        String expected = "org.example.Robot pen is now up.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 11
     Test type : Structural, white-box
     Input : < i 10 then D then D >.
     Description : Case U, while Pen already down.
     Expected output : < org.example.Robot pen is already down. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case U, while Pen already down")
    void Test11() {

        String input = "i 10\n" + "\nD\nD";
        String expected = "org.example.Robot pen is already down.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 12
     Test type : Structural, white-box
     Input : < i 10 then R then C >.
     Description : Case R.
     Expected output : < Position: 0, 0 - Pen: Up - Facing: East >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case R")
    void Test12() {

        String input = "i 10\n" + "\nR\nC";
        String expected = "Position: 0, 0 - Pen: Up - Facing: East";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 13
     Test type : Structural, white-box
     Input : < i 10 then L then C >.
     Description : Case L.
     Expected output : < Position: 0, 0 - Pen: Up - Facing: West >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case L")
    void Test13() {

        String input = "i 10\n" + "\nL\nC";
        String expected = "Position: 0, 0 - Pen: Up - Facing: West";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test : 14
     Test type : Structural, white-box
     Input : < i 2 then p >.
     Description : Case P.
     Expected output : < .	.
                        ↑	.	>
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case P")
    void Test14() {

        String input = "i 2\n" + "\np";
        String expected = ".\t.\t\n↑\t.\t\n";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 15
     Test type : Structural, white-box
     Input : < i 10 then m 5 then C>.
     Description : Case M.
     Expected output : < Position: 0, 5 - Pen: Up - Facing: North >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case M")
    void Test15() {

        String input = "i 10\n" + "\nm 5\nC";
        String expected = "org.example.Robot has moved by 5 units.";
        String expected2 = "Position: 0, 5 - Pen: Up - Facing: North";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
        assertTrue(getOutput().contains(expected2), getOutput());
    }


    /*
     Test : 16
     Test type : Structural, white-box
     Input : < i 10 then m -5 then C>.
     Description : Case M with negative value.
     Expected output : < Please enter a positive integer. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case M")
    void Test16() {

        String input = "i 10\n" + "\nm -5\nC";
        String expected = "Please enter a positive integer.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 17
     Test type : Structural, white-box
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Case M with positive value.
     Expected output : < Movement request would make the robot fall off the board. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case M")
    void Test17() {

        String input = "i 10\n" + "\nm 15\nC";
        String expected = "Movement request would make the robot fall off the board.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 18
     Test type : Structural, white-box
     Input : <Room(n) 10 printFloor() movePen() true moveRobot(movesNorth) 4 setRobotDirection(dir) 1 moveRobot(movesEast) 2 printFloor()>.
     Description : Case I.
     Expected output : < .	.	.
                         .	.	.
                         ↑	.	.
                                 >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case I")
    void Test18() {

        String input = "i 10\n" + "\ni 3\np";
        String expected = ".\t.\t.\t\n↑\t.\t.\t\n";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 19
     Test type : Structural, white-box
     Input : <i 10 then i -1000 then p>.
     Description : Case I with integer smaller than 1.
     Expected output : < Invalid initialization, please enter a positive integer that is less than 500. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case I")
    void Test19() {

        String input = "i 10\n" + "\ni -1000\np";
        String expected = "Invalid initialization, please enter a positive integer that is less than 500.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }


    /*
     Test : 20
     Test type : Structural, white-box
     Input : < i 10 then i 1000 then p >.
     Description : Case I with integer larger than 500.
     Expected output : < Invalid initialization, please enter a positive integer that is less than 500. >
     Tester : Ali Turkman
     Date : March 31st
     */
    @Test
    @DisplayName("Case I")
    void Test20() {

        String input = "i 10\n" + "\ni 1000\np";
        String expected = "Invalid initialization, please enter a positive integer that is less than 500.";
        final String test = input + "\nq";
        provideInput(test);
        Main.main(new String[0]);
        assertTrue(getOutput().contains(expected), getOutput());
    }

    /*
     Test Function: 21
     Test type : Structural, whitebox
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
        assertEquals("Position: 0, 0 - Pen: Up - Facing: North", robo2.currentStateOfTheRobot());

        int[] coordinates  = robo2.move(1);
        robo2.turnRight();
        assertEquals("Position: 0, 1 - Pen: Up - Facing: East", robo2.currentStateOfTheRobot());

        coordinates  = robo2.move(2);
        robo2.turnRight();
        robo2.setPenDown();
        assertEquals("Position: 2, 1 - Pen: Down - Facing: South", robo2.currentStateOfTheRobot());


        robo2.turnRight();
        try {
            coordinates  = robo2.move(3); // Try moving out of bounds
        } catch (Exception e) {
            assertEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }
        assertEquals("Position: 2, 1 - Pen: Down - Facing: West", robo2.currentStateOfTheRobot());
    }

    /*
     Test Function: 22
     Test type : Structural, whitebox
     Input : <Robot(n) 1 move(s) 1 Robot(n) 0 move(s) 0 Robot(n) -1>.
     Description : Robot() tested with multiple sizes and try invalid size -1, 1, 0 and move in them
     Expected output : < No Exception, No Exception, Exception -1 >
     Tester : Nicholas Kawwas
     Date : March 31th
     */
    @Test
    @DisplayName("Robot() Constructor with Different Sizes")
    void robotConstructorDiffSizes() throws Exception {
        robo2 = new Robot(0);
        int[] coordinates;
        try {
            coordinates = robo2.move(0); // Crashes, code should handle no movement here but doesn't
        } catch (Exception e) {
            assertNotEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }

        robo2 = new Robot(1);
        try {
            coordinates = robo2.move(1); // Crashes, code should handle movement to edge here but doesn't
        } catch (Exception e) {
            assertNotEquals("Movement request would make the robot fall off the board.", e.getMessage());
        }

        try {
            robo2 = new Robot(-1);
        } catch (Exception e) {
            assertEquals("-1", e.getMessage());
        }
    }

    /*
     Test Function: 23
     Test type : Structural, whitebox
     Input : <Robot(n) move(s) 7 move(s) 2 move(s) 0 turnRight() move(s) 8 move(s) 3 move(s) 0 turnRight() move(s) 9 move(s) 2 move(s) 0 turnRight() move(s) 10 move(s) 3 move(s) 0>.
     Description : Moves robot in and out of bounds in every direction to cover all conditions
     Expected output : < Out of Bounds Exception, Move 2, No Move, Out of Bounds Exception, Move 3, No Move, Out of Bounds Exception, Move 2, No Move, Out of Bounds Exception, Move 3, No Move>
     Tester : Nicholas Kawwas
     Date : March 30th
     */
    @Test
    @DisplayName("Robot move out of bounds Test")
    void roboMoveInOutBounds() throws Exception {
        robo2 = new Robot(6);
        // Case 0 - T
        // If - T
        try {
            robo2.move(7);
        } catch (Exception e) {
            Exception exception = new Exception("Movement request would make the robot fall off the board.");
            assertEquals(exception.getMessage(), e.getMessage());
        }
        // Else, While T
        robo2.move(2);

        // If, While - F
        robo2.move(0);

        // Case 1 - T
        robo2.turnRight();
        // If - T
        try {
            robo2.move(8);
        } catch (Exception e) {
            Exception exception = new Exception("Movement request would make the robot fall off the board.");
            assertEquals(exception.getMessage(), e.getMessage());
        }
        // Else, While T
        robo2.move(3);

        // If, While - F
        robo2.move(0);

        // Case 2 - T
        robo2.turnRight();
        try {
            robo2.move(9);
        } catch (Exception e) {
            Exception exception = new Exception("Movement request would make the robot fall off the board.");
            assertEquals(exception.getMessage(), e.getMessage());
        }
        robo2.move(2);

        // If, While - F
        robo2.move(0);

        // Case 3 - T
        robo2.turnRight();
        // If - T
        try {
            robo2.move(10);
        } catch (Exception e) {
            Exception exception = new Exception("Movement request would make the robot fall off the board.");
            assertEquals(exception.getMessage(), e.getMessage());
        }
        // Else, While T
        robo2.move(3);

        // If, While - F
        robo2.move(0);
    }

    /*
    Test Function: 24
    Test type : Structural, whitebox
    Input : <Robot(n) 5 turnRight() turnLeft() printBoard() setPenDown() getPenIsDown() move(s) 3 turnRight() printBoard() turnRight() printBoard()>.
    Description : Print Board in Every Direction with Marked States plus testing pen states and ability to turn
    Expected output : < 1, 0, Printed board, true, board, 1, 2, false, board, true, board >
    Tester : Nicholas Kawwas
    Date : March 31th
    */
    @Test
    @DisplayName("Print Board in Every Direction with Marked States")
    void printBoardOutOfBounds() throws Exception {
        robo2 = new Robot(5);

        // Turn left and right, back to starting position
        assertEquals(1, robo2.turnRight());
        assertEquals(0, robo2.turnLeft());

        // Direction = 0
        // Else if - F
        assertEquals(".\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t\n" +
                ".\t.\t.\t.\t.\t\n" +
                "↑\t.\t.\t.\t.\t\n", robo2.printBoard());

        // Direction = 1
        // Else if - T
        robo2.setPenDown();
        assertEquals(true, robo2.getPenIsDown());

        robo2.move(3);
        assertEquals(1, robo2.turnRight());
        assertEquals(".\t.\t.\t.\t.\t\n" +
                "→\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n", robo2.printBoard());


        // Turn backward and reset pen
        assertEquals(2, robo2.turnRight());

        // Direction = 2
        // Else if - F
        robo2.setPenUp();
        assertEquals(false, robo2.getPenIsDown());

        assertEquals(".\t.\t.\t.\t.\t\n" +
                "↓\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n", robo2.printBoard());

        // Direction = 3
        assertEquals(3, robo2.turnRight());
        assertEquals(".\t.\t.\t.\t.\t\n" +
                "←\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n" +
                "*\t.\t.\t.\t.\t\n", robo2.printBoard());
    }
}
