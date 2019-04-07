package cs2340.spacetraders.Model;


import java.io.Serializable;

/**
 * GameDifficulty.java
 * Enum for game difficulties.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 *          Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
public enum GameDifficulty {
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");


    private final String gameDifficulty;

    GameDifficulty(String gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

// --Commented out by Inspection START (4/5/2019 8:23 PM):
//    public String getGameDifficulty() {
//        return gameDifficulty;
//    }
// --Commented out by Inspection STOP (4/5/2019 8:23 PM)

    @Override
    public String toString() {
        return gameDifficulty;
    }
}