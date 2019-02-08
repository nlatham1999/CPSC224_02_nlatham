/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
/**
 *
 * @author Nicholas Latham
 */
public class hangman {
   public static void main(String[] args)
   {
        String word = getWord();
        int choice = getChoice();
        showOutput(word);
   }
   
   public static int getChoice(){
       String input;
       input = JOptionPane.showInputDialog("enter 1 if you want a random word \n enter 2 if someone else will enter it in");
       int x = Integer.parseInt(input);
       return x;
   }
   
   public static String getWord(){
        String input;
        input = JOptionPane.showInputDialog("what word do you want to use");
        return input;
   }
   
   public static void showOutput(String s){
        JOptionPane.showMessageDialog(null, "*** HANGMAN ***" + '\n' + 
                 "***********" + '\n' + s);
   }
   
    
}
