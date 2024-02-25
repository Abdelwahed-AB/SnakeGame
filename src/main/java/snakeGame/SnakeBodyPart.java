package snakeGame;

import java.util.Objects;

public class SnakeBodyPart extends Entity{
    private int posX, posY;

    public SnakeBodyPart(int posX, int posY) {
        super(posX, posY);
    }
    public SnakeBodyPart() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnakeBodyPart bodyPart = (SnakeBodyPart) o;
        return posX == bodyPart.posX && posY == bodyPart.posY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posX, posY);
    }

    @Override
    public String toString() {
        return "SnakeBodyPart{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
