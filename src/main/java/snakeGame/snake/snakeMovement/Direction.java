package snakeGame.snake.snakeMovement;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public boolean isOpposite(Direction direction){
        if(this == LEFT && direction == RIGHT || this == RIGHT && direction == LEFT){
            return true;
        }else if(this == DOWN && direction == UP || this == UP && direction == DOWN){
            return true;
        }else {
            return false;
        }
    }
}
