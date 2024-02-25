package snakeGame;

import snakeGame.collectibles.Apple;
import snakeGame.gameManagers.collisionManagers.*;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.Snake;
import snakeGame.snake.SnakeBodyPart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private Snake snake;
    private SnakeEntityManager snakeEntityManager;
    private AppleEntityManager appleEntityManager;
    private CompositeCollisionManager compositeCollisionManager;

    public Game(){
        setupGame();
    }

    private void setupGame(){
        snake = new Snake();
        snakeEntityManager = new SnakeEntityManager(snake);
        appleEntityManager = new AppleEntityManager();

        compositeCollisionManager = new CompositeCollisionManager();
        compositeCollisionManager.addCollisionManager(new SnakeCollisionManager(snake));
        compositeCollisionManager.addCollisionManager(new WallCollisionManager(snakeEntityManager));
        compositeCollisionManager.addCollisionManager(new AppleCollisionManager(appleEntityManager, snakeEntityManager));
    }

    public void drawGame(){
        List<Apple> apples = appleEntityManager.apples();
        List<SnakeBodyPart> snakeBody = snakeEntityManager.snakeBodyParts();

        List<List<Character>> board = new ArrayList<>();
        for(int row = 0; row < GameProperties.HEIGHT.value; row++){
            board.add(new ArrayList<>());
            for(int col = 0; col < GameProperties.WIDTH.value; col++){
                board.get(row).add(' ');
            }
        }

        for (SnakeBodyPart snakeBodyPart : snakeBody){
            board.get(snakeBodyPart.posY()).set(snakeBodyPart.posX(), '*');
        }

        for (Apple apple : apples){
            board.get(apple.posY()).set(apple.posX(), 'o');
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

    static class test{
        public static void main(String[] args) throws InterruptedException, IOException {
            Game game = new Game();
            game.createApples(30);

            while (true){
                game.snake.move();
                game.compositeCollisionManager.checkCollision();

                Thread.sleep(100);
                clear();
                game.drawGame();
            }
        }

        private static void clear(){
            for (int i = 0; i < 100; i++) {
                System.out.println("\n");
            }
        }
    }
}
