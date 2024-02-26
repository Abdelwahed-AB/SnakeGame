package snakeGame;

public class GameRunner {
    private Game game;

    public GameRunner() {
        game = new Game();
        game.createApples(GameProperties.APPLES.value);
    }

    public void runGame() throws InterruptedException {
        while (true){
            update();
        }
    }
    public void update() throws InterruptedException {
        game.getSnake().changeDirection(game.getBot().pickDirection());
        game.getSnake().move();
        game.checkCollisions();

        Thread.sleep(125);
        clear();
        game.drawGame();
        System.out.println("Score: "+ConsoleColors.ANSI_PURPLE+game.getScore()+ConsoleColors.ANSI_RESET);
    }

    private static void clear(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
