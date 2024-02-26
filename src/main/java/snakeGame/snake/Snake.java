package snakeGame.snake;

import snakeGame.exceptions.SelfCollisionException;
import snakeGame.snake.snakeMovement.*;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private SnakeMovementState movementState = new SnakeMovementStateRight(this);
    private final List<SnakeBodyPart> body = new LinkedList<>();

    public Snake() {
        reset();
    }
    public void reset(){
        body.clear();
        body.add(new SnakeBodyPart(0, 0));
    }
    public void move(){
        for (int i = length()-1; i > 0; i--){
            SnakeBodyPart prev = body.get(i - 1);
            SnakeBodyPart current = body.get(i);

            current.copyPos(prev);
        }

        moveHead();
    }
    public void moveHead(){
        movementState.moveHead();
    }
    public void changeDirection(Direction direction){
        movementState.changeDirection(direction);
    }
    public void setMovementState(SnakeMovementState movementState){
        this.movementState = movementState;
    }
    public SnakeBodyPart getHead(){
        return body.get(0);
    }
    public SnakeBodyPart addBodyPart(){
        SnakeBodyPart tail = body.get(body.size()-1);
        SnakeBodyPart newPart = new SnakeBodyPart();

        body.add(newPart);
        newPart.copyPos(tail);

        return newPart;
    }
    public List<SnakeBodyPart> getBody(){
        return body;
    }
    public void checkSelfCollision(){
        SnakeBodyPart head = getHead();

        for(int i = 1; i < length(); i++){
            if (head.isCollidingWith(body.get(i))){
                throw new SelfCollisionException();
            }
        }
    }
    public int length(){
        return body.size();
    }

    public Direction getDirection(){
        if(movementState.getClass() == SnakeMovementStateRight.class){
            return Direction.RIGHT;
        }
        if(movementState.getClass() == SnakeMovementStateLeft.class){
            return Direction.LEFT;
        }
        if(movementState.getClass() == SnakeMovementStateUp.class){
            return Direction.UP;
        }
        else {
            return Direction.DOWN;
        }
    }
}
