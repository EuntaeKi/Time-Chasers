import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.EnumSet;
import javax.swing.*;

/** @see http://stackoverflow.com/questions/4148336 */
public class CellTest3 extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                createGUI();
            }
        });
    }

    public static void createGUI() {
        JFrame frame = new JFrame(""+ "");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(1, 1));
        frame.setSize(1000, 1000);
        for (Digit d : Digit.digits) {
            frame.add(new CellTest3(d));
        }
        //frame.pack();
        frame.setVisible(true);
    }

    CellTest3(Digit digit) {
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        JDigit cellValue = new JDigit(digit);
        add(cellValue, BorderLayout.CENTER);
    }

class JDigit extends JPanel {

    public JDigit(Digit digit) {
        this.setPreferredSize(new Dimension(276, 500));
    }
    //Circle and Rectangle
    @Override
    protected void paintComponent(Graphics g) {
        
    	//g.drawRect(400, 400, 100, 100);
        g.drawOval(0, 0, 50, 50);
    }
  }
}