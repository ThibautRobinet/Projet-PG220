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
}
/*
Class UserInterface
// cette classe doit traiter l’interprétation des commandes, et l’affichage des erreurs dans la console
//tout est private 
Var:

Constructeur:
	userInterface()
Functions:
	void onInputMessage(String userInput); ##Switch case des différentes fonctions [sortir, type & nom du joueur, colonne dans 		lequel on joue]
    void outputMessage(String gameMessage);
    */