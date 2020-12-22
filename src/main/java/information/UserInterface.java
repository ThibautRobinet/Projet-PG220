package information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import game.QuitException;

public class UserInterface {

    public UserInterface(){

    }

    public String onInputMessage(String userInput) throws QuitException{
        //Print what user have to do
        if (!userInput.equals(""))
            System.out.println(userInput);

        //Enter data using BufferReader 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
            
        // Reading data using readLine
        String input;    
        try {
            input = reader.readLine();
        } catch (IOException e) {
            return null;
        }
        if (input.equals("sortir"))
                throw new QuitException();

        // Printing the read line 
        return input;
    }

    public void outputMessage(String gameMessage){
        //Print game message in cmd
        System.out.println(gameMessage);
    }
    public boolean isFenetreInterface(){return false;}
}
