import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
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

    @Test
    @DisplayName("Correct input for initialization")
    void correctInitializationTest() {

        final String testOutputString = "Here is the list of possible commands.";

        provideInput(testOutputString);
        final String test = "i 10\nq"; //need q to exit program to avoid scanner next line issue

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Wrong input for initialization")
    void failedInitializationTest() {

        final String testOutputString = "Error."; //error message

        provideInput(testOutputString);
        final String test = "u 10\nq"; //need q to exit program to avoid scanner next line issue

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Current Position Test")
    void currentPositionTest() {
        final String testOutputString = "Position: 0, 0 - Pen: Up - Facing: North";
        provideInput(testOutputString);
        final String test = "I 10\nC\nq";

        provideInput(test);

        Main.main(new String[0]);
        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Print Board Test")
    void printBoardTest() {
        final String testOutputString = ".\t.\t\n↑\t.\t\n";
        provideInput(testOutputString);
        final String test = "i 2\np\nq";

        provideInput(test);

        Main.main(new String[0]);
        //assertEquals(getOutput(), getOutput().contains(testOutputString));
        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Turn Left Test")
    void turnLeftTest() {
        final String testOutputString = "West";
        provideInput(testOutputString);
        final String test = "i 2\nl\nc\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Turn Right Test")
    void turnRightTest() {
        final String testOutputString = "East";
        provideInput(testOutputString);
        final String test = "i 2\nr\nc\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Pen Up Test")
    void penUpTest() {
        final String testOutputString = "Up";
        provideInput(testOutputString);
        final String test = "i 2\nd\nu\nC\nQ";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Pen Down Test")
    void penDownTest() {
        final String testOutputString = "Down";
        provideInput(testOutputString);
        final String test = "i 2\nD\nc\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }

    @Test
    @DisplayName("Correct Move Test")
    void correctMoveTest() {
        final String testOutputString = "0, 1";
        provideInput(testOutputString);
        final String test = "i 2\nm 1\nc\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
    @Test
    @DisplayName("Failed Move Test")
    void failedMoveTest() {
        final String testOutputString = "Movement request would make the robot fall off the board.";
        provideInput(testOutputString);
        final String test = "i 2\nm 2\nc\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }

    @Test
    @DisplayName("Mark board Test")
    void markBoardTest() {
        final String testOutputString = "*\t→\t.\t\n*\t.\t.\t\n*\t.\t.";
        provideInput(testOutputString);
        final String test = "i 3\nd\nm 2\nr\nm 1\np\nq";

        provideInput(test);

        Main.main(new String[0]);

        assertTrue(getOutput().contains(testOutputString));
    }
}