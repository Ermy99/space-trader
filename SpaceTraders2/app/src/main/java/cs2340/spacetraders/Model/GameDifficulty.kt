package cs2340.spacetraders.Model


import java.io.Serializable

/**
 * GameDifficulty.kt
 * Enum for game difficulties.
 *
 * @author  Sanghavi Gaddam, Ermelinda Izihirwe, Taofikat Bishi,
 * Aditya Tapshalkar, Chisomebi Obed
 * @version 1.0
 */
enum class GameDifficulty private constructor(private val gameDifficulty: String) {
    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("Impossible");

    // --Commented out by Inspection START (4/5/2019 8:23 PM):
    //    public String getGameDifficulty() {
    //        return gameDifficulty;
    //    }
    // --Commented out by Inspection STOP (4/5/2019 8:23 PM)

    override fun toString(): String {
        return gameDifficulty
    }
}