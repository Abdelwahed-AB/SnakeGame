package snakeGame.bots;

import snakeGame.Entity;
import snakeGame.GameProperties;
import snakeGame.collectibles.Apple;
import snakeGame.gameManagers.entityManager.AppleEntityManager;
import snakeGame.gameManagers.entityManager.SnakeEntityManager;
import snakeGame.snake.SnakeBodyPart;
import snakeGame.snake.snakeMovement.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StupidBot {
    private final AppleEntityManager appleEntityManager;
    private final SnakeEntityManager snakeEntityManager;
    private SnakeBodyPart head;

    public StupidBot(AppleEntityManager appleEntityManager, SnakeEntityManager snakeEntityManager) {
        this.appleEntityManager = appleEntityManager;
        this.snakeEntityManager = snakeEntityManager;
        head = snakeEntityManager.snake().getHead();
    }

    public Direction pickDirection(){
        List<Apple> apples = appleEntityManager.apples();
        apples.sort((Apple a, Apple b) -> distanceToEntity(a) - distanceToEntity(b) > 0 ? 1 : -1);

        Apple closest = apples.get(0);

        int xDist = head.posX() - closest.posX();
        int yDist = head.posY() - closest.posY();

        return directionFromDist(xDist, yDist);
    }

    public Direction directionFromDist(int xDist, int yDist){
        Direction yMov = yDist < 0 ? Direction.DOWN : Direction.UP;
        Direction xMov = xDist < 0 ? Direction.RIGHT : Direction.LEFT;

        Direction snakeDir = snakeEntityManager.snake().getDirection();

        Direction movDir;
        if(Math.abs(xDist) > Math.abs(yDist)){
            if (xMov.isOpposite(snakeDir)){
                movDir = yMov;
            }else{
                movDir = xMov;
            }
        }else{
            if (yMov.isOpposite(snakeDir)){
                movDir = xMov;
            }else {
                movDir = yMov;
            }
        }

        return checkForPossibleCollisionsAndChangeDirection(movDir);
    }

    public Direction checkForPossibleCollisionsAndChangeDirection(Direction originalDirection){
        SnakeBodyPart head = snakeEntityManager.snake().getHead();
        SnakeBodyPart cellToCheck = switch (originalDirection){
            case DOWN -> new SnakeBodyPart(head.posX(), head.posY()+1);
            case UP -> new SnakeBodyPart(head.posX(), head.posY()-1);
            case LEFT -> new SnakeBodyPart(head.posX()-1, head.posY());
            default -> new SnakeBodyPart(head.posX()+1, head.posY());
        };

        if (snakeEntityManager.snakeBodyParts().contains(cellToCheck)){
            return pickEmptyCellWhenStuck();
        }

        return originalDirection;
    }

    public Direction pickEmptyCellWhenStuck(){
        Map<SnakeBodyPart, Direction> possibleCells = new HashMap<>();

        if(head.posY() < GameProperties.HEIGHT.value - 1)
            possibleCells.put(new SnakeBodyPart(head.posX(), head.posY()+1), Direction.DOWN);
        if(head.posY() > 0)
            possibleCells.put(new SnakeBodyPart(head.posX(), head.posY()-1), Direction.UP);

        if(head.posX() < GameProperties.WIDTH.value - 1)
            possibleCells.put(new SnakeBodyPart(head.posX()+1, head.posY()), Direction.RIGHT);
        if(head.posX() > 0)
            possibleCells.put(new SnakeBodyPart(head.posX()-1, head.posY()), Direction.LEFT);

        for (SnakeBodyPart cell : possibleCells.keySet()){
            if (!snakeEntityManager.snakeBodyParts().contains(cell)){
                return possibleCells.get(cell);
            }
        }

        return snakeEntityManager.snake().getDirection();
    }


    public double distanceToEntity(Entity e){
        return Math.sqrt(
                Math.pow(head.posX() - e.posX(), 2) + Math.pow(head.posY() - e.posY(), 2)
        );
    }
}
