package board;

public class Chip {

	private String symbol;

	public Chip(String symbol){
		this.symbol = symbol;
	}
	public String toString() {
        return this.symbol;
	}
	public String getSymbol(){
		return this.symbol;
	}
}
/*
Class Chip
//tout est private
Var:
	String Symbol;
Constructeur:
	Chip(String symbol);
Functions:
	String toString(); ##Affiche le jeton
    String getSymbol(); ##retournes le symbole du jeton
    */