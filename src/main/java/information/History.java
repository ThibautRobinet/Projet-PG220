package information;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import player.Player;

public class History {

	private final String LOG_FILE_PATH = "./log.txt";
	private PrintWriter writer;

	public History() {
		newGame();
	}

	void newGame() {
		try {
			this.writer = new PrintWriter(LOG_FILE_PATH, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error 1");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("error 2");
			e.printStackTrace();
		}
	}

	public void newManche(){		
		writeNewLine("Manche commence");
	}

	public void playerMove(int playerNum, int column){
		String line = String.format("Joueur %d joue %d", playerNum, column);
		writeNewLine(line);
	}

	public void newPlayer(int playerNum, String playerType, String playerName){
		String line = String.format("Joueur %d est %s %s", playerNum, playerType, playerName);
		writeNewLine(line);
	}

	/**
	 * 
	 * @param playerNum must me the number of the player who win and 0 if there is no winner
	 */
	public void playerWin(int playerNum){
		if (playerNum == 0)
			writeNewLine("Egalite");
		else{
			String line = String.format("Joueur %d gagne", playerNum);
			writeNewLine(line);
		}
	}

	public void playersScore(List<Player> listPlayers){
		String line = "Score ";
		boolean first = true;
		for (Player p : listPlayers){
			if (!first){
				line += " - ";
			}
			line += p.getScore();
			first = false;
		}
		writeNewLine(line);
	}

	void writeNewLine(String line){
		writer.println(line);
		writer.flush();
	}

	public void gameEnded(){
		writer.println("Partie finie");
		writer.close();
	}

	/**
	 * To fit with AdvancedHistory
	 */
	public void saveHumanMove(String s, int m, int numPlayer){}
}