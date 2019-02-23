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
        boolean keepLooping = true; //loops after each game
        boolean notDone = true; // boolean that keeps track to see if the game is still in progress
        boolean isInWord = false; //boolean that checks to see if players guess is correct
        int timesWrong = 0;
        
        //main loop
        while(keepLooping){
            timesWrong = 0;
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
            
            //in game loop
            while(notDone){
                currentLetter = getLetter();
                if(isLetterInString(word, currentLetter)){
                    unfinishedWord = addToUnfinishedWord(word, unfinishedWord, currentLetter);
                }else{
                    timesWrong++;
                    switch(timesWrong){
                        case 1:
                            JOptionPane.showMessageDialog(null, "building the head...");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "building the neck...");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "building the left hand...");
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "builing the right hand...");
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "building the body...");
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null, "building the left leg...");
                            break;
                        case 7:
                            JOptionPane.showMessageDialog(null, "building the right leg...");
                            JOptionPane.showMessageDialog(null, "You lost");
                            notDone = false;
                    }
                            
                    
                }
                showOutput(unfinishedWord);
            }
            showOutput(word);
        }
    }
    
    //adds the guessed letter to the unfinished word
    public static String addToUnfinishedWord(String s, String u, char c){
        StringBuilder word = new StringBuilder(u);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c){
                word.setCharAt(i, c);
            }
        }
        return word.toString();
    }
    
    //checks to see if the letter guessed is in the word
    public static boolean isLetterInString(String s, char c){
        int x = s.indexOf(c);
        
        
        if(x > -1){
            return true;
             
        }else{
            JOptionPane.showMessageDialog(null, "bad choice");
            return false;
        }
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
       "keyboard", "monitor", "table", "chair", "syzygy"};
       
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
