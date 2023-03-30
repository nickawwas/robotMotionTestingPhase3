import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class    Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Pen Robot Simulation Program");

        int size = 0;
        boolean condition;
        String[] userInputSplit;
        String command;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please enter the following command to initialize the Robot: \"I x\" or \"i x\", where x is an integer" +
                    " greater than 0 and smaller than 500. Press Q or q to exit.");

            String userInput = scanner.nextLine();
            userInputSplit = userInput.split(" ");
            command = userInputSplit[0];
            if(userInputSplit.length > 1){
                size = Integer.parseInt(userInputSplit[1]); //used for movement or initialize
            }
            condition = (!Objects.equals(command, "I")) && !Objects.equals(command, "i");
            if(condition){
                System.out.println("Error.");
            }
            //to exit program
            if(userInput.equals("q") || userInput.equals("Q")){
                System.out.println("Exited without playing our game :(");
                return;
            }
        }while(condition || (size < 1 || size > 500));

        Robot robot = new Robot(size); //Create robot object with the size parameter for board size
        System.out.println("Here is the list of possible commands.\n" +
                "U or u to lift the pen.\n" + "D or d to set down the pen.\n" + "R or r to turn right.\n"
                + "L or l to turn left.\n" + "M x or m x where x is an integer for the amount of squares to move." +
                "It must be positive.\n" + "P or p to print the current board.\n" +
                "C or c to print the current state of the robot.\n" +
                "Q or q to exit the program.\n" + "I x or i x to reinitialize the robot where x > 0 and x < 500.\n");

        int parameter = 0;
        while(true){
            //enter a command, command wil be used for switch
            Arrays.fill(userInputSplit, null);
            System.out.println("Please enter a command.");

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
                case "P", "p" -> System.out.println(robot.printBoard());

                //print current
                case "C", "c" -> System.out.println(robot.currentStateOfTheRobot());

                //exit program
                case "Q", "q" -> {
                    System.out.println("You have quit the Robot Simulation Program.");
                    return;
                }
                //initialize
                case "I", "i" -> {
                    if (parameter < 1 || parameter > 500) {
                        System.out.println("Invalid initialization, please enter a positive integer that is less than 500.");
                        break;
                    }
                    robot = new Robot(parameter);
                }
                //command not recognized
                default ->
                        System.out.println("The command you have entered is not valid, please re-enter a valid command.");
            }
        }
    }
}