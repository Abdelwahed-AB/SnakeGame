package snakeGame;

import java.io.IOException;

public class TestRun{
    public static void main(String[] args) throws InterruptedException, IOException {
        Game game = new Game();
        game.createApples(5);

        while (true){
            game.getSnake().changeDirection(game.getBot().pickDirection());
            game.getSnake().move();
            game.checkCollisions();

            Thread.sleep(125);
            clear();
            game.drawGame();
        }
    }

    private static void clear(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}