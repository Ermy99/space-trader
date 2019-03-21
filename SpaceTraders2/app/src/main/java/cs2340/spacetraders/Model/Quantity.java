package cs2340.spacetraders.Model;

public enum Quantity {
    One("1", 1),
    Two("2", 2),
    Three("3", 3),
    Four("4", 4),
    Five("5", 5);

    String code;
    int val;

    Quantity(String code, int val) {
        this.code = code;
        this.val = val;
    }

    public String getCode() {
        return code;
    }

    public int getVal() {
        return val;
    }
}
