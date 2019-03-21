/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landscape;

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Nicholas Latham
 */
class Highrise2 extends JPanel implements ActionListener
{
   public int rectX = 150;
   public int rectY = 100;

   public Highrise2()
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
	g.setColor(Color.BLACK);
	g.fillRect(rectX, rectY, 53, 203);
        g.setColor(Color.WHITE);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 33; j++){
                g.fillRect(i*5 + rectX + 2, j*5 + rectY + 2, 4, 4);
            }
        }   
   }
}



