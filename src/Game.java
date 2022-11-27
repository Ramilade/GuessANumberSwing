import java.util.Random;
import java.util.Scanner;

public class Game {
    int randomNumber;

    public Game() {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        randomNumber = rand.nextInt(input.nextInt()) + 1;

    }

    public int getRandomNumber() {
        return randomNumber;
    }

}
