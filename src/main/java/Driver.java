import java.util.Scanner;

public class Driver {
    public static void main(String [] args){
        Game2048 game2048 = new Game2048(4);
        game2048.printBoard();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Type LEFT, RIGHT, UP, or DOWN!!");
            String input = scanner.nextLine();
            System.out.println("You Have typed " + input);
            game2048.move(Action.valueOf(input));
            game2048.printBoard();
            Result result = game2048.result();
            if(result.equals(Result.WON)){
                System.out.println("You have won the game");
                break;
            }
            else if(result.equals(Result.LOSE)){
                System.out.println("You have Lost the game");
                break;
            }

        }
    }
}
