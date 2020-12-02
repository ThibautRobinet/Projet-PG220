package information;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {

    public UserInterface(){

    }

    public String onInputMessage(String userInput){
        //Print what user have to do
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

        // Printing the read line 
        return input;
    }

    public void outputMessage(String gameMessage){
        //Print game message in cmd
        System.out.println(gameMessage);
    }
    public boolean isFenetreInterface(){return false;}
}
