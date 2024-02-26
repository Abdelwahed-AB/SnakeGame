package snakeGame;

import snakeGame.bots.StupidBot;
import snakeGame.collectibles.Apple;
import snakeGame.exceptions.EndGameException;
import snakeGame.gameManagers.EndGameManager;
import snakeGame.gameManagers.ScoreManager;
import snakeGame.gameManagers.collisionManagers.*;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Snake snake;
    private SnakeEntityManager snakeEntityManager;
    private AppleEntityManager appleEntityManager;
    private CompositeCollisionManager compositeCollisionManager;
    private EndGameManager endGameManager;
    private ScoreManager scoreManager;


    private StupidBot bot;

    public Game(){
        setupGame();
    }

    private void setupGame(){
        snake = new Snake();
        snakeEntityManager = new SnakeEntityManager(snake);
        appleEntityManager = new AppleEntityManager();
        endGameManager = new EndGameManager(snakeEntityManager);
        scoreManager = new ScoreManager(snakeEntityManager);

        compositeCollisionManager = new CompositeCollisionManager();
        compositeCollisionManager.addCollisionManager(new SnakeCollisionManager(snake));
        compositeCollisionManager.addCollisionManager(new WallCollisionManager(snakeEntityManager));
        compositeCollisionManager.addCollisionManager(new AppleCollisionManager(appleEntityManager, snakeEntityManager));

        bot = new StupidBot(appleEntityManager, snakeEntityManager);
    }

    public void drawGame(){
        List<Apple> apples = appleEntityManager.apples();
        List<SnakeBodyPart> snakeBody = snakeEntityManager.snakeBodyParts();

        List<List<String>> board = new ArrayList<>();
        for(int row = 0; row < GameProperties.HEIGHT.value; row++){
            board.add(new ArrayList<>());
            for(int col = 0; col < GameProperties.WIDTH.value; col++){
                board.get(row).add(" ");
            }
        }

        for (SnakeBodyPart snakeBodyPart : snakeBody){
            board.get(snakeBodyPart.posY()).set(snakeBodyPart.posX(), ConsoleColors.ANSI_GREEN + "*" + ConsoleColors.ANSI_RESET);
        }

        board.get(snake.getHead().posY()).set(snake.getHead().posX(), ConsoleColors.ANSI_CYAN + "$" + ConsoleColors.ANSI_RESET);

        for (Apple apple : apples){
            board.get(apple.posY()).set(apple.posX(), ConsoleColors.ANSI_RED + "a" + ConsoleColors.ANSI_RESET);
        }

        System.out.println(
                board.stream()
                        .map(
                                list -> "|" + list.stream().map(String::valueOf).collect(Collectors.joining()) + "|"
                        )
                        .collect(Collectors.joining("\n"))
        );
    }

    public void createApples(int num){
        for (int i = 0; i < num; i++) {
            appleEntityManager.spawnApple();
        }
    }

    public Snake getSnake(){
        return snake;
    }

    public void checkCollisions(){
        try {
            this.compositeCollisionManager.checkCollision();
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public void CheckEndGame(){
        try {
            this.endGameManager.check();
        }catch (EndGameException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public int getScore(){
        return scoreManager.getScore();
    }

    public StupidBot getBot(){
        return bot;
    }
}
