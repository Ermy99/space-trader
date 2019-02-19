package cs2340.spacetraders.Model;

public class Model {
//    private Model instance = new Model(game, player);
//
//    public static Model getInstance() { return instance; }

    Game game;
    public Player player;

    public Model(Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
