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
   private int delay = 10;
   protected Timer timer; 
    
   public static int rectX = 60;   //x for first building
   public static int rectY = 100;  //y for first building
   
   private boolean showBanner = false;
   
   public int houseX1 = 50;
   public int houseY1 = 398;
   
   public int treeX1 = 300;
   public int treeY1 = 400;
   
   public int planeX1 = 250;
   public int planeY1 = 40;
   
   int[] b1 = new int[517];
   int[] b2 = new int[470];
   int[] b3 = new int[413];
   
   private int[] red = new int[5];
   private int[] green = new int[5];
   private int[] blue = new int[5];
   
   public Highrise1()
   {
        timer = new Timer(delay, this);
        timer.start();		// start the time
        
        for(int i = 0; i < 517; i++){//set which windows light up on highrise1
            Random ran = new Random();
            int flip = ran.nextInt(3);
            if(flip == 1)
                b1[i] = 0;
            else
                b1[i] = 1;
        }
        for(int i = 0; i < 470; i++){//set which windows light up on highrise2
            Random ran = new Random();
            int flip = ran.nextInt(3);
            if(flip == 1)
                b2[i] = 0;
            else
                b2[i] = 1;
        }
        for(int i = 0; i < 413; i++){ //set which windows light up on highrise3
            Random ran = new Random();
            int flip = ran.nextInt(3);
            if(flip == 1)
                b3[i] = 0;
            else
                b3[i] = 1;
        }
        for(int i = 0; i < 5; i++){  //set the colors for the houses
            Random ran = new Random();
            red[i] = ran.nextInt(255);
            green[i] = ran.nextInt(255);
            blue[i] = ran.nextInt(255);
        }
        
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
   }

   public void actionPerformed(ActionEvent e)
   // will run when the timer fires
   {
	repaint();
   }

   // draw rectangles and arcs
   public void paintComponent( Graphics g )
   {
       
        int rectX2 = rectX + 300;
        int rectY2 = rectY - 20;
        int rectX3 = rectX + 130;
        int rectY3 = rectY - 30;
       
        super.paintComponent( g ); // call superclass's paintComponent
        
        g.setColor(new Color(10, 26, 75)); //background
        g.fillRect(0, 0, 500, 500);
        
        g.setColor(Color.WHITE);  //moon
        g.fillOval(30, 30, 80, 80);
        
	g.setColor(Color.BLACK);
	g.fillRect(rectX, rectY, 102, 400);  //main block for first building
	g.fillRect(rectX2, rectY2, 93, 400); //main block for seccond building
        g.fillRect(rectX3, rectY3, 66, 400);  //main block for the third building
        g.setColor(Color.WHITE);
        int count = 0;
        for(int i = 0; i < 11; i++){  //makes the windows for building 1
            for(int j = 0; j < 47; j++, count++){
                if(count < 517 && b1[count] == 0)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(i*9 + rectX + 2, j*9 + rectY + 2, 8, 8);
            }
        }
        count = 0;
        for(int i = 0; i < 10; i++){  //makes the windows for building 2
            for(int j = 0; j < 47; j++, count++){
                if(count < 470 && b2[count] == 0){
                    g.setColor(Color.black);
                }
                else
                    g.setColor(Color.WHITE);
                g.fillRect(i*9 + rectX2 + 2, j*9 + rectY2 + 2, 8, 8);
            }
        }
        count=0;
        for(int i = 0; i < 7; i++){  //makes the windows for building 3
            for(int j = 0; j < 59; j++, count++){
                if(count < 413 && b3[count] == 0)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(i*9 + rectX3 + 2, j*9 + rectY3 + 2, 8, 8);
            }
        }
        
        for(int k = 0; k < 5; k++){  //builds the houses
            int houseX = houseX1 + k*60;
            g.setColor(new Color(red[k], green[k], blue[k])); //random color of the house
            
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
            g.setColor(new Color(112, 69, 12));
            g.fillRect(treeX, treeY1, 10, 100);
            g.setColor(new Color(4, 98, 4));
            g.fillOval(treeX - 10, treeY1 - 20, 30, 50);
        }
        
        planeX1 = (planeX1 + 1) % 500; //does the plane
        g.setColor(Color.WHITE);
        g.fillOval(planeX1, planeY1, 60, 15);
        g.fillRect(planeX1 + 26, planeY1 - 10, 8, 38);
        g.fillRect(planeX1, planeY1 - 4, 5, 10);
        for(int i = 0; i < 5; i++){  //plane windows
            g.setColor(Color.BLACK);
            g.fillOval(planeX1 + 3 + i*10, planeY1+3, 9, 9);
        }
        if(showBanner){
            g.setColor(Color.red);
            g.fillRect(planeX1 - 60, planeY1 - 5, 60, 20);
            g.setColor(Color.white);
            g.drawString("welcome", planeX1 - 56, planeY1 + 6);
        }
        
        g.setColor(Color.black);  //does the ground
        g.fillRect(0, 450, 500, 50);
        
        
   }
   
   private class MyMouseListener implements MouseListener
    {
        public void mousePressed(MouseEvent e)
        {
            showBanner = true;
        }

        public void mouseClicked(MouseEvent e) {
            //System.out.println("test");
        }

        public void mouseReleased(MouseEvent e) {
            showBanner = false;
        }

        public void mouseEntered(MouseEvent e) {
            System.out.println("test");
        }

        public void mouseExited(MouseEvent e) {
            System.out.println("test");
        }
        
        
    }
   
   private class MyMouseMotionListener implements MouseMotionListener
   {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            
            rectX = 60 + (x - 250)/12;
            rectY = 100 + (y - 250)/20;
            
            houseX1 = 50 + (x - 250)/7;
            houseY1 = 398 + (y - 250)/16;
   
            treeX1 = 300 + (x - 250)/4;
            treeY1 = 400 + (y - 250)/12;
        }
   }
 }




