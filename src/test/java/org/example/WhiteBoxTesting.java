package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhiteBoxTesting {

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






}
