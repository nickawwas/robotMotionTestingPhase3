import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Pen Robot Simulation Program");

        int size;
        String[] userInputSplit;
        String command;
        //Initialize robot and board

        do {
            System.out.println("Please enter the following command to initialize the Robot: I x, where x is an integer" +
                    " greater than 0 and smaller than 1000.");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            userInputSplit = userInput.split(" ");
            command = userInputSplit[0];
            size = Integer.parseInt(userInputSplit[1]);

        }while((!Objects.equals(command, "I") || !Objects.equals(command, "i")) && (size < 1 || size > 1000));

        Robot robot = new Robot(size); //Create robot object with the size parameter for board size
        System.out.println("PASSED");
        //case statement with different commands inside a while loop, Q flag for exit which is the boolean
        int parameter = 0;
        while(true){
            //enter a command, command wil be used for switch
            Arrays.fill(userInputSplit, null);
            System.out.println("Enter a command please. Here is the list of possible commands.");

            Scanner cmdScanner = new Scanner(System.in);
            String cmdInput = cmdScanner.nextLine();
            userInputSplit = cmdInput.split(" ");
            command = userInputSplit[0];
            if(userInputSplit.length > 1){
                parameter = Integer.parseInt(userInputSplit[1]); //used for movement or initialize
            }

            switch (command) {
                //pen up
                case "U", "u" -> robot.setPenUp();

                //pen down
                case "D", "d" -> robot.setPenDown();

                //turn right
                case "R", "r" -> robot.turnRight();

                //turn left
                case "L", "l" -> robot.turnLeft();

                //move number of places
                case "M", "m" -> {
                    if (parameter < 0) {
                        System.out.println("Enter a positive integer.");
                    } else {
                        robot.move(parameter);
                    }
                }
                //print
                case "P", "p" -> robot.printBoard();

                //print current
                case "C", "c" -> robot.currentStateOfTheRobot();

                //exit program
                case "Q", "q" -> {
                    System.out.println("You have quit the Robot Simulation Program.");
                    return;
                }
                //initialize
                case "I", "i" -> {
                    //Function to change board size?
                    if (parameter < 1 || parameter > 1000) {
                        System.out.println("Invalid initialization, please enter a positive integer that is less than 1000.");
                        break;
                    }
                    robot = new Robot(parameter);
                }
                //command not recognized
                default ->
                    //code block
                        System.out.println("The command you have entered is not valid, please re-enter a valid command.");
            }
        }
    }
}