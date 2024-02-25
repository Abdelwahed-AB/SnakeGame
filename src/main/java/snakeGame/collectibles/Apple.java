package snakeGame.collectibles;

import snakeGame.Entity;

// Why do snakes eat apples?
public class Apple extends Entity {
    public Apple(int posX, int posY) {
        super(posX, posY);
    }

    public Apple() {}

    @Override
    public String toString() {
        return "Apple{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
