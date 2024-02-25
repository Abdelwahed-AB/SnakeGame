package snakeGame;

import snakeGame.snakeMovement.Direction;
import snakeGame.snakeMovement.SnakeMovementState;
import snakeGame.snakeMovement.SnakeMovementStateRight;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private SnakeMovementState movementState = new SnakeMovementStateRight(this);
    private List<SnakeBodyPart> body = new ArrayList<>();

    public Snake() {
        reset();
    }
    public void reset(){
        body.clear();
        body.add(new SnakeBodyPart(0, 0));
    }
    public void moveBody(){
        for (int i = body.size()-1; i > 0; i--){
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
    public void addBodyPart(){
        SnakeBodyPart tail = body.get(body.size()-1);
        SnakeBodyPart newPart = new SnakeBodyPart();

        body.add(newPart);
        newPart.copyPos(tail);
    }
    public List<SnakeBodyPart> getBody(){
        return body;
    }
}
