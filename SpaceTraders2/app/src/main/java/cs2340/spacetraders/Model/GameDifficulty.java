package cs2340.spacetraders.Model;

public enum GameDifficulty {
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");


    private String gameDifficulty;

    GameDifficulty(String gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public String getGameDifficulty() {
        return gameDifficulty;
    }

    @Override
    public String toString() {
        return gameDifficulty;
    }
}
