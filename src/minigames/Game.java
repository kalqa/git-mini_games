package minigames;

public abstract class Game {

    private String name;
    private String description;
    boolean gameStared = false;
    boolean gamePrepared = false;
    boolean gameToEnd = false;

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
