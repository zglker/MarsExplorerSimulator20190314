
import exception.IgnoreException;
import simulator.Explorer;
import simulator.Mars;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //initialize the Mars explore
        Mars mars = new Mars(5, 5);
        Explorer explorer = new Explorer();
        MarsExplorer marsExplorer = new MarsExplorer(mars, explorer);

        System.out.println("Mars Explorer Simulator");
        System.out.println("Enter a command, Valid commands are:");
        System.out.println("\'PLACE X,Y\', \'MOVE X,Y\', REPORT or EXIT");


        while (true) {
            String inputString = sc.nextLine();
            if ("EXIT".equals(inputString)) {
                break;
            } else {
                try {
                    String output = marsExplorer.getCommand(inputString);

                    if(output != null && !output.equals(""))
                    System.out.println(output);
                } catch (IgnoreException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Exit Mars Explorer Simulator");
    }
}
