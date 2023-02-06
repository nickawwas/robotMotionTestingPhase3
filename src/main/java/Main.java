import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Pen Robot Simulation Program");

        int size = 0;
        boolean condition;
        String[] userInputSplit;
        String command;
        Scanner scanner = new Scanner(System.in);
        //Initialize robot and board

        do {
            System.out.println("Please enter the following command to initialize the Robot: I x, where x is an integer" +
                    " greater than 0 and smaller than 1000.");

            String userInput = scanner.nextLine();
            userInputSplit = userInput.split(" ");
            command = userInputSplit[0];
            if(userInputSplit.length > 1){
                size = Integer.parseInt(userInputSplit[1]); //used for movement or initialize
            }
            condition = (!Objects.equals(command, "I")) && !Objects.equals(command, "i");

        }while(condition || (size < 1 || size > 1000));

        Robot robot = new Robot(size); //Create robot object with the size parameter for board size
        System.out.println("PASSED");
        //case statement with different commands inside a while loop, Q flag for exit which is the boolean
        int parameter = 0;
        while(true){
            //enter a command, command wil be used for switch
            Arrays.fill(userInputSplit, null);
            System.out.println("Enter a command please. Here is the list of possible commands.");

            String cmdInput = scanner.nextLine();
            userInputSplit = cmdInput.split(" ");
            command = userInputSplit[0];
            if(userInputSplit.length > 1){
                parameter = Integer.parseInt(userInputSplit[1]); //used for movement or initialize
            }

            switch (command) {
                //pen up
                case "U", "u" -> {
                    if(!robot.getPenIsDown()){
                        System.out.println("Robot pen is already up.");
                        break;
                    }
                    robot.setPenUp();
                    System.out.println("Robot pen is now up.");
                }

                //pen down
                case "D", "d" -> {
                    if(robot.getPenIsDown()){
                        System.out.println("Robot pen is already down.");
                        break;
                    }
                    robot.setPenDown();
                    System.out.println("Robot pen is now down.");
                }

                //turn right
                case "R", "r" -> {
                    robot.turnRight();
                    System.out.println("Robot has rotated to the right.");
                }

                //turn left
                case "L", "l" -> {
                    robot.turnLeft();
                    System.out.println("Robot has rotated to the left.");
                }

                //move number of places
                case "M", "m" -> {
                    if (parameter < 0) {
                        System.out.println("Please enter a positive integer.");
                    } else {
                        try{
                            robot.move(parameter);
                            System.out.println("Robot has moved by " + parameter + " units.");
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
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