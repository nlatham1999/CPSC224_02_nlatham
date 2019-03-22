/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landscape;

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Nicholas Latham
 */
class Highrise1 extends JPanel implements ActionListener
{
   public int rectX = 60;
   public int rectY = 100;
   public int rectX2 = 360;
   public int rectY2 = 80;
   public int rectX3 = 190;
   public int rectY3 = 70;
   
   public int houseX1 = 50;
   public int houseY1 = 398;
   
   public int treeX1 = 350;
   public int treeY1 = 390;
   
   public Highrise1()
   {
      
   }

   public void actionPerformed(ActionEvent e)
   // will run when the timer fires
   {
	repaint();
   }

   // draw rectangles and arcs
   public void paintComponent( Graphics g )
   {
        super.paintComponent( g ); // call superclass's paintComponent
        
        g.setColor(new Color(10, 26, 75)); //background
        g.fillRect(0, 0, 500, 500);
        
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 45, 45);
        
	g.setColor(Color.BLACK);
	g.fillRect(rectX, rectY, 102, 400);  //main block for first building
	g.fillRect(rectX2, rectY2, 93, 400); //main block for seccond building
        g.fillRect(rectX3, rectY3, 66, 400);  //main block for the third building
        g.setColor(Color.WHITE);
        for(int i = 0; i < 11; i++){  //makes the windows for building 1
            for(int j = 0; j < 47; j++){
                g.fillRect(i*9 + rectX + 2, j*9 + rectY + 2, 8, 8);
            }
        }
        for(int i = 0; i < 10; i++){  //makes the windows for building 2
            for(int j = 0; j < 47; j++){
                g.fillRect(i*9 + rectX2 + 2, j*9 + rectY2 + 2, 8, 8);
            }
        }
        for(int i = 0; i < 7; i++){  //makes the windows for building 3
            for(int j = 0; j < 59; j++){
                g.fillRect(i*9 + rectX3 + 2, j*9 + rectY3 + 2, 8, 8);
            }
        }
        
        for(int k = 0; k < 5; k++){  //builds the houses
            int houseX = houseX1 + k*60;
            Random ran = new Random();
            int red = ran.nextInt(255);
            int green = ran.nextInt(255);
            int blue = ran.nextInt(255);
            g.setColor(new Color(red, green, blue)); //random color of the house
            
            g.fillRect(houseX, houseY1, 46, 92); //body of house 
            int[] xPoints = {houseX - 3, houseX + 23, houseX + 46 + 3};
            int[] yPoints = {houseY1, houseY1 - 20, houseY1};
            g.fillPolygon(xPoints, yPoints, 3);  //roof of house 
            g.setColor(Color.WHITE);
            for(int i = 0; i < 2; i++){  //windows of house 
                for(int j = 0; j < 2; j++){
                    g.fillRect(i*22 + houseX + 2, j*22 + houseY1 + 2, 19, 19);
                }
            }
        }
        
        for(int i = 0; i < 6; i++){
            int treeX = treeX1 + i*30;
            g.setColor(Color.GREEN);
            g.drawLine(treeX, treeY1, treeX, treeY1+50);
        }
        
        
        g.setColor(Color.black);
        g.fillRect(0, 450, 500, 50);
        
        
   }
}



