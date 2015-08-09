import javax.swing.*;
import java.awt.*;

public class whiteBoard extends JFrame {
    private JFrame frame;
    private JPanel control;
    private JButton left;
    private JButton right;
    private Dimension size;
    public whiteBoard() {
        gui();
    }
    public void gui() {
        //Frame property
        frame = new JFrame("White Board");
        frame.setVisible(true);
        frame.setSize(276, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //Control panel property
        control = new JPanel();
        control.setSize(276, 500);
        control.setBackground(Color.white);
        //Declaring Left Button
        left = new JButton("");
        //Size of JButton
        left.setPreferredSize(new Dimension(125, 500));
        //Next 3 Lines = Making Button transparent
        left.setOpaque(false);
        left.setContentAreaFilled(false);
        left.setBorderPainted(false);
        //Declaring Right Button
        right = new JButton("");
        //Size of JButton
        right.setPreferredSize(new Dimension(125, 500));
        //Setting them invisible
        right.setOpaque(false);
        right.setContentAreaFilled(false);
        right.setBorderPainted(false);
        //Positioning Control Button in the JPanel
        control.add(left);
        control.add(right);
        //Adding JPanel(control) into JFrame(frame)
        frame.add(control);
    }
    public static void main(String[] args) {
        new whiteBoard();
        /*CircleDraw clock = new CircleDraw();
        clock.paint();*/
    }
}