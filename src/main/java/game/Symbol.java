package game;

public enum Symbol {
    CROSS(0), 
    CIRCLE(1), 
    SQUARE(2), 
    SNAIL(3);
 
    private int symbol;
    Symbol(int i){
        this.symbol = i;
    }
 
    public String getSymbol() {
        return symbol_char[symbol];
    }

    public final String[] symbol_char = {
        "x",
        "o",
        "#",
        "@"
    };
}