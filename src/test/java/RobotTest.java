import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    private final Robot robot = new Robot(10);

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
    void getPenIsDown() {
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }

    @Test
    void move() {
    }

    @Test
    void printBoard() {
    }

    @Test
    void currentStateOfTheRobot() {
    }
}