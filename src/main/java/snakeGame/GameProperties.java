package snakeGame;

public enum GameProperties {
    WIDTH(150),
    HEIGHT(15);

    public final int value;

    GameProperties(int value) {
        this.value = value;
    }
}
