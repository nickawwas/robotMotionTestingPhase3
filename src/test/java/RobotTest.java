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
    @DisplayName("Robot Turn Left Test")
    void turnLeft() {
        assertEquals(3, robot.turnLeft());
    }

    @Test
    @DisplayName("Robot Turn Right Test")
    void turnRight() {
        assertEquals(1, robot.turnRight());
        assertEquals(2, robot.turnRight());
    }

    @Test
    @DisplayName("Robot Move Test")
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
    @DisplayName("Current State of Robot")
    void currentStateOfTheRobot() {
        assertEquals("Position: 0, 0 - Pen: Up - Facing: North", robot.currentStateOfTheRobot());
    }

}