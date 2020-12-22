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


public class AdvancedHistory extends History{
    
    private final String KNN_FILE_PATH = "./human_move.txt";

    private PrintWriter knnWriter;
    private PrintWriter player1Writer,player2Writer;

    public AdvancedHistory() {
		super();
	}
    
    @Override
    void newGame() {
        super.newGame();
        try{
            File f = new File(KNN_FILE_PATH);
            FileWriter fw = new FileWriter(f, true);
			this.knnWriter = new PrintWriter(fw);
            this.player1Writer = new PrintWriter("./player1.txt", "UTF-8");
			this.player2Writer = new PrintWriter("./player2.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error 1");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("error 2");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error 3");
			e.printStackTrace();
        }
    }

    /**
	 * 
	 * @param playerNum must me the number of the player who win and 0 if there is no winner
	 */
    @Override
	public void playerWin(int playerNum){
		if (playerNum == 0)
			writeNewLine("Egalite");
		else{
			String line = String.format("Joueur %d gagne", playerNum);
			writeNewLine(line);
			if (playerNum == 1){
				saveMove("./player1.txt");
			}
			else{
				saveMove("./player2.txt");
			}
		}
	}

    public void saveHumanMove(String s, int m, int numPlayer){
		if (numPlayer == 1){
			player1Writer.println(s+"/"+m);
			player1Writer.flush();
		}
		else{
			player2Writer.println(s+"/"+m);
			player2Writer.flush();
		}
		
    }
    
    	
	private void saveMove(String path){
		try {
			FileReader fr = new FileReader(path);
			BufferedReader reader = new BufferedReader(fr);
			String s;
			while ((s = reader.readLine()) != null) {
				//System.out.println(s);
				knnWriter.println(s);
				knnWriter.flush();
			}
			if (reader != null)
				reader.close();
			if (fr != null)
				fr.close();
			cleanPlayerFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    private void cleanPlayerFiles() throws FileNotFoundException, UnsupportedEncodingException {
		player1Writer.close();
		player2Writer.close();
		this.player1Writer = new PrintWriter("./player1.txt", "UTF-8");
		this.player2Writer = new PrintWriter("./player2.txt", "UTF-8");
	}

    @Override
    public void gameEnded(){
		super.gameEnded();
		knnWriter.close();
	}
}
