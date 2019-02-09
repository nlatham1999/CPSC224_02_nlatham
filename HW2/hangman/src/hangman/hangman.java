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
        char currentLetter = 'a';
        String unfinishedWord = ""; //string containing blanks and letter correctly guessed
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
            
            unfinishedWord = getUnfinishedWord(word);
            
            boolean notDone = true; //switch to loop playing
            while(notDone){
                currentLetter = getLetter();
                unfinishedWord = isLetterInString(word, unfinishedWord, currentLetter);
                showOutput(unfinishedWord);
            }
            showOutput(word);
        }
    }
    
    //checks to see if the letter guessed is in the word
    //if true then it adds it to the unfinished word
    public static String isLetterInString(String s, String u, char c){
        int x = s.indexOf(c);
        StringBuilder word = new StringBuilder(u);
        
        if(x > -1){
             for(int i = 0; i < s.length(); i++){
                 if(s.charAt(i) == c){
                     word.setCharAt(i, c);
                 }
             }
        }else{
            JOptionPane.showMessageDialog(null, "bad choice");
        }
        return word.toString();
    }
    
    public static String getUnfinishedWord(String s){
        String word = "";
        for(int i = 0; i < s.length(); i++){
            word += "_";
        }
        return word;
    }
   
    public static char getLetter(){
        boolean notCorrect = true;
        String input ="";
        char cInput;
        while(notCorrect){
            input = JOptionPane.showInputDialog("enter a character");
            if(input.length() == 1)
                notCorrect = false;
            else{
                JOptionPane.showMessageDialog(null, "only one character allowed");
            }
        }
        input = input.toLowerCase();
        cInput = input.charAt(0);
        return cInput;
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
