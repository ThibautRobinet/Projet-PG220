package board;

public class Chip {

	String Symbol;

	public Chip(String symbol){
		this.symbol = symbol;
	}
	public String toString() {
        return Chip;
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