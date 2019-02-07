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
        showOutput(word, 2);
   }
   public static String getWord(){
        String input;
        input = JOptionPane.showInputDialog("what word do you want to use");
        return input;
   }
   
   public static void showOutput(String s, int x){
        String word = "";
        for(int i = 0; i < s.length(); i++){
            if(i < x){
                word += s.charAt(i);
            }else{
                word += "_ ";
            }
        }
        JOptionPane.showMessageDialog(null, "*** HANGMAN ***" + '\n' + 
                 "***********" + '\n' + word);
   }
   
    
}
