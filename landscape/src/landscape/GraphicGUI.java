/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landscape;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 *
 * @author Nicholas Latham
 */
public class GraphicGUI extends JFrame {
    
    public GraphicGUI(){
        JFrame frame = new JFrame( "Bouncing Ball" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        Highrise1 hr1 = new Highrise1(); 
        Highrise2 hr2 = new Highrise2();
        frame.add(hr1);
        frame.add(hr2);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setSize( 300, 300 ); // set frame size
        frame.setVisible( true ); // display frame
    }
}

