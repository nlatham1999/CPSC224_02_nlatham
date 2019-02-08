/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class hangman {
   public static void main(String[] args)
   {
        boolean keepLooping = true;
        while(keepLooping){
            String word = "";
            int choice = getChoice();
            if(choice == 2){
                word = getWord();
            }else if (choice == 1){
                word = getRandomWord();
            }else{
                keepLooping = false;
            }
            showOutput(word);
        }
   }

   //gets the users choice 
   public static int getChoice(){
       String input;
       input = JOptionPane.showInputDialog("enter 1 if you want a random word \n enter 2 if someone else will enter it in");
       int x = Integer.parseInt(input);
       return x;
   }
   
   public static String getRandomWord(){
       String[] listOfWords =  {"hello", "guess", "computer", "library", "information", "desk", "mouse",
       "keyboard", "monitor", "table", "chair"};
       
       int lengthA = listOfWords.length;


        Random rand = new Random();

        int n = rand.nextInt(lengthA) % lengthA;
       
       return listOfWords[n];      
   }
   
   //gets a word from the user
   public static String getWord(){
        String input;
        input = JOptionPane.showInputDialog("what word do you want to use");
        return input;
   }
   
   //shows the output
   public static void showOutput(String s){
        JOptionPane.showMessageDialog(null, "*** HANGMAN ***" + '\n' + 
                 "***********" + '\n' + s);
   }
    
}
