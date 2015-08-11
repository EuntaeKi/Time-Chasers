import java.awt.*;
//import java.awt.Image;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.util.EnumSet;
import java.lang.*;
import java.net.URL;

import javax.imageio.*;


import javax.swing.*;


import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JPanel;



/** @see http://stackoverflow.com/questions/4148336 */
public class GameBackground extends JPanel {
	
	private BufferedImage image;
	private BufferedImage image2;
	
	
    GameBackground(Digit digit) {
        //this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JDigit cellValue = new JDigit(digit);
        add(cellValue, BorderLayout.CENTER);
        
        
        
        //Defining one image
        URL resource = getClass().getResource("Clock Without Black Rim Finalized.png");
        try {
            image2 = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        //Defining another image
        URL resource2 = getClass().getResource("Clock.png");
        try {
            image = ImageIO.read(resource2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
class JDigit extends JPanel {

    public JDigit(Digit digit) {
        this.setPreferredSize(new Dimension(960, 540));
    }
    //Circle, and other objects to immitate a background atm
    @Override
    public void paintComponent(Graphics g) {
    	//super.paintComponent(g);
        //g.drawOval(0, 0, 50, 50);
        //repaint();
        //g.drawImage(img, 0, 0, null);
    	//g.drawImage(image, -400, 0, this);
        //g.fillOval(100, 100, 50, 50);
        
        //g.drawImage(image, -400, 0, this);
    	
    	//Drawing the image with the ability to resize which we can also use for scaling the image down or up
        g.drawImage(image, 0, 0, 960, 540, this);
        g.drawImage(image2, 0, 0, 960, 540, this);
        g.setColor(Color.red);
        g.fillRect(910, 490, 50, 50);
        g.setColor(Color.MAGENTA);
        g.drawString("Settings",910,490);
        g.setColor(Color.BLACK);
        g.fillRect(510, 270, 140, 10);
        g.fillRect(315, 270, 140, 10);
        
    }
  }
}