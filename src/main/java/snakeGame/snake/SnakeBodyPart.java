package snakeGame.snake;

import snakeGame.Entity;

public class SnakeBodyPart extends Entity {
    public SnakeBodyPart(int posX, int posY) {
        super(posX, posY);
    }
    public SnakeBodyPart() {}
    @Override
    public String toString() {
        return "SnakeBodyPart{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
