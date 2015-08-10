import java.awt.*;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import javax.swing.*;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** @see http://stackoverflow.com/questions/4148336 */
public class GameBackground extends JPanel {
    GameBackground(Digit digit) {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JDigit cellValue = new JDigit(digit);
        add(cellValue, BorderLayout.CENTER);
    }

class JDigit extends JPanel {
	
	private Image img;
	 
	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }
	 
	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }
	 

    public JDigit(Digit digit) {
        this.setPreferredSize(new Dimension(276, 500));
    }
    //Circle
    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(0, 0, 50, 50);
        g.drawImage(img, 0, 0, null);
    }
  }
}