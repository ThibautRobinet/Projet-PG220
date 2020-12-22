package game.board;

final class Chip {

	private final String symbol;
	private final int ownerPlayerNum;

	Chip(String symbol, int ownerPlayerNum){
		this.symbol = symbol;
		this.ownerPlayerNum = ownerPlayerNum;
	}

	int getOwnerPlayerNum(){
		return this.ownerPlayerNum;
	}
	
	String getSymbol(){
		return this.symbol;
	}

	public String toString() {
        return this.symbol;
	}
}