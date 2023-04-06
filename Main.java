package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input command: ");
            String command = scanner.nextLine();
            if (Objects.equals(command, "exit")) {
                break;
            } else if (command.matches("start (easy|user|medium|hard) (easy|user|medium|hard)")) {
                Game game = new Game(command.substring(6)); // "start " is cut out, and the remaining players mode become arguments, e.g. "user easy"
                game.run();
            } else {
                System.out.println("Bad parameters!");
            }
        }

    }
}

